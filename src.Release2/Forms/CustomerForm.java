package Forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Threads.*;
import javax.swing.JCheckBox;


public class CustomerForm{

	private static JFrame CustomerFrame;
	private JPanel contentPane;
	private static JTextField fname;
	private static JTextField lname;
	private static JTextField city;
	private static JTextField accountCode;
	private static JTextField email1;
	private static JTextField country;
	private static JTextField email2;
	private static JTextField zip;
	private static JTextField phonebus;
	private static JTextField phonecon;
	private static JTextField phonemob;
	private static JTextField note;
	private static JTextField fax;
	private static JTextField address;
	private static JCheckBox ClosedAccount;
	private static JCheckBox InfoMaterial ;
	
	public static int id = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		CustomerForm custform = new CustomerForm();
		custform.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public CustomerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CustomerFrame = new JFrame();
		CustomerFrame.setBounds(100, 100, 608, 562);
		CustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		CustomerFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel_2 = new JLabel(input);
		lblNewLabel_2.setBounds(29, 11, 96, 84);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_10 = new JLabel("Account Code :");
		lblNewLabel_10.setBounds(29, 106, 96, 17);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_10);

		accountCode = new JTextField();
		accountCode.setEditable(false);
		accountCode.setBounds(166, 106, 115, 20);
		contentPane.add(accountCode);
		accountCode.setColumns(10);
		accountCode.setText("" + id);

		JLabel lblNewLabel = new JLabel("First Name 1 :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 133, 96, 14);
		contentPane.add(lblNewLabel);

		fname = new JTextField();
		fname.setBounds(166, 130, 115, 20);
		contentPane.add(fname);
		fname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Last Name 1 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 158, 109, 14);
		contentPane.add(lblNewLabel_1);

		lname = new JTextField();
		lname.setBounds(166, 155, 115, 20);
		contentPane.add(lname);
		lname.setColumns(10);

		city = new JTextField();
		city.setBounds(429, 132, 115, 20);
		contentPane.add(city);
		city.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email 1 :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(29, 183, 81, 14);
		contentPane.add(lblNewLabel_4);

		email1 = new JTextField();
		email1.setBounds(166, 180, 115, 20);
		contentPane.add(email1);
		email1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Email 2 :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(29, 208, 109, 14);
		contentPane.add(lblNewLabel_5);

		country = new JTextField();
		country.setBounds(429, 157, 115, 20);
		contentPane.add(country);
		country.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("City :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(323, 133, 46, 14);
		contentPane.add(lblNewLabel_6);

		email2 = new JTextField();
		email2.setBounds(166, 205, 115, 20);
		contentPane.add(email2);
		email2.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Country :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(323, 158, 109, 14);
		contentPane.add(lblNewLabel_7);

		zip = new JTextField();
		zip.setBounds(429, 182, 115, 20);
		contentPane.add(zip);
		zip.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Address :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(323, 107, 58, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblPhoneBusiness = new JLabel("Phone Business :");
		lblPhoneBusiness.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneBusiness.setBounds(29, 258, 104, 14);
		contentPane.add(lblPhoneBusiness);

		phonebus = new JTextField();
		phonebus.setBounds(166, 255, 115, 20);
		contentPane.add(phonebus);
		phonebus.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Phone Mob :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(29, 233, 109, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblPhoneRes = new JLabel("Contact Phone :");
		lblPhoneRes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneRes.setBounds(29, 283, 127, 14);
		contentPane.add(lblPhoneRes);

		phonecon = new JTextField();
		phonecon.setBounds(166, 280, 115, 20);
		contentPane.add(phonecon);
		phonecon.setColumns(10);

		JLabel lblFax = new JLabel("Fax :");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFax.setBounds(29, 308, 109, 14);
		contentPane.add(lblFax);

		phonemob = new JTextField();
		phonemob.setBounds(166, 232, 115, 20);
		contentPane.add(phonemob);
		phonemob.setColumns(10);

		JLabel lblClosedAccount = new JLabel("Closed Account :");
		lblClosedAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClosedAccount.setBounds(29, 337, 127, 14);
		contentPane.add(lblClosedAccount);

		JLabel lblInformationMaterial = new JLabel("Information Material :");
		lblInformationMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformationMaterial.setBounds(29, 365, 140, 14);
		contentPane.add(lblInformationMaterial);

		JLabel lblNote = new JLabel("Note :");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNote.setBounds(29, 392, 127, 14);
		contentPane.add(lblNote);

		note = new JTextField();
		note.setBounds(29, 416, 252, 95);
		contentPane.add(note);
		note.setColumns(10);

		JLabel lblZipCode = new JLabel("Zip Code :");
		lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZipCode.setBounds(323, 183, 127, 14);
		contentPane.add(lblZipCode);

		final JButton addCust = new JButton("ADD CUSTOMER");
		addCust.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addCust.setBounds(304, 485, 240, 23);
		addCust.setEnabled(true);

		addCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  new BtnAddCustomer().start();
			}
		});
		contentPane.add(addCust);

		JButton goMenu = new JButton("GO TO MENU");
		goMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerFrame.setVisible(false);
				// new adminLogin(usern, type).frame.setVisible(true);
			}
		});
		goMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		goMenu.setBounds(429, 417, 115, 23);
		contentPane.add(goMenu);

		fax = new JTextField();
		fax.setColumns(10);
		fax.setBounds(166, 307, 115, 20);
		contentPane.add(fax);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(429, 106, 115, 20);
		contentPane.add(address);

		JButton help = new JButton("HELP");
		help.setFont(new Font("Tahoma", Font.PLAIN, 12));
		help.setBounds(429, 451, 115, 23);
		contentPane.add(help);

		JLabel lblNewLabel_3 = new JLabel("CUSTOMER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(169, 38, 112, 23);
		contentPane.add(lblNewLabel_3);
		
		 ClosedAccount = new JCheckBox("Yes");
		ClosedAccount.setBounds(166, 333, 128, 23);
		contentPane.add(ClosedAccount);
		
		 InfoMaterial = new JCheckBox("Yes");
		InfoMaterial.setBounds(166, 361, 128, 23);
		contentPane.add(InfoMaterial);
	}

	
	public static void setVisible(boolean f){
		CustomerFrame.setVisible(f);
	}
	
	
	
	
	/******************************* All Getters Here *****************************/
	
	public static String getFname(){
		return fname.getText();
	}
	public static String getLname(){
		return lname.getText();
	}
	public static String getCity(){
		return city.getText();
	}
	public static String getAccountCode(){
		return accountCode.getText();
	}
	public static String getEmail1(){
		return email1.getText();
	}
	public static String getEmail2(){
		return email2.getText();
	}
	public static String getCountry(){
		return country.getText();
	}
	public static String getZipCode(){
		return zip.getText();
	}
	public static String getPhoneBussines(){
		return phonebus.getText();
	}
	public static String getPhoneMob(){
		return phonemob.getText();
	}
	public static String getPhoneConnection(){
		return phonecon.getText();
	}
	public static String getNote(){
		return note.getText();
	}
	public static String getFax(){
		return fax.getText();
	}
	public static String getAddress(){
		return address.getText();
	}
	public static boolean getInfoMaterial(){
		return ClosedAccount.isSelected();
	}
	public static boolean getAccountClose(){
		return InfoMaterial.isSelected();
	}
	
	public static int getID(){
		return id;
	}
	
	
	
	/******************************* All Setters Here *****************************/
	
	
	public static void setFName(String srt){
		fname.setText(srt);
	}
	public static void setLName(String srt){
		lname.setText(srt);
	}
	public static void setCity(String srt){
		city.setText(srt);
	}
	public static void setAddress(String srt){
		address.setText(srt);
	}
	public static void setZip(String srt){
		zip.setText(srt);
	}
	public static void setAccountCode(String srt){
		accountCode.setText(srt);
	}
	public static void setEmail1(String srt){
		email1.setText(srt);
	}
	public static void setEmail2(String srt){
		email2.setText(srt);
	}
	public static void setPhoneMob(String srt){
		phonemob.setText(srt);
	}
	public static void setPhoneBussines(String srt){
		phonebus.setText(srt);
	}
	public static void setContact(String srt){
		phonecon.setText(srt);
	}
	public static void setFax(String srt){
		fax.setText(srt);
	}
	public static void setInfoMaterial(boolean f){
		InfoMaterial.setSelected(f);
	}
	public static void setAccountClosed(boolean f){
		ClosedAccount.setSelected(f);
	}
	public static void setCountry(String srt){
		country.setText(srt);
	}
	public static void setNote(String srt){
		note.setText(srt);
	}
	
}
