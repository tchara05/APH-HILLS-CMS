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


public class CustomerMenu extends JPanel {
	
	
	// Graphical Variables //

	private static CustomerForm customerform;
	private static JLabel lblCustomerDescriptions;	
	private static JTextField txtCustomerSearch;
	private static JComboBox<String> AllCustomers;
	private static JPanel CustomerPanel;
	
	

	
	


	/**
	 * Create the panel.
	 */
	public CustomerMenu() {
		
		customerform = new CustomerForm();
		customerform.setVisible(false);
		
		
		CustomerPanel = new JPanel();
		
		
		JLabel lblAllCustomers = new JLabel("All Customers:");
		lblCustomerDescriptions = new JLabel("");
		
		AllCustomers = new JComboBox<String>();
		
		
		UpDateCustomerList();
	
		
		
		
		JButton btnAddNewCustomer = new JButton("Add New Customer");
		btnAddNewCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 
				lblCustomerDescriptions.setText("<html>Button Description: <br><br>" +
						"Adding new customer into the database" +
						" with all his information.<html>");
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblCustomerDescriptions.setText("");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				customerform.setVisible(true);
			}
		});
		
		
		JButton btnEditCustomer = new JButton("Edit/View Customer");
		btnEditCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblCustomerDescriptions.setText("<html>Button Description:<br><br>" +
						"Edit the the selected customer from the dropdown list.<html>");
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerDescriptions.setText("");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerEditButton().start();
			}
		});

		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblCustomerDescriptions.setText("<html>Button Description:<br><br>" +
						"Deleting the selected customer if the customer have no relationship with any contract.<html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCustomerDescriptions.setText("");
			}
		});
		
		JButton btnShowCustomerDetais = new JButton("Show Customer Details");
		
		JLabel lblSearchCustomerBy = new JLabel("Search Customer by Name");
		
		txtCustomerSearch = new JTextField();
		txtCustomerSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		
		GroupLayout gl_CustomerPanel = new GroupLayout(CustomerPanel);
		gl_CustomerPanel.setHorizontalGroup(
			gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CustomerPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAllCustomers)
						.addGroup(gl_CustomerPanel.createSequentialGroup()
							.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtCustomerSearch, Alignment.LEADING)
										.addComponent(AllCustomers, Alignment.LEADING, 0, 227, Short.MAX_VALUE))
									.addComponent(lblSearchCustomerBy))
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCustomerDescriptions, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnEditCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnDeleteCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnShowCustomerDetais, 0, 0, Short.MAX_VALUE)
									.addComponent(btnAddNewCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addGap(13))
		);
		gl_CustomerPanel.setVerticalGroup(
			gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CustomerPanel.createSequentialGroup()
					.addGap(44)
					.addComponent(lblAllCustomers)
					.addGap(18)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddNewCustomer))
					.addGap(18)
					.addComponent(btnDeleteCustomer)
					.addGap(18)
					.addComponent(btnEditCustomer)
					.addGap(18)
					.addComponent(btnShowCustomerDetais)
					.addGroup(gl_CustomerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CustomerPanel.createSequentialGroup()
							.addGap(118)
							.addComponent(lblSearchCustomerBy)
							.addGap(18)
							.addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSearch)
							.addContainerGap(61, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_CustomerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCustomerDescriptions, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(70))))
		);
		CustomerPanel.setLayout(gl_CustomerPanel);
		

	}
	
	public static JPanel createCustumerMenu(){
		new CustomerMenu();
		return CustomerPanel;
	
	}
	
	public static Object getSelectedCustomer(){
		return AllCustomers.getSelectedItem();
	}
	
	public static void UpDateCustomerList(){
		
		/** Remove in the finish **/	
		DatabaseConnection database= new DatabaseConnection();
		ResultSet rst =null;
		Statement st = database.getStatement(); 	
		
			
		/*************************/	
		
		//	Statement st = LogIn.database.getStatement();
		try {
			rst = st.executeQuery("SELECT customerID, firstName , lastName FROM Customer");
			while (rst.next()){
				AllCustomers.addItem(rst.getString(2) +" " + rst.getString(3));
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
