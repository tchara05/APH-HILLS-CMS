package extras;

public class fileExcel {

	public static void initial() {
	Workbook wb = new HSSFWorkbook();
	Sheet personSheet = wb.createSheet("PersonList");
	Row headerRow = personSheet.createRow(0);
	Cell nameHeaderCell = headerRow.createCell(0);
	Cell addressHeaderCell = headerRow.createCell(1);
	}
	
	public static void exportToExcel () {
		
		
	}
	
	
	public static void importFromExcel() {
		
		
	}
	
}


