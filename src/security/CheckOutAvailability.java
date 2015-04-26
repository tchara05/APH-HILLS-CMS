package security;

import java.sql.SQLException;
import extras.Checker;
import security.CheckOutButton;

/**
 * 
 * This class is used to check if the key is available,
 * if the key is not available or if the key is not
 * found. For this functionality we use some queries
 * into the database. 
 * 
 * @author TeamD
 * 
 */

public class CheckOutAvailability extends Thread {

	public void run() {
		int check = 0;
		String key = CheckOut.getKeyID();

		if (!Checker.checkEmpty(key))
			check = 1;

		if (!Checker.checkNumber(key))
			check = 1;

		if (check == 1) {
			Checker.showMessage();
			check = 0;
			return;
		}

		String specificKey = CheckOut.getSpecificKey();

		try {

			boolean val1 = CheckOutButton.checkKey(key, 0);
			boolean val2 = CheckOutButton.chekServiceTable(key, specificKey);

			if (val1 == false) {
				CheckOut.txtAvailability.setText("Key is not Found");
			} else if (val2 == true) {
				CheckOut.txtAvailability.setText("Key is not Available");
			} else
				CheckOut.txtAvailability.setText("Key is Available");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
