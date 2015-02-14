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
		
			boolean checked = true;
			
		    String country = CustomerForm.getCountry();
		    
			String Fname = CustomerForm.getFname();
			if ( !Checker.checkString(Fname)){
				JOptionPane.showMessageDialog(null,
			    "First Name has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String Lname=CustomerForm.getLastName();
			if ( !Checker.checkString(Lname)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Last Name has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			
			String address = CustomerForm.getAddress();
			// Check Here //
			
			String bussinesNumber = CustomerForm.getBussinesNumber();
			if ( !Checker.checkNumber(bussinesNumber)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Bussines Number has invalid characters ",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String city = CustomerForm.getCity();
			if ( !Checker.checkString(city)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "City has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String contactNumber = CustomerForm.getContactNumber();
			if ( !Checker.checkNumber(contactNumber)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Contact Number has invalid characters ",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String faxNumber = CustomerForm.getFaxNumber();
			if ( !Checker.checkNumber(faxNumber)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Fax has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String customerID =	CustomerForm.getID();
			// Check Here //
			// i think we no need this check//
			
			String note =  CustomerForm.getNote();
			// Check Here //
			// i think we no need this check//
			
			String mobileNum = CustomerForm.getPhoneMobile();
			if ( !Checker.checkNumber(mobileNum)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Mobile Number has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String primaryMail = CustomerForm.getPrimaryMail();
			if ( !Checker.checkEmailAddress(primaryMail)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Primary Email has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}

			String secondaryMail = CustomerForm.getSecondaryMail();
			if ( !Checker.checkEmailAddress(secondaryMail)&& checked==false){
				JOptionPane.showMessageDialog(null,
			    "Primary Email has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
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
					CustomerForm.clear.start();
					JOptionPane.showMessageDialog(null,
						    "Customer Added",
						    "Information Message",
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
