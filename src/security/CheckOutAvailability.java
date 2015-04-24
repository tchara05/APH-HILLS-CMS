package security;
import java.sql.SQLException;

import extras.Checker;

import security.CheckOutButton;

public class CheckOutAvailability extends Thread {
	
	public void run() {
	int check = 0;
	String key = CheckOut.getKeyID();
	
	if(!Checker.checkEmpty(key))
		check = 1;
	
	if(!Checker.checkNumber(key))
		check = 1;
	
	if(check == 1) {
		Checker.showMessage();
		check = 0;
		return;
	}
	
	String specificKey = CheckOut.getSpecificKey();
	
	
	try {
		
		boolean val1 = CheckOutButton.checker(key, 0);
		boolean val2 = CheckOutButton.cheked2(key, specificKey);
		
		if(val1 == false) {
			CheckOut.txtAvailability.setText("Key is not Found");
		}
		else if (val2 == true) {
			CheckOut.txtAvailability.setText("Key is not Available");
		}
		else 
			CheckOut.txtAvailability.setText("Key is Available");
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
	
	}
}

