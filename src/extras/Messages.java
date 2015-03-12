package extras;

import javax.swing.JOptionPane;

public class Messages {

	
	 public static void  showWarningMessage(String msg){
			JOptionPane.showMessageDialog(null,
				    msg,
				    "Input warning",
				    JOptionPane.WARNING_MESSAGE); 
	 }
	 public static void showSaveMessage(String msg){
		 
			JOptionPane.showMessageDialog(null, msg,
					"Information Message",
					JOptionPane.INFORMATION_MESSAGE);
	 }		
}
