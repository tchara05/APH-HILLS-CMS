package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extras.DatabaseConnection;

public class CustomerDeleteButton {
	
	
	public static void start(){
		
		/** Remove in the finish **/	
		DatabaseConnection database= new DatabaseConnection();
		ResultSet rst =null;
		Statement st = database.getStatement(); 	
		/*************************/	
		
	String customer = (String)CustomerMenu.getSelectedCustomer();
	String Fname="";
	String Lname="";
	int i = 0;
	while (customer.charAt(i)!=' ' && i<customer.length()){
		Fname = Fname + customer.charAt(i);
		i++;
	}
	i++;
	while(i<customer.length()){
		Lname = Lname+customer.charAt(i);
		i++;
	}
	
	CustomerMenu.DeleteCustomerFromList();
	String query = "DELETE Customer WHERE firstName = '" + Fname + "' and lastName = '" + Lname+"'";
	
	
	try {
		st.executeUpdate(query);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	}

}
