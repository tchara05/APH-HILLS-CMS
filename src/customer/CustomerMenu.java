package customer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import userMenus.LogIn;
import extras.ListManager;
import extras.Query;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class CustomerMenu{

	// This is the hole box //
	private static JPanel CustomerPanel;

	@SuppressWarnings("unused")
	private static CustomerForm customerform;

	// Graphical Input Variables //
	public static JComboBox<String> AllCustomers;

	private static JTextField PrimaryMail;
	private static JTextField FirstName;
	private static JTextField LastName;
	private static JTextField CustomerID;
	private static JTextField contactNumber;
	private static JTextField MobilePhone;

	// Buttons Variables //
    private static JButton btnAddNewCustomer;
	private static JButton btnDeleteCustomer;
	private static JButton btnEditCustomer;
	private static JPanel detailsPanel;
	private JPanel panel;

	CustomerMenu() {

		customerform = new CustomerForm();
		CustomerForm.setVisible(false);
		CustomerPanel = new JPanel();
		CustomerPanel.setBackground(new Color(255, 255, 255));
		CustomerPanel.setBorder(new LineBorder(new Color(0, 0, 128), 3));

		// Labels //
		JLabel lblAllCustomers = new JLabel("All Customers:");
		lblAllCustomers.setBounds(33, 47, 93, 16);

		// DropDown List //
		AllCustomers = new JComboBox<String>();
		AllCustomers.setBounds(33, 82, 301, 27);
		ListManager.setUpThreeList(AllCustomers, Query.CUSTOMER_NO_FNAME_LNAME);

		// Buttons //
		btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.setBounds(412, 81, 169, 36);
		btnEditCustomer = new JButton("Edit/View Customer");
		btnEditCustomer.setBounds(412, 165, 158, 34);
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setBounds(412, 117, 169, 36);
		CustomerPanel.setLayout(null);
		CustomerPanel.add(lblAllCustomers);
		CustomerPanel.add(AllCustomers);
		CustomerPanel.add(btnEditCustomer);
		CustomerPanel.add(btnDeleteCustomer);
		CustomerPanel.add(btnAddNewCustomer);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 211, 617, 176);
		CustomerPanel.add(panel);
		panel.setLayout(null);
		
				detailsPanel = new JPanel();
				detailsPanel.setBounds(16, 19, 584, 135);
				panel.add(detailsPanel);
				detailsPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
				JLabel lblNewLabel = new JLabel("Primary Email:");
				lblNewLabel.setBounds(308, 45, 89, 16);
				detailsPanel.setBackground(new Color(173, 216, 230));
				detailsPanel.setLayout(null);
				detailsPanel.add(lblNewLabel);
				
						// Text Box //
						PrimaryMail = new JTextField();
						PrimaryMail.setBounds(415, 39, 164, 28);
						detailsPanel.add(PrimaryMail);
						PrimaryMail.setEditable(false);
						PrimaryMail.setColumns(15);
						JLabel lblContactPhone = new JLabel("Contact Phone:");
						lblContactPhone.setBounds(308, 73, 95, 16);
						detailsPanel.add(lblContactPhone);
						
								contactNumber = new JTextField();
								contactNumber.setBounds(415, 67, 164, 28);
								detailsPanel.add(contactNumber);
								contactNumber.setEditable(false);
								contactNumber.setColumns(10);
								
										MobilePhone = new JTextField();
										MobilePhone.setBounds(115, 39, 181, 28);
										detailsPanel.add(MobilePhone);
										MobilePhone.setEditable(false);
										MobilePhone.setColumns(15);
										JLabel lblMobilePhone = new JLabel("Mobile Phone:");
										lblMobilePhone.setBounds(15, 45, 88, 16);
										detailsPanel.add(lblMobilePhone);
										JLabel lblNewLabel_1 = new JLabel("Customer ID:");
										lblNewLabel_1.setBounds(111, 11, 83, 16);
										detailsPanel.add(lblNewLabel_1);
										
												CustomerID = new JTextField();
												CustomerID.setBounds(206, 5, 161, 28);
												detailsPanel.add(CustomerID);
												CustomerID.setEditable(false);
												CustomerID.setColumns(10);
												JLabel lblFirstName = new JLabel("First Name:");
												lblFirstName.setBounds(15, 73, 72, 16);
												detailsPanel.add(lblFirstName);
												
														FirstName = new JTextField();
														FirstName.setBounds(115, 67, 181, 28);
														detailsPanel.add(FirstName);
														FirstName.setEditable(false);
														FirstName.setColumns(15);
														JLabel lblLastname = new JLabel("Last Name:");
														lblLastname.setBounds(15, 101, 70, 16);
														detailsPanel.add(lblLastname);
														
																LastName = new JTextField();
																LastName.setBounds(115, 95, 181, 28);
																detailsPanel.add(LastName);
																LastName.setEditable(false);
																LastName.setColumns(15);
		addButtonsFuctionalities();
	}

	// Events Added //
	private void addButtonsFuctionalities() {

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

	public static void setDetails(String customer) {

		ResultSet rst = null;

		if (customer == null) {
			return;
		}

		String[] Customer = ListManager.SplitThreeItem(customer);

		String query = "SELECT customerID, firstName, lastName, primaryEmail, contactPhone, mobilePhone FROM"
				+ " Customer WHERE customerID = '" + Customer[0] + "'";

		try {
			rst = LogIn.database.getStatement().executeQuery(query);
			if (rst.next() && rst.getString(1) != null) {

				CustomerID.setText(rst.getString(1));
				FirstName.setText(rst.getString(2));
				LastName.setText(rst.getString(3));
				PrimaryMail.setText(rst.getString(4));
				contactNumber.setText(rst.getString(5));
				MobilePhone.setText(rst.getString(6));
			}
		} catch (SQLException e) {
			System.out
					.println("Cannot execute query in customer details filling fields");
			e.printStackTrace();
		}

	}

}
