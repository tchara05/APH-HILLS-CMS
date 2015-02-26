package security;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import security.CheckIn;
import extras.DatabaseConnection;

public class CheckInButton extends Thread{
	
	@SuppressWarnings("static-access")
	public void run() {

		String checkInDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String checkInTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = null;
		//	ResultSet rst = null;

			stment = database.getStatement();

			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to Check In this Key?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				String query = "";

				// insert query here
				//rst = stment.executeQuery("SELECT * FROM SERVICE WHERE checkInTime = '"
					//	+ checkInTime + "' and checkInDate = '" + checkInDate + "'");
				
				query = "UPDATE SERVICE SET checkInTime = '" + checkInTime
						+ "', checkInDate = '" + checkInDate
						+ "' WHERE  keyID = '"
						+ CheckIn.txtSearch.getText() + "'";

				stment.executeUpdate(query);

				new CheckInClearButton().start();

				JOptionPane.showMessageDialog(null, "Key Checked In",
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
