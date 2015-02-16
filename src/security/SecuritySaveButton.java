package security;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import userMenus.SecurityMenu;

import extras.DatabaseConnection;

public class SecuritySaveButton extends Thread {

	public void run() {

		boolean checked = true;
		String propertyID = SecurityForm.getPropertyID();

		if (propertyID.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Property ID field is not filled.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			checked = false;
		}

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = null;

			stment = database.getStatement();

			if (checked) {
				int response = JOptionPane
						.showConfirmDialog(null,
								"Do you want to save changes?", "Confirm",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {

					String query = "";

					// insert query here
					query = "";

					stment.executeUpdate(query);

					// SecurityClearButton.start();

					JOptionPane.showMessageDialog(null, "Key Contract Added",
							"Information Message",
							JOptionPane.INFORMATION_MESSAGE);

					SecurityForm.setVisible(false);
					SecurityMenu.UpdateContractList(propertyID);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
}
