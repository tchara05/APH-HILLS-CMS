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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import admin.mainAdminPanel;
import logistics.accountantPanel;
import contract.ContractMenu;
import property.PropertyMenu;
import security.Securitymenu;
import customer.CustomerMenu;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class AdminMenu {

	private static JFrame frame;
	
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
	private JPanel panel_1;
	private JPanel panel_2;
	

	public static void main(String[] args) {

					AdminMenu window = new AdminMenu();
					window.frame.setVisible(true);
	}

	public AdminMenu() {
		initialize();
	}
	private void initialize() {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(1120, 29, 213, 210);
		lblNewLabel.setBackground(Color.BLACK);
		
		// All Menu Panels //	
		ContractPanel = ContractMenu.createContractMenu();
		PropertyPanel = PropertyMenu.createPropertyMenu();
		CustomerPanel = CustomerMenu.createCustomerMenu();
		

		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "ADMINISTRATOR MENU", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(55, 48, 1237, 633);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(71, 193, 79, 23);
		panel_1.add(btnCustomer);
		
		// Set Buttons //
	    btnProperty = new JButton("Property");
	    btnProperty.setBounds(53, 227, 117, 29);
	    panel_1.add(btnProperty);
	    btnContract = new JButton("Contract");
	    btnContract.setBounds(53, 267, 117, 29);
	    panel_1.add(btnContract);
	    
	    panel_2 = new JPanel();
	    panel_2.setBorder(new LineBorder(new Color(0, 0, 128)));
	    panel_2.setBounds(40, 41, 220, 553);
	    panel_1.add(panel_2);
	    panel_2.setLayout(null);
	    
	    panel = new JPanel();
	    panel.setBounds(406, 120, 629, 474);
	    panel_1.add(panel);
	    panel.setLayout(new BorderLayout(0, 0));
		
		//panel.add(PropertyPanel);
		//PropertyPanel.setVisible(true);
		
		
	
		addButtonFuctionalities();
		
	}
	
	
	private static void  addButtonFuctionalities(){
		
	    btnProperty.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    				
	    		panel.removeAll();
	    		panel.add(PropertyPanel);
	    		panel.revalidate();
	    		frame.repaint();
	    	}
	    });
	    
	    btnContract.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		panel.removeAll();
	    		panel.add(ContractPanel);
	    	
	    		panel.revalidate();
	    		frame.repaint();
	    		
		 	}
		 });
	    
	    btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
	    		panel.add(CustomerPanel);
	    		panel.revalidate();
	    		frame.repaint();
			}
		});
		
		
		
		
	}
	
	
	public void setVisible(boolean visible){
		frame.setVisible(visible);
	
	}
}
