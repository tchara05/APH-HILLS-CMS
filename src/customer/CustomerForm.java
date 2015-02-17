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
import java.sql.Statement;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import userMenus.LogIn;

import extras.Checker;
import extras.DatabaseConnection;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class CustomerForm {
	// Graphical Variables  Data //
	private static JFrame frame;
	private static JTextField txtFname;
	private static JTextField txtLastName;
	private static JTextField txtAddress;
	private static JTextField txtCity;
	private static JTextField txtZipCode;
	private static JTextField txtPrimaryMail;
	private static JTextField txtSeconadaryMail;
	private static JTextField txtPhoneMobile;
	private static JTextField txtBussinesNumber;
	private static JTextField ContactNumber;
	private static JTextField FaxNumber;
	private static JTextField txtID;
	private static JComboBox<String> Country;
	private static JTextArea txtNote;
	private static JCheckBox chckbxCloseAccound;	
	private static JCheckBox chckbxInformationMaterial;
	
	public static boolean edit = false;


	
	//Remove when finished //
	 static DatabaseConnection 	database= new DatabaseConnection();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					CustomerForm window = new CustomerForm();
					CustomerForm.setVisible(true);
					
	}

	/**
	 * Create the application.
	 */
	public CustomerForm() {
		initialize();
		
		
		try{
			
			/** Remove in the finish **/	
			database= new DatabaseConnection();
			ResultSet rst =null;
			Statement st = database.getStatement(); 	
			
				
			/*************************/	
			
			//	Statement st = LogIn.database.getStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT countryName FROM Country");	
			
			
			while (rs.next()){
				Country.addItem(rs.getString(1));
			}
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
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
		
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblImage = new JLabel(image);
		lblImage.setText("image");
		lblImage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Customer Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 959, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(42, 43, 402, 452);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Customer Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(Color.GRAY);
	    panel.setLayout(null);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	    panel_4.setBackground(Color.LIGHT_GRAY);
	    panel_4.setBounds(26, 30, 349, 399);
	    panel.add(panel_4);
	    panel_4.setLayout(null);
	    
	    txtNote = new JTextArea();
	    txtNote.setBounds(10, 277, 326, 111);
	    panel_4.add(txtNote);
	    txtNote.setText("Add any notes here..");
	    txtNote.setLineWrap(true);
	    
	    JLabel lblCustomerId = new JLabel("Customer ID:");
	    lblCustomerId.setBounds(10, 18, 69, 16);
	    panel_4.add(lblCustomerId);
	    lblCustomerId.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    JLabel lblFirstName = new JLabel("First Name:");
	    lblFirstName.setBounds(10, 52, 62, 16);
	    panel_4.add(lblFirstName);
	    lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    	
	    	JLabel lblLastname = new JLabel("Last Name:");
	    	lblLastname.setBounds(10, 88, 60, 16);
	    	panel_4.add(lblLastname);
	    	lblLastname.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	
	    	JLabel lblAddress = new JLabel("Address:");
	    	lblAddress.setBounds(13, 127, 47, 16);
	    	panel_4.add(lblAddress);
	    	lblAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	
	    	JLabel lblCity = new JLabel("City:");
	    	lblCity.setBounds(10, 166, 22, 16);
	    	panel_4.add(lblCity);
	    	lblCity.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	
	    	JLabel lblZipPosta = new JLabel("Zip Code:");
	    	lblZipPosta.setBounds(10, 205, 50, 16);
	    	panel_4.add(lblZipPosta);
	    	lblZipPosta.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	
	    	
	    	JLabel lblCountry = new JLabel("Country:");
	    	lblCountry.setBounds(10, 245, 43, 16);
	    	panel_4.add(lblCountry);
	    	lblCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	
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
	    	Country.setBounds(105, 238, 231, 28);
	    	panel_4.add(Country);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBounds(476, 43, 445, 452);
	    panel_2.add(panel_1);
	    panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Customer Contact Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(23, 30, 394, 397);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		chckbxInformationMaterial = new JCheckBox("Information Material");
		chckbxInformationMaterial.setBounds(20, 328, 153, 23);
		panel_5.add(chckbxInformationMaterial);
		
		chckbxCloseAccound = new JCheckBox("Close Accound");
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
		
		ContactNumber = new JTextField();
		ContactNumber.setBounds(165, 175, 216, 30);
		panel_5.add(ContactNumber);
		ContactNumber.setColumns(10);
		
		FaxNumber = new JTextField();
		FaxNumber.setBounds(165, 216, 216, 30);
		panel_5.add(FaxNumber);
		FaxNumber.setColumns(10);
		
		txtPrimaryMail = new JTextField();
		txtPrimaryMail.setBounds(165, 11, 216, 30);
		panel_5.add(txtPrimaryMail);
		txtPrimaryMail.setColumns(10);
		
		JLabel lblSecondaryEmail = new JLabel("Secondary Email:");
		lblSecondaryEmail.setBounds(20, 61, 123, 14);
		panel_5.add(lblSecondaryEmail);
		lblSecondaryEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel lblFaxNumber = new JLabel("Fax Number:");
		lblFaxNumber.setBounds(20, 225, 107, 14);
		panel_5.add(lblFaxNumber);
		lblFaxNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel lblContactPhoneNumber = new JLabel("Contact Phone Number:");
		lblContactPhoneNumber.setBounds(20, 184, 153, 14);
		panel_5.add(lblContactPhoneNumber);
		lblContactPhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel lblBussinesPhoneNumber = new JLabel("Bussines Phone Number:");
		lblBussinesPhoneNumber.setBounds(20, 143, 181, 14);
		panel_5.add(lblBussinesPhoneNumber);
		lblBussinesPhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel lblMobilePhoneNumber = new JLabel("Mobile Phone Number:");
		lblMobilePhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMobilePhoneNumber.setBounds(20, 101, 153, 14);
		panel_5.add(lblMobilePhoneNumber);
		
		JLabel lblPrimaryEmail = new JLabel("Primary Email:");
		lblPrimaryEmail.setBounds(20, 20, 107, 14);
		panel_5.add(lblPrimaryEmail);
		lblPrimaryEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_3.setForeground(Color.WHITE);
		panel_3.setBounds(42, 526, 879, 66);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSave.setBounds(22, 20, 104, 30);
		panel_3.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnClear.setBounds(149, 20, 109, 30);
		panel_3.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBack.setBounds(283, 21, 110, 29);
		panel_3.add(btnBack);
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
		frame.getContentPane().setLayout(groupLayout);
	
	}
	
	
	/* All setters for global variables */
	public static void setFname(String val){
		txtFname.setText(val);
	
	}
	
	public static void setLastName(String val){
		txtLastName.setText(val);
	}
	
	public static void setAddress(String val){
		txtAddress.setText(val);
	}
	
	public static void setCity(String val){
	 txtCity.setText(val);
	}
	
	public static void setZipCode(String val){
		txtZipCode.setText(val);
	}
	
	public static void setPrimaryMail(String val){
		txtPrimaryMail.setText(val);
	}
	public static void setSecondaryMail(String val){
		txtSeconadaryMail.setText(val);
	}
	
	
	public static void setPhoneMobile(String val){
		txtPhoneMobile.setText(val);
	}
	
	
	public static void setBussinesNumber(String val){
		txtBussinesNumber.setText(val);
	}
	
	
	public static void setContactNumber(String val){
		ContactNumber.setText(val);
	}
	
	public static void setFaxNumber(String val){
		FaxNumber.setText(val);
	}
	
	public static void setID() {

		// Statement st = LogIn.database.getStatement();

		// Remove later //
		Statement st = database.getStatement();
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT MAX(customerID)  FROM Customer");

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void setIDbyEdit(String val){
		txtID.setText(val);
	}
	
	
	public static void setNote(String val){
		txtNote.setText(val);
	}
	
	public static void setCloseAccound(boolean val){
		chckbxCloseAccound.setSelected(val);	
	}
	
	public static void setInformationMaterial(boolean val){
			chckbxInformationMaterial.setSelected(val);
	}
	
	/*All getters for the global variable */
	
	
	public static String getFname(){
		return txtFname.getText();
	
	}
	
	public static String getLastName(){
		return txtLastName.getText();
	}
	
	public static String getAddress(){
		return txtAddress.getText();
	}
	
	public static String getCity(){
		return txtCity.getText();
	}
	
	public static String getZipCode(){
		return txtZipCode.getText();
	}
	
	public static String getPrimaryMail(){
		return txtPrimaryMail.getText();
	}
	public static String getSecondaryMail(){
		return txtSeconadaryMail.getText();
	}
	
	
	public static String getPhoneMobile(){
		return txtPhoneMobile.getText();
	}
	
	
	public static String getBussinesNumber(){
		return txtBussinesNumber.getText();
	}
	
	
	public static String getContactNumber(){
		return ContactNumber.getText();
	}
	
	public static String getFaxNumber(){
		return FaxNumber.getText();
	}
	
	public static String getID(){
		return txtID.getText();
	}
	
	
	public static String getNote(){
		return txtNote.getText();
	}
	
	public static boolean getCloseAccound(){
		return chckbxCloseAccound.isSelected();	
	}
	
	public static boolean getInformationMaterial(){
		return	chckbxInformationMaterial.isSelected();
	}
	
	public static String getCountry(){
		return Country.getSelectedItem() + "";
	}
	
	public static void setVisible(boolean val){
		frame.setVisible(val);	
	}
}
