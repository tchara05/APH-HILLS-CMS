package customer;

import javax.swing.JOptionPane;

import checksClasses.Checker;

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
		
			
			
			String s = CustomerForm.getFname();
			boolean checked = true;
			
			
			if ( !Checker.checkString(s)){
						JOptionPane.showMessageDialog(null,
					    "First Name has invalid characters",
					    "Inane warning",
					    JOptionPane.WARNING_MESSAGE);
						checked = false;
			}
		
			
			
			/* If everything is ok, run the query for the database */
			
			
			
			if  (checked){
				execQuery();
			}
		
		
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
	
	
	
	private static int getCountry(String  country){
		
		int countryID=0;
		
		/* We need a query here */
		
		return countryID;
		
	}
		
		
		
		
		
		
		
		
	
	
	

}
