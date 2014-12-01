import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminLogin {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminLogin window = new adminLogin(null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminLogin(String username, String usertype) {
		initialize(username, usertype);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username, final String usertype) {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(23, 11, 93, 75);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TASK MANAGER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(138, 32, 142, 25);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(388, 11, 113, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// //////////////////////////////////////////////////
		JButton addcust = new JButton("Add new");
		addcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// frame.setVisible(false);
				new First_idioktitis(username, usertype, 0, null)
						.setVisible(true);
			}
		});
		addcust.setBounds(237, 105, 89, 23);
		frame.getContentPane().add(addcust);

		JButton viewcust = new JButton("View");
		viewcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new viewCustomer().setVisible(true);
			}
		});
		viewcust.setBounds(138, 105, 89, 23);
		frame.getContentPane().add(viewcust);

		JButton editcust = new JButton("Edit/Delete");
		editcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// frame.dispose();
				new ManageCustomers().setVisible(true);
			}
		});
		editcust.setBounds(336, 105, 113, 23);
		frame.getContentPane().add(editcust);

		JButton addprop = new JButton("Add new");
		addprop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddNewProperty().main(null);
				
			}
		});
		addprop.setBounds(237, 156, 89, 23);
		frame.getContentPane().add(addprop);

		JButton viewprop = new JButton("View\r\n");
		viewprop.setBounds(138, 156, 89, 23);
		frame.getContentPane().add(viewprop);

		JButton editprop = new JButton("Edit/Delete");
		editprop.setBounds(336, 156, 113, 23);
		frame.getContentPane().add(editprop);

		JButton addsecur = new JButton("Add new");
		addsecur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addsecur.setBounds(237, 206, 89, 23);
		frame.getContentPane().add(addsecur);

		JButton viewsecur = new JButton("View");
		viewsecur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		viewsecur.setBounds(138, 206, 89, 23);
		frame.getContentPane().add(viewsecur);

		JButton editsecu = new JButton("Edit/Delete");
		editsecu.setBounds(336, 206, 113, 23);
		frame.getContentPane().add(editsecu);
		// /////////////////////////////////////////////////////

		// ///////////////////////////////////Enabled
		// KOUPIA///////////////////////////////////////
		if (usertype.equals("admin")) {
		}
		// do nothing

		if (usertype.equals("secre")) {
			viewsecur.setEnabled(false);
			addsecur.setEnabled(false);
			editsecu.setEnabled(false);
		}

		else if (usertype.equals("secur")) {
			addcust.setEnabled(false);
			editcust.setEnabled(false);
			addprop.setEnabled(false);
			editprop.setEnabled(false);
		}

		textField.setText(username);
		textField.setEditable(false);
		// textField.setEnabled(false);

		JLabel lblLogInAs = new JLabel("Loged in as:");
		lblLogInAs.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblLogInAs.setBounds(313, 13, 75, 14);
		frame.getContentPane().add(lblLogInAs);

		JLabel customer = new JLabel("CUSTOMER:");
		customer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		customer.setBounds(33, 102, 108, 25);
		frame.getContentPane().add(customer);

		JLabel lblProperty = new JLabel("PROPERTY:");
		lblProperty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProperty.setBounds(33, 154, 108, 25);
		frame.getContentPane().add(lblProperty);

		JLabel lblSecurity = new JLabel("SECURITY:");
		lblSecurity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecurity.setBounds(33, 204, 108, 25);
		frame.getContentPane().add(lblSecurity);

		JLabel lblBilling = new JLabel("BILLING:");
		lblBilling.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBilling.setBounds(33, 252, 108, 25);
		frame.getContentPane().add(lblBilling);

		JButton help = new JButton("HELP");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"1. Click a specific button to View, Add or Edit/Delete from: \n- Customer \n- Property \n- Security \n- Billing",
								"HELP", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.setFont(new Font("Tahoma", Font.PLAIN, 12));
		help.setBounds(241, 302, 89, 23);
		frame.getContentPane().add(help);

		JButton switch_user = new JButton("SWITCH USER");
		switch_user.setFont(new Font("Tahoma", Font.PLAIN, 11));
		switch_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new myLogin().frame.setVisible(true);
			}
		});
		switch_user.setBounds(336, 302, 113, 24);
		frame.getContentPane().add(switch_user);

		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		exit.setBounds(138, 302, 93, 23);
		frame.getContentPane().add(exit);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEmail.setBounds(138, 255, 89, 23);
		frame.getContentPane().add(btnEmail);
		
		JButton btnPoforma = new JButton("Proforma");
		btnPoforma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)  {
				
				try{
					new PDFexporter().creat_Invoice(2);
				}catch (Exception t){
					System.out.println("ok");
				}
			}
		});
		btnPoforma.setBounds(237, 255, 89, 23);
		frame.getContentPane().add(btnPoforma);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					new PDFexporter().creat_Invoice(1);
				}catch (Exception t){
					System.out.println("ok");
				}
				
				
				try{
					new PDFexporter().creat_Invoice(3);
				}catch (Exception t){
					System.out.println("ok");
				}
			}
		});
		btnInvoice.setBounds(336, 255, 113, 23);
		frame.getContentPane().add(btnInvoice);
	}
}
