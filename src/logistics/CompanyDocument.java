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
import extras.ListManager;

/**
 * Class PDF (proforma, Invoice , receipt)
 * 
 *
 * @author TeamD
 *
 */
enum TYPE {
	INVOICE, RECEIPT, PROFORMA
}

public class CompanyDocument {

	/* All Document and Company Details */
	

	protected static final String CompanyName = "APHRODITEHILLS SERVICES LTD \n";
	protected static final String CustomerDetails = "\nCustomer Details:";
	protected static final String AccountCode = "Account Code:";
	protected static final String DocNumber = "Doc. Number:";
	protected static final String OrderNumber = "Order Number:";
	protected static final String DocDate = "DocDate";
	
	protected static final double VAT = 19/100;

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
	
	
	/**
	 * 
	 * Method create the Header for receipt Document
	 * 
	 *@param doc -Document file 
	 */
	public void receiptHeader(Document doc) throws Exception {

		Image image1 = Image.getInstance("PDF-IMAGE.png");
		doc.add(image1);

		Paragraph HeaderPara = new Paragraph(general, smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);
		doc.add(NewLine);
		
		Paragraph InvoicePara = new Paragraph("RECEIPT", MEDIUMUNDERLINE);
		InvoicePara.setAlignment(Element.ALIGN_CENTER);
		doc.add(InvoicePara);
		
		Paragraph DatesPara = new Paragraph(Dates);
		DatesPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(DatesPara);
		Paragraph CustDetails = new Paragraph(CustomerDetails, smallbold);
		CustDetails.setAlignment(Element.ALIGN_LEFT);
		doc.add(CustDetails);

	}
	

