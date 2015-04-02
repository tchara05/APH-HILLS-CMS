package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;

public class SecuritySearchKey extends Thread {

	public void run() {

		String txtPlotName = Securitymenu.txtPlotName.getText();
		String txtPlotNumber = Securitymenu.txtPlotNumber.getText();
		
		String prop = SecuritySaveButton.getPropId(txtPlotName, Integer.parseInt(txtPlotNumber));
		
		if (prop==null){
			JOptionPane.showMessageDialog(null, "Non KeyID",
					"Warning Message",
					JOptionPane.WARNING_MESSAGE);
		}else{
			try {
	
				DatabaseConnection database = new DatabaseConnection();
				Statement stment = database.getStatement();
				ResultSet rst = null;
	
				stment = database.getStatement();
	
				// insert query here
				rst = stment.executeQuery("SELECT * FROM KeyContract WHERE propertyID = '"
						+ prop +  "'");
				
				if(rst.next())
					Securitymenu.txtShowIfFound.setText("Key Found: " + rst.getString("keyID"));
				else 
					Securitymenu.txtShowIfFound.setText("Key not Found");
	
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
