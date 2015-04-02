package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import extras.DatabaseConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class Securitymenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtSearchProp;
	public static JComboBox<String> AllContracts;
	public static JTextField txtShowIfFound;
	public static DatabaseConnection database;
	@SuppressWarnings("unused")
	private static CheckIn checkIn;
	private static CheckOut checkOut;
	private static SecurityForm securityForm;
	@SuppressWarnings("unused")
	private static SecuritySearchKey search;
	private static JPanel panel;

	public Securitymenu() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		checkOut = new CheckOut();
		checkIn = new CheckIn();
		database = new DatabaseConnection();
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		securityForm = new SecurityForm();
		panel.setLayout(null);

		@SuppressWarnings("unused")
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 128)), "SECURITY DEPARTMENT",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(22, 21, 792, 473);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(211, 211, 211));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(497, 49, 246, 382);
		panel_3.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAddContract = new JButton("Add New Key Contract");
		btnAddContract.setBounds(30, 288, 184, 33);
		panel_1.add(btnAddContract);
		btnAddContract.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnCheckOut = new JButton("Check out a Key");
		btnCheckOut.setBounds(57, 76, 134, 33);
		panel_1.add(btnCheckOut);
		btnCheckOut.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnCheckIn = new JButton("Check in a Key");
		btnCheckIn.setBounds(57, 120, 134, 33);
		panel_1.add(btnCheckIn);
		btnCheckIn.setFont(new Font("Calibri", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(211, 211, 211));
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(46, 49, 412, 382);
		panel_3.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSearch = new JLabel("Search Key Manually using Plot Name:");
		lblSearch.setBounds(26, 42, 325, 23);
		panel_2.add(lblSearch);
		lblSearch.setFont(new Font("Calibri", Font.PLAIN, 14));

		txtSearchProp = new JTextField();
		txtSearchProp.setBounds(26, 76, 166, 32);
		panel_2.add(txtSearchProp);
		txtSearchProp.setColumns(10);

		JLabel lblSelectKeyFrom = new JLabel("Select Key from List:");
		lblSelectKeyFrom.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSelectKeyFrom.setBounds(26, 155, 151, 23);
		panel_2.add(lblSelectKeyFrom);

		JButton btnSearchKey = new JButton("Search");
		btnSearchKey.setBounds(218, 76, 166, 33);
		panel_2.add(btnSearchKey);
		btnSearchKey.setFont(new Font("Calibri", Font.PLAIN, 14));

		txtShowIfFound = new JTextField();
		txtShowIfFound.setBounds(218, 120, 166, 32);
		panel_2.add(txtShowIfFound);
		txtShowIfFound.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtShowIfFound.setEnabled(false);
		txtShowIfFound.setEditable(false);
		txtShowIfFound.setText("Key not Found");
		txtShowIfFound.setColumns(10);

		AllContracts = new JComboBox<String>();
		AllContracts.setBounds(26, 189, 358, 32);
		panel_2.add(AllContracts);

		JButton btnDeleteContract = new JButton("Delete Selected Key");
		btnDeleteContract.setBounds(26, 288, 166, 33);
		panel_2.add(btnDeleteContract);
		btnDeleteContract.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnEditContract = new JButton("Edit/View Selected Key ");
		btnEditContract.setBounds(217, 288, 167, 33);
		panel_2.add(btnEditContract);
		btnEditContract.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEditContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecurityDeleteButton.start();
			}
		});
		btnSearchKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SecuritySearchKey().start();
			}
		});
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckIn.frmCheckIn.setVisible(true);
			}
		});
		btnCheckOut.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				checkOut.frmService.setVisible(true);
			}
		});
		btnAddContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				securityForm.frame.setVisible(true);
			}
		});

		setUpContractList();
	}

	public static Object getSelectedContract() {
		return AllContracts.getSelectedItem();
	}

	public static void DeleteKeyContractFromList() {

		if (AllContracts.getItemCount() > 0) {
			AllContracts.removeItemAt((AllContracts.getSelectedIndex()));
		}
	}

	public static void setUpContractList() {

		Statement stment = database.getStatement();

		ResultSet rset = null;

		try {
			rset = stment
					.executeQuery("SELECT plotName, plotNumber, keyID FROM KeyContract, Property WHERE Property.plotID = KeyContract.propertyID ORDER BY plotName");

			while (rset.next() && rset.getString(1) != null) {
				AllContracts.addItem(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3));
			}

		} catch (SQLException e1) {
			System.out.println("Can execute the query in setUpContractList");
			e1.printStackTrace();
		}
		try {
		} catch (Exception e) {
			System.out.println("Empty Contract List");
			e.printStackTrace();
		}
	}

	public static JPanel createSecurityMenu() {
		new Securitymenu();
		return panel;
	}
}
