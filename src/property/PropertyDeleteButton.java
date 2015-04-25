package property;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import userMenus.LogIn;
import contract.ContractMenu;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;

public class PropertyDeleteButton extends Thread {

	public void run() {

		

		// Confirm Dialog Here //
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (response == JOptionPane.YES_OPTION) {
			String property = ListManager.DeleteFromList(PropertyMenu.AllProperties);
			if (property != null) {
			   
				ContractMenu.AllProperties.removeItem(property);
				String Property[] = ListManager.SplitThreeItem(property);
				ContractMenu.AllProperties.removeItem(property);
				String query = "DELETE Property WHERE plotID='" + Property[0] + "'";
				
				DatabaseConnection database = new DatabaseConnection();

				try {
						database.getStatement().executeUpdate(query);
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
