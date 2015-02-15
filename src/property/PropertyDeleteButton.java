package property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import customer.CustomerMenu;
import extras.DatabaseConnection;

public class PropertyDeleteButton {
	
	
	
	public static void start(){
		
		
		/** Remove in the finish **/	
		DatabaseConnection database= new DatabaseConnection();
		ResultSet rst =null;
		Statement st = database.getStatement(); 	
		/*************************/	
		
		
		// Confirm Dialog Here //
	    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
	       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
	       if (response == JOptionPane.YES_OPTION) {
	    	   
	    	   
	    	   String property = (String)PropertyMenu.getSelectedProperty();
	    		String plotName="";
	    		String plotNo="";
	    		int i = 0;
	    		while (property.charAt(i)!=' ' && i<property.length()){
	    			plotName = plotName + property.charAt(i);
	    			i++;
	    		}
	    		i++;
	    		while(i<property.length()){
	    			plotNo = plotNo+property.charAt(i);
	    			i++;
	    		}
	    		
	    		
	    		
	    		PropertyMenu.DeletePropertyFromList();
	    		String query = "DELETE Property WHERE plotName = '" + plotName + "' and plotNumber = '" + plotNo+"'";
	    		
	    		try {
	    			st.executeUpdate(query);
	    		} catch (SQLException e) {
	    			
	    			e.printStackTrace();
	    		}
	    		
				JOptionPane.showMessageDialog(null,
					    "Customer Deleted",
					    "Information Message",
					    JOptionPane.INFORMATION_MESSAGE);

	         
	        }
		
		
		
		
		
	}
	
	
	
	

}
