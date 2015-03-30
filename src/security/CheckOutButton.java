package security;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import security.CheckOut;
import extras.DatabaseConnection;
import extras.Messages;
import userMenus.LogIn;
import security.CheckOutClearButton;
import extras.Checker;

public class CheckOutButton extends Thread {

	public boolean checker() {

		return false;
	}

	@SuppressWarnings("static-access")
	public void run() {

		String keyID = CheckOut.getKeyID();
		String specificKey = CheckOut.getSpecificKey();
		String pickUpPerson = CheckOut.getPickUpPerson();
		String details = CheckOut.getDetails();
		String securityPerson = LogIn.getUsername();
		String checkOutDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String checkOutTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		String checkInTime = "Key is not checked in yet";
		String checkInDate = "Key is not checked in yet";

		
		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red,2);

		
		boolean flag=true;
		int flagged = 0;

		if(keyID.compareTo("") != 0){
			try {
				if (!checker(keyID, flagged)){
					compound = BorderFactory.createCompoundBorder(redline, compound);
					CheckOut.txtKey.setBorder(compound);
					compound=null;
					flag=false;
				}else{
					@SuppressWarnings("unused")
					boolean f1,f2;
					f1=cheked2(keyID,specificKey);//pernei true an exei sto pedio ckeckedInTime"key is not checked in yet"
					//f2=cheked3(keyID,specificKey);//pernei true ean  den yparxei o syndiasmos keyid me specifickey
					System.out.print(f1);
					//System.out.print(f2);
					
					if (f1){
						Messages.showWarningMessage("Can not Ckeck out this Key Not checkIn yet ");
						flag=false;	
						CheckOutClearButton.start(3);
					}
					
				}
			} catch (SQLException e1) {
				System.out.print("2222");
			}
		}
		else{
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CheckOut.txtKey.setBorder(compound);
			compound=null;
			flag=false;
		}
		
		
		pickUpPerson=Checker.clearString(pickUpPerson);
		
		if(!Checker.checkString(pickUpPerson) ){ 
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CheckOut.txtPerson.setBorder(compound);
			compound=null;
			flag=false;
		}
		
		if( pickUpPerson.compareTo("")==0  ){
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CheckOut.txtPerson.setBorder(compound);
			compound=null;
			flag=false;
		}
		
		if(!flag){
			Messages.showWarningMessage("Erros input ");
			CheckOutClearButton.start(3);
			
		}
		
		if(flag){
			try {
	
				DatabaseConnection database = new DatabaseConnection();
				Statement stment = null;
	
				stment = database.getStatement();
	
				int response = JOptionPane.showConfirmDialog(null,
						"Do you want to Check Out this Key?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	
				if (response == JOptionPane.YES_OPTION) {
	
					String query = "";
	
					// insert query here
					query = "INSERT INTO SERVICE VALUES ('" + keyID + "','"
							+ specificKey + "','" + pickUpPerson + "','"
							+ securityPerson + "','" + checkOutTime + "','"
							+ checkOutDate + "','" + checkInTime + "','"
							+ checkInDate + "','" + details + "')";
	
					stment.executeUpdate(query);
	
					new CheckOutClearButton().start(0);
	
					JOptionPane.showMessageDialog(null, "Key Checked Out",
							"Information Message", JOptionPane.INFORMATION_MESSAGE);
	
					//CheckOut.setVisible(false);
					// SecurityMenu.UpdateContractList(propertyID);
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
	
				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean checker(String s, int flag) throws SQLException {
		
		if(Checker.checkNumber(s)){
			
			int id=Integer.parseInt(s);
			try{
				DatabaseConnection database = new DatabaseConnection();
				Statement st = database.getStatement();
				ResultSet rst = null;
			
				if(flag == 0)
					rst = st.executeQuery("SELECT keyID FROM KeyContract WHERE keyID='" + id+"'");
				else
					rst = st.executeQuery("SELECT keyID FROM KeyContract WHERE propertyID='" + id+"'");
					
				if (rst.next()){
						return true;
				}
					
			
				
			} catch (NullPointerException e) {

				e.printStackTrace();
			}
		
		}
		return false;

	}

	
	
	public static boolean cheked2(String s, String p) throws SQLException {
		
		
			int id=Integer.parseInt(s);
			String temp="Key is not checked in yet";
			
			try{
				DatabaseConnection database = new DatabaseConnection();
				Statement st = database.getStatement();
				ResultSet rst = null;
				
				rst = st.executeQuery("SELECT * FROM Service WHERE keyID = '" + id +"' and specificKey= '"+ p +"' and checkInDate = '"+ temp +"'");
				
					if (rst.next()){
						return true;
					}
			
				
			} catch (NullPointerException e) {

				e.printStackTrace();
			}
		
		
		return false;

	}
	
	
//	public boolean cheked3(String s,String p) throws SQLException {
//		
//		
//		int id=Integer.parseInt(s);
//		try{
//			DatabaseConnection database = new DatabaseConnection();
//			Statement st = database.getStatement();
//			ResultSet rst = null;
//			
//			rst = st.executeQuery("SELECT * FROM Service WHERE keyID= '" + id+"' and specificKey= '"+ p +"'");
//			
//				if (!rst.next()){
//					return true;
//				}
//		
//			
//		} catch (NullPointerException e) {
//
//			e.printStackTrace();
//		}
//	
//	
//	return false;
//
//}
	
	
}
