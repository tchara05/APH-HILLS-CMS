package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;

public class SecuritySearchKey extends Thread {

	public void run() {

		String keyID = Securitymenu.txtSearchKey.getText();
		
		if (keyID==null){
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
				rst = stment.executeQuery("SELECT * FROM KeyContract WHERE keyID = '"
						+ keyID +  "'");
				
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
