package logistics;

class ExportExcelBtn extends Thread {
	
	public void run(){
		Excel.createExcelFile();
	}
}


class ReadExcelBtn extends Thread {
	public void run(){
		Excel.ReadExcel();
	}
	
	
	
}