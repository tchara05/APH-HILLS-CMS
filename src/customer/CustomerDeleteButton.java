package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;

public class CustomerDeleteButton extends Thread {

	public void run() {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		ResultSet rst = null;
		Statement st = database.getStatement();
		/*************************/

		// Confirm Dialog Here //
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {

			String customer = (String) CustomerMenu.getSelectedCustomer();
			String Fname = "";
			String Lname = "";
			String id = "";

			if (customer != null) {
				int i = 0;
				while (i < customer.length() && customer.charAt(i) != ' ') {
					id = id + customer.charAt(i);
					i++;
				}
				i++;
				while (i < customer.length() && customer.charAt(i) != ' ') {
					Fname = Fname + customer.charAt(i);
					i++;
				}
				i++;
				while (i < customer.length()) {
					Lname = Lname + customer.charAt(i);
					i++;
				}

				CustomerMenu.DeleteCustomerFromList();
				String query = "DELETE Customer WHERE firstName = '" + Fname
						+ "' and lastName = '" + Lname + "'";

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
