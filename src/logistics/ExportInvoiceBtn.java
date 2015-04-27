package logistics;

import java.sql.ResultSet;
import java.sql.Statement;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.email;

public class ExportInvoiceBtn extends Thread {
	
	public void run(){
		
		String customer = (String) accountantPanel.AllCustomers.getSelectedItem();
		
		try {
			//CompanyDocument.CreateInvoice(customer);
			CompanyDocument.CreateRECEIPT(customer);
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
			email.send(mail,id,FName,LName);
			
		} catch (Exception e) {
			System.out.println("Create Invoice");
			e.printStackTrace();
		}
		
	}

}
