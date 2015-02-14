package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extras.DatabaseConnection;

import userMenus.LogIn;

public class CustomerEditButton extends Thread {
	
	public void run(){
		
	//	Statement st = LogIn.database.getStatement();
		
		
		
		/** Remove in the finish **/	
		CustomerForm.edit=true;
		
		Statement st =CustomerForm.database.getStatement(); 	
		
		/*************************/	
		
		ResultSet rst =null;
		
		String customer = (String)CustomerMenu.getSelectedCustomer();
		String Fname="";
		String Lname="";
		int i = 0;
		while (customer.charAt(i)!=' ' && i<customer.length()){
			Fname = Fname + customer.charAt(i);
			i++;
			System.out.println(1);
		}
		i++;
		while(i<customer.length()){
			Lname = Lname+customer.charAt(i);
			i++;
			System.out.println(2);
		}
		
		
		
		try {
			rst = st.executeQuery("SELECT * FROM Customer WHERE firstName='"+Fname+"' and lastName ='"+Lname+"'");
			if ( rst.next()&&(rst.getString(1)!=null)){
				
				CustomerForm.setAddress(rst.getString(4));
				CustomerForm.setBussinesNumber(rst.getString(10));
				CustomerForm.setCity(rst.getString(8));
				CustomerForm.setContactNumber(rst.getString(12));
				CustomerForm.setFaxNumber(rst.getString(13));
				CustomerForm.setFname(rst.getString(2));
				CustomerForm.setLastName(rst.getString(3));
				CustomerForm.setNote(rst.getString(16));
				CustomerForm.setPhoneMobile(rst.getString(11));
				CustomerForm.setPrimaryMail(rst.getString(5));
				CustomerForm.setSecondaryMail(rst.getString(6));
				CustomerForm.setZipCode(rst.getString(9));	
				CustomerForm.setIDbyEdit(rst.getString(1));
				
				if (rst.getInt(14)==0){
					CustomerForm.setCloseAccound(false);
				}else
					CustomerForm.setCloseAccound(true);
				
				if (rst.getInt(15)==0){	
					CustomerForm.setInformationMaterial(false);
				}else{
					CustomerForm.setInformationMaterial(true);
				}
				
				

			}
			CustomerForm.setVisible(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
