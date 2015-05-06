package logistics;

import extras.Messages;

/**
 * Class read the excel file (with cost values per property)
 * for when the user click on Import Excel button.
 *
 * @author TeamD
 *
 */
public class ReadExcelBtn extends Thread {
	/**
	 * 
	 * Method that  read excel file (with cost values per 
	 * property) and show the proper messages of succes.
	 * 
	 * 
	 * 
	 */
		public void run(){
			Excel.ReadExcel(FileChooser.file);
			Messages.showSaveMessage("File Imported Succesfully");
		}
}
