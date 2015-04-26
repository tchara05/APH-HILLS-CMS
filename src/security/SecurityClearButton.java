package security;

/**
 * 
 * This class is used for clearing the text fields
 * that are used in the security department menu. 
 * 
 * @author TeamD
 *
 */

public class SecurityClearButton {
	
	public static void start() {
		
		String value = "";
		SecurityForm.txtAreaNotes.setText(value);
		SecurityForm.txtPlotName.setText(value);
		SecurityForm.txtPlotNumber.setText(value);
	}
}
