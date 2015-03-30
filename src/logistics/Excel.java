package logistics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import extras.DatabaseConnection;
import extras.Query;


public class Excel {
	
	
	public static void createExcelFile(){
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet excelSheet = wb.createSheet("Test excel sheet");
		
		
		HSSFRow headerRow = excelSheet.createRow(0);
		HSSFCell propertyIDCell = headerRow.createCell((short) 0);
		HSSFCell propertyNameCell = headerRow.createCell((short) 1);
		HSSFCell propertyNumbersOfRooms = headerRow.createCell((short) 2);
		
		propertyIDCell.setCellValue("PROPERTY ID:");
		propertyNameCell.setCellValue("PROPERTY NAME and NUMBER:");
		propertyNumbersOfRooms.setCellValue("NUMBERS OF ROOMS");
		
		DatabaseConnection database = new DatabaseConnection();
		Statement stment = null;
		stment = database.getStatement();

		
		
		int row = 1;

		try {
			ResultSet rset = stment.executeQuery(Query.PLOTS_AND_ROOMS);			
			while (rset.next()) {
				
				String plotID = rset.getString(1);
				String plotName = rset.getString(3);
				String plotNumber = rset.getString(2);
				String plotRooms = rset.getString(4);
				int nums = rset.getInt(4);
						
				HSSFRow dataRow = excelSheet.createRow(row);

				HSSFCell plotIDCell = dataRow.createCell((short) 0);
				HSSFCell plotNameCell = dataRow.createCell((short) 1);
				HSSFCell rooms = dataRow.createCell((short) 2);
				
				
				plotNameCell.setCellValue(plotName  + " " +  plotNumber );
				plotIDCell.setCellValue(plotID+"  ");
				rooms.setCellValue(nums + " " );

				row++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String outputDirPath = "/Users/Theodoros/Desktop/properties.xls";
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(outputDirPath);
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
		
  public static void ReadExcel(){
	  
	  
	  DatabaseConnection data = new DatabaseConnection();
	  
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("/Users/Theodoros/Desktop/properties.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;
		    double roomValue=0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }
		    for(int r = 1; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	HSSFCell id = row.getCell((short) 0);
		        	String propID =id.getStringCellValue();
		        
	                if(id != null) {
	           
	                }
		            for(int c = 1 ; c < cols; c++) {
		                cell = row.getCell((short)c);
		                
		                if(cell != null) {
		                	
		                	try{
		                		System.out.print(cell.getStringCellValue() + " | ");
		                		
		                	}catch (Exception e){
		                		roomValue =cell.getNumericCellValue();
		                	data.getStatement().executeUpdate("INSERT INTO Rooms values('"+propID+"','"+roomValue+"','0')");
		                		System.out.print(roomValue+ " ");	
		
		                	}
		                }
		            }
		        }
		        System.out.println("Total Value: " + roomValue );
		    }
		    
		    
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
  }
		
		
	
	public static void main(String args[]) throws Exception  {
		
//		CompanyDocument Companydocument = new CompanyDocument(1);
//		Document document = new Document();
//		
//		// Creating The Table //
//		PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
//		document.open();
//		
//		Companydocument.createHeader(document);
//		Companydocument.createCustomerDetailsTable(document);
//		Companydocument.createCostTable(document);
//		Companydocument.Signatures(document);
//		Companydocument.BankInfo(document);
//		document.close();
//	
	//	createExcelFile();
		ReadExcel();
		

		

	}
	
	
	
}


