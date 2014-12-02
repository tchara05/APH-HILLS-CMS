package Forms;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Forms.CustomerForm;
import Forms.PropertyForm;


public class ContractForm  {

	private static JFrame ContractForm;
	private static JPanel contentPane;
	private static JTextField Lname;
	private static JTextField SFname;
	private static JTextField SLname;
	private static JTextField Pemail;
	private static JTextField Semail;
	private static JTextField city;
	private static JTextField country;
	private static JTextField zipCode;
	private static JTextField address;
	private static JTextField Fname;
	private static JTextField code;
	private static JLabel lblContractId;
	private static JLabel label_3;
	private static JLabel lblBusinessPhone;
	private static JLabel lblMobilePhone;
	private static JLabel lblContactPhone;
	private static JLabel lblFax;
	private static JLabel lblInformationMaterial;
	private static JLabel lblNote;
	private static JLabel lblPlotId;
	private static JTextField contractID;
	private static JTextField businessPhone;
	private static JTextField mobilePhone;
	private static JTextField contactPhone;
	private static JTextField fax;
	private static JTextField iMaterial;
	private static JTextField note;
	private static JTextField plotID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		ContractForm t = new ContractForm();

	}

	/**
	 * Create the application.
	 */
	public ContractForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ContractForm = new JFrame();
		ContractForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ContractForm.setBounds(0, 0,10000, 1000);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ContractForm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblContractId = new JLabel("Contract ID:");
		lblContractId.setBounds(351, 14, 60, 26);
		lblContractId.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.add(lblContractId);
		
		contractID = new JTextField();
		contractID.setBounds(416, 17, 193, 20);
		contentPane.add(contractID);
		contractID.setColumns(10);
		
		label_3 = new JLabel("");
		label_3.setBounds(10, 10, 1, 1);
		contentPane.add(label_3);
		
		JLabel lblAccountCode = new JLabel("Account Code :");
		lblAccountCode.setBounds(16, 51, 110, 26);
		lblAccountCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccountCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblAccountCode);
		
		code = new JTextField();
		code.setBounds(146, 53, 195, 26);
		contentPane.add(code);
		code.setColumns(10);
		
		lblBusinessPhone = new JLabel("Business Phone:");
		lblBusinessPhone.setBounds(393, 51, 140, 26);
		lblBusinessPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblBusinessPhone);
		
		JLabel lblFirstName = new JLabel("First Name 1 :");
		lblFirstName.setBounds(16, 82, 110, 26);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblFirstName);
		
		Fname = new JTextField();
		Fname.setBounds(146, 84, 195, 26);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		lblMobilePhone = new JLabel("Mobile Phone:");
		lblMobilePhone.setBounds(393, 82, 140, 26);
		lblMobilePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblMobilePhone);
		
		JLabel lblNewLabel = new JLabel("Last Name 1 :");
		lblNewLabel.setBounds(16, 113, 110, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		Lname = new JTextField();
		Lname.setBounds(146, 115, 195, 26);
		contentPane.add(Lname);
		Lname.setColumns(10);
		
		lblContactPhone = new JLabel("Contact Phone:");
		lblContactPhone.setBounds(393, 113, 140, 26);
		lblContactPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblContactPhone);
		
		JLabel lblNewLabel_1 = new JLabel("First Name 2 :");
		lblNewLabel_1.setBounds(16, 144, 110, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		SFname = new JTextField();
		SFname.setBounds(146, 146, 195, 26);
		contentPane.add(SFname);
		SFname.setColumns(10);
		
		lblFax = new JLabel("Fax:");
		lblFax.setBounds(392, 144, 140, 26);
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblFax);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name 2 :");
		lblNewLabel_2.setBounds(16, 175, 110, 26);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2);
		
		SLname = new JTextField();
		SLname.setBounds(146, 177, 195, 26);
		contentPane.add(SLname);
		SLname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email 1:");
		lblNewLabel_3.setBounds(16, 206, 110, 26);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3);
		
		Pemail = new JTextField();
		Pemail.setBounds(146, 208, 195, 26);
		contentPane.add(Pemail);
		Pemail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email 2:");
		lblNewLabel_4.setBounds(16, 237, 110, 26);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4);
		
		Semail = new JTextField();
		Semail.setBounds(146, 239, 195, 26);
		contentPane.add(Semail);
		Semail.setColumns(10);
		
		lblInformationMaterial = new JLabel("Information Material:");
		lblInformationMaterial.setBounds(393, 208, 140, 26);
		lblInformationMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblInformationMaterial);
		
		JLabel lblNewLabel_5 = new JLabel("City:");
		lblNewLabel_5.setBounds(16, 268, 110, 26);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5);
		
		city = new JTextField();
		city.setBounds(146, 270, 195, 26);
		contentPane.add(city);
		city.setColumns(10);
		
		lblNote = new JLabel("Note:");
		lblNote.setBounds(393, 239, 140, 26);
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNote);
		
		JLabel lblNewLabel_6 = new JLabel("Country:");
		lblNewLabel_6.setBounds(16, 299, 110, 26);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_6);
		
		country = new JTextField();
		country.setBounds(146, 301, 195, 26);
		contentPane.add(country);
		country.setColumns(10);
		
		lblPlotId = new JLabel("Plot ID:");
		lblPlotId.setBounds(393, 181, 140, 26);
		lblPlotId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPlotId);
		
		JLabel lblNewLabel_7 = new JLabel("Zip Code:");
		lblNewLabel_7.setBounds(16, 330, 110, 26);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_7);
		
		zipCode = new JTextField();
		zipCode.setBounds(146, 332, 195, 26);
		contentPane.add(zipCode);
		zipCode.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address:");
		lblNewLabel_8.setBounds(16, 361, 110, 31);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_8);
		
		address = new JTextField();
		address.setBounds(146, 363, 195, 31);
		contentPane.add(address);
		address.setColumns(10);
		
		businessPhone = new JTextField();
		businessPhone.setColumns(10);
		businessPhone.setBounds(524, 53, 195, 26);
		contentPane.add(businessPhone);
		
		mobilePhone = new JTextField();
		mobilePhone.setColumns(10);
		mobilePhone.setBounds(524, 87, 195, 26);
		contentPane.add(mobilePhone);
		
		contactPhone = new JTextField();
		contactPhone.setColumns(10);
		contactPhone.setBounds(524, 119, 195, 26);
		contentPane.add(contactPhone);
		
		fax = new JTextField();
		fax.setColumns(10);
		fax.setBounds(524, 149, 195, 26);
		contentPane.add(fax);
		
		iMaterial = new JTextField();
		iMaterial.setColumns(10);
		iMaterial.setBounds(524, 210, 195, 26);
		contentPane.add(iMaterial);
		
		note = new JTextField();
		note.setColumns(10);
		note.setBounds(524, 239, 195, 26);
		contentPane.add(note);
		
		plotID = new JTextField();
		plotID.setColumns(10);
		plotID.setBounds(524, 181, 195, 26);
		contentPane.add(plotID);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int blank = 0;
				
				if (plotID.getText().equals(""))
					blank++;
				if (contactPhone.getText().equals(""))
					blank++;
				if (mobilePhone.getText().equals(""))
					blank++;
				if (businessPhone.getText().equals(""))
					blank++;
				if (contractID.getText().equals(""))
					blank++;
				if (code.getText().equals(""))
					blank++;
				if (Fname.getText().equals(""))
					blank++;
				if (address.getText().equals(""))
					blank++;
				if (zipCode.getText().equals(""))
					blank++;
				if (country.getText().equals(""))
					blank++;
				if (city.getText().equals(""))
					blank++;
				if (Semail.getText().equals(""))
					blank++;
				if (Pemail.getText().equals(""))
					blank++;
				if (SLname.getText().equals(""))
					blank++;
				if (SFname.getText().equals(""))
					blank++;
				if (Lname.getText().equals(""))
					blank++;
				if (fax.getText().equals(""))
					blank++;
				if (iMaterial.getText().equals(""))
					blank++;
				if(blank>0){
					JOptionPane.showMessageDialog(null,
							"There are "+blank+" empty fields. \nPlease, check again",
							"Warning", JOptionPane.WARNING_MESSAGE);				     
				    
				    
				    
				}
				
			}
		});
		btnSave.setBounds(401, 367, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(630, 367, 89, 23);
		contentPane.add(btnExit);
		
		JRadioButton multipleOwner = new JRadioButton("Multiple Owner");
		multipleOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		multipleOwner.setBounds(524, 271, 140, 23);
		contentPane.add(multipleOwner);
		
		JRadioButton closedAccount = new JRadioButton("Closed Account");
		closedAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		closedAccount.setBounds(524, 301, 140, 23);
		contentPane.add(closedAccount);
		
		JButton btnNewButton = new JButton("Add Contract");
		btnNewButton.setBounds(500, 367, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(630, 334, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnView = new JButton("View Details");
		btnView.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnView.setBounds(401, 332, 89, 26);
		contentPane.add(btnView);
		
		
	}

	
	public static  void setVisible(boolean f){
		
		ContractForm.setVisible(f);	
	}
	

	
/******************************* All Getters Here *****************************/
	
	public static String getLName(){
		return Lname.getText();
	}
	public static String getSFName(){
		return SFname.getText();
	}
	public static String getSLName(){
		return SLname.getText();
	}
	public static String getFName(){
		return Fname.getText();
	}
	public static String getPEmail(){
		return Pemail.getText();
	}
	public static String getSEmail(){
		return Semail.getText();
	}
	public static String getCity(){
		return city.getText();
	}
	public static String getCountry(){
		return country.getText();
	}
	public static String getZipCode(){
		return zipCode.getText();
	}
	public static String getAddress(){
		return address.getText();
	}
	public static int getCode(){
		return Integer.parseInt(code.getText());
	}
	public static String getBusinessPhone(){
		return businessPhone.getText();
	}
	public static String getContactPhone(){
		return contactPhone.getText();
	}
	public static String getMobilePhone(){
		return mobilePhone.getText();
	}
	public static String getFax(){
		return fax.getText();
	}
	public static String getNote(){
		return note.getText();
	}
	public static String getPlotID(){
		return plotID.getText();
	}

	
/******************************* All Setters Here *****************************/
	

	
	public static void setLName(String srt){
		Lname.setText(srt);
	}
	public static void setSFName(String srt){
		SFname.setText(srt);
	}
	public static void setSLName(String srt){
		SLname.setText(srt);
	}
	public static void setFName(String srt){
		Fname.setText(srt);
	}
	public static void setPEmail(String srt){
		Pemail.setText(srt);
	}
	public static void setSEmail(String srt){
		Semail.setText(srt);
	}
	public static void setCity(String srt){
		city.setText(srt);
	}
	public static void setCountry(String srt){
		country.setText(srt);
	}
	public static void setZipCode(String srt){
		zipCode.setText(srt);
	}
	public static void setAddress(String srt){
		address.setText(srt);
	}
	public static void setCode(int srt){
		code.setText(String.valueOf(srt));
	}
	public static void setBusinessPhone(int srt){
		businessPhone.setText(String.valueOf(srt));
	}
	public static void setMobilePhone(int srt){
		mobilePhone.setText(String.valueOf(srt));
	}
	public static void setContactPhone(int srt){
		contactPhone.setText(String.valueOf(srt));
	}
	public static void setFax(String srt){
		fax.setText(srt);
	}
//	public static void setIMaterial(boolean f){
//		iMaterial.setSelected(f);
//	}
	public static void setNote(String srt){
		note.setText(srt);
	}
	public static void setPlotID(String srt){
		plotID.setText(srt);
	}
}
