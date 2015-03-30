package userMenus;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import contract.ContractMenu;

import property.PropertyMenu;

import customer.CustomerMenu;



public class SecretaryMenu {

	private JFrame frmSecretaryMenu;
	
	public static void main(String[] args) {
		
					SecretaryMenu window = new SecretaryMenu();
					window.frmSecretaryMenu.setVisible(true);
				
	}

	public SecretaryMenu() {
		initialize();

	}
	
	private void initialize() {
		frmSecretaryMenu = new JFrame();
		frmSecretaryMenu.setTitle("Secretary Menu");
		frmSecretaryMenu.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JLabel lblSecretaryMenu;
		
		frmSecretaryMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(1120, 29, 213, 210);
		lblNewLabel.setBackground(Color.BLACK);
		
		lblSecretaryMenu = new JLabel("Secretary Menu ");
		lblSecretaryMenu.setBounds(307, 50, 232, 36);
		lblSecretaryMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(307, 128, 592, 582);
		
		// Inserting the tapped //
		JPanel PropertyPanel = PropertyMenu.createPropertyMenu();
		tabbedPane.addTab("Property Menu", null, PropertyPanel, null);
		
		JPanel CustomerPanel = CustomerMenu.createCustomerMenu();
		tabbedPane.addTab("Customer Menu", null, CustomerPanel, null);
		
		JPanel ContractPanel = ContractMenu.createContractMenu();
		frmSecretaryMenu.getContentPane().setLayout(null);
		tabbedPane.addTab("Contract Menu", null, ContractPanel);
		frmSecretaryMenu.getContentPane().add(tabbedPane);
		frmSecretaryMenu.getContentPane().add(lblSecretaryMenu);
		frmSecretaryMenu.getContentPane().add(lblNewLabel);
	}
	
	public void setVisible(boolean visible){
		this.frmSecretaryMenu.setVisible(visible);
	}
	
}
