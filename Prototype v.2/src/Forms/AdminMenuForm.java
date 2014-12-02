package Forms;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Threads.BtnProforma;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMenuForm implements Runnable {

	private static JFrame AdminForm;
	private JTextField Actor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		AdminMenuForm AdmMenu = new AdminMenuForm("s","S");
		EventQueue.invokeLater(AdmMenu);
	}

	/**
	 * Create the application.
	 */
	public AdminMenuForm(String username, String usertype) {
		initialize(username, usertype);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username, final String usertype) {
		AdminForm = new JFrame();
		AdminForm.setBounds(100, 100, 574, 460);
		AdminForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminForm.getContentPane().setLayout(null);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(23, 11, 93, 75);
		AdminForm.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TASK MANAGER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(138, 32, 142, 25);
		AdminForm.getContentPane().add(lblNewLabel_1);

		Actor = new JTextField();
		Actor.setBounds(388, 11, 113, 20);
		AdminForm.getContentPane().add(Actor);
		Actor.setColumns(10);

		// //////////////////////////////////////////////////
		JButton addcust = new JButton("Add new");
		addcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CustomerForm.setVisible(true);
			}
		});
		addcust.setBounds(237, 105, 89, 23);
		AdminForm.getContentPane().add(addcust);

		JButton viewcust = new JButton("View");
		viewcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCustForm.setVisible(true);
			}
		});
		viewcust.setBounds(138, 105, 89, 23);
		AdminForm.getContentPane().add(viewcust);

		JButton editcust = new JButton("Edit/Delete");
		editcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageCustForm.setVisible(true);
			}
		});
		editcust.setBounds(336, 105, 113, 23);
		AdminForm.getContentPane().add(editcust);

		JButton addprop = new JButton("Add new");
		addprop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PropertyForm.setVisible(true);
				
			}
		});
		addprop.setBounds(237, 156, 89, 23);
		AdminForm.getContentPane().add(addprop);

		JButton viewprop = new JButton("View\r\n");
		viewprop.setBounds(138, 156, 89, 23);
		AdminForm.getContentPane().add(viewprop);

		JButton editprop = new JButton("Edit/Delete");
		editprop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ManagePropertyForm.setVisible(true);
			}
		});
		editprop.setBounds(336, 156, 113, 23);
		AdminForm.getContentPane().add(editprop);

		JButton addsecur = new JButton("Add new");
		addsecur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addsecur.setBounds(237, 206, 89, 23);
		AdminForm.getContentPane().add(addsecur);

		JButton viewsecur = new JButton("View");
		viewsecur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		viewsecur.setBounds(138, 206, 89, 23);
		AdminForm.getContentPane().add(viewsecur);

		JButton editsecu = new JButton("Edit/Delete");
		editsecu.setBounds(336, 206, 113, 23);
		AdminForm.getContentPane().add(editsecu);
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

		Actor.setText(username);
		Actor.setEditable(false);
		// textField.setEnabled(false);

		JLabel lblLogInAs = new JLabel("Loged in as:");
		lblLogInAs.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblLogInAs.setBounds(313, 13, 75, 14);
		AdminForm.getContentPane().add(lblLogInAs);

		JLabel customer = new JLabel("CUSTOMER:");
		customer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		customer.setBounds(33, 102, 108, 25);
		AdminForm.getContentPane().add(customer);

		JLabel lblProperty = new JLabel("PROPERTY:");
		lblProperty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProperty.setBounds(33, 154, 108, 25);
		AdminForm.getContentPane().add(lblProperty);

		JLabel lblSecurity = new JLabel("SECURITY:");
		lblSecurity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecurity.setBounds(33, 204, 108, 25);
		AdminForm.getContentPane().add(lblSecurity);

		JLabel lblBilling = new JLabel("BILLING:");
		lblBilling.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBilling.setBounds(33, 309, 108, 25);
		AdminForm.getContentPane().add(lblBilling);

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
		help.setBounds(237, 396, 89, 23);
		AdminForm.getContentPane().add(help);

		JButton switch_user = new JButton("SWITCH USER");
		switch_user.setFont(new Font("Tahoma", Font.PLAIN, 11));
		switch_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdminForm.setVisible(false);
				MainForm.setVisible(true);
			}
		});
		switch_user.setBounds(336, 396, 113, 24);
		AdminForm.getContentPane().add(switch_user);

		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminForm.setVisible(false);
				System.exit(1);
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		exit.setBounds(138, 396, 93, 23);
		AdminForm.getContentPane().add(exit);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEmail.setBounds(138, 353, 89, 23);
		AdminForm.getContentPane().add(btnEmail);
		
		JLabel lblContract = new JLabel("CONTRACT:");
		lblContract.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContract.setBounds(33, 258, 83, 20);
		AdminForm.getContentPane().add(lblContract);
		
		JButton btnAddContract = new JButton("Add new");
		btnAddContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractForm.setVisible(true);
				
				
			}
		});
		btnAddContract.setBounds(237, 256, 89, 29);
		AdminForm.getContentPane().add(btnAddContract);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(138, 256, 85, 29);
		AdminForm.getContentPane().add(btnEdit);
		
		JButton Cost = new JButton("Cost");
		Cost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cost.setBounds(138, 309, 89, 29);
		AdminForm.getContentPane().add(Cost);
		
		JButton btnExportProf = new JButton("Export Prof");
		btnExportProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BtnProforma t = new BtnProforma();
				t.start();
				
				
			}
		});
		btnExportProf.setBounds(237, 309, 117, 29);
		AdminForm.getContentPane().add(btnExportProf);
		
		JButton btnExportInvoice = new JButton("Export Invoice");
		btnExportInvoice.setBounds(366, 309, 117, 29);
		AdminForm.getContentPane().add(btnExportInvoice);
		
		JButton btnPoforma = new JButton("Proforma");
	}
	
	public void setActor(String pr){
		
		Actor.setText(pr);
		
	}
	
	
	public static void setVisible(boolean t){
		AdminForm.setVisible(t);
	}

	@Override
	public void run() {
		
		AdminForm.setVisible(false);
		// TODO Auto-generated method stub
		
	}
}
