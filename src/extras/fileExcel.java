package extras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class fileExcel {
	
	
	public static void createExcelFile(){
		
		
		
		
		
		
		
	}
	
	public static void main(String args[])  {
		
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet excelSheet = wb.createSheet("Test excel sheet");
		
		
		HSSFRow headerRow = excelSheet.createRow(0);
		HSSFCell nameHeaderCell = headerRow.createCell((short) 0);
		HSSFCell addressHeaderCell = headerRow.createCell((short) 1);
		nameHeaderCell.setCellValue("KEY ID");
		addressHeaderCell.setCellValue("PROPERTY ID");
		
		//////////////////////////////////////////////////////////
//		DatabaseConnection database = new DatabaseConnection();
//		Statement stment = null;
//		stment = database.getStatement();
//
//		String query = "SELECT * FROM KeyContract";
//		
//		int row = 1;
//
//		try {
//			ResultSet rset = stment.executeQuery(query);
//			
//			while (rset.next()) {
//				
//				String name = rset.getString("keyId");
//				String address = rset.getString("propertyId");
//
//				HSSFRow dataRow = excelSheet.createRow(row);
//
//				HSSFCell dataKeyIDCell = dataRow.createCell((short) 0);
//				dataKeyIDCell.setCellValue(name);
//
//				HSSFCell dataPropertyIDCell = dataRow.createCell((short) 1);
//				dataPropertyIDCell.setCellValue(address);
//
//				row = row + 1;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		

		
		String outputDirPath = "/Users/Theodoros/Desktop/properties.xls";
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(outputDirPath);
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("ok");
	}
	
	
	
	
}


