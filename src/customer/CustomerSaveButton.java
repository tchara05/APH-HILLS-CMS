package customer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import userMenus.LogIn;
import extras.Checker;
import extras.DatabaseConnection;

public class CustomerSaveButton extends Thread {
	
	
   /* To do Things :
    * 
    * We have to filter or string with Checker.clearString(str) before make any other check;
    * 
    * 
    * 
    * 
    */
	public void run(){
		
			boolean checked = true;
			
		    String country = CustomerForm.getCountry();
		    
			
		  /**   Retrieve and check the data from the form **/
		    
			String nFname= Checker.clearString(CustomerForm.getFname());
			nFname=Checker.clearString(nFname);
			if ( !Checker.checkString(nFname)||(nFname.isEmpty())){
				JOptionPane.showMessageDialog(null,
			    "First Name has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			
			String nLname = Checker.clearString(CustomerForm.getLastName());
			nLname=Checker.clearString(nLname);
			if ( !Checker.checkString(nLname)||(nLname.isEmpty())){
				JOptionPane.showMessageDialog(null,
			    "Last Name has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			
			String address = CustomerForm.getAddress();
			
			String city = CustomerForm.getCity();
			city=Checker.clearString(city);
			if ( !Checker.checkString(city)||(city.isEmpty())){
				JOptionPane.showMessageDialog(null,
			    "City has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String bussinesNumber = CustomerForm.getBussinesNumber();
			if ( !Checker.checkNumber(bussinesNumber)){
				JOptionPane.showMessageDialog(null,
			    "Bussines Number has invalid characters ",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
		
			
			String contactNumber = CustomerForm.getContactNumber();
			contactNumber = contactNumber.trim();
			if ( !Checker.checkNumber(contactNumber)){
				JOptionPane.showMessageDialog(null,
			    "Contact Number has invalid characters ",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String faxNumber = CustomerForm.getFaxNumber();
			faxNumber = faxNumber.trim();
			if ( !Checker.checkNumber(faxNumber)){
				JOptionPane.showMessageDialog(null,
			    "Fax has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String customerID =	CustomerForm.getID();
			String note =  CustomerForm.getNote();
			
			
			String mobileNum = CustomerForm.getPhoneMobile();
			mobileNum = mobileNum.trim();
			if ( !Checker.checkNumber(mobileNum)){
				JOptionPane.showMessageDialog(null,
			    "Mobile Number has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}
			
			String primaryMail = CustomerForm.getPrimaryMail();
			primaryMail = primaryMail.trim();
			if ( !Checker.checkEmailAddress(primaryMail)){
				JOptionPane.showMessageDialog(null,
			    "Primary Email has invalid characters",
			    "Input warning",
			    JOptionPane.WARNING_MESSAGE);
				checked = false;
			}

			String secondaryMail = CustomerForm.getSecondaryMail();
			secondaryMail = secondaryMail.trim();
			if(!secondaryMail.isEmpty()){
					if ( !Checker.checkEmailAddress(secondaryMail)){
						JOptionPane.showMessageDialog(null,
					    "Secondary Email has invalid characters",
					    "Input warning",
					    JOptionPane.WARNING_MESSAGE);
						checked = false;
					}
			}
			String zipcode = CustomerForm.getZipCode();
		
			
			short infoMaterial = 0; 
			if   (CustomerForm.getInformationMaterial()){
				infoMaterial = 1;
			}
			
			short closeAccount = 0;
			if (CustomerForm.getCloseAccound()){
				closeAccount =1;
			}
			
		/****************************************************************/	

			try {
				
				
			/** Remove in the finish **/	
			DatabaseConnection	database= new DatabaseConnection();
			Statement st =database.getStatement();
			/*************************/	
				
			
			//	Statement st =	LogIn.database.getStatement();
				
				
				int countryID = getCountry(country,st);
				if (countryID >0 && checked){
					
					
					// Confirm Dialog //
				    int response = JOptionPane.showConfirmDialog(null, "Do you want to save changes?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.YES_OPTION) {
				      
				    	String query="";
						if (!CustomerForm.edit){
							query = "INSERT INTO CUSTOMER VALUES ('"+nFname+"','"+nLname+"','"+address+"','"+primaryMail+"','"+secondaryMail+"','"
										+countryID+"','"+city+"','"+zipcode+"','"+bussinesNumber+"','"+mobileNum+"','"+contactNumber+
										"','"+faxNumber+"','"+closeAccount+"','"+infoMaterial+"','"+note+"')";
						}else{
											
							
							query = "UPDATE Customer SET firstName = '" + nFname + "', lastName = '"+ nLname + "', address = '" + address +
									"', primaryEmail ='" +primaryMail + "', secondaryEmail = '" + secondaryMail +"', countryID = '" +
									countryID + "', city ='" + city +"', zipCode= '" + zipcode + "', bussinesPhone = '"+ bussinesNumber +
									"', mobilePhone = '" +mobileNum + "', contactPhone ='" + contactNumber + "', fax = '" + faxNumber +
									"', closeAccount = '" +closeAccount + "', informationMaterial = '"+ infoMaterial + "', note ='" +note +
									"' WHERE  customerID = '"+CustomerForm.getID() +"'";
							
						
							CustomerMenu.DeleteCustomerFromList();
						}
						
						
						
						st.executeUpdate(query);
						CustomerMenu.UpdateCustomerList(CustomerForm.getID(),nFname,nLname);	
						
						new CustomerClearButton().start();
						
						JOptionPane.showMessageDialog(null,
							    "Customer Added",
							    "Information Message",
							    JOptionPane.INFORMATION_MESSAGE);
						
						CustomerForm.setVisible(false);
						
				    }
				}else {
					System.out.println("Invalid Character or Country Somewhere");
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
				
			} catch (NullPointerException e){
				
				e.printStackTrace();
			}
			
			
			CustomerForm.edit=false;
		
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
