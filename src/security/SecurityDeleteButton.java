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
			keyID = (String)Securitymenu.getSelectedContract();

			if (keyID != null) {
				
				Securitymenu.DeletePropertyFromList();
				String query = "";
				query = "DELETE KeyContract WHERE keysID = '" + keyID;

				try {
					stment.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Key Contract Deleted",
						"Information Message", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"No Key Contract is Selected", "Information Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
