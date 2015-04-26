package customer;


import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import extras.DatabaseConnection;
import extras.Query;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
/**
 * Class that represents a window.
 * The user uses this window-form to save Customer (data) into
 * the database.
 * 
 * All types and fields are static because the form would be created 
 * one time.
 * 
 * 
 * All methods and listeners in this class
 * connect to a database to retrieve, or puts some data.
 * 
 * @author TeamD
 *
 */


public class CustomerForm {
	
	
	// Text Boxes: //
	public static JFrame frame;
	public static JTextField txtFname;
	public static JTextField txtLastName;
	public static JTextField txtAddress;
	public static JTextField txtCity;
	public static JTextField txtZipCode;
	public static JTextField txtPrimaryMail;
	public static JTextField txtSeconadaryMail;
	public static JTextField txtPhoneMobile;
	public static JTextField txtBussinesNumber;
	public static JTextField txtContactNumber;
	public static JTextField txtFaxNumber;
	public static JTextField txtID;
	
	//List for scroll //
	public static JComboBox<String> Country;
	
	// Text Area box: //
	public static JTextArea txtNote;
	
	// Check Box: //
	public static JCheckBox chckbxCloseAccound;	
	public static JCheckBox chckbxInformationMaterial;
	
	public static boolean edit = false;
	
	// Button Veriables //
	 private JButton btnSave;
	 private JButton btnClear;
	 private JButton btnBack;
	 private JLabel lblNewLabel;
	
	
	 
	 /**
		 * Main method
		 * Useful only for testing
		 *
		 * @param  Srting[]
		 */
	public static void main(String[] args) {
		
					@SuppressWarnings("unused")
					CustomerForm window = new CustomerForm();
					CustomerForm.setVisible(true);
					
	}
	
	/**
	 * Constructor of the form.
	 * The constructor calls the initialize method to 
	 * design the window-form and initialize all fields.
	 * 
	 * 
	 */
	public CustomerForm() {
		initialize();
		setUpClassesList();
		addButtonsFuctionalities();	
	}
	
