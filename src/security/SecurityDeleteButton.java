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
			
			if(Securitymenu.radioList.isSelected() == true) {
				
				String con = "";
				con = (String)Securitymenu.getSelectedContract();
				
				String[] contract = new String[3];
				contract = extras.ListManager.SplitThreeItem(con);
				
				keyID =contract[2];

			}
			else {
				
				String propId = "";
				String txtPlotName = Securitymenu.txtPlotName.getText();
				String txtPlotNumber = Securitymenu.txtPlotNumber.getText();
				propId = SecuritySaveButton.getPropId(txtPlotName, Integer.parseInt(txtPlotNumber));
				
				ResultSet rst = null;
				try {
					rst = stment.executeQuery("SELECT * FROM KeyContract WHERE propertyID = '"
							+ propId +  "'");
					if(rst.next())
						keyID = rst.getString("keyID");
					else 
						keyID = "";
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			if (!keyID.equals("")) {
				
				String queryChecker = "";
				queryChecker = "SELECT * FROM KeyContract WHERE keyID = '"
						+ keyID +  "'";
				
				String query = "";
				query = "DELETE KeyContract WHERE keyID = '" + keyID + "'";

				try {
					ResultSet rst = null;
					rst = stment.executeQuery(queryChecker);
					if(!rst.next())
						JOptionPane.showMessageDialog(null, "Key not found",
								"Warning message", JOptionPane.WARNING_MESSAGE);
					else {
						stment.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Key Contract Deleted",
								"Information Message", JOptionPane.INFORMATION_MESSAGE);
						///////////////////////////////////////////
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
