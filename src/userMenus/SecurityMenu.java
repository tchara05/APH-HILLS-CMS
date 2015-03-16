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

import property.PropertyForm;
import property.PropertyMenu;
import security.SecurityForm;
import security.SecurityMen;
import contract.ContractMenu;
import customer.CustomerMenu;

public class SecurityMenu {

	private JFrame frmSecurityMenu;
	@SuppressWarnings("unused")
	
	
	
	
	public static void main(String[] args) {
		
					SecurityMenu window = new SecurityMenu();
					window.frmSecurityMenu.setVisible(true);
	}


	public SecurityMenu() {
		initialize();
	}

	private void initialize() {
		frmSecurityMenu = new JFrame();
		frmSecurityMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecurityMenu.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JLabel lblSecretaryMenu;
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBackground(Color.BLACK);
		
		lblSecretaryMenu = new JLabel("SecurityMenu ");
		lblSecretaryMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout groupLayout = new GroupLayout(frmSecurityMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(307)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecretaryMenu))
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
							.addComponent(lblSecretaryMenu)
							.addGap(42)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		
		// Inserting the tapped //
		JPanel SecurityPanel = SecurityMen.createSecurityMenu();
		tabbedPane.addTab("Security Menu", null, SecurityPanel);
		
		
		frmSecurityMenu.getContentPane().setLayout(groupLayout);
	}
	
	
	public void setVisible(boolean val){
		this.frmSecurityMenu.setVisible(val);
	}

}