	/**
	 * The initialize method creates and initialize
	 * all buttons, text fields, panels and everything 
	 * that the window needs to show. 
	 * 
	 * 
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
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "CUSTOMER FORM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 43, 402, 452);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Customer Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setForeground(Color.BLACK);
	    panel.setLayout(null);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBorder(new LineBorder(new Color(0, 0, 128)));
	    panel_4.setBackground(new Color(173, 216, 230));
	    panel_4.setBounds(26, 30, 349, 399);
	    panel.add(panel_4);
	    panel_4.setLayout(null);
	    
	    txtNote = new JTextArea();
	    txtNote.setFont(new Font("Calibri", Font.PLAIN, 14));
	    txtNote.setBounds(10, 277, 326, 111);
	    panel_4.add(txtNote);
	    txtNote.setText("Add any notes here..");
	    txtNote.setLineWrap(true);
	    
	    JLabel lblCustomerId = new JLabel("Customer ID:");
	    lblCustomerId.setBounds(10, 18, 85, 16);
	    panel_4.add(lblCustomerId);
	    lblCustomerId.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    JLabel lblFirstName = new JLabel("First Name:");
	    lblFirstName.setBounds(10, 52, 102, 16);
	    panel_4.add(lblFirstName);
	    lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    	
	    	JLabel lblLastname = new JLabel("Last Name:");
	    	lblLastname.setBounds(10, 88, 102, 16);
	    	panel_4.add(lblLastname);
	    	lblLastname.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	
	    	JLabel lblAddress = new JLabel("Address:");
	    	lblAddress.setBounds(10, 127, 102, 16);
	    	panel_4.add(lblAddress);
	    	lblAddress.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	
	    	JLabel lblCity = new JLabel("City:");
	    	lblCity.setBounds(10, 166, 85, 16);
	    	panel_4.add(lblCity);
	    	lblCity.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	
	    	JLabel lblZipPosta = new JLabel("Zip Code:");
	    	lblZipPosta.setBounds(10, 205, 85, 16);
	    	panel_4.add(lblZipPosta);
	    	lblZipPosta.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	
	    	
	    	JLabel lblCountry = new JLabel("Country:");
	    	lblCountry.setBounds(10, 245, 85, 16);
	    	panel_4.add(lblCountry);
	    	lblCountry.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	
	    	txtID = new JTextField();
	    	txtID.setEnabled(false);
	    	txtID.setBounds(105, 11, 231, 28);
	    	panel_4.add(txtID);
	    	txtID.setColumns(10);
	    	
	    	txtFname = new JTextField();
	    	txtFname.setBounds(105, 45, 231, 28);
	    	panel_4.add(txtFname);
	    	txtFname.setColumns(10);
	    	
	    	txtLastName = new JTextField();
	    	txtLastName.setBounds(105, 81, 231, 28);
	    	panel_4.add(txtLastName);
	    	txtLastName.setColumns(10);
	    	
	    	txtAddress = new JTextField();
	    	txtAddress.setBounds(105, 120, 231, 28);
	    	panel_4.add(txtAddress);
	    	txtAddress.setColumns(10);
	    	
	    	txtCity = new JTextField();
	    	txtCity.setBounds(105, 159, 231, 28);
	    	panel_4.add(txtCity);
	    	txtCity.setColumns(10);
	    	
	    	txtZipCode = new JTextField();
	    	txtZipCode.setBounds(105, 198, 231, 28);
	    	panel_4.add(txtZipCode);
	    	txtZipCode.setColumns(10);
	    	
	    	Country = new JComboBox<String>();
	    	Country.setFont(new Font("Calibri", Font.PLAIN, 14));
	    	Country.setBounds(105, 238, 231, 28);
	    	panel_4.add(Country);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
	    panel_1.setBounds(494, 43, 445, 452);
	    panel_2.add(panel_1);
	    panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Customer Contact Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_5.setBackground(new Color(173, 216, 230));
		panel_5.setBounds(23, 30, 394, 397);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		chckbxInformationMaterial = new JCheckBox("Information Material");
		chckbxInformationMaterial.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxInformationMaterial.setBackground(new Color(173, 216, 230));
		chckbxInformationMaterial.setBounds(20, 328, 153, 23);
		panel_5.add(chckbxInformationMaterial);
		
		chckbxCloseAccound = new JCheckBox("Close Accound");
		chckbxCloseAccound.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxCloseAccound.setBackground(new Color(173, 216, 230));
		chckbxCloseAccound.setBounds(20, 289, 153, 23);
		panel_5.add(chckbxCloseAccound);
		
		txtSeconadaryMail = new JTextField();
		txtSeconadaryMail.setBounds(165, 52, 216, 30);
		panel_5.add(txtSeconadaryMail);
		txtSeconadaryMail.setColumns(10);
		
		txtPhoneMobile = new JTextField();
		txtPhoneMobile.setBounds(165, 93, 216, 30);
		panel_5.add(txtPhoneMobile);
		txtPhoneMobile.setColumns(10);
		
		txtBussinesNumber = new JTextField();
		txtBussinesNumber.setBounds(165, 134, 216, 30);
		panel_5.add(txtBussinesNumber);
		txtBussinesNumber.setColumns(10);
		
		txtContactNumber = new JTextField();
		txtContactNumber.setBounds(165, 175, 216, 30);
		panel_5.add(txtContactNumber);
		txtContactNumber.setColumns(10);
		
		txtFaxNumber = new JTextField();
		txtFaxNumber.setBounds(165, 216, 216, 30);
		panel_5.add(txtFaxNumber);
		txtFaxNumber.setColumns(10);
		
		txtPrimaryMail = new JTextField();
		txtPrimaryMail.setBounds(165, 11, 216, 30);
		panel_5.add(txtPrimaryMail);
		txtPrimaryMail.setColumns(10);
		
		JLabel lblSecondaryEmail = new JLabel("Secondary Email:");
		lblSecondaryEmail.setBounds(20, 61, 123, 14);
		panel_5.add(lblSecondaryEmail);
		lblSecondaryEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblFaxNumber = new JLabel("Fax Number:");
		lblFaxNumber.setBounds(20, 225, 107, 14);
		panel_5.add(lblFaxNumber);
		lblFaxNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblContactPhoneNumber = new JLabel("Contact Phone Number:");
		lblContactPhoneNumber.setBounds(20, 184, 153, 14);
		panel_5.add(lblContactPhoneNumber);
		lblContactPhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblBussinesPhoneNumber = new JLabel("Bussines Phone Number:");
		lblBussinesPhoneNumber.setBounds(20, 143, 181, 14);
		panel_5.add(lblBussinesPhoneNumber);
		lblBussinesPhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblMobilePhoneNumber = new JLabel("Mobile Phone Number:");
		lblMobilePhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMobilePhoneNumber.setBounds(20, 101, 153, 14);
		panel_5.add(lblMobilePhoneNumber);
		
		JLabel lblPrimaryEmail = new JLabel("Primary Email:");
		lblPrimaryEmail.setBounds(20, 20, 107, 14);
		panel_5.add(lblPrimaryEmail);
		lblPrimaryEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_6.setBackground(new Color(211, 211, 211));
		panel_6.setBounds(1008, 43, 183, 452);
		panel_2.add(panel_6);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(21, 296, 149, 33);
		panel_6.add(btnSave);
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(21, 340, 149, 33);
		panel_6.add(btnClear);
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(21, 382, 149, 33);
		panel_6.add(btnBack);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(21, 75, 152, 147);
		panel_6.add(lblNewLabel);
		
		
		frame.getContentPane().setLayout(groupLayout);
	
	}
	/**
	 * This method creates retrieve from Database
	 * the customer ID and increases by 1
	 * Or if  Database is empty start with 1
	 * 
	 * 
	 */
	public static void setID() {
		ResultSet rs = null;
		DatabaseConnection database=null; 
		try {
			database = new DatabaseConnection();
			rs = database.getStatement().executeQuery("SELECT MAX(customerID)  FROM Customer");

			if (rs.next()) {
				if (rs.getString(1) != null) {
					txtID.setText("" + (rs.getInt(1) + 1));
				} else {
					txtID.setText("1");
				}
			} else {
				txtID.setText("1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			database.closeDatabaseConnection();
		}

	}
	
	/**
	 * This is a method that hide and show the window-form
	 * 
	 * 
	 * @param val boolean
	 */
	public static void setVisible(boolean val){
		frame.setVisible(val);	
	}
	
	/**
	 * This method creates list of country.
	 * Retrieve from Database country and 
	 * show on the list.
	 * 
	 * 
	 */
	private static void setUpClassesList(){
		DatabaseConnection database=null; 
		try{
			database = new DatabaseConnection();
			ResultSet rs = database.getStatement().executeQuery(Query.COUNTRY);	
			while (rs.next()){
				Country.addItem(rs.getString(2));
			}
		}catch (Exception e){
			e.printStackTrace();
			
		}finally{
			database.closeDatabaseConnection();
		}
		
	}
	
	
	/**
	 * This method  manage the buttons and 
	 * their actions
	 * 
	 * 
	 */
	private void addButtonsFuctionalities(){
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerClearButton.start();
				setVisible(false);
			}
		});
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerClearButton.start();
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 	new CustomerSaveButton().start();
			}
		});
	}
}
