package customer;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;
import extras.ListManager;

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

				CustomerMenu.DeleteCustomerFromList();
				String query = "DELETE Customer WHERE  and customerID ='"+Customer[0]+"'";

				try {
					st.executeUpdate(query);
				} catch (SQLException e) {
					System.out
							.println("Cant execute the query in CustomerDelete");
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Customer Deleted",
						"Information Message", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Nothing To Deleted",
						"Information Message", JOptionPane.INFORMATION_MESSAGE);

			}
		}

	}

}
