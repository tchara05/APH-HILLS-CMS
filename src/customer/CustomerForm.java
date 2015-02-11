package customer;


import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import propertyFormButtons.CustomerClearButton;
import propertyFormButtons.Checker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerForm {

	private JFrame frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					CustomerForm window = new CustomerForm();
					window.frame.setVisible(true);
					
	}

	/**
	 * Create the application.
	 */
	public CustomerForm() {
		initialize();
		File fp = new File("Countries.txt");
		
		try{
			Scanner read = new Scanner(fp);
			while (read.hasNext() ){
				
				String cntr = read.nextLine();
				Country.addItem(cntr);	
				
			}
			read.close();
		}catch (Exception e){
			System.out.println("File Not Found!");
			
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblImage = new JLabel(image);
		lblImage.setText("image");
		lblImage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		JLabel lblCustomerForm = new JLabel("Customer Form:");
		lblCustomerForm.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setForeground(Color.GRAY);
		
		JLabel lblCustomerInformation = new JLabel("Customer Information:");
		lblCustomerInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblCustomerContactDetails = new JLabel("Customer Contact Details:");
		lblCustomerContactDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new CustomerClearButton().start();
				setVisible(false);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//boolean t=Checker.checkString(txtFname);
				if (!Checker.checkString(txtFname )){
					System.out.print("dfjsanfasfniasjfoiaLA8");
				}
				
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					new CustomerClearButton().start();
			
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCustomerForm)
								.addComponent(lblCustomerInformation)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCustomerContactDetails)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(83))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(lblCustomerForm)
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerInformation)
								.addComponent(lblCustomerContactDetails))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave)
						.addComponent(btnClear))
					.addGap(167))
		);
		
		JLabel lblPrimaryEmail = new JLabel("Primary Email:");
		
		txtPrimaryMail = new JTextField();
		txtPrimaryMail.setColumns(10);
		
		JLabel lblSecondaryEmail = new JLabel("Secondary Email:");
		
		txtSeconadaryMail = new JTextField();
		txtSeconadaryMail.setColumns(10);
		
		JLabel lblMobilePhoneNumber = new JLabel("Mobile Phone Number:");
		
		txtPhoneMobile = new JTextField();
		txtPhoneMobile.setColumns(10);
		
		JLabel lblBussinesPhoneNumber = new JLabel("Bussines Phone Number:");
		
		txtBussinesNumber = new JTextField();
		txtBussinesNumber.setColumns(10);
		
		JLabel lblContactPhoneNumber = new JLabel("Contact Phone Number:");
		
		ContactNumber = new JTextField();
		ContactNumber.setColumns(10);
		
		JLabel lblFaxNumber = new JLabel("Fax Number:");
		
		FaxNumber = new JTextField();
		FaxNumber.setColumns(10);
		
		chckbxCloseAccound = new JCheckBox("Close Accound");
		
		chckbxInformationMaterial = new JCheckBox("Information Material");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrimaryEmail)
										.addComponent(lblSecondaryEmail)
										.addComponent(lblMobilePhoneNumber))
									.addGap(25)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPhoneMobile, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(txtSeconadaryMail, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(txtPrimaryMail, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBussinesPhoneNumber)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(lblContactPhoneNumber)
											.addComponent(lblFaxNumber)
											.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
												.addComponent(chckbxCloseAccound)
												.addGap(34))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(ContactNumber, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(txtBussinesNumber, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(FaxNumber, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
							.addContainerGap(76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxInformationMaterial)
							.addContainerGap(285, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrimaryEmail)
						.addComponent(txtPrimaryMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSecondaryEmail)
						.addComponent(txtSeconadaryMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPhoneMobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMobilePhoneNumber))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBussinesPhoneNumber)
						.addComponent(txtBussinesNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(ContactNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContactPhoneNumber))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(FaxNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFaxNumber))
					.addGap(48)
					.addComponent(chckbxCloseAccound)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxInformationMaterial)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
	
		
		JLabel lblLastname = new JLabel("Last Name");
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		
		Country = new JComboBox<String>();
		
		
		JLabel lblCountry = new JLabel("Country:");
		
		JLabel lblZipPosta = new JLabel("Zip Code:");
		
		txtZipCode = new JTextField();
		txtZipCode.setColumns(10);
		
		JLabel lblNote = new JLabel("Note:");
		
	    txtNote = new JTextArea();
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		
		txtID = new JTextField();
		txtID.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNote)
						.addComponent(txtNote, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(lblCustomerId)
													.addComponent(lblLastname)
													.addComponent(lblAddress)
													.addComponent(lblFirstName)))
											.addComponent(lblCity))
										.addGap(18))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblCountry)
										.addGap(47)))
								.addComponent(lblZipPosta))
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtZipCode)
								.addComponent(Country, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCity)
								.addComponent(txtAddress)
								.addComponent(txtLastName)
								.addComponent(txtFname)
								.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerId)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(txtFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastname)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtZipCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblZipPosta))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry))
					.addGap(12)
					.addComponent(lblNote)
					.addGap(18)
					.addComponent(txtNote, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		panel.setLayout(gl_panel);
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
	
	public static void setID(String val){
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
	
	
	public static String getNote(String val){
		return txtNote.getText();
	}
	
	public static boolean getCloseAccound(boolean val){
		return chckbxCloseAccound.isSelected();	
	}
	
	public static boolean getInformationMaterial(boolean val){
		return	chckbxInformationMaterial.isSelected();
	}
	
	public void setVisible(boolean val){
		this.frame.setVisible(val);	
	}
	
	
	
	
	
}
