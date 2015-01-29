package UserMenus;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Customer.CustomerMenu;
import Property.PropertyMenu;


public class SecretaryMenu {

	private JFrame frmSecretaryMenu;
	

	

	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SecretaryMenu window = new SecretaryMenu();
					window.frmSecretaryMenu.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public SecretaryMenu() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecretaryMenu = new JFrame();
		frmSecretaryMenu.setTitle("Secretary Menu");
		frmSecretaryMenu.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		
		
		JLabel lblSecretaryMenu;
		
		frmSecretaryMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBackground(Color.BLACK);
		
		lblSecretaryMenu = new JLabel("Secretary Menu ");
		lblSecretaryMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmSecretaryMenu.getContentPane());
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
		
		JPanel ContractPanel = new JPanel();
		tabbedPane.addTab("Contract Menu", null, ContractPanel, null);
		
		JPanel PropertyPanel = PropertyMenu.createPropertyMenu();
		tabbedPane.addTab("Property Menu", null, PropertyPanel, null);
		
		JPanel CustomerPanel = CustomerMenu.createCustumerMenu();
		tabbedPane.addTab("Customer Menu", null, CustomerPanel, null);
		
		
		
		frmSecretaryMenu.getContentPane().setLayout(groupLayout);
		
		
		
		
	}
}
