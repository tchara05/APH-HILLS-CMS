package userMenus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import admin.mainAdminPanel;
import contract.ContractMenu;
import property.PropertyMenu;
import security.Securitymenu;
import customer.CustomerMenu;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import logistics.accountantPanel;

/**
 * 
 * This is the main class of the program. In this class we have
 * the panels of the users. We have the administrator, the security,
 * the property, the customer, the contract, the billing panels which
 * are appear depends of your log in user name. 
 * 
 * @author TeamD
 * 
 */

public class AdminMenu {

	private static JFrame frame;

	// Buttons //
	private static JButton btnProperty;
	private static JButton btnContract;
	private static JButton btnCustomer;
	private static JButton btnSecurity;
	private static JButton btnAccount;
	private static JButton btnDatabase;

	// Admins Panels //
	private static JPanel ContractPanel;
	private static JPanel PropertyPanel;
	private static JPanel CustomerPanel;
	private static JPanel SecurityPanel;
	private static JPanel AccountantPanel;
	private static JPanel MaintancePanel;

	// Central Panel
	private static JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		AdminMenu window = new AdminMenu(0);
		frame.setVisible(true);
	}

	public AdminMenu(int menu) {
		initialize(menu);
	}

	private void initialize(int menu) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// All Menu Panels //
		
		PropertyPanel = PropertyMenu.createPropertyMenu();
		CustomerPanel = CustomerMenu.createCustomerMenu();
		SecurityPanel = Securitymenu.createSecurityMenu();
		MaintancePanel = mainAdminPanel.createAdminMenu();
		AccountantPanel = accountantPanel.createAccountantMenu();
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(392, 107, 839, 520);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 0), 2), "ADMINISTRATOR MENU",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
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
		btnProperty.setBounds(43, 170, 127, 31);
		// panel_2.add(btnProperty);

		btnContract = new JButton("Contract Menu");
		btnContract.setForeground(new Color(0, 0, 128));
		btnContract.setBackground(Color.WHITE);
		btnContract.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnContract.setBounds(43, 254, 127, 31);

		btnCustomer = new JButton("Customer Menu");
		btnCustomer.setForeground(new Color(0, 0, 128));
		btnCustomer.setBackground(Color.WHITE);
		btnCustomer.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnCustomer.setBounds(43, 212, 127, 31);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(24, 26, 167, 133);
		panel_2.add(imgLabel);

		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LogIn().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(43, 437, 127, 31);
		panel_2.add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnExit.setBounds(43, 479, 127, 31);
		panel_2.add(btnExit);

		btnDatabase = new JButton("Database");
		btnDatabase.setBackground(new Color(255, 255, 255));
		btnDatabase.setForeground(new Color(0, 0, 128));
		btnDatabase.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnDatabase.setBounds(43, 380, 127, 31);

		btnSecurity = new JButton("Security Menu");
		btnSecurity.setForeground(new Color(0, 0, 128));
		btnSecurity.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSecurity.setBackground(Color.WHITE);
		btnSecurity.setBounds(43, 296, 127, 31);

		btnAccount = new JButton("Logistic Menu");

		btnAccount.setForeground(new Color(0, 0, 128));
		btnAccount.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAccount.setBackground(Color.WHITE);
		btnAccount.setBounds(43, 338, 127, 31);

		
		if (menu == 0) {
			panel_2.add(btnProperty);
			panel_2.add(btnContract);
			panel_2.add(btnCustomer);
			panel_2.add(btnSecurity);
			panel_2.add(btnAccount);
			panel_2.add(btnDatabase);
		} else if (menu == 1) {
			panel_2.add(btnProperty);
			panel_2.add(btnContract);
			panel_2.add(btnCustomer);
		} else if (menu == 2) {
			panel.add(SecurityPanel);
		} else if (menu == 3) {
			panel.add(AccountantPanel);
		}

		addButtonFuctionalities();

	}

	private static void addButtonFuctionalities() {

		btnProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel.removeAll();
				panel.add(PropertyPanel);
				panel.revalidate();
				frame.repaint();
			}
		});
		btnDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(MaintancePanel);
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

		btnSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(SecurityPanel);
				panel.revalidate();
				frame.repaint();
			}
		});

		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(AccountantPanel);
				panel.revalidate();
				frame.repaint();
			}
		});

	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}
}
