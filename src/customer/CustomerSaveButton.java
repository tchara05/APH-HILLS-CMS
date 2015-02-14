package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import userMenus.LogIn;
import extras.Checker;

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
		
			
			
			String Fname = CustomerForm.getFname();
			boolean checked = true;
			
			
			if ( !Checker.checkString(Fname)){
						JOptionPane.showMessageDialog(null,
					    "First Name has invalid characters",
					    "Inane warning",
					    JOptionPane.WARNING_MESSAGE);
						checked = false;
			}
			String country = CustomerForm.getCountry();
			
			
		
			try {
				Statement st =	LogIn.database.getDatabaseConnection().createStatement();
				
				int countryID = getCountry(country,st);
				if (countryID >0 && checked){
					
					String query = "";
					st.executeUpdate(query);
					new CustomerClearButton().start();
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
	
	/** Query Code is be in here
	 * 
	 * 
	 * Before we run the full query for the save,
	 * we will run some other query first to retrieve the countryID
	 * 
	 * if it throws PK exception,  mean some updates so with catch,
	 * we run the update query
	 *  
	 **/
	
	private static void execQuery(){
		
		
		/* Code Here */
		

	}	
	
	
	
	
	
	/**
	 * 
	 * We need this to retrieve the id of country from the database 
	 * because they are in talbe.
	 * 
	 */
	
	
	
	private static int getCountry(String  country,Statement st) throws SQLException{
		
		int countryID=-1;
		ResultSet result = st.executeQuery("SELECT counrtyID FROM Country WHERE countryName='"+country+"'");
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
