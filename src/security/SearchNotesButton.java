package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extras.Checker;
import extras.DatabaseConnection;
import extras.Messages;

public class SearchNotesButton extends Thread {

	@SuppressWarnings("static-access")
	public void run() {

		int method = 2;
		boolean checked=true;
		
		
		String keyID = CheckOut.txtKeyId.getText();
		String propertyID = CheckOut.txtPropertyId.getText();
		
		System.out.println(keyID);
		
		
		
		if(keyID.compareTo("") != 0){
			method = 0;
		
			try {
				if (!checker(keyID)){
					Messages.showWarningMessage("Key ID not found ");
					checked=false;
				}
			} catch (SQLException e1) {
				System.out.print("2222");
			}
		}else{
		
			if(propertyID.compareTo("") != 0)
				method = 1;
			try {
				if (!checker2(propertyID)){
					Messages.showWarningMessage("property ID not found ");
					checked=false;
				}
			} catch (SQLException e1) {
				System.out.print("3333");
			}
			
		}
		

		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = database.getStatement();
			ResultSet rst = null;

			// int response = JOptionPane.showConfirmDialog(null,
			// "Do you want to Check In this Key?", "Confirm",
			// JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			//if (response == JOptionPane.YES_OPTION) {
			if(checked){
				System.out.println(method);
					// insert query here
				if(method == 0)
					rst = stment.executeQuery("SELECT * FROM KEYCONTRACT WHERE keyID = '"
							+ keyID + "'");
				else if (method == 1)
					rst = stment.executeQuery("SELECT * FROM KEYCONTRACT WHERE propertyID = '"
							+ propertyID + "'");
					
					
					if(rst.next());
						CheckOut.txtNotes.setText(rst.getString("notes"));
					
				//}
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
				
				
				rst = st.executeQuery("SELECT keyID FROM KeyContract WHERE keyID='" + id+"'");
						
					if (rst.next()){
						return true;
					}
			
				
			} catch (NullPointerException e) {
	
				e.printStackTrace();
			}
		
		}
		return false;
	
}

private boolean checker2(String s) throws SQLException {
	
	if(Checker.checkNumber(s)){
		
		int id=Integer.parseInt(s);
		try{
			DatabaseConnection database = new DatabaseConnection();
			Statement st = database.getStatement();
			ResultSet rst = null;
			
			
			rst = st.executeQuery("SELECT propertyID FROM KeyContract WHERE propertyID='" + id+"'");
					
				if (rst.next()){
					return true;
				}
		
			
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	
	}
	return false;

}
}

