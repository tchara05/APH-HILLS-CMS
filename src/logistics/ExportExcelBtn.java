package logistics;

public class ExportExcelBtn extends Thread {
	
	public void run(){
		Excel.createExcelFile();
	}
}

