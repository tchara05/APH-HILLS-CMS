package logistics;

import extras.Messages;

/**
 * Class create the excel for when the user
 * click on Export Excel button.After that the user
 * must to complete the values of rooms per 
 * property.
 *
 *
 * @author TeamD
 *
 */
public class ExportExcelBtn extends Thread {
	/**
	 * 
	 * Method that create excel for where the user
	 * must to complete the values of rooms per 
	 * property and show the proper message.
	 * 
	 * 
	 * 
	 */
	public void run(){
		Excel.createExcelFile();
		Messages.showSaveMessage("Excel File Create SuccesFully\n Please insert Rooms values");
	}
}

