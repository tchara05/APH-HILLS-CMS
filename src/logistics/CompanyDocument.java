package logistics;

import java.io.FileOutputStream;
import java.sql.ResultSet;

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
	
    protected   final String CompanyName = "APHRODITEHILLS SERVICES LTD \n";
    protected   final String CustomerDetails = "\nCustomer Details:";
    protected   final String AccountCode = "Account Code:";
    protected   final String DocNumber = "Doc. Number:";
    protected   final String OrderNumber = "Order Number:";
    protected   final String DocDate = "DocDate";
    protected   final int INVOICE =1;
    protected   final int PROFORMA =2;
    protected   final int RECEIPT =3;

	protected   final Paragraph NewLine = new Paragraph("\n");
	
	protected   final String Dates = "ADVISE OF COMMON EXPESNES DUE";
	protected   final String general = "\n 1st Floor-Village Square \n Aphrodite Hills, 8509 - CYPRUS \n" +
								" P.O.Box 62769 - 8068 Paphos- \n" +
								"Tel: + 357 26828000 - - Fax: + 357 26828001 \n" +
								"Email: info@aphroditehills.com, Web: www.aphroditehills.com";
	
	
	// Fonts For The Document //
	
	protected   Font BIGBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 18 , Font.BOLD);
	protected   Font MEDIUMUNDERLINE = new Font (Font.FontFamily.TIMES_ROMAN,16,Font.UNDERLINE);
	protected   Font MEDIUMBOLD = new Font (Font.FontFamily.TIMES_ROMAN,14,Font.BOLD);			
	protected   Font smallbold = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
	protected   Font small = new Font(Font.FontFamily.TIMES_ROMAN,8);
	protected   Font smallerbold = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.BOLD);
	
	
	
	/* All Customer and Property Details -- Dynamic variables that initialize by database data */
	
	private int type;
	private String customerName;
	private int customerID;
	private int documentID;
	private String address;
	
	
	
	private String location_Type;
	private String description;
	private int qty;
	private double amount;
	private int plotID;

	
	public CompanyDocument (int type){
		this.type = type;
	}

	
	
	
	
	
	public void createHeader(Document doc) throws Exception{
		
		Image image1 = Image.getInstance("PDF-IMAGE.png");
		doc.add(image1);
		
		Paragraph HeaderPara = new Paragraph(general,smallbold);
		HeaderPara.setAlignment(Element.ALIGN_CENTER);
		doc.add(HeaderPara);
		
		doc.add(NewLine);
		
		if (type ==INVOICE){
			Paragraph InvoicePara = new Paragraph("INVOICE",MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
		}else if (type == RECEIPT){
			Paragraph InvoicePara = new Paragraph("RECEIPT",MEDIUMUNDERLINE);
			InvoicePara.setAlignment(Element.ALIGN_CENTER);
			doc.add(InvoicePara);
			
		}
		
		if (type != RECEIPT) {
			Paragraph DatesPara = new Paragraph(Dates);
			DatesPara.setAlignment(Element.ALIGN_CENTER);
			doc.add(DatesPara);
		}
		Paragraph CustDetails = new Paragraph(CustomerDetails,smallbold);
		CustDetails.setAlignment(Element.ALIGN_LEFT);
		doc.add(CustDetails);
		

	}
	
	
	public   void createCustomerDetailsTable(Document doc) throws Exception {
		
		
		String documentDetailsString = documentType();
		PdfPTable CustomerDetailsTable = new PdfPTable(2);	  //Megalos Pinakas
		PdfPCell CustomerDetails = new PdfPCell(new Phrase("Kokos\nKokos\nKokos"));// aristeri Plevra
		CustomerDetails.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		PdfPCell AllCodes = new PdfPCell(); //De3ia keli megalo pinaka p krata tous kodikous
		
		CustomerDetails.setBorderWidth(0);
		AllCodes.setBorderWidth(0);
		
		PdfPTable CodesTable = new PdfPTable(2); // Pinakas Kodikwn 
		PdfPCell CodesDefinition = new PdfPCell(new Phrase(documentDetailsString)); //De3i keli me names
		PdfPCell Codes = new PdfPCell (new Phrase("1\n1\n1\n1")); //aristero kelli me arithmous
		
		CodesDefinition.setHorizontalAlignment(Element.ALIGN_LEFT);
		Codes.setHorizontalAlignment(Element.ALIGN_LEFT);
		CodesDefinition.setBorderWidth(0);
		Codes.setBorderWidth(0);
	
		CodesTable.addCell(CodesDefinition);
		CodesTable.addCell(Codes);
		

		CustomerDetailsTable.setWidthPercentage(100);

		CustomerDetailsTable.addCell(CustomerDetails);
		
		AllCodes.addElement(CodesTable); 		//Isagwgi pinaka kwdikwn stin keli tou megalou pinaka
		CustomerDetailsTable.addCell(AllCodes); //eisagogi keliou kwdikwn stin de3ia plevra

		doc.add(CustomerDetailsTable);
		
		
	}
	
	private   String documentType(){
		
		String documentDetailsString="";
		
		
		if (type ==INVOICE)
		return documentDetailsString = AccountCode + "\n" + DocNumber + "\n"
				+ OrderNumber + "\n" + DocDate;
		else if(type == PROFORMA  || type== RECEIPT)
			return documentDetailsString = AccountCode + "\n" + DocNumber + "\n" + DocDate;
		else
			return "Error";
		
	}
	
	
	public   void Signatures(Document doc) throws Exception{
		
		PdfPTable Signature = new PdfPTable(2);
		
		Signature.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		if (type!=RECEIPT){
			Phrase t = new Phrase("CUSTOMER \n\n ________________________________ \n\t " +
				
				"                         Signature");
			LeftCell.addElement(t);
		}
		Signature.addCell(LeftCell);
		
		
		Signature.setWidthPercentage(100);
		PdfPCell RightCell = new PdfPCell();
		RightCell.setBorderWidth(0);
		RightCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		Phrase W = new Phrase("APHRODITE HILL SERVICE LTD \n\n ________________________________ \n" +
				              "                         Signature");
		RightCell.addElement(W);
		
		
		
		Signature.addCell(RightCell);
		
		doc.add(Signature);
		
		
		
		
		
		
	}
	
	
	
	public   void BankInfo(Document doc) throws Exception{
		
		PdfPTable BankINF = new PdfPTable(1);
		
		BankINF.setWidthPercentage(100);
		PdfPCell LeftCell = new PdfPCell();
		LeftCell.setBorderWidth(0);
		LeftCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		Phrase t = new Phrase("Please issue payment to: Aphrodite Hills Services Ltd \nMailing address:" +
							  "            P.O.Box 62769 \n        " +
							  "                              8068 Paphos\n             " +
							  "                         CYPRUS\n\nOr Bank Transfer to:  Bank of Cyprus\n                                  Account Name: Aphrodite Hills Services Ltb\n                                  Acocount Number:35701306518\n                                  Swift Code:BCYPCY2N\n                                  IBAN:CY08002001950000357013065018");
		t.setFont(small);
		LeftCell.addElement(t);
		
		BankINF.addCell(LeftCell);
		
		doc.add(NewLine);

				
		doc.add(BankINF);
		if (type == PROFORMA){
			Paragraph noVAT1 = new Paragraph("This is not a VAT invoice");
			noVAT1.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT1);
			Paragraph noVAT2 = new Paragraph("The above amount is payable with immediate effect",small);
			noVAT2.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT2);
		}else if (type ==INVOICE){
			doc.add(NewLine);	
			Paragraph noVAT2 = new Paragraph("The above amount is payable 30 days,if not paid interest at the rate 8%  pa will be charged",smallerbold );
			noVAT2.setAlignment(Element.ALIGN_CENTER);
			doc.add(noVAT2);
		}
			
	}
	
	public   void createCostTable(Document doc) throws Exception{	
		
		int N=0;
		if (type == INVOICE){
	       N = 5;
		}else if (type == PROFORMA){
		   N = 6;
		}else if (type ==RECEIPT){
		   N=3;
		}
		
		PdfPTable columnsTitle = new PdfPTable (N);
		
		PdfPCell[] Columns = new PdfPCell[N];
	
		for(int i = 0;i<N;i++){
			Columns[i] = new PdfPCell();
			Columns[i].setHorizontalAlignment(Element.ALIGN_LEFT);
			Columns[i].setBorderWidth(0);
		}
		
		Phrase[] titles =new Phrase[N];
		
		
		if (N==5){
			titles[0]= new Phrase("S/N");
			titles[1] =new Phrase("PlotNo");
			titles[2] =new Phrase("Location/Type");
			titles[3] =new Phrase("Quantity");
			titles[4] =new Phrase("Amount");
		}else if (N==6 ){
			titles[0]= new Phrase("S/N");
			titles[1] =new Phrase("PlotNo");
			titles[2] =new Phrase("Location/Type");
			titles[3] = new Phrase("Description");
			titles[4] = new Phrase("Qty");
			titles[5] = new Phrase("Amount");
		}else if (N==3){
			titles[0]= new Phrase("Details");
			titles[1] =new Phrase("Quantity");
			titles[2] =new Phrase("Amount");
		}
		
		
		
		
		
		
		for (int i = 0;i<N;i++){
			titles[i].setFont(smallbold);
			Columns[i].addElement(titles[i]); // Mpenoun oi titloi pou einai fraseis mesa sta kelia //
			columnsTitle.addCell(Columns[i]); // Mpenoun ta kelia mesa sto pinaka //
		}
			
		columnsTitle.setWidthPercentage(100);
		doc.add(columnsTitle);
		
	}
	
	
	
	public static void main(String args[]) throws Exception{
		
		
		CompanyDocument Companydocument = new CompanyDocument(1);
		Document document = new Document();
		
		// Creating The Table //
		PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
		document.open();
		
		Companydocument.createHeader(document);
		Companydocument.createCustomerDetailsTable(document);
		Companydocument.createCostTable(document);
		Companydocument.Signatures(document);
		Companydocument.BankInfo(document);
		document.close();
		
		
		
	}
	

}
