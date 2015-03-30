package userMenus;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager.*;
import java.awt.SystemColor;
import java.sql.ResultSet;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import security.Securitymenu;

import extras.Checker;
import extras.DatabaseConnection;
import extras.Messages;

public class LogIn {

	private JFrame frmAphroditeHill;
	public static JTextField txtUserName;
	private JPasswordField txtPassword;
	private JFrame menu;

	// Button //
	private JButton btnLogIn;

	public static DatabaseConnection database;

	public static void main(String[] args) {

		LogIn window = new LogIn();
		window.frmAphroditeHill.setVisible(true);
	}

	public LogIn() {
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

		frmAphroditeHill = new JFrame();
		frmAphroditeHill.setTitle("Aphrodite Hill");
		frmAphroditeHill.setBackground(Color.GRAY);
		frmAphroditeHill.getContentPane().setForeground(new Color(0, 0, 0));
		database = new DatabaseConnection();
		JPanel panel = new JPanel();
		panel.setBounds(484, 376, 365, 213);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(30,
				144, 255), new Color(0, 0, 0)));

		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");

		JLabel lblIcon = new JLabel(image);
		lblIcon.setBounds(462, 29, 549, 312);
		lblIcon.setBackground(UIManager.getColor("Button.foreground"));
		lblIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblIcon.setForeground(UIManager.getColor("DesktopIcon.labelBackground"));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

		// TextBoxes
		txtUserName = new JTextField();
		txtUserName.setBounds(149, 45, 155, 28);
		txtUserName.setColumns(10);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(149, 91, 155, 28);

		// Labels //
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(64, 95, 63, 19);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(64, 49, 67, 19);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 15));

		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(62, 137, 112, 29);
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(186, 137, 118, 29);
		frmAphroditeHill.getContentPane().setLayout(null);
		frmAphroditeHill.getContentPane().add(lblIcon);
		frmAphroditeHill.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblPassword);
		panel.add(lblUsername);
		panel.add(txtUserName);
		panel.add(txtPassword);
		panel.add(btnLogIn);
		panel.add(btnHelp);
		frmAphroditeHill.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmAphroditeHill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addButtonFuctionalities();
	}

	// Buttons Fuctionalities //
	private void addButtonFuctionalities() {

		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				String query = "SELECT * FROM SystemUsers WHERE userName='"
						+ username + "' AND passwords = '" + password + "'";

				try {
					ResultSet rst = null;

					// Concurrency //
					synchronized (database) {
						rst = database.getStatement().executeQuery(query);
						System.out.println("I executed query");
					}

					if (rst.next()) {
						String rights = rst.getString(3);
						if (rights.equals("a")) {
							frmAphroditeHill.setVisible(false);
							new AdminMenu().setVisible(true);
						} else if (rights.equals("b")) {
							frmAphroditeHill.setVisible(false);
							new SecretaryMenu().setVisible(true);
						} else if (rights.equals("c")) {
							frmAphroditeHill.setVisible(false);
							new SecurityMenu().setVisible(true);
						} else if (rights.equals("d")) {
							frmAphroditeHill.setVisible(false);
							new AccountantMenu().setVisible(true);
						}

					} else {

						Messages.showErrorMessage("Error Username Or Password");
					}
				} catch (Exception p) {
					p.printStackTrace();
				}
			}
		});
	}

	public static String getUsername() {
		return "marios";
	}

}
