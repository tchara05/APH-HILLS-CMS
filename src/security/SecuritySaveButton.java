package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import extras.DatabaseConnection;
import extras.Checker;

public class SecuritySaveButton extends Thread {

	public void run() {

		if (SecurityForm.editor == 1) {

		} else {
			DatabaseConnection database = new DatabaseConnection();
			Statement stment = null;

			boolean checked = true;
			boolean exist = false;
			int flag = 1;
			String txtpropertyID = null;
			String query = null;
			// int txtpropertyID = 0;

			String txtNotes = SecurityForm.txtAreaNotes.getText();

			String txtplotName = SecurityForm.txtPlotName.getText();
			String plotNumber = SecurityForm.txtPlotNumber.getText();
			int txtplotNumber = Integer.parseInt(plotNumber);

			txtpropertyID = getPropId(txtplotName, txtplotNumber);

			try {
				checked = checker(txtpropertyID);
				exist = CheckOutButton.checker(txtpropertyID, flag);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			try {

				stment = database.getStatement();

				if (checked && !exist) {
					int response = JOptionPane.showConfirmDialog(null,
							"Do you want to save changes?", "Confirm",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						query = "";

						// insert query here
						query = "INSERT INTO KEYCONTRACT VALUES ('"
								+ txtpropertyID + "','" + txtNotes + "')";

						stment.executeUpdate(query);

						SecurityClearButton.start();

						JOptionPane.showMessageDialog(null,
								"Key Contract Added", "Information Message",
								JOptionPane.INFORMATION_MESSAGE);
						SecurityClearButton.start();
						Securitymenu.setUpContractList();
						// SecurityForm.setVisible(false);

					}

				} else if (exist) {
					JOptionPane.showMessageDialog(null, "Key is already added",
							"Warning Message", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Property ID is Emprty or not exist",
							"Warning Message", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {

				e.printStackTrace();
			}
		}
	}

	private boolean checker(String s) throws SQLException {

		if (Checker.checkNumber(s)) {

			int id = Integer.parseInt(s);
			try {
				DatabaseConnection database = new DatabaseConnection();
				Statement st = database.getStatement();
				ResultSet rst = null;

				rst = st.executeQuery("SELECT plotID FROM Property WHERE plotID ='"
						+ id + "'");

				if (rst.next()) {
					return true;
				}

			} catch (NullPointerException e) {

				e.printStackTrace();
			}

		}
		return false;

	}

	public static String getPropId(String txtplotName, int txtplotNumber) {

		DatabaseConnection database = new DatabaseConnection();
		Statement stment = null;
		stment = database.getStatement();
		String query = null;
		ResultSet rset = null;
		String txtpropertyID = "0";

		query = "SELECT * FROM Property WHERE plotName = '" + txtplotName
				+ "' AND plotNumber = '" + txtplotNumber + "'";

		try {
			rset = stment.executeQuery(query);

			if (rset.next())
				txtpropertyID = rset.getString(1);
			else
				txtpropertyID = "0";

			// txtpropertyID = Integer.parseInt(propertyID);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return txtpropertyID;
	}
}
