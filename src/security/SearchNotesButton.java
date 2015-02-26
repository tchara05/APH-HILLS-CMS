package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extras.DatabaseConnection;

public class SearchNotesButton extends Thread {

	@SuppressWarnings("static-access")
	public void run() {

		int method = 2;
		
		String keyID = CheckOut.txtKeyId.getText();
		String propertyID = CheckOut.txtPropertyId.getText();
		
		System.out.println(keyID);
		
		if(keyID.compareTo("") != 0)
			method = 0;
		
		if(propertyID.compareTo("") != 0)
			method = 1;
		

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = database.getStatement();
			ResultSet rst = null;

			// int response = JOptionPane.showConfirmDialog(null,
			// "Do you want to Check In this Key?", "Confirm",
			// JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			//if (response == JOptionPane.YES_OPTION) {

			System.out.println(method);
				// insert query here
			if(method == 0)
				rst = stment.executeQuery("SELECT * FROM KEYCONTRACT WHERE keyID = '"
						+ keyID + "'");
			else if (method == 1)
				rst = stment.executeQuery("SELECT * FROM KEYCONTRACT WHERE propertyID = '"
						+ propertyID + "'");
				
				rst.next();
				
				CheckOut.txtNotes.setText(rst.getString("notes"));

			//}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
}

