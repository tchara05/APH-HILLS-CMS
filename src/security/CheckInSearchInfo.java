package security;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.BorderFactory;

import javax.swing.border.Border;


import security.CheckIn;
import extras.DatabaseConnection;
import extras.Checker;
import extras.ListManager;
import extras.Messages;

public class CheckInSearchInfo extends Thread {

	@SuppressWarnings("static-access")
	public void run() {

		String keyID;
		String specificKey;
		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red,2);
		
		if(CheckIn.isList == 0) {
			keyID = CheckIn.txtSearch.getText();
			specificKey = CheckIn.txtSpecificKey.getText();
		}
		else {
			String inList = CheckIn.inList;
			String splits[] = new String[2];
			splits = ListManager.SplitTwoItem(inList);
			keyID = splits[0];
			specificKey = splits[1];
		}
		
		boolean  flag=false;
		
		if(Checker.checkNumber(keyID) &&(specificKey.compareTo("A")==0 || specificKey.compareTo("B")==0||specificKey.compareTo("C")==0)){
			try {
				
				if(checkerexist(keyID,specificKey)){
					flag=true;
				}
				else{
				
					Messages.showWarningMessage("Compinasion not correct OR key is checked in !");
					new CheckInClearButton().start();
					flag=false;
				}
			} catch (SQLException e) {
				
			}
			
		}
		else{
			
				if(!Checker.checkNumber(keyID)){
					compound = BorderFactory.createCompoundBorder(redline, compound);
					CheckIn.txtSearch.setBorder(compound);
					compound = null;
					flag=false;
				}
				
				if(!(specificKey.compareTo("A")==0 || specificKey.compareTo("B")==0||specificKey.compareTo("C")==0)){
					compound = BorderFactory.createCompoundBorder(redline, compound);
					CheckIn.txtSpecificKey.setBorder(compound);
					compound = null;
					flag=false;
				}
			Messages.showWarningMessage("Fields has error input!");
			new CheckInClearButton().start();
				
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
				String str = "Key is not checked in yet";
				
				rst = st.executeQuery("SELECT * FROM Service WHERE keyID='" + id+ "' and specificKey='" + g + "' and checkInTime = '" + str + "'");	
			
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
