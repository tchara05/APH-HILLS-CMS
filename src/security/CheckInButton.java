package security;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import security.CheckIn;
import extras.DatabaseConnection;

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

				query = "UPDATE SERVICE SET checkInTime = '" + checkInTime
						+ "', checkInDate = '" + checkInDate
						+ "' WHERE  keyID = '" + CheckIn.txtSearch.getText()
						+ "' AND specificKey = '"
						+ CheckIn.txtSpecificKey.getText() + "'";

				stment.executeUpdate(query);
				new CheckInClearButton().start();

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
