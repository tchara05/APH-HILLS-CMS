package customer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import userMenus.LogIn;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Query;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;

import java.awt.Font;
/**
 * Class that represents a window.
 *
 * All types and fields are static because the form would be created 
 * one time.
 * 
 * 
 * All methods and listeners in this class
 * connect to a database to retrieve, or puts some data.
 * 
 * @author TeamD
 *
 */
public class CustomerMenu {

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
	private JPanel panel_1;
	
	/**
	 * Constructor of the form.
	 * The constructor calls the initialize method to 
	 * design the window-form and initialize all fields.
	 * 
	 * 
	 */
	CustomerMenu() {

		customerform = new CustomerForm();
		CustomerForm.setVisible(false);
		CustomerPanel = new JPanel();
		CustomerPanel.setBackground(new Color(255, 255, 255));
		CustomerPanel.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		CustomerPanel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"CUSTOMER MENU", TitledBorder.CENTER, TitledBorder.TOP, null,
				null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 21, 792, 473);
		CustomerPanel.add(panel_1);
		panel_1.setLayout(null);

		detailsPanel = new JPanel();
		detailsPanel.setBounds(65, 248, 673, 183);
		panel_1.add(detailsPanel);
		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		JLabel lblNewLabel = new JLabel("Primary Email:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(351, 61, 91, 16);
		detailsPanel.setBackground(new Color(173, 216, 230));
		detailsPanel.setLayout(null);
		detailsPanel.add(lblNewLabel);

		// Text Box //
		PrimaryMail = new JTextField();
		PrimaryMail.setBounds(461, 49, 164, 28);
		detailsPanel.add(PrimaryMail);
		PrimaryMail.setEditable(false);
		PrimaryMail.setColumns(15);
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		lblContactPhone.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblContactPhone.setBounds(351, 100, 95, 16);
		detailsPanel.add(lblContactPhone);

		contactNumber = new JTextField();
		contactNumber.setBounds(461, 94, 164, 28);
		detailsPanel.add(contactNumber);
		contactNumber.setEditable(false);
		contactNumber.setColumns(10);

		MobilePhone = new JTextField();
		MobilePhone.setBounds(144, 55, 181, 28);
		detailsPanel.add(MobilePhone);
		MobilePhone.setEditable(false);
		MobilePhone.setColumns(15);
		JLabel lblMobilePhone = new JLabel("Mobile Phone:");
		lblMobilePhone.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMobilePhone.setBounds(44, 61, 90, 16);
		detailsPanel.add(lblMobilePhone);
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 17, 83, 16);
		detailsPanel.add(lblNewLabel_1);

		CustomerID = new JTextField();
		CustomerID.setBounds(144, 11, 181, 28);
		detailsPanel.add(CustomerID);
		CustomerID.setEditable(false);
		CustomerID.setColumns(10);
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFirstName.setBounds(44, 100, 90, 16);
		detailsPanel.add(lblFirstName);

		FirstName = new JTextField();
		FirstName.setBounds(144, 94, 181, 28);
		detailsPanel.add(FirstName);
		FirstName.setEditable(false);
		FirstName.setColumns(15);
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLastname.setBounds(44, 139, 90, 16);
		detailsPanel.add(lblLastname);

		LastName = new JTextField();
		LastName.setBounds(144, 133, 181, 28);
		detailsPanel.add(LastName);
		LastName.setEditable(false);
		LastName.setColumns(15);

		panel = new JPanel();
		panel.setBounds(65, 48, 670, 162);
		panel_1.add(panel);
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setLayout(null);

		// Labels //
		JLabel lblAllCustomers = new JLabel("All Customers:");
		lblAllCustomers.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAllCustomers.setBounds(49, 41, 93, 16);
		panel.add(lblAllCustomers);

		// DropDown List //
		AllCustomers = new JComboBox<String>();
		AllCustomers.setBounds(49, 68, 301, 27);
		panel.add(AllCustomers);
		ListManager.setUpThreeList(AllCustomers, Query.CUSTOMER_NO_FNAME_LNAME);
		btnEditCustomer = new JButton("Edit/View Customer");
		btnEditCustomer.setBounds(429, 109, 149, 33);
		panel.add(btnEditCustomer);
		btnEditCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setBounds(429, 65, 149, 33);
		panel.add(btnDeleteCustomer);
		btnDeleteCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));

		// Buttons //
		btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.setBounds(429, 21, 149, 33);
		panel.add(btnAddNewCustomer);
		btnAddNewCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
		addButtonsFuctionalities();
	}

	/**
	 * This method  manage the buttons and 
	 * their actions
	 * 
	 * 
	 */
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
	/**
	 * This method  manage the list 
	 * 
	 * 
	 */
	public static void addListListener(){
		AllCustomers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String) AllCustomers.getSelectedItem();
				setDetails(str);
			}
		});
	
	}
	
	/**
	 * this method create that Form calling the
	 * constructor of CustomerMenu
	 * 
	 * 
	 */
	public static JPanel createCustomerMenu() {
		new CustomerMenu();
		return CustomerPanel;
	}
	
	/**
	 * This method  connect to a database and execute query to select
	 * a Customer and disable same information.
	 * To be sure about the customer to delete or edit.
	 * 
	 * 
	 */
	public static void setDetails(String customer) {

		ResultSet rst = null;

		if (customer == null) {
			return;
		}

		String[] Customer = ListManager.SplitThreeItem(customer);

		String query = "SELECT customerID, firstName, lastName, primaryEmail, contactPhone, mobilePhone FROM"
				+ " Customer WHERE customerID = '" + Customer[0] + "'";

		DatabaseConnection database = new DatabaseConnection();
		try {
			rst = database.getStatement().executeQuery(query);
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
