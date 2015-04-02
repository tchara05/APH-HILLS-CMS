package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;

public class SecurityDeleteButton {

	public static void start() {

		DatabaseConnection database = new DatabaseConnection();
		Statement stment = database.getStatement();

		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION) {

			String keyID = "";
			
			String txtPlotName = Securitymenu.txtPlotName.getText();
			String txtPlotNumber = Securitymenu.txtPlotNumber.getText();
			
			keyID = SecuritySaveButton.getPropId(txtPlotName, Integer.parseInt(txtPlotNumber));
			
			String keyID_fromList = "";
			keyID_fromList = (String)Securitymenu.getSelectedContract();

			if ((!keyID.equals("")) || (!keyID_fromList.equals(""))) {
		
				if(keyID.equals("")) {
					keyID = keyID_fromList.substring(0, keyID_fromList.length());
				}
				System.out.println(keyID);
				
				String queryChecker = "";
				queryChecker = "SELECT * FROM KeyContract WHERE keyID = '"
						+ keyID +  "'";
				
				String query = "";
				query = "DELETE KeyContract WHERE keyID = '" + keyID + "'";

				try {
					ResultSet rst = stment.executeQuery(queryChecker);
					if(!rst.next())
						JOptionPane.showMessageDialog(null, "Key not found",
								"Warning message", JOptionPane.WARNING_MESSAGE);
					else {
						stment.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Key Contract Deleted",
								"Information Message", JOptionPane.INFORMATION_MESSAGE);
						Securitymenu.AllContracts.removeAllItems();
						Securitymenu.setUpContractList();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"No Key Contract is Selected", "Information Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
