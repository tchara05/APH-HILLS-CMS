package customer;

import java.sql.SQLException;

import extras.DatabaseConnection;
import extras.Messages;

import javax.swing.JOptionPane;

import contract.ContractForm;
import extras.ListManager;
/**
 * Class that can Delete a Customer from Database.
 * Connect to database and execute query to delete Customer
 *
 * @author TeamD
 *
 */
public class CustomerDeleteButton extends Thread {

	
	/**
	 * 
	 * Method that connect to a database and execute query to delete
	 * a Customer and disable the safe question to complete this action.
	 * 
	 * 
	 */
	public void run() {


			// Confirm Dialog Here //
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				DatabaseConnection database= new DatabaseConnection();

				String customer = (String) CustomerMenu.AllCustomers
						.getSelectedItem();

				if (customer != null) {

					String[] Customer = ListManager.SplitThreeItem(customer);
					String s = ListManager
							.DeleteFromList(CustomerMenu.AllCustomers);
					ListManager.DeleteFromList(ContractForm.AllCustomers, s);
					String query = "DELETE Customer WHERE  customerID ='"
							+ Customer[0] + "'";

					try {
						database.getStatement().executeUpdate(query);
					} catch (SQLException e) {
						System.out
								.println("Cant execute the query in CustomerDelete");
						e.printStackTrace();
					}finally{
						database.closeDatabaseConnection();
					}

					Messages.showWarningMessage("Customer Deleted");

				} else {
					Messages.showWarningMessage("Nothing To Delete");

				}
			
		}
	}

}
