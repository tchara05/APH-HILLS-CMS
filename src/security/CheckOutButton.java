package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

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

		boolean flag=true;
		//
		pickUpPerson=Checker.clearString(pickUpPerson);
		if(!Checker.checkString(pickUpPerson)){
			Messages.showWarningMessage("PickUp Person not found");
		}
		
		
		if(keyID.compareTo("") != 0){
			try {
				if (!checker(keyID)){
					Messages.showWarningMessage("Key ID not found ");
					flag=false;
				}
			} catch (SQLException e1) {
				System.out.print("2222");
			}
		}
		System.out.print(flag);
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
	
	
}
