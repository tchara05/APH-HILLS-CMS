package logistics;

import extras.Messages;

public class ReadExcelBtn extends Thread {
	
		public void run(){
			Excel.ReadExcel();
			Messages.showSaveMessage("File Imported Succesfully");
		}

}
