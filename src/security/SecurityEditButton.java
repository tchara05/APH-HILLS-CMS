package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.Checker;
import extras.DatabaseConnection;

public class SecurityEditButton {

	public static void start() {

		DatabaseConnection database = new DatabaseConnection();
		Statement stment = database.getStatement();
		String[] contract = new String[3];
		String keyID = "";
		String txtPlotNumber = "";
		String txtPlotName = "";
		int check = 0;

		if (Securitymenu.radioList.isSelected() == true) {

			String con = "";
			con = (String) Securitymenu.getSelectedContract();
			contract = extras.ListManager.SplitThreeItem(con);

			keyID = contract[2];

		} else {

			txtPlotName = Securitymenu.txtPlotName.getText();
			txtPlotNumber = Securitymenu.txtPlotNumber.getText();
			
			if(!Checker.checkEmpty(txtPlotName) || !Checker.checkEmpty(txtPlotNumber))
				check = 1;
			
			if(!Checker.checkString(txtPlotName) || !Checker.checkNumber(txtPlotNumber))
				check = 1;
			
			if(check == 1) {
				Checker.showMessage();
				check = 0;
				return;
			}
			
			String propId = "";
			propId = SecuritySaveButton.getPropId(txtPlotName,
					Integer.parseInt(txtPlotNumber));

			ResultSet rst = null;
			try {
				rst = stment
						.executeQuery("SELECT * FROM KeyContract WHERE propertyID = '"
								+ propId + "'");
				if (rst.next())
					keyID = rst.getString("keyID");
				else
					keyID = "";
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (!keyID.equals("")) {

			String queryChecker = "";
			queryChecker = "SELECT * FROM KeyContract WHERE keyID = '" + keyID
					+ "'";

			try {
				ResultSet rst = null;
				rst = stment.executeQuery(queryChecker);
				if (!rst.next())
					JOptionPane.showMessageDialog(null, "Key not found",
							"Warning message", JOptionPane.WARNING_MESSAGE);
				else {

					SecurityForm.frame.setVisible(true);
					SecurityForm.editor = 1;

					if (Securitymenu.radioList.isSelected() == true) {

						ResultSet rst1 = null;
						SecurityForm.txtPlotName.setText(contract[1]);
						SecurityForm.txtPlotNumber.setText(contract[2]);
						rst1 = stment.executeQuery("SELECT * FROM KeyContract WHERE keyID = '"
										+ keyID + "'");
						SecurityForm.txtAreaNotes.setText(rst1.getString("notes"));
						rst = null;

					} else {

						ResultSet rst2 = null;
						SecurityForm.txtPlotName.setText(txtPlotName);
						SecurityForm.txtPlotNumber.setText(txtPlotNumber);
						rst2 = stment.executeQuery("SELECT * FROM KEYCONTRACT WHERE keyID = '"
										+ keyID + "'");
						SecurityForm.txtAreaNotes.setText(rst2.getString("notes"));

					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No Key Contract is Found",
					"Information Message", JOptionPane.INFORMATION_MESSAGE);
		}
		
		Securitymenu.txtPlotName.setText("");
		Securitymenu.txtPlotNumber.setText("");

	}

}
