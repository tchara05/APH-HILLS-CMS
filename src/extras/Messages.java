package extras;

import javax.swing.JOptionPane;

/**
 * 
 * Class that defines pop up messages for warings, erros,
 * and informations.
 * 
 * @author TeamD
 *
 */

public class Messages {

	/**
	 * Method that takes as parameter a message and show this
	 * message to a pop up warning window
	 * 
	 * 
	 * 
	 * @param String
	 */
	
	
	
	 public static void  showWarningMessage(String msg){
			JOptionPane.showMessageDialog(null,
				    msg,
				    "Input warning",
				    JOptionPane.WARNING_MESSAGE); 
	 }
	 
	 
	/** Method that takes as parameter a message and show this
	 * message to a pop up save window
	 * 
	 * 
	 * 
	 * @param String
	 */
	 
	 public static void showSaveMessage(String msg){
		 
			JOptionPane.showMessageDialog(null, msg,
					"Information Message",
					JOptionPane.INFORMATION_MESSAGE);
	 }		
	 
	/** Method that takes as parameter a message and show this
	 * message to a pop up error window
	 * 
	 * 
	 * 
	 * @param String
	 */
	 
	 public static void showErrorMessage(String msg){
		 JOptionPane.showMessageDialog(null,
				    msg,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);	
	 }
}
