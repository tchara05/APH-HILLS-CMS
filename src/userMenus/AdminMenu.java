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
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// All Menu Panels //	
		ContractPanel = ContractMenu.createContractMenu();
		PropertyPanel = PropertyMenu.createPropertyMenu();
		CustomerPanel = CustomerMenu.createCustomerMenu();
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(402, 118, 821, 498);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "ADMINISTRATOR MENU", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 41, 1250, 649);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_2.setBounds(64, 65, 215, 521);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		// Set Buttons //
	    btnProperty = new JButton("Property Menu");
	    btnProperty.setForeground(new Color(0, 0, 128));
	    btnProperty.setBackground(Color.WHITE);
	    btnProperty.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnProperty.setBounds(43, 197, 127, 31);
	    panel_2.add(btnProperty);
	    btnContract = new JButton("Contract Menu");
	    btnContract.setForeground(new Color(0, 0, 128));
	    btnContract.setBackground(Color.WHITE);
	    btnContract.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnContract.setBounds(43, 295, 127, 31);
	    panel_2.add(btnContract);
	    btnCustomer = new JButton("Customer Menu");
	    btnCustomer.setForeground(new Color(0, 0, 128));
	    btnCustomer.setBackground(Color.WHITE);
	    btnCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnCustomer.setBounds(43, 246, 127, 31);
	    panel_2.add(btnCustomer);
	    
	    JLabel imgLabel = new JLabel(image);
	    imgLabel.setBounds(24, 26, 167, 133);
	    panel_2.add(imgLabel);
	    
	    JButton btnNewButton = new JButton("Log Out");
	    btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnNewButton.setBounds(43, 413, 127, 31);
	    panel_2.add(btnNewButton);
	    
	    JButton btnExit = new JButton("Exit");
	    btnExit.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnExit.setBounds(43, 463, 127, 31);
	    panel_2.add(btnExit);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBorder(new LineBorder(new Color(0, 0, 128), 2));
	    panel_3.setBackground(new Color(173, 216, 230));
	    panel_3.setBounds(341, 65, 843, 521);
	    panel_1.add(panel_3);
	    panel_3.setLayout(null);
		
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
