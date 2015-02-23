package contract;

import java.sql.SQLException;
import java.sql.Statement;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;

public class ContractSaveButton extends Thread {

	
	public void run(){
		
		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/
		
		int length = ContractForm.AllOwners.getSize();;
		boolean act = ContractForm.getActive();
		int active = 0;
		if (act){
			active =1;
		}
		String contractID = ContractForm.getContractID();
		while (!ContractForm.AllOwners.isEmpty()){
			String[] customer = ListManager.removeShare(ContractForm.AllOwners.remove(0));
			String[] Customer = ListManager.SplitThreeItem(customer[1]);
			String query = "INSERT INTO Contract VALUES ('"+Customer[0] +"','"+ContractForm.txtPlotID.getText()+"','"
							+customer[0]+"','"+active+"')";
			ListManager.UpdateList(Customer[0], Customer[1], Customer[2],ContractForm.AllCustomers);
			try {
				st.executeUpdate(query);
			
				ContractForm.totalShare=0;
				
			} catch (SQLException e) {
				System.out.println("Can not execut query in contract save button");
				e.printStackTrace();
			}
		}
		

		
		

		Messages.showSaveMessage("Contract Added");
		ContractForm.setVisible(false);
	}
	
	
	
}


