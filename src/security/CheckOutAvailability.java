package security;
import java.sql.SQLException;

import security.CheckOutButton;

public class CheckOutAvailability extends Thread {
	
	public void run() {
	String key = CheckOut.getKeyID();
	String specificKey = CheckOut.getSpecificKey();
	
	
	try {
		
		boolean val1 = CheckOutButton.checker(key);
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

