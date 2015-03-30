package userMenus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;

import admin.mainAdminPanel;
import logistics.accountantPanel;
import contract.ContractMenu;
import property.PropertyMenu;
import security.Securitymenu;
import customer.CustomerMenu;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu {

	private JFrame frame;
	
	//Buttons //
	private static JButton btnProperty;
	private static JButton btnContract ;
	private static JButton btnCustomer;
	
	// Admins Panels //
	private static JPanel ContractPanel; 
	private static JPanel PropertyPanel; 
	private static JPanel CustomerPanel;
	
	// Central Panel
	private static JPanel panel;
	

	public static void main(String[] args) {

					AdminMenu window = new AdminMenu();
					window.frame.setVisible(true);
	}

	public AdminMenu() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminMenu;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(1120, 29, 213, 210);
		lblNewLabel.setBackground(Color.BLACK);
		
		lblAdminMenu = new JLabel("Adminstrator Menu ");
		lblAdminMenu.setBounds(307, 50, 291, 36);
		lblAdminMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		// All Menu Panels //	
		ContractPanel = ContractMenu.createContractMenu();
		PropertyPanel = PropertyMenu.createPropertyMenu();
		CustomerPanel = CustomerMenu.createCustomerMenu();
		
		PropertyPanel.setVisible(true);
		CustomerPanel.setVisible(false);
		ContractPanel.setVisible(false);
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblAdminMenu);
		frame.getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(307, 149, 565, 474);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// Set Buttons //
	    btnProperty = new JButton("Property");
		btnProperty.setBounds(66, 220, 117, 29);
		btnContract = new JButton("Contract");
		btnContract.setBounds(66, 276, 117, 29);
		btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(66, 328, 117, 29);
		
		// Add The Buttons /
		frame.getContentPane().add(btnContract);
		frame.getContentPane().add(btnProperty);
		frame.getContentPane().add(btnCustomer);
		
		
		panel.add(ContractPanel);
		panel.add(PropertyPanel);
		panel.add(CustomerPanel);
		
		
		
		
		
		
		addButtonFuctionalities();
		
	}
	
	
	private static void  addButtonFuctionalities(){
		
	    btnProperty.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		ContractPanel.setVisible(false);
	    		PropertyPanel.setVisible(true);
	    		
	    		
	    	}
	    });
	    
	    btnContract.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		PropertyPanel.setVisible(false);
		 		ContractPanel.setVisible(true);
	    		
		 	}
		 });
	    
	    btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		
		
	}
	
	
	
	public void setVisible(boolean visible){
		frame.setVisible(visible);
	
	}
}
