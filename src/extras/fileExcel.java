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
		HSSFCell propertyIDCell = headerRow.createCell((short) 0);
		HSSFCell propertyNameCell = headerRow.createCell((short) 1);
		HSSFCell propertyNumCell = headerRow.createCell((short) 1);
		
		propertyIDCell.setCellValue("PROPERTY ID:");
		propertyNameCell.setCellValue("PROPERTY NAME:");
		propertyNumCell.setCellValue("PROPERTY NO:");
		
		
		DatabaseConnection database = new DatabaseConnection();
		Statement stment = null;
		stment = database.getStatement();

		String query = "SELECT plotID, plotNumber, plotName, numberOfBedrooms FROM Property ";
		
		int row = 1;

		try {
			ResultSet rset = stment.executeQuery(query);			
			while (rset.next()) {
				
				String plotID = rset.getString(1);
				String plotName = rset.getString(2);
				String plotNumber = rset.getString(3);
				String nums = Integer.parseInt(rset.getString(4));

				HSSFRow dataRow = excelSheet.createRow(row);

				HSSFCell dataKeyIDCell = dataRow.createCell((short) 0);
				dataKeyIDCell.setCellValue(name);
				
				HSSFCell dataPropertyIDCell = dataRow.createCell((short) 1);
				dataPropertyIDCell.setCellValue(address);

				row++;
//			}
//			
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
	
	
	
	
}


