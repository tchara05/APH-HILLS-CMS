package property;

import javax.swing.JOptionPane;

import checksClasses.Checker;

public class PropertySaveButton extends Thread {
	
	
	/*This classes need improvements*/
	
	public void run(){
		
		String s = PropertyForm.getPlotName();
		boolean checked = true;
		
		if (!Checker.checkString(s)){
			
			
			if ( !Checker.checkString(s)){
				JOptionPane.showMessageDialog(null,
			    "Plot Name has invalid characters",
			    "Inane warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
	
			}
		}
	}
}
