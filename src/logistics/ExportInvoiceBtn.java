package logistics;

import java.sql.ResultSet;
import java.sql.Statement;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Email;
/**
 * Class create the Invoice for  customer 
 * has property in active when the Export Invoice  
 * button clicked. And create pdf file and also sent 
 * this file with e-mail to the customer.
 *  
 * 
 *
 *
 * @author TeamD
 *
 */
public class ExportInvoiceBtn extends Thread {
	
	/**
	 * 
	 * Method that  create pdf file (invoice) for
	 * the selected Customer from drop-down list.
	 * After that sent with e-mail this file to 
	 * the selected customer. 
	 * 
	 * 
	 */
	public void run(){
		
		String customer = (String) accountantPanel.AllCustomers1.getSelectedItem();
		
		try {
			CompanyDocument.CreateInvoice(customer);
			String[] Customer = ListManager.SplitThreeItem(customer);
			
			DatabaseConnection database = new DatabaseConnection();
			Statement st = database.getStatement();
			ResultSet rst = null;

			rst = st.executeQuery("SELECT * FROM Customer WHERE customerID = '" + Customer[0]+ "'");
			
			String id="";
			String mail ="";
			String FName="";
			String LName="";
			
			if (rst.next()) {
				id=rst.getString(1);
				mail=rst.getString(5);
				FName=rst.getString(2);
				LName=rst.getString(3);	
			}
			Email.send(mail,id,FName,LName,"Invoices");
			
		} catch (Exception e) {
			System.out.println("Create Invoice");
			e.printStackTrace();
		}
		
	}

}
