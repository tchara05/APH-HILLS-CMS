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
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Query;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class CustomerMenu extends JPanel {

	// This is the hole box //
	private static JPanel CustomerPanel;
	
	@SuppressWarnings("unused")
	private static CustomerForm customerform;
	
	// Graphical Input Variables //
	public static JComboBox<String> AllCustomers;
	
	private JTextField PrimaryMail;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField CustomerID;
	private JTextField contactNumber;
	private JTextField MobilePhone;
	
	// Buttons Variables //
	private JButton btnAddNewCustomer;
	private JButton btnDeleteCustomer;
	private JButton btnEditCustomer;

	public static DatabaseConnection database;
	
	
	CustomerMenu() {

		customerform = new CustomerForm();
		CustomerForm.setVisible(false);
		CustomerPanel = new JPanel();

		// Labels //
		JLabel lblAllCustomers = new JLabel("All Customers:");
		JLabel lblFirstName = new JLabel("First Name:");
		JLabel lblLastname = new JLabel("Last Name:");
		JLabel lblNewLabel = new JLabel("Primary Email:");
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		JLabel lblMobilePhone = new JLabel("Mobile Phone:");

		//DropDown List //
		AllCustomers = new JComboBox<String>();
		ListManager.setUpThreeList(AllCustomers, Query.CUSTOMER_NO_FNAME_LNAME);
		
		// Buttons //
		btnAddNewCustomer = new JButton("Add New Customer");
		btnEditCustomer = new JButton("Edit/View Customer");
		btnDeleteCustomer = new JButton("Delete Customer");
	
		database = new DatabaseConnection();
		
		//Text Box //
		PrimaryMail = new JTextField();
		PrimaryMail.setEditable(false);
		PrimaryMail.setColumns(15);

		FirstName = new JTextField();
		FirstName.setEditable(false);
		FirstName.setColumns(15);

		LastName = new JTextField();
		LastName.setEditable(false);
		LastName.setColumns(15);

		CustomerID = new JTextField();
		CustomerID.setEditable(false);
		CustomerID.setColumns(10);

		contactNumber = new JTextField();
		contactNumber.setEditable(false);
		contactNumber.setColumns(10);

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
		addButtonsFuctionalities();
	}
	
	
	
	//Events Added //
	private void addButtonsFuctionalities(){
		
		btnDeleteCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerDeleteButton().start();
			}
		});
		
		btnEditCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerEditButton().start();
			}
		});
		
		btnAddNewCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerForm.setID();
				CustomerForm.setVisible(true);
			}
		});
		
		AllCustomers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String) AllCustomers.getSelectedItem();
				setDetails(str);
			}
		});
		
	}
	
	// Reuturns the hole box //
	public static JPanel createCustomerMenu() {
		new CustomerMenu();
		return CustomerPanel;
	}
	public void setDetails(String customer) {
		Statement st = database.getStatement();
		ResultSet rst = null;

		if (customer == null) {
			return;
		}

		String[] Customer = ListManager.SplitThreeItem(customer);

		String query ="SELECT customerID, firstName, lastName, primaryEmail, contactPhone, mobilePhone FROM" +
				" Customer WHERE customerID = '" + Customer[0] +"'";
			
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
