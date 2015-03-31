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
import java.awt.Font;

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
		CustomerPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setBounds(127, 55, 584, 161);
		CustomerPanel.add(panel);
		panel.setLayout(null);
		
				// Labels //
				JLabel lblAllCustomers = new JLabel("All Customers:");
				lblAllCustomers.setBounds(42, 9, 93, 16);
				panel.add(lblAllCustomers);
				
						// DropDown List //
						AllCustomers = new JComboBox<String>();
						AllCustomers.setBounds(37, 37, 301, 27);
						panel.add(AllCustomers);
						ListManager.setUpThreeList(AllCustomers, Query.CUSTOMER_NO_FNAME_LNAME);
						btnEditCustomer = new JButton("Edit/View Customer");
						btnEditCustomer.setBounds(379, 105, 149, 33);
						panel.add(btnEditCustomer);
						btnEditCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
						btnDeleteCustomer = new JButton("Delete Customer");
						btnDeleteCustomer.setBounds(379, 70, 149, 33);
						panel.add(btnDeleteCustomer);
						btnDeleteCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
						
								// Buttons //
								btnAddNewCustomer = new JButton("Add New Customer");
								btnAddNewCustomer.setBounds(379, 34, 149, 33);
								panel.add(btnAddNewCustomer);
								btnAddNewCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
																
																		detailsPanel = new JPanel();
																		detailsPanel.setBounds(130, 263, 584, 188);
																		CustomerPanel.add(detailsPanel);
																		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
																		JLabel lblNewLabel = new JLabel("Primary Email:");
																		lblNewLabel.setBounds(313, 72, 89, 16);
																		detailsPanel.setBackground(new Color(173, 216, 230));
																		detailsPanel.setLayout(null);
																		detailsPanel.add(lblNewLabel);
																		
																				// Text Box //
																				PrimaryMail = new JTextField();
																				PrimaryMail.setBounds(414, 66, 164, 28);
																				detailsPanel.add(PrimaryMail);
																				PrimaryMail.setEditable(false);
																				PrimaryMail.setColumns(15);
																				JLabel lblContactPhone = new JLabel("Contact Phone:");
																				lblContactPhone.setBounds(313, 100, 95, 16);
																				detailsPanel.add(lblContactPhone);
																				
																						contactNumber = new JTextField();
																						contactNumber.setBounds(414, 94, 164, 28);
																						detailsPanel.add(contactNumber);
																						contactNumber.setEditable(false);
																						contactNumber.setColumns(10);
																						
																								MobilePhone = new JTextField();
																								MobilePhone.setBounds(114, 66, 181, 28);
																								detailsPanel.add(MobilePhone);
																								MobilePhone.setEditable(false);
																								MobilePhone.setColumns(15);
																								JLabel lblMobilePhone = new JLabel("Mobile Phone:");
																								lblMobilePhone.setBounds(14, 72, 88, 16);
																								detailsPanel.add(lblMobilePhone);
																								JLabel lblNewLabel_1 = new JLabel("Customer ID:");
																								lblNewLabel_1.setBounds(146, 32, 83, 16);
																								detailsPanel.add(lblNewLabel_1);
																								
																										CustomerID = new JTextField();
																										CustomerID.setBounds(241, 26, 161, 28);
																										detailsPanel.add(CustomerID);
																										CustomerID.setEditable(false);
																										CustomerID.setColumns(10);
																										JLabel lblFirstName = new JLabel("First Name:");
																										lblFirstName.setBounds(14, 100, 72, 16);
																										detailsPanel.add(lblFirstName);
																										
																												FirstName = new JTextField();
																												FirstName.setBounds(114, 94, 181, 28);
																												detailsPanel.add(FirstName);
																												FirstName.setEditable(false);
																												FirstName.setColumns(15);
																												JLabel lblLastname = new JLabel("Last Name:");
																												lblLastname.setBounds(14, 128, 70, 16);
																												detailsPanel.add(lblLastname);
																												
																														LastName = new JTextField();
																														LastName.setBounds(114, 122, 181, 28);
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
