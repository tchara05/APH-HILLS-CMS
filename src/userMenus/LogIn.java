package userMenus;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager.*;
import java.sql.ResultSet;

import extras.DatabaseConnection;
import extras.Messages;

public class LogIn {

	public static JFrame frmAphroditeHill;
	public static JTextField txtUserName;
	private JPasswordField txtPassword;

	// Button //
	private JButton btnLogIn;

	public static DatabaseConnection database;

	public static void main(String[] args) {

		LogIn window = new LogIn();
		LogIn.frmAphroditeHill.setVisible(true);
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
		frmAphroditeHill.getContentPane().setBackground(Color.WHITE);
		frmAphroditeHill.setTitle("Aphrodite Hill");
		frmAphroditeHill.setBackground(Color.GRAY);
		frmAphroditeHill.getContentPane().setForeground(new Color(0, 0, 0));
		database = new DatabaseConnection();
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(420, 141, 511, 407);
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 2));

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		// TextBoxes
		txtUserName = new JTextField();
		txtUserName.setBounds(222, 202, 155, 28);
		txtUserName.setColumns(10);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(222, 261, 155, 28);

		// Labels //
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(137, 266, 63, 19);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(137, 207, 67, 19);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 14));

		btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnLogIn.setBounds(137, 321, 112, 36);
		JButton btnHelp = new JButton("EXIT");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnHelp.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnHelp.setBounds(259, 321, 118, 36);
		frmAphroditeHill.getContentPane().setLayout(null);
		frmAphroditeHill.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblPassword);
		panel.add(lblUsername);
		panel.add(txtUserName);
		panel.add(txtPassword);
		panel.add(btnLogIn);
		panel.add(btnHelp);
		
				JLabel lblIcon = new JLabel(image);
				lblIcon.setBounds(166, 26, 177, 145);
				panel.add(lblIcon);
				lblIcon.setBackground(UIManager.getColor("Button.foreground"));
				lblIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
				lblIcon.setForeground(UIManager.getColor("DesktopIcon.labelBackground"));
				lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		frmAphroditeHill.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmAphroditeHill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addButtonFuctionalities();
	}

	// Buttons Fuctionalities //
	private void addButtonFuctionalities() {

		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				@SuppressWarnings("deprecation")
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
							new AdminMenu(0).setVisible(true);
						} else if (rights.equals("b")) {
							frmAphroditeHill.setVisible(false);
							new AdminMenu(1).setVisible(true);
						} else if (rights.equals("c")) {
							frmAphroditeHill.setVisible(false);
							new AdminMenu(2).setVisible(true);
						} else if (rights.equals("d")) {
							frmAphroditeHill.setVisible(false);
							new AdminMenu(3).setVisible(true);
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
	public void setVisible(boolean t) {
		frmAphroditeHill.setVisible(t);
	}

}
