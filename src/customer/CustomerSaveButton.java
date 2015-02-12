package customer;

import javax.swing.JOptionPane;

import checksClasses.Checker;

public class CustomerSaveButton extends Thread {
	
	
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
	
	
	private static void execQuery(){
		
		/** Query Code is be in here
		 * 
		 * PK  exception mean some updates so with catch run the update query
		 *  
		 *  
		 *  
		 *  
		 *  
		 **/
		
	}	
		
		
		
		
		
		
		
		
	
	
	

}
