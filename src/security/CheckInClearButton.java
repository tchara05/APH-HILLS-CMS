package security;

import javax.swing.border.Border;
import security.CheckIn;

public class CheckInClearButton {

	public static void start() {

		String value = "";
		
		Border correct = CheckIn.txtPerson.getBorder();
		
		CheckIn.txtSearch.setText("key ID");
		CheckIn.txtSearch.setBorder(correct);
		
		CheckIn.txtSpecificKey.setText("specific key (A,B,C)");
		CheckIn.txtSpecificKey.setBorder(correct);
		
		CheckIn.txtPerson.setText(value);
		CheckIn.txtTime.setText(value);
		CheckIn.txtDate.setText(value);
		

	}
}
