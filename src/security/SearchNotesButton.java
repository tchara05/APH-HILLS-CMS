package security;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import extras.Checker;
import extras.DatabaseConnection;
import extras.Messages;

public class SearchNotesButton extends Thread {

	public static int searchMethod = 0;

	public void run() {

		int check = 0;
		int method = -1;
		boolean checked = true;

		String propertyID = " ";
		String keyID = " ";
		String plotName = "";
		String plotNumber = "";

		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red, 2);

		if (searchMethod == 0) {
			plotName = CheckOut.txtPlotName.getText();
			plotNumber = CheckOut.txtPlotNumber.getText();

			if (!Checker.checkEmpty(plotName)
					|| !Checker.checkEmpty(plotNumber))
				check = 1;

			if (!Checker.checkString(plotName)
					|| !Checker.checkNumber(plotNumber))
				check = 1;

			if (check == 1) {
				//Checker.showMessage();
				check = 0;
				propertyID = "1";
			} else {
				propertyID = SecuritySaveButton.getPropId(plotName,
						Integer.parseInt(plotNumber));
			}
		} else {
			keyID = CheckOut.txtKeyId.getText();

			if (!Checker.checkEmpty(keyID))
				check = 1;

			if (!Checker.checkNumber(keyID))
				check = 1;

			if (check == 1) {
				check = 0;
				keyID = "1";
			}

		}

		method = -1;

		if ((searchMethod == 1) && (!keyID.equals("1"))) {
			
			try {
				if (checker(keyID))
					method = 0;
				else {
					JOptionPane.showMessageDialog(null, "No Key Contract is Found",
							"Information Message", JOptionPane.INFORMATION_MESSAGE);
					CheckOutClearButton.start(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(searchMethod == 1){
			compound = BorderFactory.createCompoundBorder(redline,
					compound);
			CheckOut.txtKeyId.setBorder(compound);
			compound = null;
			checked = false;
			Checker.showMessage();
			CheckOutClearButton.start(1);
			return;
		}
		
		if ((searchMethod == 0) && (!propertyID.equals("1"))) {

			try {
				if (checker2(propertyID))
					method = 1;
				else if(propertyID.equals("0")) {
					JOptionPane.showMessageDialog(null, "No Key Contract is Found",
							"Information Message", JOptionPane.INFORMATION_MESSAGE);
					CheckOutClearButton.start(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(searchMethod == 0){
			compound = BorderFactory.createCompoundBorder(redline,
					compound);
			CheckOut.txtPlotName.setBorder(compound);
			CheckOut.txtPlotNumber.setBorder(compound);
			compound = null;
			checked = false;
			Checker.showMessage();
			CheckOutClearButton.start(1);
			return;
		}

		if (method != -1) {
			try {

				DatabaseConnection database = new DatabaseConnection();
				Statement stment = database.getStatement();
				ResultSet rst = null;

				if (checked) {
					System.out.println(method);
					// insert query here
					if (method == 0)
						rst = stment
								.executeQuery("SELECT * FROM KEYCONTRACT WHERE keyID = '"
										+ keyID + "'");
					else if (method == 1)
						rst = stment
								.executeQuery("SELECT * FROM KEYCONTRACT WHERE propertyID = '"
										+ propertyID + "'");

					if (rst.next())
						;
					CheckOut.txtNotes.setText(rst.getString("notes"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean checker(String s) throws SQLException {

		int id = Integer.parseInt(s);
		try {
			DatabaseConnection database = new DatabaseConnection();
			Statement st = database.getStatement();
			ResultSet rst = null;

			rst = st.executeQuery("SELECT keyID FROM KeyContract WHERE keyID='"
					+ id + "'");

			if (rst.next()) {
				return true;
			}

		} catch (NullPointerException e) {

			e.printStackTrace();
		}
		return false;

	}

	private boolean checker2(String s) throws SQLException {

		int id = Integer.parseInt(s);
		try {
			DatabaseConnection database = new DatabaseConnection();
			Statement st = database.getStatement();
			ResultSet rst = null;

			rst = st.executeQuery("SELECT propertyID FROM KeyContract WHERE propertyID='"
					+ id + "'");

			if (rst.next()) {
				return true;
			}

		} catch (NullPointerException e) {

			e.printStackTrace();
		}

		return false;

	}
}
