package security;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import security.CheckIn;
import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;

/**
 * 
 * This class is used for checking-in a key. When the button of
 * the check-in form is pushed then this function is called.
 * Then we execute a query in updating the service table
 * in the database.
 * 
 * @author TeamD
 *
 */

public class CheckInButton extends Thread {
	
	public static int check_in = -1;
	
	@SuppressWarnings("static-access")
	public void run() {

		String checkInDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar
				.getInstance().getTime());
		String checkInTime = new SimpleDateFormat("HH:mm").format(Calendar
				.getInstance().getTime());

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = null;
			stment = database.getStatement();

			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to Check In this Key?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				String query = "";
				
				String keyID = "";
				String specificKey = "";
				
				if (check_in == 0) {
					String inList = CheckIn.inList.replace('|', ' ');
					String splits[] = new String[2];
					splits = ListManager.SplitTwoItem(inList);
					keyID = splits[0];
					specificKey = ListManager.SplitOneItem(splits[1]);
				}
				else if(check_in == 1) {
					keyID = CheckIn.txtSearch.getText();
					specificKey = CheckIn.txtSpecificKey.getText();
				}
				else
					Checker.showMessage();

				query = "UPDATE SERVICE SET checkInTime = '" + checkInTime
						+ "', checkInDate = '" + checkInDate
						+ "' WHERE  keyID = '" + keyID
						+ "' AND specificKey = '"
						+ specificKey + "'";

				stment.executeUpdate(query);
				new CheckInClearButton().start();

				CheckIn.allKeys.removeAll();
				CheckIn.setUpContractList();
				
				JOptionPane.showMessageDialog(null, "Key Checked In",
						"Information Message", JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
}
