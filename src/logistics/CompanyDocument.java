package logistics;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import extras.DatabaseConnection;

public class CompanyDocument {

	/* All Document and Company Details */

	protected static final String CompanyName = "APHRODITEHILLS SERVICES LTD \n";
	protected static final String CustomerDetails = "\nCustomer Details:";
	protected static final String AccountCode = "Account Code:";
	protected static final String DocNumber = "Doc. Number:";
	protected static final String OrderNumber = "Order Number:";
	protected static final String DocDate = "DocDate";
	protected static final int INVOICE = 1;
	protected static final int PROFORMA = 2;
	protected static final int RECEIPT = 3;

	protected static final Paragraph NewLine = new Paragraph("\n");

	protected static final String Dates = "ADVISE OF COMMON EXPESNES DUE";
	protected static final String general = "\n 1st Floor-Village Square \n Aphrodite Hills, 8509 - CYPRUS \n"
			+ " P.O.Box 62769 - 8068 Paphos- \n"
			+ "Tel: + 357 26828000 - - Fax: + 357 26828001 \n"
			+ "Email: info@aphroditehills.com, Web: www.aphroditehills.com";

	// Fonts For The Document //

	protected Font BIGBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	protected Font MEDIUMUNDERLINE = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.UNDERLINE);
	protected Font MEDIUMBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 14,
			Font.BOLD);
	protected Font smallbold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);
	protected Font small = new Font(Font.FontFamily.TIMES_ROMAN, 8);
	protected Font smallerbold = new Font(Font.FontFamily.TIMES_ROMAN, 8,
			Font.BOLD);

	/*
	 * All Customer and Property Details -- Dynamic variables that initialize by
	 * database data
	 */
	private int documentID=0;
	
	private int type;

	public CompanyDocument(int type) {
		this.type = type;
	}

	public void createHeader(Document doc) throws Exception {

		Image image1 = Image.getInstance("PDF-IMAGE.png");
		doc.add(image1);

		Paragraph HeaderPara = new Paragraph(general, smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);

		doc.add(NewLine);

		if (type == INVOICE) {
			Paragraph InvoicePara = new Paragraph("INVOICE", MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
		} else if (type == RECEIPT) {
			Paragraph InvoicePara = new Paragraph("RECEIPT", MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);

		}

		if (type != RECEIPT) {
			Paragraph DatesPara = new Paragraph(Dates);
			DatesPara.setAlignment(Element.ALIGN_CENTER);
			doc.add(DatesPara);
		}
		Paragraph CustDetails = new Paragraph(CustomerDetails, smallbold);
		CustDetails.setAlignment(Element.ALIGN_LEFT);
		doc.add(CustDetails);

	}

	public void createCustomerDetailsTable(Document doc, ResultSet rs)
			throws Exception {

		DatabaseConnection database = new DatabaseConnection();
		ResultSet proforma = database.getStatement().executeQuery(
				"SELECT docID " + "FROM DocumentsIDS "
						+ "WHERE docType = 'Proforma' ");
		documentID = 0;
		if (proforma.next()) {
			documentID = proforma.getInt(1);
			database.getStatement().execute(
					"UPDATE DocumentsIDS " + "SET docID='" + (documentID + 1)
							+ "' WHERE docType = 'Proforma' ");
		} else {
			System.exit(-1);
		
		}
		proforma.close();
		
		
		
		String customerName = "\n" + rs.getString(5) + " " + rs.getString(6);
		String address = rs.getString(7) + " " + rs.getString(8) + ",\n"
				+ rs.getString(11);
		String customerID = rs.getString(4);

		String documentDetailsString = documentType();
		PdfPTable CustomerDetailsTable = new PdfPTable(2); // Megalos Pinakas
		PdfPCell CustomerDetails = new PdfPCell(new Phrase(customerName + "\n"
				+ address +",\n" + rs.getString(11)));// aristeri Plevra
		CustomerDetails.setHorizontalAlignment(Element.ALIGN_LEFT);

		PdfPCell AllCodes = new PdfPCell(); // De3ia keli megalo pinaka p krata
											// tous kodikous

		CustomerDetails.setBorderWidth(0);
		AllCodes.setBorderWidth(0);

		PdfPTable CodesTable = new PdfPTable(2); // Pinakas Kodikwn
		PdfPCell CodesDefinition = new PdfPCell(new Phrase(
				documentDetailsString)); // De3i keli me names
		PdfPCell Codes = new PdfPCell(new Phrase(customerID +"\n" +documentID)); // aristero
																		// kelli
																		// me
																		// arithmous

		CodesDefinition.setHorizontalAlignment(Element.ALIGN_LEFT);
		Codes.setHorizontalAlignment(Element.ALIGN_LEFT);
		CodesDefinition.setBorderWidth(0);
		Codes.setBorderWidth(0);

		CodesTable.addCell(CodesDefinition);
		CodesTable.addCell(Codes);

		CustomerDetailsTable.setWidthPercentage(100);

		CustomerDetailsTable.addCell(CustomerDetails);

		AllCodes.addElement(CodesTable); // Isagwgi pinaka kwdikwn stin keli tou
											// megalou pinaka
		CustomerDetailsTable.addCell(AllCodes); // eisagogi keliou kwdikwn stin
												// de3ia plevra

		doc.add(CustomerDetailsTable);

	}

	private String documentType() {

		if (type == INVOICE)
			return AccountCode + "\n" + DocNumber + "\n" + OrderNumber + "\n"
					+ DocDate;
		else if (type == PROFORMA || type == RECEIPT)
			return AccountCode + "\n" + DocNumber + "\n" + DocDate;
		else
			return "Error";

	}

	public void Signatures(Document doc) throws Exception {

		PdfPTable Signature = new PdfPTable(2);
		doc.add(NewLine);
		Signature.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		if (type != RECEIPT) {
			Phrase t = new Phrase(
					"CUSTOMER \n\n ________________________________ \n\t " +

					"                         Signature");
			LeftCell.addElement(t);
		}
		Signature.addCell(LeftCell);

		Signature.setWidthPercentage(100);
		PdfPCell RightCell = new PdfPCell();
		RightCell.setBorderWidth(0);
		RightCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		Phrase W = new Phrase(
				"APHRODITE HILL SERVICE LTD \n\n ________________________________ \n"
						+ "                         Signature");
		RightCell.addElement(W);
		Signature.addCell(RightCell);
		doc.add(Signature);
	}

	public void BankInfo(Document doc) throws Exception {

		PdfPTable BankINF = new PdfPTable(1);

		BankINF.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		Phrase t = new Phrase(
				"Please issue payment to: Aphrodite Hills Services Ltd \nMailing address:"
						+ "            P.O.Box 62769 \n        "
						+ "                              8068 Paphos\n             "
						+ "                         CYPRUS\n\nOr Bank Transfer to:  Bank of Cyprus\n  "
						+ "                                Account Name: Aphrodite Hills Services Ltb\n "
						+ "                                 Acocount Number:35701306518\n                 "
						+ "                 Swift Code:BCYPCY2N\n                                "
						+ "  IBAN:CY08002001950000357013065018");
		t.setFont(small);
		LeftCell.addElement(t);

		BankINF.addCell(LeftCell);

		doc.add(NewLine);

		doc.add(BankINF);
		if (type == PROFORMA) {
			Paragraph noVAT1 = new Paragraph("This is not a VAT invoice");
			noVAT1.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT1);
			Paragraph noVAT2 = new Paragraph(
					"The above amount is payable with immediate effect", small);
			noVAT2.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT2);
		} else if (type == INVOICE) {
			doc.add(NewLine);
			Paragraph noVAT2 = new Paragraph(
					"The above amount is payable 30 days,if not paid interest at the rate 8%  pa will be charged",
					smallerbold);
			noVAT2.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT2);
		}

	}

	public void createCostTable(Document doc, ResultSet rs) throws Exception {
		
		
		DatabaseConnection database = new DatabaseConnection();
		
		
		int N = 6;
		String CustomerID = rs.getString(4);
		PdfPTable columnsTitle = new PdfPTable(N);
		PdfPCell[] Columns = new PdfPCell[N];

		for (int i = 0; i < N; i++) {
			Columns[i] = new PdfPCell();
			Columns[i].setHorizontalAlignment(Element.ALIGN_LEFT);
			Columns[i].setBorderWidth(0);
		}

		Phrase[] titles = new Phrase[N];
		int i = 1;
		int rooms = 1;
<<<<<<< HEAD

		float total = 0;
		titles[0] = new Phrase("S/N");
		titles[1] = new Phrase("PlotNo");
		titles[2] = new Phrase("Location/Type");
		titles[3] = new Phrase("Description");
		titles[4] = new Phrase("Qty");
		titles[5] = new Phrase("Amount");

=======
		double total =0;
	
			titles[0] = new Phrase("S/N");
			titles[1] = new Phrase("PlotNo");
			titles[2] = new Phrase("Location/Type");
			titles[3] = new Phrase("Description");
			titles[4] = new Phrase("Qty");
			titles[5] = new Phrase("Amount");
			 
>>>>>>> 3d49c3c052f0e8cebc1e0eb397a3bf8f4666a3a6
		for (int j = 0; j < N; j++) {
			titles[j].setFont(smallbold);
			Columns[j].addElement(titles[j]);
			columnsTitle.addCell(Columns[j]);
		}

		columnsTitle.setWidthPercentage(100);

		String prev = rs.getString(3);
		documentID++;

		do {
			
<<<<<<< HEAD
			String exportDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

			
			

			if (!CustomerID.equals(rs.getString(4))) {
=======
			if (!CustomerID.equals(rs.getString(4))){
				
				Columns[0].setPhrase(new Phrase());
				Columns[1].setPhrase(new Phrase());
				Columns[2].setPhrase(new Phrase());
				Columns[3].setPhrase(new Phrase());
				Phrase t = new Phrase("\nTotal Amount: ");
				t.setFont(smallbold);			
				Columns[4].setPhrase(t);
				Columns[5].setPhrase(new Phrase("\n"+total));
				for (int j = 0; j < N; j++) {
					columnsTitle.addCell(Columns[j]);
				}
>>>>>>> 3d49c3c052f0e8cebc1e0eb397a3bf8f4666a3a6
				doc.add(columnsTitle);
			
				return;
			}
			
			database.getStatement().executeUpdate(
					"INSERT INTO Proforma values ('" + documentID + "','"+
							rs.getString(1) + "','" + rs.getString(2) + "','" +
							rs.getString(3) + "','" + rs.getString(4)+ "','" +
							rs.getString(5) + "','" + rs.getString(6) +"','" +
							rs.getString(7) + "','"+ rs.getString(8) + "','" +
							rs.getString(9) + "','" + rs.getString(10)+ "','" +
							rs.getString(11) + "','"+exportDate + "','0' )");
			
			Columns[0].setPhrase(new Phrase(i + ""));
			i++;
			if (!prev.equals(rs.getString(3))) {
				prev = rs.getString(3);
				rooms = 1;
			}
			double roomCost =Double.parseDouble(rs.getString(9)) * Double.parseDouble(rs.getString(10))/100;
			total=total + roomCost;
			Columns[1].setPhrase(new Phrase(prev));
			Columns[2].setPhrase(new Phrase(rs.getString(2) + " "
					+ rs.getString(3)));
			Columns[3].setPhrase(new Phrase("Room No:" + rooms));
			Columns[4].setPhrase(new Phrase("1"));
			Columns[5].setPhrase(new Phrase(roomCost + ""));
			rooms++;
			for (int j = 0; j < N; j++) {
				columnsTitle.addCell(Columns[j]);
			}
		} while (rs.next());

		doc.add(columnsTitle);
		
	}

	public static void createAllProforma() throws Exception {

		DatabaseConnection database = new DatabaseConnection();
		String query = "SELECT *" + "FROM  COSTS " + "ORDER BY customerID ASC";

		File f = new File("Proformas");
		f.mkdir();

		try {

			ResultSet rs = database.createBackForwardStateMent().executeQuery(
					query);

			while (rs.next()) {
				CompanyDocument Companydocument = new CompanyDocument(3);
				Document document = new Document();

				PdfWriter.getInstance(document, new FileOutputStream(
						"Proformas/" + rs.getString(5) + ".pdf"));
				document.open();
				Companydocument.createHeader(document);

				Companydocument.createCustomerDetailsTable(document, rs);

				Companydocument.createCostTable(document, rs);
				rs.previous();
				Companydocument.Signatures(document);
				Companydocument.BankInfo(document);
				document.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		try {
			createAllProforma();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
