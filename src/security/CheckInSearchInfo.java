package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import security.CheckIn;
import extras.DatabaseConnection;
import extras.Checker;
import extras.Messages;

public class CheckInSearchInfo extends Thread {

	@SuppressWarnings("static-access")
	public void run() {

		String keyID = CheckIn.txtSearch.getText();
		System.out.println(keyID);
		String specificKey = CheckIn.txtSpecificKey.getText();
		boolean  flag=true;
		
		if(keyID.compareTo("")!=0 &&(specificKey.compareTo("A")==0 || specificKey.compareTo("B")==0||specificKey.compareTo("C")==0)){
			try {
				if(!checkerexist(keyID,specificKey)){
					Messages.showWarningMessage("Not exist this compinasion on Database!");
					flag=false;
				}
				else{
					if(!checkerfields(keyID,specificKey)){
						Messages.showWarningMessage("Not emprty fields!");
						flag=false;
					}
				}
			} catch (SQLException e) {
				
			}
			
		}
		else{
			flag=false;
			Messages.showWarningMessage("Fields has error input!");
		}
		
		try {

			DatabaseConnection database = new DatabaseConnection();
			Statement stment = database.getStatement();
			ResultSet rst = null;

			stment = database.getStatement();

			// int response = JOptionPane.showConfirmDialog(null,
			// "Do you want to Check In this Key?", "Confirm",
			// JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			//if (response == JOptionPane.YES_OPTION) {

			if(flag){
				// insert query here
				rst = stment.executeQuery("SELECT * FROM SERVICE WHERE keyID = '"
								+ keyID + "' and specificKey = '" + specificKey + "'");
				
				rst.next();
				
				CheckIn.txtPerson.setText(rst.getString("pickUpPerson"));
				CheckIn.txtTime.setText(rst.getString("checkOutTime"));
				CheckIn.txtDate.setText(rst.getString("checkOutDate"));

			//}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	}
	
private boolean checkerexist(String s,String g) throws SQLException {
		
		if(Checker.checkNumber(s)){
			
			int id=Integer.parseInt(s);
			try{
				DatabaseConnection database = new DatabaseConnection();
				Statement st = database.getStatement();
				ResultSet rst = null;
				
				
				rst = st.executeQuery("SELECT * FROM Service WHERE keyID='" + id+ "' and specificKey='" + g +"'");
				
		
		
					if (rst.next()){
						return true;
					}
					
			
				
			} catch (NullPointerException e) {

				e.printStackTrace();
			}
		
		}
		return false;

	}


private boolean checkerfields(String s,String g) throws SQLException {
	
	
		int id=Integer.parseInt(s);
		try{
			DatabaseConnection database = new DatabaseConnection();
			Statement st = database.getStatement();
			ResultSet rst = null;
			
			
			rst = st.executeQuery("SELECT * FROM Service WHERE keyID='" + id+ "' and specificKey='" + g +"'");
			//System.out.print("fdsa");
			rst.next();
			
			String l1=rst.getString("checkInTime");
			String l2=rst.getString("checkInDate");
			System.out.println(l1);
			System.out.println(l2);
			
			if(l1!=null && l2!=null){
				return true;
			}
				
		
			
		} catch (NullPointerException e) {

			e.printStackTrace();
		}
	
	
	return false;

}
}
