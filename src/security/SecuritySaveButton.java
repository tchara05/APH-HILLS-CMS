package security;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;
import extras.Checker;
import extras.Messages;

public class SecuritySaveButton extends Thread {

	public void run() {

		boolean checked = true;
		
		String txtNotes = SecurityForm.txtAreaNotes.getText();
		String txtpropertyID=SecurityForm.txtPropertyID.getText();
		
		try {
			checked=checker(txtpropertyID );
		} catch (SQLException e1) {
			
			e1.printStackTrace();
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
					query = "INSERT INTO KEYCONTRACT VALUES ('" + txtpropertyID + "','"
							+ txtNotes + "')";

					stment.executeUpdate(query);

					SecurityClearButton.start();

					JOptionPane.showMessageDialog(null, "Key Contract Added",
							"Information Message",
							JOptionPane.INFORMATION_MESSAGE);

					//SecurityForm.setVisible(false);
					
				}

			}
			else{
				JOptionPane.showMessageDialog(null, "Property ID is Emprty or not exist",
						"Warning Message",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}


	private boolean checker(String s) throws SQLException {
		
		if(Checker.checkNumber(s)){
			
			int id=Integer.parseInt(s);
			try{
				DatabaseConnection database = new DatabaseConnection();
				Statement st = database.getStatement();
				ResultSet rst = null;
				
				
				rst = st.executeQuery("SELECT plotID FROM Property WHERE plotID ='" + id + "'");
						
					if (rst.next()) {
						return true;
					}
			
				
			} catch (NullPointerException e) {
	
				e.printStackTrace();
			}
		
		}
		return false;
	
}

}
