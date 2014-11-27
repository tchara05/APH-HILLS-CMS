/*

package Forms;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFexporter implements Runnable {

	private String CompanyName = "APHRODITEHILLS SERVICES LTD \n";

	private String CustomerDetails = "\nCustomer Details:";
	private String AccountCode = "Account Code:";
	private String DocNumber = "Doc. Number:";
	private String OrderNumber = "Order Number:";
	private String DocDate = "DocDate";
	private static int INVOICE = 1;
	private static int PROFORMA = 2;
	private static int RECEIPT = 3;
	private int DocType;

	private class InvoiceExport implements Runnable {

		@Override
		public void run() {

			Document doc = new Document();

			String name = "INVOICE.pdf";
			int type = INVOICE;

			try {

				PdfWriter.getInstance(doc, new FileOutputStream(name));
				doc.open();

				createHeader(type, doc);
				doc.add(NewLine);
				createDetailsTable(type, doc);
				doc.add(NewLine);
				createCostTable(type, doc);
				doc.add(NewLine);
				Signatures(type, doc);
				doc.add(NewLine);
				if (type != RECEIPT) {
					BankInfo(type, doc);
				}
				doc.close();
			} catch (Exception e) {};

		}

	}

	private class ReceiptExport implements Runnable {

		@Override
		public void run() {

			Document doc = new Document();

			String name = "RECEIPT.pdf";
			int type = RECEIPT;

			try {

				PdfWriter.getInstance(doc, new FileOutputStream(name));
				doc.open();

				createHeader(type, doc);
				doc.add(NewLine);
				createDetailsTable(type, doc);
				doc.add(NewLine);
				createCostTable(type, doc);
				doc.add(NewLine);
				Signatures(type, doc);
				doc.add(NewLine);
				if (type != RECEIPT) {
					BankInfo(type, doc);
				}
				doc.close();
			} catch (Exception e) {};

			// TODO Auto-generated method stub

		}

	}
	
	
	private class ProformaExport implements Runnable{

		@Override
		public void run() {
			Document doc = new Document();

			String name = "PROFORMA.pdf";
			int type = PROFORMA;

			try {

				PdfWriter.getInstance(doc, new FileOutputStream(name));
				doc.open();

				createHeader(type, doc);
				doc.add(NewLine);
				createDetailsTable(type, doc);
				doc.add(NewLine);
				createCostTable(type, doc);
				doc.add(NewLine);
				Signatures(type, doc);
				doc.add(NewLine);
				if (type != RECEIPT) {
					BankInfo(type, doc);
				}
				doc.close();
			} catch (Exception e) {};

			
		}
		
		
		
		
	}

	private static Paragraph NewLine = new Paragraph("\n");

	private String Invoice = "INVOICE";
	private String Receipt = "RECEIPT";
	private String Dates = "ADVISE OF COMMON EXPESNES DUE";
	private String general = "\n 1st Floor-Village Square \n Aphrodite Hills, 8509 - CYPRUS \n"
			+ " P.O.Box 62769 - 8068 Paphos- \n"
			+ "Tel: + 357 26828000 - - Fax: + 357 26828001 \n"
			+ "Email: info@aphroditehills.com, Web: www.aphroditehills.com";

	private static Font BIGBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font MEDIUMUNDERLINE = new Font(Font.FontFamily.TIMES_ROMAN,
			16, Font.UNDERLINE);
	private static Font MEDIUMBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 14,
			Font.BOLD);
	private static Font smallbold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);
	private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 8);
	private static Font smallerbold = new Font(Font.FontFamily.TIMES_ROMAN, 8,
			Font.BOLD);

	public void createHeader(int type, Document doc) throws Exception {

		Paragraph TitlePara = new Paragraph(CompanyName, BIGBOLD);
		TitlePara.setAlignment(Element.ALIGN_CENTER);
		doc.add(TitlePara);

		Paragraph HeaderPara = new Paragraph(general, smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);

		doc.add(NewLine);
		if (type == INVOICE) {
			Paragraph InvoicePara = new Paragraph(Invoice, MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
		} else if (type == RECEIPT) {
			Paragraph InvoicePara = new Paragraph(Receipt, MEDIUMUNDERLINE);
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

	public void createDetailsTable(int type, Document doc) throws Exception {

		String documentDetailsString = documentType(type);

		PdfPTable CustomerDetailsTable = new PdfPTable(2); // Megalos Pinakas
		PdfPCell CustomerDetails = new PdfPCell(new Phrase(
				"Kokos\nKokos\nKokos"));// aristeri Plevra
		CustomerDetails.setHorizontalAlignment(Element.ALIGN_LEFT);

		PdfPCell AllCodes = new PdfPCell(); // De3ia keli megalo pinaka p krata
											// tous kodikous

		CustomerDetails.setBorderWidth(0);
		AllCodes.setBorderWidth(0);

		PdfPTable CodesTable = new PdfPTable(2); // Pinakas Kodikwn
		PdfPCell CodesDefinition = new PdfPCell(new Phrase(
				documentDetailsString)); // De3i keli me names
		PdfPCell Codes = new PdfPCell(new Phrase("1\n1\n1\n1")); // aristero
																	// kelli me
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

	public void createCostTable(int type, Document doc) throws Exception {

		int N = 0;
		if (type == INVOICE) {
			N = 5;
		} else if (type == PROFORMA) {
			N = 6;
		} else if (type == RECEIPT) {
			N = 3;
		}

		PdfPTable columnsTitle = new PdfPTable(N);
		PdfPCell[] Columns = new PdfPCell[N];
		for (int i = 0; i < N; i++) {
			Columns[i] = new PdfPCell();
			Columns[i].setHorizontalAlignment(Element.ALIGN_LEFT);
			Columns[i].setBorderWidth(0);

		}

		Phrase[] titles = new Phrase[N];

		if (N == 5) {
			titles[0] = new Phrase("S/N");
			titles[1] = new Phrase("PlotNo");
			titles[2] = new Phrase("Location/Type");
			titles[3] = new Phrase("Quantity");
			titles[4] = new Phrase("Amount");
		} else if (N == 6) {
			titles[0] = new Phrase("S/N");
			titles[1] = new Phrase("PlotNo");
			titles[2] = new Phrase("Location/Type");
			titles[3] = new Phrase("Description");
			titles[4] = new Phrase("Qty");
			titles[5] = new Phrase("Amount");
		} else if (N == 3) {
			titles[0] = new Phrase("Details");
			titles[1] = new Phrase("Quantity");
			titles[2] = new Phrase("Amount");
		}

		for (int i = 0; i < N; i++) {
			titles[i].setFont(smallbold);
			Columns[i].addElement(titles[i]);
			columnsTitle.addCell(Columns[i]);
		}

		columnsTitle.setWidthPercentage(100);
		doc.add(columnsTitle);

	}

	private String documentType(int type) {

		String documentDetailsString;

		if (type == INVOICE)
			return documentDetailsString = AccountCode + "\n" + DocNumber
					+ "\n" + OrderNumber + "\n" + DocDate;
		else if (type == PROFORMA || type == RECEIPT)
			return documentDetailsString = AccountCode + "\n" + DocNumber
					+ "\n" + DocDate;
		else
			return "Error";

	}

	private void Signatures(int type, Document doc) throws Exception {

		PdfPTable Signature = new PdfPTable(2);

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

	private void BankInfo(int type, Document doc) throws Exception {

		PdfPTable BankINF = new PdfPTable(1);

		BankINF.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		Phrase t = new Phrase(
				"Please issue payment to:Aphrodite Hills Services Ltd \nMailing address:"
						+ "            P.O.Box 62769 \n        "
						+ "                              8068 Paphos\n             "
						+ "                         CYPRUS\n\nOr Bank Transfer to:  Bank of Cyprus\n                                  Account Name: Aphrodite Hills Services Ltb\n                                  Acocount Number:35701306518\n                                  Swift Code:BCYPCY2N\n                                  IBAN:CY08002001950000357013065018");
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

	public void creat_Invoice(int type) throws Exception {
		PDFexporter t = new PDFexporter();

		String name = "test.pdf";
		Document doc = new Document();
		if (type == INVOICE) {
			name = "INVOICE.pdf";
		} else if (type == PROFORMA) {
			name = "PROFORMA.pdf";
		} else if (type == RECEIPT) {
			name = "RECEIPT.pdf";

		}
		PdfWriter.getInstance(doc, new FileOutputStream(name));
		doc.open();

		t.createHeader(type, doc);
		doc.add(NewLine);
		t.createDetailsTable(type, doc);
		doc.add(NewLine);
		t.createCostTable(type, doc);
		doc.add(NewLine);
		t.Signatures(type, doc);
		doc.add(NewLine);
		if (type != RECEIPT) {
			t.BankInfo(type, doc);
		}
		doc.close();
		
		System.out.println("AAAAAAAAAAAA");

	}

	public void StartInvoiceExporter() {

		InvoiceExport t = new InvoiceExport();
		ReceiptExport r = new ReceiptExport();
		

		
		
		t.run();
		r.run();
		

	}
	
	public void StartProformaExporter(){
		
		ProformaExport p = new ProformaExport();
		p.run();
	}
	
	
	public void setDocType(int t){
		DocType = t;
	}
	
	
	@Override
	public void run() {
		
		if (DocType == INVOICE || DocType == RECEIPT){
			StartInvoiceExporter();
			
		}else{
			StartProformaExporter();
		}
		
		
		
		
	}
	
	public void shit(){
		for (int i = 0; i <1000;i++){
			System.out.println("Skata");
		}
	}

	public static void main(String args[]) throws Exception {

		
		

	}



}
*/
