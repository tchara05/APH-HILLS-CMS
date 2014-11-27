package Forms;
import Threads.BtnAddCustomer;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;


public class ContractForm implements Runnable {

	private static JFrame ContractForm;
	private JPanel contentPane;
	private JTextField Lname;
	private JTextField SFname;
	private JTextField SLname;
	private JTextField Pemail;
	private JTextField Semail;
	private JTextField city;
	private JTextField country;
	private JTextField zipCode;
	private JTextField address;
	private JTextField Fname;
	private JTextField code;
	private JLabel lblContractId;
	private JLabel label_3;
	private JLabel lblBusinessPhone;
	private JLabel lblMobilePhone;
	private JLabel lblContactPhone;
	private JLabel lblFax;
	private JLabel lblInformationMaterial;
	private JLabel lblNote;
	private JLabel lblPlotId;
	private JTextField contractID;
	private JTextField businessPhone;
	private JTextField mobilePhone;
	private JTextField contactPhone;
	private JTextField fax;
	private JTextField iMaterial;
	private JTextField note;
	private JTextField plotID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		ContractForm t = new ContractForm();
		EventQueue.invokeLater(t);
		t.run();
		
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
		
		JButton btnNewButton = new JButton("Add Contract");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(500, 367, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(630, 334, 89, 23);
		contentPane.add(btnHelp);
		
		JCheckBox MltiOwner = new JCheckBox("Multiple Owner");
		MltiOwner.setBounds(524, 270, 128, 23);
		contentPane.add(MltiOwner);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Closed Account");
		chckbxNewCheckBox.setBounds(524, 301, 154, 23);
		contentPane.add(chckbxNewCheckBox);
		
		
	}

	
	public static  void setVisible(boolean f){
		
		ContractForm.setVisible(f);	
	}
	
	@Override
	public void run() {
		
		ContractForm.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}
}
