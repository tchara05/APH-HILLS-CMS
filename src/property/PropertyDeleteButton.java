package property;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import contract.ContractMenu;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;

public class PropertyDeleteButton extends Thread {

	public void run() {

		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();

		// Confirm Dialog Here //
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (response == JOptionPane.YES_OPTION) {
			String property = (String) PropertyMenu.AllProperties.getSelectedItem();
			if (property != null) {
			     ListManager.DeleteFromList(PropertyMenu.AllProperties);
				ContractMenu.AllProperties.removeItem(property);
				
				String Property[] = ListManager.SplitThreeItem(property);
				System.out.println(Property[0]);
				System.out.println(Property[1]);
				ContractMenu.AllProperties.removeItem(property);
				String query = "DELETE Property WHERE plotID='" + Property[0] + "'";

				try {
					st.executeUpdate(query);
				} catch (SQLException e) {
					System.out.println("Cant Delete Property");
					e.printStackTrace();
				}

				Messages.showSaveMessage("Property Deleted");
			} else {
				Messages.showWarningMessage("Nothing to delete");

			}
		}

	}

}
