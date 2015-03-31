package logistics;

import extras.Messages;

public class ExportExcelBtn extends Thread {
	
	public void run(){
		Excel.createExcelFile();
		Messages.showSaveMessage("Excel File Create SuccesFully\n Please insert Rooms values");
	}
}

