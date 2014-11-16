import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class First_idioktitis extends JFrame {

	private JPanel contentPane;
	JTextField fname;
	JTextField lname;
	JTextField city;
	JTextField accountCode;
	JTextField email1;
	JTextField country;
	JTextField email2;
	JTextField zip;
	JTextField phonebus;
	JTextField phonecon;
	JTextField phonemob;
	JTextField note;
	JTextField fax;
	JTextField address;
	Checkbox aa;
	Checkbox bb;
	public int id = 0;
	public static ArrayList<CustomerClass> allCustomers = new ArrayList<CustomerClass>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First_idioktitis frame = new First_idioktitis(null, null,
							0, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public First_idioktitis(final String usern, final String type,
			final int changed, final CustomerClass cust) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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

		final JRadioButton closedacc = new JRadioButton("Yes");
		closedacc.setBounds(169, 333, 109, 23);
		contentPane.add(closedacc);

		JLabel lblInformationMaterial = new JLabel("Information Material :");
		lblInformationMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformationMaterial.setBounds(29, 365, 140, 14);
		contentPane.add(lblInformationMaterial);

		final JRadioButton infomaterial = new JRadioButton("Yes");
		infomaterial.setBounds(169, 361, 109, 23);
		contentPane.add(infomaterial);

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

		final JButton addCust = new JButton("ADD/UPDATE CUSTOMER");
		addCust.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addCust.setBounds(304, 485, 240, 23);

		if (changed == 3)
			addCust.setEnabled(false);

		addCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int blank = 0;

				if (fname.getText().equals(""))
					blank = 1;

				if (lname.getText().equals(""))
					blank = 1;

				if (email1.getText().equals(""))
					blank = 1;

				if (email2.getText().equals(""))
					blank = 1;

				if (address.getText().equals(""))
					blank = 1;

				if (city.getText().equals(""))
					blank = 1;

				if (country.getText().equals(""))
					blank = 1;

				if (zip.getText().equals(""))
					blank = 1;

				if (phonebus.getText().equals(""))
					blank = 1;

				if (phonecon.getText().equals(""))
					blank = 1;

				if (phonemob.getText().equals(""))
					blank = 1;

				if (fax.getText().equals(""))
					blank = 1;

				// ginete tropopoiisi
				if (changed == 1) {
					cust.fname = fname.getText();
					cust.lname = lname.getText();
					cust.accountCode = Integer.parseInt(accountCode.getText());
					cust.email1 = email1.getText();
					cust.email2 = email2.getText();
					cust.phonemob = phonemob.getText();
					cust.phonecon = phonecon.getText();
					cust.fax = fax.getText();
					// if(cust.closeAccount == true)
					// aa.setEnabled(true);
					// if(cust.informationMaterial == true)
					// bb.setEnabled(true);
					cust.address = address.getText();
					cust.city = city.getText();
					cust.country = country.getText();
					cust.zipCode = zip.getText();
					cust.note = note.getText();
					setVisible(false);
					dispose();
				}

				else if (changed == 0) {

					if (blank == 1)
						JOptionPane
								.showMessageDialog(
										null,
										"There are empty fields. \nPlease, check again",
										"Warning", JOptionPane.WARNING_MESSAGE);
					else {
						CustomerClass newCustomer = new CustomerClass(fname
								.getText(), lname.getText(),
								(1015200 + First_idioktitis.this.id++), email1
										.getText(), email2.getText(), phonemob
										.getText(), phonebus.getText(),
								phonecon.getText(), fax.getText(), closedacc
										.isSelected(), infomaterial
										.isSelected(), address.getText(), city
										.getText(), country.getText(), zip
										.getText(), note.getText());

						allCustomers.add(newCustomer);

						setVisible(false);
						dispose();
					}

				}
			}
		});
		contentPane.add(addCust);

		JButton goMenu = new JButton("GO TO MENU");
		goMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
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
	}
}