	/**
	 * 
	 * Method create the Header for invoice Document
	 * 
	 *@param doc -Document file 
	 */
	public void invoiceHeader(Document doc) throws Exception {

		Image image1 = Image.getInstance("PDF-IMAGE.png");
		doc.add(image1);

		Paragraph HeaderPara = new Paragraph(general, smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);
		doc.add(NewLine);

			Paragraph InvoicePara = new Paragraph("INVOICE", MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
			
			Paragraph DatesPara = new Paragraph(Dates);
			DatesPara.setAlignment(Element.ALIGN_CENTER);
			doc.add(DatesPara);
			Paragraph CustDetails = new Paragraph(CustomerDetails, smallbold);
			CustDetails.setAlignment(Element.ALIGN_LEFT);
			doc.add(CustDetails);

	}

	/**
	 * 
	 * Method create the Header for Proforma Document
	 * 
	 *@param doc -Document file 
	 */
	public void proformaHeader(Document doc) throws Exception {

		Image image1 = Image.getInstance("PDF-IMAGE.png");
		doc.add(image1);

		Paragraph HeaderPara = new Paragraph(general, smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);
		doc.add(NewLine);

			Paragraph InvoicePara = new Paragraph("Proforma", MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
			
			Paragraph DatesPara = new Paragraph(Dates);
			DatesPara.setAlignment(Element.ALIGN_CENTER);
			doc.add(DatesPara);
			Paragraph CustDetails = new Paragraph(CustomerDetails, smallbold);
			CustDetails.setAlignment(Element.ALIGN_LEFT);
			doc.add(CustDetails);

	}
	
	
	/**
	 * 
	 * Method create the Customer Details Table for
	 * Prodorma document. Connect to Database and 
	 * retrieve the number of this type Document.
	 * After that Update the number of this type 
	 * Document by 1. At last, create table to 
	 * save all customer Details and also date 
	 * and number of Document and write them 
	 * into PDF
	 *
	 * 
	 *@param doc -Document file 
	 *@param rs -ResltSet customer data
	 */
	public void createCustomerDetailsTableProforma(Document doc, ResultSet rs)
			throws Exception {

		String exportDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar
				.getInstance().getTime());
		DatabaseConnection database = new DatabaseConnection();
		ResultSet proforma = database.getStatement().executeQuery(
				"SELECT docID " + "FROM DocumentsIDS "
						+ "WHERE docType = 'Proforma' ");
		
		int documentID =0;
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

		String documentDetailsString = documentType(TYPE.PROFORMA);
		PdfPTable CustomerDetailsTable = new PdfPTable(2); // Megalos Pinakas
		PdfPCell CustomerDetails = new PdfPCell(new Phrase(customerName + "\n"
				+ address));// aristeri Plevra
		CustomerDetails.setHorizontalAlignment(Element.ALIGN_LEFT);

		PdfPCell AllCodes = new PdfPCell(); // De3ia keli megalo pinaka p krata
											// tous kodikous

		CustomerDetails.setBorderWidth(0);
		AllCodes.setBorderWidth(0);

		PdfPTable CodesTable = new PdfPTable(2); // Pinakas Kodikwn
		PdfPCell CodesDefinition = new PdfPCell(new Phrase(
				documentDetailsString)); // De3i keli me names
		PdfPCell Codes = new PdfPCell(new Phrase(customerID + "\n" + documentID
				+ "\n" + exportDate)); // aristero
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
	
	/**
	 * 
	 * Method create the Customer Details Table for
	 * Invoice document. Connect to Database and 
	 * retrieve the number of this type Document.
	 * After that Update the number of this type 
	 * Document by 1. At last, create table to 
	 * save all customer Details and also date 
	 * and number of Document and write them 
	 * into PDF 
	 *
	 * 
	 *@param doc -Document file 
	 *@param rs -ResltSet customer data
	 */
	public void createCustomerDetailsTableInvoice(Document doc, ResultSet rs)
			throws Exception {

		String exportDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar
				.getInstance().getTime());

		DatabaseConnection database = new DatabaseConnection();
		ResultSet proforma = database.getStatement().executeQuery(
				"SELECT docID " + "FROM DocumentsIDS "
						+ "WHERE docType = 'Invoice' ");
		int documentID = 0;
		if (proforma.next()) {
			documentID = proforma.getInt(1);
			database.getStatement().execute(
					"UPDATE DocumentsIDS " + "SET docID='" + (documentID + 1)
							+ "' WHERE docType = 'Invoice' ");
		} else {
			System.exit(-1);

		}
		proforma.close();

		String customerName = "\n" + rs.getString(6) + " " + rs.getString(7);
		String address = rs.getString(8) + " " + rs.getString(9) + ",\n"
				+ rs.getString(12);
		String customerID = rs.getString(5);
		System.out.println(customerName);
		
		String documentDetailsString = documentType(TYPE.INVOICE);
		PdfPTable CustomerDetailsTable = new PdfPTable(2); // Megalos Pinakas
		PdfPCell CustomerDetails = new PdfPCell(new Phrase(customerName + "\n"
															+ address));// aristeri Plevra
		CustomerDetails.setHorizontalAlignment(Element.ALIGN_LEFT);

		PdfPCell AllCodes = new PdfPCell(); // De3ia keli megalo pinaka p krata
											// tous kodikous

		CustomerDetails.setBorderWidth(0);
		AllCodes.setBorderWidth(0);

		PdfPTable CodesTable = new PdfPTable(2); // Pinakas Kodikwn
		PdfPCell CodesDefinition = new PdfPCell(new Phrase(
				documentDetailsString)); // De3i keli me names
		PdfPCell Codes = new PdfPCell(new Phrase(customerID + "\n" + documentID
				+ "\n" + exportDate)); // aristero


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

   /**
	 * 
	 * Method create String for Details about 
	 * the Document.
	 *
	 * 
	*@param type -enumeration Document type
	 */
	private String documentType(TYPE type) {

		switch(type){
			case INVOICE:	return AccountCode + "\n" + DocNumber + "\n" + OrderNumber + "\n"
							+ DocDate;
			case PROFORMA: 	return AccountCode + "\n" + DocNumber + "\n" + DocDate;
			case RECEIPT:   return AccountCode + "\n" + DocNumber + "\n" + DocDate;
		}
		
		return "Error";
	}
 /**
	 * 
	 * Method create the Signatures area on PDF
	 *
	 * 
	 *@param doc -Document file 
	 *@param type -enumeration Document type
	 */
	public void Signatures(Document doc,TYPE type) throws Exception {

		PdfPTable Signature = new PdfPTable(2);
		doc.add(NewLine);
		Signature.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		
		switch (type){
		
		case PROFORMA:
		case INVOICE:  	Phrase t = new Phrase(
						"CUSTOMER \n\n ________________________________ \n\t " +

						"                         Signature");
						LeftCell.addElement(t);
						break;
		
		
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
 /**
	 * 
	 * Method add into the PDF the hotel details 
	 * And some other Details different for each 
	 * Document Type
	 *	 
	 * 
	 *@param doc -Document file 
	 *@param type -enumeration Document type
	 */
	public void BankInfo(Document doc,TYPE type) throws Exception {

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
		
		Paragraph noVAT2;
		switch (type){
		case PROFORMA :
						Paragraph noVAT1 = new Paragraph("This is not a VAT invoice");
						noVAT1.setAlignment(Element.ALIGN_CENTER);
						doc.add(noVAT1);
						noVAT2 = new Paragraph(
						"The above amount is payable with immediate effect", small);
						noVAT2.setAlignment(Element.ALIGN_CENTER);
						doc.add(noVAT2);
						break;
		case INVOICE: 
						doc.add(NewLine);
						noVAT2 = new Paragraph(
						"The above amount is payable 30 days,if not paid interest at the rate 8%  pa will be charged",
						smallerbold);
						noVAT2.setAlignment(Element.ALIGN_CENTER);
						doc.add(noVAT2);
						break;
		default:
						break;
		}

	}
 /**
	 * 
	 * Method create and Add into file
	 * cost table for Proforma. At this point 
	 * we use tables to write data in file.
	 * At the same time connected to Database 
	 * and save all data for each record on 
	 * Proforma.
	 *	 
	 * 
	 *@param doc -Document file 
	 *@param type -enumeration Document type
	 */
	public void createCostTableProforma(Document doc, ResultSet rs)
			throws Exception {

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

		double total = 0;

		titles[0] = new Phrase("S/N");
		titles[1] = new Phrase("PlotNo");
		titles[2] = new Phrase("Location/Type");
		titles[3] = new Phrase("Description");
		titles[4] = new Phrase("Qty");
		titles[5] = new Phrase("Amount");

		for (int j = 0; j < N; j++) {
			titles[j].setFont(smallbold);
			Columns[j].addElement(titles[j]);
			columnsTitle.addCell(Columns[j]);
		}

		columnsTitle.setWidthPercentage(100);

		String prev = rs.getString(1);
		int documentID=0;  // Prepei na to piano apo ti vasi //
		String exportDate = new SimpleDateFormat("dd/MM/yyyy")
		.format(Calendar.getInstance().getTime());
		do {
			

			if (!CustomerID.equals(rs.getString(4))) {
				Columns[0].setPhrase(new Phrase());
				Columns[1].setPhrase(new Phrase());
				Columns[2].setPhrase(new Phrase());
				Columns[3].setPhrase(new Phrase());
				Phrase t = new Phrase("\nTotal Amount: ");
				t.setFont(smallbold);
				Columns[4].setPhrase(t);
				Columns[5].setPhrase(new Phrase("\n" + total));
				for (int j = 0; j < N; j++) {
					columnsTitle.addCell(Columns[j]);
				}

				doc.add(columnsTitle);
				return;
			}

			database.getStatement().executeUpdate(
					"INSERT INTO Proforma values ('" + documentID + "','"
							+ rs.getString(1) + "','" + rs.getString(2) + "','"
							+ rs.getString(3) + "','" + rs.getString(4) + "','"
							+ rs.getString(5) + "','" + rs.getString(6) + "','"
							+ rs.getString(7) + "','" + rs.getString(8) + "','"
							+ rs.getString(9) + "','" + rs.getString(10)
							+ "','" + rs.getString(11) + "','" + exportDate
							+ "','0' )");

			Columns[0].setPhrase(new Phrase(i + ""));
			i++;
			if (!prev.equals(rs.getString(1))) {
				prev = rs.getString(1);
				rooms = 1;
			}
			double roomCost = Double.parseDouble(rs.getString(9))
					* Double.parseDouble(rs.getString(10)) / 100;
			total = total + roomCost;
			Columns[1].setPhrase(new Phrase(rs.getString(1)));
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

		Columns[0].setPhrase(new Phrase());
		Columns[1].setPhrase(new Phrase());
		Columns[2].setPhrase(new Phrase());
		Columns[3].setPhrase(new Phrase());
		Phrase t = new Phrase("\nTotal Amount: ");
		t.setFont(smallbold);
		Columns[4].setPhrase(t);
		Columns[5].setPhrase(new Phrase("\n" + total));
		for (int j = 0; j < N; j++) {
			columnsTitle.addCell(Columns[j]);
		}
		doc.add(columnsTitle);

	}
	
	/**
	 * 
	 * Method create and Add into file
	 * cost table for Receipt. At this point 
	 * we use tables to write data in file.
	 * At the same time connected to Database 
	 * and save all data for each record on 
	 * Receipt.
	 *	 
	 * 
	 *@param doc -Document file 
	 *@param type -enumeration Document type
	 */
	public void createCostTableReceipt(Document doc, ResultSet rs,TYPE type)
			throws Exception {
		DatabaseConnection database = new DatabaseConnection();
		String exportDate = new SimpleDateFormat("dd/MM/yyyy")
		.format(Calendar.getInstance().getTime());
		
		int id=0;
		ResultSet ids;
		String query;
		query = "SELECT docID FROM DocumentsIDS WHERE docType =  'receipt'";
		 ids = database.getStatement().executeQuery(query);
		 if (ids.next())
		 id = (ids.getInt(1)+1);
		query = "UPDATE DocumentsIDS SET docID = '"+id + "WHERE docType = 'receipt'";
		database.getStatement().executeUpdate(query);
	
		
					
		int N = 6;
		int counter=1;
		String CustomerID = 0+"";
		
		CustomerID = rs.getString(4);
		query = "UPDATE Invoice set toPaid ='1' WHERE customerID='"+CustomerID+"'";
		database.getStatement().executeUpdate(query);
		PdfPTable columnsTitle = new PdfPTable(N);
		PdfPCell[] Columns = new PdfPCell[N];

		for (int i = 0; i < N; i++) {
			Columns[i] = new PdfPCell();
			Columns[i].setHorizontalAlignment(Element.ALIGN_LEFT);
			Columns[i].setBorderWidth(0);
		}

		Phrase[] titles = new Phrase[N];
		
		int rooms = 1;
		double total = 0;
		String prev = rs.getString(2);

		titles[0] = new Phrase("S/N");
		titles[1] = new Phrase("PlotNo");
		titles[2] = new Phrase("Location/Type");
		titles[3] = new Phrase("Description");
		titles[4] = new Phrase("Qty");
		titles[5] = new Phrase("Amount");

		for (int j = 0; j < N; j++) {
			titles[j].setFont(smallbold);
			Columns[j].addElement(titles[j]);
			columnsTitle.addCell(Columns[j]);
		}

		columnsTitle.setWidthPercentage(100);
		
		do{
			
			
			database.getStatement().executeUpdate(
				   	"INSERT INTO Receipt values ('" + id + "','"
							+ rs.getString(2) + "','" + rs.getString(3) + "','"
							+ rs.getString(4) + "','" + rs.getString(5) + "','"
							+ rs.getString(6) + "','" + rs.getString(7) + "','"
							+ rs.getString(8) + "','" + rs.getString(9) + "','"
							+ rs.getString(10) + "','" + rs.getString(11)
							+ "','" + rs.getString(12) + "','" + exportDate
							+ " ')");
			
			if (!prev.equals(rs.getString(2))) {
				prev = rs.getString(2);
				rooms = 1;
			}
			
			double roomCost = Double.parseDouble(rs.getString(10))
					* Double.parseDouble(rs.getString(11)) / 100;
			total = total + roomCost;
			Columns[0].setPhrase(new Phrase(counter+""));
			Columns[1].setPhrase(new Phrase(prev));
			Columns[2].setPhrase(new Phrase(rs.getString(3) + " "
					+ rs.getString(4)));
			Columns[3].setPhrase(new Phrase("Room No:" + rooms));
			Columns[4].setPhrase(new Phrase("1"));
			Columns[5].setPhrase(new Phrase(roomCost + ""));
			counter++;
			rooms++;
			for (int j = 0; j < N; j++) {
				columnsTitle.addCell(Columns[j]);
			}

		}while (rs.next());
		
		
		double vat = total*VAT;
		Columns[0].setPhrase(new Phrase());
		Columns[1].setPhrase(new Phrase());
		Columns[2].setPhrase(new Phrase());
		Columns[3].setPhrase(new Phrase());
		Phrase t = new Phrase("\nVAT 19%:\nTotal Amount: ");
		t.setFont(smallbold);
		Columns[4].setPhrase(t);
		Columns[5].setPhrase(new Phrase("\n" + (vat)+"\n"+(total+vat)));
		for (int j = 0; j < N; j++) {
			columnsTitle.addCell(Columns[j]);
		}
		doc.add(columnsTitle);

	}
	
	
	/**
	 * 
	 * Method create and Add into file
	 * cost table for Invoice. At this point 
	 * we use tables to write data in file.
	 * At the same time connected to Database 
	 * and save all data for each record on 
	 * Invoice.
	 *	 
	 * 
	 *@param doc -Document file 
	 *@param type -enumeration Document type
	 */
	public void createCostTableInvoice(Document doc, ResultSet rs,TYPE type)
			throws Exception {
		DatabaseConnection database = new DatabaseConnection();
		String exportDate = new SimpleDateFormat("dd/MM/yyyy")
		.format(Calendar.getInstance().getTime());
		
		int id=0;
		ResultSet ids;
		String query;

						 query = "SELECT docID FROM DocumentsIDS WHERE docType =  'invoice'";
						 ids = database.getStatement().executeQuery(query);
						 if (ids.next())
						 id = (ids.getInt(1)+1);
						query = "UPDATE DocumentsIDS SET docID = '"+id + "' WHERE docType = 'invoice'";
						database.getStatement().executeUpdate(query);
					
						

		
		int N = 6;
		int counter=1;
		
	    String CustomerID = 0+"";
	  
	    CustomerID = rs.getString(4);
		query = "UPDATE Proforma set toPaid ='1' WHERE customerID='"+CustomerID+"'";
		database.getStatement().executeUpdate(query);
		PdfPTable columnsTitle = new PdfPTable(N);
		PdfPCell[] Columns = new PdfPCell[N];

		for (int i = 0; i < N; i++) {
			Columns[i] = new PdfPCell();
			Columns[i].setHorizontalAlignment(Element.ALIGN_LEFT);
			Columns[i].setBorderWidth(0);
		}

		Phrase[] titles = new Phrase[N];
		
		int rooms = 1;
		double total = 0;
		String prev = rs.getString(2);

		titles[0] = new Phrase("S/N");
		titles[1] = new Phrase("PlotNo");
		titles[2] = new Phrase("Location/Type");
		titles[3] = new Phrase("Description");
		titles[4] = new Phrase("Qty");
		titles[5] = new Phrase("Amount");

		for (int j = 0; j < N; j++) {
			titles[j].setFont(smallbold);
			Columns[j].addElement(titles[j]);
			columnsTitle.addCell(Columns[j]);
		}

		columnsTitle.setWidthPercentage(100);
		
		do{
			
			if (!prev.equals(rs.getString(2))) {
				prev = rs.getString(2);
				rooms = 1;
			}
			database.getStatement().executeUpdate(
			    	"INSERT INTO Invoice values ('" + id + "','"
						+ rs.getString(2) + "','" + rs.getString(3) + "','"
						+ rs.getString(4) + "','" + rs.getString(5) + "','"
						+ rs.getString(6) + "','" + rs.getString(7) + "','"
						+ rs.getString(8) + "','" + rs.getString(9) + "','"
						+ rs.getString(10) + "','" + rs.getString(11)
						+ "','" + rs.getString(12) + "','" + exportDate
						+ "','0' )");
			
			double roomCost = Double.parseDouble(rs.getString(10))
					* Double.parseDouble(rs.getString(11)) / 100;
			total = total + roomCost;
			Columns[0].setPhrase(new Phrase(counter+""));
			Columns[1].setPhrase(new Phrase(prev));
			Columns[2].setPhrase(new Phrase(rs.getString(3) + " "
					+ rs.getString(4)));
			Columns[3].setPhrase(new Phrase("Room No:" + rooms));
			Columns[4].setPhrase(new Phrase("1"));
			Columns[5].setPhrase(new Phrase(roomCost + ""));
			counter++;
			rooms++;
			for (int j = 0; j < N; j++) {
				columnsTitle.addCell(Columns[j]);
			}

		}while (rs.next());
		
		
		double vat = total*VAT;
		
		Columns[0].setPhrase(new Phrase());
		Columns[1].setPhrase(new Phrase());
		Columns[2].setPhrase(new Phrase());
		Columns[3].setPhrase(new Phrase());
		Phrase t = new Phrase("\nTotal Amount: ");
		t.setFont(smallbold);
		Columns[4].setPhrase(t);
		Columns[5].setPhrase(new Phrase("\n" + (vat)+"\n"+(total+vat)));
		for (int j = 0; j < N; j++) {
			columnsTitle.addCell(Columns[j]);
		}
		doc.add(columnsTitle);

	}
	/**
	 * 
	 * Method create Proforma file
	 * for all customer
 	 *	 
	 * 
	 */
	public static void createAllProforma() throws Exception {

		DatabaseConnection database = new DatabaseConnection();
		String query = "SELECT *" + " FROM  COSTS " + "ORDER BY customerID ASC";

		File f = new File("Proformas");
		f.mkdir();

		try {

			ResultSet rs = database.createBackForwardStateMent().executeQuery(
					query);

			while (rs.next()) {
				CompanyDocument Companydocument = new CompanyDocument();
				Document document = new Document();

				PdfWriter.getInstance(document, new FileOutputStream(
						"Proformas/" + rs.getString(5) + ".pdf"));
				document.open();
				Companydocument.proformaHeader(document);

				Companydocument
						.createCustomerDetailsTableProforma(document, rs);

				Companydocument.createCostTableProforma(document, rs);
				rs.previous();
				Companydocument.Signatures(document,TYPE.PROFORMA);
				Companydocument.BankInfo(document,TYPE.PROFORMA);
				document.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
	 * 
	 * Method create Invoice file
	 * for this customer customer
 	 *	 
	 * @param customer - item from drop-down list
	 */
	public static void CreateInvoice(String customer) throws Exception {

		DatabaseConnection database = new DatabaseConnection();

		String[] Customer = ListManager.SplitThreeItem(customer);

		String query = "SELECT * " + "FROM PROFORMA " + "WHERE customerID = '"
				+ Customer[0] + "' and toPaid = 0 ";
		
		
		File f = new File("Invoices");
		f.mkdir();

		ResultSet rs = database.getStatement().executeQuery(query);
		
		
		CompanyDocument Companydocument = new CompanyDocument();
		Document document = new Document();
		if (rs.next()) {

			PdfWriter.getInstance(document, new FileOutputStream("Invoices/"
					+ rs.getString(5) +"_" +rs.getString(6)+ "_"+rs.getString(7) + ".pdf"));
			document.open();
			Companydocument.invoiceHeader(document);
			Companydocument.createCustomerDetailsTableInvoice(document, rs);	
			Companydocument.createCostTableInvoice(document, rs,TYPE.INVOICE);
			Companydocument.Signatures(document,TYPE.INVOICE);
			Companydocument.BankInfo(document,TYPE.INVOICE);
			document.close();
			
		}
	
	}
	/**
	 * 
	 * Method create Receipt file
	 * for this customer customer
 	 *	 
	 * @param customer - item from drop-down list
	 */
	public static void CreateReceipt(String customer) throws Exception {
		DatabaseConnection database = new DatabaseConnection();

		String[] Customer = ListManager.SplitThreeItem(customer);

		String query = "SELECT * " + "FROM Invoice " + "WHERE customerID = '"  
				+ Customer[0] + "' and toPaid = 0 ";
		
		
		File f = new File("Receipt");
		f.mkdir();

		ResultSet rs = database.getStatement().executeQuery(query);
		
		
		CompanyDocument Companydocument = new CompanyDocument();
		Document document = new Document();
		if (rs.next()) {

			PdfWriter.getInstance(document, new FileOutputStream("RECEIPT/"
					+ rs.getString(5) +"_" +rs.getString(6)+ "_"+rs.getString(7) + ".pdf"));
			document.open();
			Companydocument.receiptHeader(document);
			Companydocument.createCustomerDetailsTableReceipt(document, rs);	
			Companydocument.createCostTableReceipt(document, rs,TYPE.RECEIPT);
			Companydocument.Signatures(document,TYPE.RECEIPT);
			Companydocument.BankInfo(document,TYPE.RECEIPT);
			document.close();
			
		}
	
	}

	private void createCustomerDetailsTableReceipt(Document document,
			ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
	 /**
		 * Main method
		 * Useful only for testing
		 *
		 * @param  Srting[]
		 */
	public static void main(String args[]) {

		try {
			createAllProforma();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
