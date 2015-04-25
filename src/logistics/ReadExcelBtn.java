package logistics;

import extras.Messages;

public class ReadExcelBtn extends Thread {
		public void run(){
			Excel.ReadExcel(FileChooser.file);
			Messages.showSaveMessage("File Imported Succesfully");
		}
}
