package customer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;
import userMenus.LogIn;
import extras.Checker;
import extras.DatabaseConnection;

public class CustomerSaveButton extends Thread {
	
	
	/**
	 * run method to start the threat running.
	 * 
	 * It does all the necessary checks
	 * and call some function to execute queries
	 * 
	 * 
	 */
	
	
	
	public void run(){
		
			
		    String country = CustomerForm.getCountry();
			String Fname = CustomerForm.getFname();
			boolean checked = true;
			if ( !Checker.checkString(Fname)){
						JOptionPane.showMessageDialog(null,
					    "First Name has invalid characters",
					    "Inane warning",
					    JOptionPane.WARNING_MESSAGE);
						
						checked = false;
			}
			String Lname=CustomerForm.getLastName();
			// Check Here //
			
			
			String address = CustomerForm.getAddress();
			// Check Here //
			
			String bussinesNumber = CustomerForm.getBussinesNumber();
			//Check Here //
			
			String city = CustomerForm.getCity();
			//Check Here //
			
			String contactNumber = CustomerForm.getContactNumber();
			//Check Here //
			String faxNumber = CustomerForm.getFaxNumber();
			// Check Here //
			
			String customerID =	CustomerForm.getID();
			// Check Here //
			String note =  CustomerForm.getNote();
			// Check Here //
			String mobileNum = CustomerForm.getPhoneMobile();
			// Check Here //
			String primaryMail = CustomerForm.getPrimaryMail();
			// Check Here //
			String secondaryMail = CustomerForm.getSecondaryMail();
			// Check Here //
			String zipcode = CustomerForm.getZipCode();
			// Check Here //
			
			short infoMaterial = 0; 
			if   (CustomerForm.getInformationMaterial()){
				infoMaterial = 1;
			}
			
			short closeAccount = 0;
			if (CustomerForm.getCloseAccound()){
				closeAccount =1;
			}
			
			
			

			try {
			/** Remove in the finishe **/	
			DatabaseConnection	database= new DatabaseConnection();
			ResultSet rst =null;
			Statement st = null; 	
			
			
			
				
			/*************************/	
				st = database.getStatement();
			
			//	Statement st =	LogIn.database.getStatement();
				
				int countryID = getCountry(country,st);
				if (countryID >0 && checked){
					
					String query = "INSERT INTO CUSTOMER VALUES ('"+Fname+"','"+Lname+"','"+primaryMail+"','"+secondaryMail+"','"
									+countryID+"','"+city+"','"+zipcode+"','"+bussinesNumber+"','"+mobileNum+"','"+contactNumber+
									"','"+faxNumber+"','"+closeAccount+"','"+infoMaterial+"','"+note+"')";
					
					
					st.executeUpdate(query);
					new CustomerClearButton().start();
					JOptionPane.showMessageDialog(null,
						    "Customer Added",
						    "",
						    JOptionPane.INFORMATION_MESSAGE);
					CustomerForm.setVisible(false);
					
					
					
				}else {
					System.out.println("Invalid Character or Country Somewhere");
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
				
			} catch (NullPointerException e){
				
				e.printStackTrace();
			}
			
			/* If everything is ok, run the query for the database */
			
			System.out.println("I am here");
			

		
	}
	

	
	
	/**
	 * 
	 * We need this to retrieve the id of country from the database 
	 * because they are in talbe.
	 * 
	 */
	
	
	
	private static int getCountry(String  country,Statement st) throws SQLException{
		
		
	
		int countryID=-1;
		ResultSet result = st.executeQuery("SELECT countryID FROM Country WHERE countryName='"+country+"'");
		if (result.next()){
			countryID = Integer.parseInt(result.getString(1));
		}else{
			countryID=-1;
		}
		return countryID;
	}
	
		
}

/** To Do Things:
 * 
 * 	We must implement the query and check int
 * 
 */
