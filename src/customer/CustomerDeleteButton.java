package customer;

import java.sql.SQLException;
import extras.Messages;
import java.sql.Statement;

import javax.swing.JOptionPane;
import contract.ContractForm;
import extras.ListManager;

import extras.DatabaseConnection;

public class CustomerDeleteButton extends Thread {

	public void run() {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/

		// Confirm Dialog Here //
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {

			String customer = (String) CustomerMenu.getSelectedCustomer();

			if (customer != null) {
				
				
				String[] Customer = ListManager.SplitThreeItem(customer);
				String s = ListManager.DeleteFromList(CustomerMenu.AllCustomers);
				ListManager.DeleteFromList(ContractForm.AllCustomers, s);
				String query = "DELETE Customer WHERE  customerID ='"+Customer[0]+"'";

				try {
					st.executeUpdate(query);
				} catch (SQLException e) {
					System.out
							.println("Cant execute the query in CustomerDelete");
					e.printStackTrace();
				}

				Messages.showWarningMessage("Customer Deleted");
				

			} else {
				Messages.showWarningMessage("Nothing To Delete");

			}
		}

	}

}
