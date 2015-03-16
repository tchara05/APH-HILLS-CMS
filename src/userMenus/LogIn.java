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

import security.SecurityMen;

import extras.Checker;
import extras.DatabaseConnection;
import extras.Messages;

public class LogIn {

	private JFrame frmAphroditeHill;
	public static JTextField txtUserName;
	private JPasswordField txtPassword;
	private JFrame menu;

	// Button //
	JButton btnLogIn;
	
	public static DatabaseConnection  database;

	/**
	 * Launch the application.
	 * Just a main to test the rusult.
	 */
	public static void main(String[] args) {

					LogIn window = new LogIn();
					window.frmAphroditeHill.setVisible(true);			
	}				
				

	/**
	 * Create the application.
	 * Constructor for the window.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		frmAphroditeHill = new JFrame();
		frmAphroditeHill.setTitle("Aphrodite Hill");
		frmAphroditeHill.setBackground(Color.GRAY);
		frmAphroditeHill.getContentPane().setForeground(new Color(0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(30, 144, 255), new Color(0, 0, 0)));
		
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		
		JLabel lblIcon = new JLabel(image);
		lblIcon.setBackground(UIManager.getColor("Button.foreground"));
		lblIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblIcon.setForeground(UIManager.getColor("DesktopIcon.labelBackground"));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmAphroditeHill.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(372, Short.MAX_VALUE)
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
					.addGap(429))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(484)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(505, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(289))
		);
		
		// TextBoxes
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtPassword = new JPasswordField();
		
		
		//Labels //
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		btnLogIn = new JButton("Log In");
		JButton btnHelp = new JButton("Help");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addGap(59))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(btnHelp))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAphroditeHill.getContentPane().setLayout(groupLayout);
		frmAphroditeHill.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmAphroditeHill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addButtonFuctionalities();
	}
	
	// Buttons Fuctionalities //
	private void addButtonFuctionalities(){
	btnLogIn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String username = txtUserName.getText();
			String password = txtPassword.getText();
			String query="SELECT * FROM SystemUsers WHERE userName='"+username+"' AND passwords = '"+password+"'";
			
			try {
				ResultSet rst =null;
			
				// Concurrency //
				synchronized(database){
					rst = database.getStatement().executeQuery(query);
					System.out.println("I executed query");
				}
				
				if (rst.next()){
					 String rights = rst.getString(3);
					 if (rights.equals("a")){
						 frmAphroditeHill.setVisible(false);
						  new AdminMenu().setVisible(true);
					 }else if (rights.equals("b")){
						 frmAphroditeHill.setVisible(false);
						 new SecretaryMenu().setVisible(true);
					 }else if (rights.equals("c")){
						 frmAphroditeHill.setVisible(false);
						 new SecurityMenu().setVisible(true);
					 }else if(rights.equals("d")){
						 frmAphroditeHill.setVisible(false);
						 new AccountantMenu().setVisible(true);
					 }
			
				}else{
					
					Messages.showErrorMessage("Error Username Or Password");
			   }
			}catch(Exception p){
				p.printStackTrace();
			}
		}
	});		
	}
	
	
	public static String  getUsername(){
		
		return "marios";
		
		
		
	}
	
	
	
}
