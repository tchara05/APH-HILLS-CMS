package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import extras.DatabaseConnection;

public class SecuritySearchKey extends Thread {

	public void run() {

		String keyID = "3";
		System.out.println(keyID);
		String specificKey = CheckIn.txtSpecificKey.getText();
		boolean  flag=true;
		
		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = database.getStatement();
			ResultSet rst = null;

			stment = database.getStatement();

			// int response = JOptionPane.showConfirmDialog(null,
			// "Do you want to Check In this Key?", "Confirm",
			// JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			//if (response == JOptionPane.YES_OPTION) {

			if(flag){
				// insert query here
				rst = stment.executeQuery("SELECT * FROM SERVICE WHERE keyID = '"
								+ keyID + "' and specificKey = '" + specificKey + "'");
				
				rst.next();
				
				CheckIn.txtPerson.setText(rst.getString("pickUpPerson"));
				CheckIn.txtTime.setText(rst.getString("checkOutTime"));
				CheckIn.txtDate.setText(rst.getString("checkOutDate"));

			//}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
}
