package security;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import security.CheckOut;
import extras.DatabaseConnection;
import userMenus.LogIn;
import security.checkOutClearButton;

public class CheckOutButton extends Thread {

	public boolean checker() {

		return false;
	}

	@SuppressWarnings("static-access")
	public void run() {

		String keyID = CheckOut.getKeyID();
		String specificKey = CheckOut.getSpecificKey();
		String pickUpPerson = CheckOut.getPickUpPerson();
		String details = CheckOut.getDetails();
		String securityPerson = LogIn.getUsername();
		String checkOutDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String checkOutTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		String checkInTime = "Key is not checked in yet";
		String checkInDate = "Key is not checked in yet";

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = null;

			stment = database.getStatement();

			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to Check Out this Key?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				String query = "";

				// insert query here
				query = "INSERT INTO SERVICE VALUES ('" + keyID + "','"
						+ specificKey + "','" + pickUpPerson + "','"
						+ securityPerson + "','" + checkOutTime + "','"
						+ checkOutDate + "','" + checkInTime + "','"
						+ checkInDate + "','" + details + "')";

				stment.executeUpdate(query);

				new checkOutClearButton().start();

				JOptionPane.showMessageDialog(null, "Key Checked Out",
						"Information Message", JOptionPane.INFORMATION_MESSAGE);

				//CheckOut.setVisible(false);
				// SecurityMenu.UpdateContractList(propertyID);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
}
