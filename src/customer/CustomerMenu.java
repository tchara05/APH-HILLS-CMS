package customer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import extras.Checker;
import extras.DatabaseConnection;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class CustomerMenu extends JPanel {

	// Graphical Variables //

	@SuppressWarnings("unused")
	private static CustomerForm customerform;
	private static JComboBox<String> AllCustomers;
	private static JPanel CustomerPanel;
	private JTextField PrimaryMail;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField CustomerID;
	private JTextField contactNumber;
	private JTextField MobilePhone;

	/**
	 * Create the panel.
	 */
	public CustomerMenu() {

		customerform = new CustomerForm();
		CustomerForm.setVisible(false);

		CustomerPanel = new JPanel();

		JLabel lblAllCustomers = new JLabel("All Customers:");

		AllCustomers = new JComboBox<String>();
		setUpCustomerList();
		AllCustomers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String) AllCustomers.getSelectedItem();
				setDetails(str);
			}
		});

		JButton btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// CustomerClearButton.start();
				CustomerForm.setID();
				CustomerForm.setVisible(true);
			}
		});

		JButton btnEditCustomer = new JButton("Edit/View Customer");
		btnEditCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerEditButton().start();
			}
		});

		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				new CustomerDeleteButton().start();
			}
		});

		PrimaryMail = new JTextField();
		PrimaryMail.setEditable(false);
		PrimaryMail.setColumns(15);

		FirstName = new JTextField();
		FirstName.setEditable(false);
		FirstName.setColumns(15);

		LastName = new JTextField();
		LastName.setEditable(false);
		LastName.setColumns(15);

		JLabel lblFirstName = new JLabel("First Name:");

		JLabel lblLastname = new JLabel("Last Name:");

		JLabel lblNewLabel = new JLabel("Primary Email:");

		JLabel lblNewLabel_1 = new JLabel("Customer ID:");

		CustomerID = new JTextField();
		CustomerID.setEditable(false);
		CustomerID.setColumns(10);

		contactNumber = new JTextField();
		contactNumber.setEditable(false);
		contactNumber.setColumns(10);

		JLabel lblContactPhone = new JLabel("Contact Phone:");

		JLabel lblMobilePhone = new JLabel("Mobile Phone:");

		MobilePhone = new JTextField();
		MobilePhone.setEditable(false);
		MobilePhone.setColumns(15);

		GroupLayout gl_CustomerPanel = new GroupLayout(CustomerPanel);
		gl_CustomerPanel.setHorizontalGroup(
			gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CustomerPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAllCustomers)
						.addGroup(gl_CustomerPanel.createSequentialGroup()
							.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_CustomerPanel.createSequentialGroup()
									.addComponent(lblMobilePhone)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(MobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblLastname)
								.addComponent(lblNewLabel_1)
								.addComponent(AllCustomers, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_CustomerPanel.createSequentialGroup()
									.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblFirstName)
										.addComponent(lblContactPhone))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(PrimaryMail)
										.addComponent(LastName)
										.addComponent(FirstName)
										.addComponent(CustomerID)
										.addComponent(contactNumber))))
							.addGap(78)
							.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnEditCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeleteCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddNewCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(78))
		);
		gl_CustomerPanel.setVerticalGroup(
			gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CustomerPanel.createSequentialGroup()
					.addGap(44)
					.addComponent(lblAllCustomers)
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewCustomer)
						.addComponent(AllCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteCustomer)
						.addComponent(lblNewLabel_1)
						.addComponent(CustomerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditCustomer)
						.addComponent(FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastname)
						.addComponent(LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(PrimaryMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(contactNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContactPhone))
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobilePhone)
						.addComponent(MobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(90))
		);
		CustomerPanel.setLayout(gl_CustomerPanel);
		

	}

	public static JPanel createCustumerMenu() {
		new CustomerMenu();
		return CustomerPanel;

	}

	public static Object getSelectedCustomer() {
		return AllCustomers.getSelectedItem();
	}

	public static void setUpCustomerList() {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/

		// Statement st = LogIn.database.getStatement();
		ResultSet rst = null;
		try {
			rst = st.executeQuery("SELECT customerID, firstName , lastName FROM Customer ORDER BY firstName , lastName");
			while (rst.next() && rst.getString(1) != null) {
				AllCustomers.addItem(rst.getString(1) + " " + rst.getString(2)
						+ " " + rst.getString(3));
			}

		} catch (SQLException e1) {
			System.out.println("Set up list custoemr exception");
			e1.printStackTrace();
		}	

		try {
			AllCustomers.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("Empty Customer List");
			e.printStackTrace();
		}

	}

	public static void UpdateCustomerList(String id,String str1, String str2) {

		int length = AllCustomers.getItemCount();
		String value = str1 + " " + str2;
		int i = 0;
		String testing= (String) AllCustomers.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,Checker.removeStringID(testing)) >0) {
			i++;
			testing= (String) AllCustomers.getItemAt(i);
		}
		testing= (String) AllCustomers.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,Checker.removeStringID(testing)) == 0) {
			i++;
			testing= (String) AllCustomers.getItemAt(i);
		}
		
		String finalValue =id+" " + value;
		AllCustomers.insertItemAt( finalValue, i);
		try {
			AllCustomers.setSelectedIndex(0);
		} catch (Exception e) {

			System.out.println("Empty Customer List");
			e.printStackTrace();
		}
	}

	public static void DeleteCustomerFromList() {

		if (AllCustomers.getItemCount() > 0) {
			AllCustomers.removeItemAt((AllCustomers.getSelectedIndex()));
		}

	}

	public void setDetails(String customer) {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/

		// Statement st = LogIn.database.getStatement();
		ResultSet rst = null;

		if (customer == null) {
			return;
		}

		String Fname = "";
		String Lname = "";
		String id = "";
		int i = 0;
		while (i < customer.length() && customer.charAt(i) != ' ') {
			id = id + customer.charAt(i);
			i++;
		}
		i++;
		while ((i < customer.length() && customer.charAt(i) != ' ')) {
			Fname = Fname + customer.charAt(i);
			i++;
		}
		i++;
		while (i < customer.length()) {
			Lname = Lname + customer.charAt(i);
			i++;
		}

		String query ="SELECT customerID, firstName, lastName, primaryEmail, contactPhone, mobilePhone FROM Customer WHERE firstName='"
				+ Fname + "' and lastName ='" + Lname + "' and customerID = '" + id +"'";
		
		
	
		try {
			rst = st.executeQuery(query);
			if(rst.next() && rst.getString(1)!=null) {

				CustomerID.setText(rst.getString(1));
				FirstName.setText(rst.getString(2));
				LastName.setText(rst.getString(3));
				PrimaryMail.setText(rst.getString(4));
				contactNumber.setText(rst.getString(5));
				MobilePhone.setText(rst.getString(6));
				
			}

		} catch (SQLException e) {
			System.out.println("Cannot execute query in customer details filling fields");
			e.printStackTrace();
		}

	}

}
