package userMenus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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

public class AdminMenu {

	private JFrame frame;

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
		lblNewLabel.setBackground(Color.BLACK);
		
		lblAdminMenu = new JLabel("Adminstrator Menu ");
		lblAdminMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(307)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdminMenu))
					.addGap(221)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblAdminMenu)
							.addGap(42)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		// All Menu Panels //
		JPanel ContractPanel = ContractMenu.createContractMenu();
		tabbedPane.addTab("Contract Menu", null, ContractPanel, null);
		
		JPanel PropertyPanel = PropertyMenu.createPropertyMenu();
		tabbedPane.addTab("Property Menu", null, PropertyPanel, null);
		
		JPanel CustomerPanel = CustomerMenu.createCustomerMenu();
		tabbedPane.addTab("Customer Menu", null, CustomerPanel, null);
		
/*		JPanel accountMenu = accountantPanel.createAccountantMenu();
		tabbedPane.addTab("Accountant Menu", null, accountMenu, null);
		
		JPanel SecurityMenu = Securitymenu.createSecurityMenu();
		tabbedPane.addTab("Security Menu", null, SecurityMenu,null);
		
		JPanel AdminPanel = mainAdminPanel.createAdminMenu();
		tabbedPane.addTab("Admin Menu", null, AdminPanel, null);
	*/	
		frame.getContentPane().setLayout(groupLayout);
	}
	public void setVisible(boolean visible){
		frame.setVisible(visible);
	
	}

}
