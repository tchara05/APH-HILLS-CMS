package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import extras.DatabaseConnection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Securitymenu extends JPanel {

	public static JTextField txtSearchKey;
	public static JComboBox<String> AllContracts;
	public static JTextField txtShowIfFound;
	public static DatabaseConnection database;
	private static CheckIn checkIn;
	private static CheckOut checkOut;
	private static SecurityForm securityForm;
	private static SecuritySearchKey search;
	private static JPanel panel;
	
	public Securitymenu() {
		
		checkOut = new CheckOut();
		checkIn = new CheckIn();
		database = new DatabaseConnection();
		panel=new JPanel();
		securityForm = new SecurityForm();
		

		JButton btnAddContract = new JButton("Add New Key Contract");
		btnAddContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				securityForm.frame.setVisible(true);
			}
		});

		JButton btnDeleteContract = new JButton("Delete Key Contract");
		btnDeleteContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecurityDeleteButton.start();
			}
		});

		JButton btnEditContract = new JButton("Edit/View Key Contract");
		btnEditContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblSearch = new JLabel("Search Contract By KeyID:");

		txtSearchKey = new JTextField();
		txtSearchKey.setColumns(10);

		JButton btnSearchKey = new JButton("Search");
		btnSearchKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SecuritySearchKey().start();
			}
		});

		JLabel lblkeyContracts = new JLabel("Key Contracts:");

		AllContracts = new JComboBox<String>();
		
		JButton btnCheckOut = new JButton("Check out a Key");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOut.frmService.setVisible(true);
			}
		});
		
		JButton btnCheckIn = new JButton("Check in a Key");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckIn.frmCheckIn.setVisible(true);
			}
		});
		
		txtShowIfFound = new JTextField();
		txtShowIfFound.setEnabled(false);
		txtShowIfFound.setEditable(false);
		txtShowIfFound.setText("Key not Found");
		txtShowIfFound.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(txtSearchKey, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnSearchKey, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnAddContract, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(342)
					.addComponent(btnCheckOut, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(342)
					.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AllContracts, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnEditContract, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtShowIfFound, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(btnDeleteContract, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblkeyContracts, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
					.addGap(296))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblkeyContracts, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtSearchKey, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSearchKey, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddContract, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtShowIfFound, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnDeleteContract, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditContract, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllContracts, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(btnCheckOut, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(groupLayout);
		
		
		
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
			rset = stment.executeQuery("SELECT keyID FROM KeyContract ORDER BY keyID");

			while (rset.next() && rset.getString(1) != null) {
				AllContracts.addItem(rset.getString(1));
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
	
	public static JPanel createSecurityMenu(){
		new Securitymenu();
		return panel ;
	}
	
	
}
