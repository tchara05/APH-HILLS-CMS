package Forms;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.util.ArrayList;
import java.util.Arrays;



import java.awt.Label;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainForm implements Runnable {

	private static JFrame LoginFrame;
	private JTextField username;
	private JPasswordField password;
	private static String PermissionCategory;
	
	private static ArrayList<Customer> Customers = new ArrayList<Customer>();
	private static ArrayList<Property> Property = new ArrayList<Property>();
	private static ArrayList<Contract> Contract=new ArrayList<Contract>();

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		
		//Program Starts
		MainForm main = new MainForm();
		
		//AdminMenu
		AdminMenuForm  AdmMenu= new AdminMenuForm(main.getUserName(), main.getPassword().toString());
		
		//Contract Form
		ContractForm contractForm = new ContractForm();
		
		//CustomerForm
		CustomerForm custForm = new CustomerForm();
		
		//Property Form
		PropertyForm prtyForm = new PropertyForm();
		//Manage Customer Form 
		ManageCustForm mngCust = new ManageCustForm();
		//Manage Property Form
		ManagePropertyForm mngPro = new ManagePropertyForm();
		
		
		AdmMenu.setActor(PermissionCategory);
		
		
		mngCust.setVisible(false);
		prtyForm.setVisible(false);
		AdmMenu.setVisible(false);
		main.setVisible(true);
		mngPro.setVisible(false);
		contractForm.setVisible(false);
		custForm.setVisible(false);
		
		

	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	

	// check pass
	final boolean isPasswordCorrect_admin(char[] pass) {
		boolean isCorrect = true;
		char[] correctPassword = { 'a', 'd', 'm', 'i', 'n', 'a', 'h' };

		if (pass.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(pass, correctPassword);
		}

		return isCorrect;
	}

	final boolean isPasswordCorrect_accountant(char[] pass) {
		boolean isCorrect = true;
		char[] correctPassword = { 'a', 'c', 'c', 'o', 'u', 'n', 't', 'a', 'n',
				't', 'a', 'h' };

		if (pass.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(pass, correctPassword);
		}

		return isCorrect;
	}

	final boolean isPasswordCorrect_secretary(char[] pass) {
		boolean isCorrect = true;
		char[] correctPassword = { 's', 'e', 'c', 'r', 'e', 't', 'a', 'r', 'y',
				'a', 'h' };

		if (pass.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(pass, correctPassword);
		}

		return isCorrect;
	}

	final boolean isPasswordCorrect_security(char[] pass) {
		boolean isCorrect = true;
		char[] correctPassword = { 's', 'e', 'c', 'u', 'r', 'i', 't', 'y', 'a',
				'h' };

		if (pass.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(pass, correctPassword);
		}

		return isCorrect;
	}

	final boolean isUsernameCorrect_admin(String user) {
		boolean isCorrect = true;
		String correctUser = "admin";

		if (user.length() != correctUser.length())
			isCorrect = false;
		else
			isCorrect = user.equals(correctUser);

		return isCorrect;
	}

	final boolean isUsernameCorrect_security(String user) {
		boolean isCorrect = true;
		String correctUser = "secur";

		if (user.length() != correctUser.length())
			isCorrect = false;
		else
			isCorrect = user.equals(correctUser);

		return isCorrect;
	}

	final boolean isUsernameCorrect_secretary(String user) {
		boolean isCorrect = true;
		String correctUser = "secre";

		if (user.length() != correctUser.length())
			isCorrect = false;
		else
			isCorrect = user.equals(correctUser);

		return isCorrect;
	}

	final boolean isUsernameCorrect_accountant(String user) {
		boolean isCorrect = true;
		String correctUser = "accoun";

		if (user.length() != correctUser.length())
			isCorrect = false;
		else
			isCorrect = user.equals(correctUser);

		return isCorrect;
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		LoginFrame = new JFrame();
		LoginFrame.setBounds(100, 100, 379, 320);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.getContentPane().setLayout(null);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));
		
		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(35, 11, 117, 74);
		LoginFrame.getContentPane().add(lblNewLabel);

		Label label = new Label("LOG IN TASK");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(167, 30, 133, 33);
		LoginFrame.getContentPane().add(label);

		Label label_1 = new Label("USERNAME:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(53, 122, 83, 22);
		LoginFrame.getContentPane().add(label_1);

		Label label_2 = new Label("PASSWORD:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(53, 150, 89, 22);
		LoginFrame.getContentPane().add(label_2);

		username = new JTextField();
		username.setBounds(167, 122, 133, 20);
		LoginFrame.getContentPane().add(username);
		username.setColumns(10);

		final JComboBox Actors = new JComboBox();
		Actors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int permision = Actors.getSelectedIndex();
				if (permision == 0){
					PermissionCategory = "Admin";
					
				}else if (permision ==1 ){
					PermissionCategory = "Secretary";
				}else if (permision == 2){
					PermissionCategory = "Accountant";
				}else {
					PermissionCategory = "Security";
				}
			
			
			}
		});
		Actors.setModel(new DefaultComboBoxModel(new String[] { "Admin",
				"Secretary", "Accountant", "Security" }));
		Actors.setSelectedIndex(1);
		Actors.setBounds(167, 91, 133, 20);
		LoginFrame.getContentPane().add(Actors);

		final JButton login = new JButton("LOGIN");
		login.setEnabled(false);
		// enable-disable button
		username.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				
				
				
				
				
				if (username.getText().equals("")) {
					login.setEnabled(false);
				} else {
					login.setEnabled(true);
				}
			}
		});

		login.setFont(new Font("Tahoma", Font.PLAIN, 12));

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String type = null;
				String usern = username.getText();
				char[] input = password.getPassword();

				if (input.length == 0)
					JOptionPane.showMessageDialog(null, "Password is missing",
							"Warning", JOptionPane.WARNING_MESSAGE);

				Object typelogin = Actors.getSelectedItem();
				if (typelogin.toString().equals("Admin"))
					type = "admin";
				else if (typelogin.toString().equals("Secretary"))
					type = "secre";
				else if (typelogin.toString().equals("Accountant"))
					type = "accoun";
				else if (typelogin.toString().equals("Security"))
					type = "secur";

				if (type.equals("admin")) {
					if (isUsernameCorrect_admin(usern)
							&& isPasswordCorrect_admin(input)) {
						LoginFrame.setVisible(false);
						AdminMenuForm.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,
								"Username or Password is wrong", "WARNING",
								JOptionPane.WARNING_MESSAGE);
				} else if (type.equals("secre")) {
					if (isUsernameCorrect_secretary(usern)
							&& isPasswordCorrect_secretary(input)) {
						LoginFrame.setVisible(false);
						AdminMenuForm.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,
								"Username or Password is wrong", "WARNING",
								JOptionPane.WARNING_MESSAGE);
				} else if (type.equals("accoun")) {
					if (isUsernameCorrect_accountant(usern)
							&& isPasswordCorrect_accountant(input)) {
						LoginFrame.setVisible(false);
						AdminMenuForm.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,
								"Username or Password is wrong", "WARNING",
								JOptionPane.WARNING_MESSAGE);
				} else if (type.equals("secur")) {
					if (isUsernameCorrect_security(usern)
							&& isPasswordCorrect_security(input)) {
						LoginFrame.setVisible(false);
						AdminMenuForm.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,
								"Username or Password is wrong", "WARNING",
								JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		login.setBounds(211, 183, 89, 23);
		LoginFrame.getContentPane().add(login);

		final JButton help = new JButton("HELP");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
								"1. Choose your login type from the combo box \n2. Type your username \n3. Type your password \n4. Then, Click LOG IN",
								"HELP", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		help.setFont(new Font("Tahoma", Font.PLAIN, 12));
		help.setBounds(211, 217, 89, 23);
		LoginFrame.getContentPane().add(help);

		password = new JPasswordField();
		password.setBounds(167, 152, 133, 20);
		LoginFrame.getContentPane().add(password);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame.setVisible(false);
				LoginFrame.dispose();
			}
		});
		btnExit.setBounds(53, 218, 89, 23);
		LoginFrame.getContentPane().add(btnExit);
	}

	
	

	
	
	public String getUserName(){
		return username.getText();
	}
	
	public char[] getPassword(){
		return password.getPassword();
	}
	
	 public static void  setVisible(boolean f){
		LoginFrame.setVisible(f);
	}
	
	 public static ArrayList<Customer> getCustomers(){
		 return Customers;
	 }
	 
	 public static ArrayList<Property> getProperties(){
		 return Property;
	 }
	
	 public static ArrayList<Contract> getContracts(){
		 return Contract;
	 }
	@Override
	public void run() {
		LoginFrame.setVisible(true);
	
		
	}
}
