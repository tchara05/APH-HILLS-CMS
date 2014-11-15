import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class viewCustomer extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCustomers frame = new ManageCustomers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public viewCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManageCustomers = new JLabel("MANAGE CUSTOMERS");
		lblManageCustomers.setBounds(134, 51, 205, 20);
		lblManageCustomers.setForeground(Color.BLACK);
		lblManageCustomers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblManageCustomers);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 140, 365, 135);
		contentPane.add(scrollPane);

		final JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[First_idioktitis.allCustomers.size()];
			{
				if (values.length != 0)
					for (int i = 0; i < First_idioktitis.allCustomers.size(); i++) {
						values[i] = First_idioktitis.allCustomers.get(i).accountCode
								+ "  "
								+ First_idioktitis.allCustomers.get(i).fname
								+ "  "
								+ First_idioktitis.allCustomers.get(i).lname;
					}
			}

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		/**
		 * Skopos tou pio kato kodikas einai na emfanizete sto xristi mia lista
		 * opou periexei olous tou pelates me to onoma kai to epitheto tous.
		 * Epilegei kapoio kai sti sinexei akolouthei tis analoges energeies gia
		 * to ti thelei na kanei.
		 * 
		 */

		JButton btnNewButton_1 = new JButton("VIEW SELECTED ITEM");
		btnNewButton_1.setBounds(53, 287, 177, 23);
		btnNewButton_1.addActionListener(new ActionListener() {

			/**
			 * Skopos tis parakato sinartisis einai i tropopoiisi twn
			 * periexomenwn tou pelati. Sti arxi elegxete oti iparxei kapoios
			 * diathesimos pelatis gia na tropopoiithei. An auto isxiei tote
			 * pernoume to stoixeio to opoio epele3e o xristis gia na to
			 * tropopoiisi, pernoume to onoma kai to epitheto tou sigkekrimenou
			 * pelati, to vriskoume mesa apo ti lista kai pernoume to
			 * antikeimeno sto opoio anikei. Sti sinexeia kaloume to constructor
			 * tis klasis pelati kai thetoume ta stoixeia sta text fields etsi
			 * oste o xristis na mporei na kanei allages.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				int go = 0;
				if (First_idioktitis.allCustomers.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"There are no Customers!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					setVisible(false);
					dispose();
					go = 1;
				}

				if (go == 0) {
					// String a = "";
					// String b = "";
					String name_sur = list.getSelectedValue().toString();

					CustomerClass cust = First_idioktitis.allCustomers.get(0);

					String[] name = name_sur.split("\\s+");
					String idnum = name[0];
					// String Name = name[1];
					// String Surname = name[2];

					int id_num = Integer.parseInt(idnum.toString());
					for (int i = 0; i < First_idioktitis.allCustomers.size(); i++) {
						int id_cust = First_idioktitis.allCustomers.get(i).accountCode;
						// a = First_idioktitis.allCustomers.get(i).fname;
						// b = First_idioktitis.allCustomers.get(i).lname;
						// if (a.equals(Name) && b.equals(Surname)) {
						if (id_num == id_cust) {
							cust = First_idioktitis.allCustomers.get(i);
							break;
						}
					}

					First_idioktitis myPelatis = new First_idioktitis(null,
							null, 3, cust);

					myPelatis.setVisible(true);
					myPelatis.fname.setText(cust.fname);
					myPelatis.fname.setEditable(false);
					myPelatis.lname.setText(cust.lname);
					myPelatis.lname.setEditable(false);
					myPelatis.accountCode.setText(String
							.valueOf(cust.accountCode));
					myPelatis.email1.setText(cust.email1);
					myPelatis.email1.setEditable(false);
					myPelatis.email2.setText(cust.email2);
					myPelatis.email2.setEditable(false);
					myPelatis.phonemob.setText(cust.phonemob);
					myPelatis.phonemob.setEditable(false);
					myPelatis.phonebus.setText(cust.phonebus);
					myPelatis.phonebus.setEditable(false);
					myPelatis.phonecon.setText(cust.phonecon);
					myPelatis.phonecon.setEditable(false);
					myPelatis.note.setText(cust.note);
					myPelatis.note.setEditable(false);
					myPelatis.address.setText(cust.address);
					myPelatis.address.setEditable(false);
					myPelatis.city.setText(cust.city);
					myPelatis.city.setEditable(false);
					myPelatis.country.setText(cust.country);
					myPelatis.country.setEditable(false);
					myPelatis.zip.setText(cust.zipCode);
					myPelatis.zip.setEditable(false);
					myPelatis.fax.setText(cust.fax);
					myPelatis.fax.setEditable(false);
					// if (myPelatis.allCustomers.get(numb).closeAccount)
					// myPelatis.aa.setEnabled(true);
					// if (myPelatis.allCustomers.get(numb).informationMaterial)
					// myPelatis.bb.setEnabled(true);
				}
			}
		});
		contentPane.add(btnNewButton_1);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(23, 15, 96, 88);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 115, 84, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(147, 115, 44, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(201, 115, 84, 14);
		contentPane.add(lblSurname);

		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// setVisible(false);
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGoBack.setBounds(334, 320, 84, 23);
		contentPane.add(btnGoBack);

		JButton btnNewButton = new JButton("HELP");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(334, 286, 84, 23);
		contentPane.add(btnNewButton);

	}
}
