package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import extras.DatabaseConnection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SecurityMen extends JPanel {

	public static JTextField textField;
	public static JComboBox<String> AllContracts;
	public static JTextField txtKeyNotFound;
	public static DatabaseConnection database;
	
	
	private static JPanel panel;
	
	public SecurityMen() {
		
		
		database = new DatabaseConnection();
		panel=new JPanel();

		JButton btnAddNew = new JButton("Add New Key Contract");

		JButton btnNewButton = new JButton("Delete Key Contract");

		JButton btnNewButton_1 = new JButton("Edit/View Key Contract");

		JLabel lblNewLabel = new JLabel("Search Contract By KeyID:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("Search");

		JLabel lblNewLabel_1 = new JLabel("Key Contracts:");

		AllContracts = new JComboBox<String>();
		
		JButton btnCheckOutA = new JButton("Check out a Key");
		
		JButton btnCheckInA = new JButton("Check in a Key");
		
		txtKeyNotFound = new JTextField();
		txtKeyNotFound.setEnabled(false);
		txtKeyNotFound.setEditable(false);
		txtKeyNotFound.setText("key not found");
		txtKeyNotFound.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnAddNew, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(342)
					.addComponent(btnCheckOutA, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(342)
					.addComponent(btnCheckInA, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AllContracts, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtKeyNotFound, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddNew, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtKeyNotFound, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllContracts, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(btnCheckOutA, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(btnCheckInA, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(groupLayout);
	}
	
	

	public static Object getSelectedContract() {
		return AllContracts.getSelectedItem();
	}

	public static void DeletePropertyFromList() {

		if (AllContracts.getItemCount() > 0) {
			AllContracts.removeItemAt((AllContracts.getSelectedIndex()));
		}
	}

	public static void setUpContractList() {

		
		Statement stment = database.getStatement();

		ResultSet rset = null;

		try {
			rset = stment
					.executeQuery("SELECT keysID, propertyID FROM keyContract ORDER BY keysID");

			while (rset.next() && rset.getString(1) != null) {
				AllContracts.addItem(rset.getString(1) + " "
						+ rset.getString(2));
			}

		} catch (SQLException e1) {
			System.out.println("Can execute the query in setUpContractList");
			e1.printStackTrace();
		}
		try {
			AllContracts.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("Empty Contract List");
			e.printStackTrace();
		}
	}
	
	public static void UpdateContractList(String str){
		
		int length = AllContracts.getItemCount();
		String value = str;
		int i = 0;
		
		while (i<length && String.CASE_INSENSITIVE_ORDER.compare(value,(String)AllContracts.getItemAt(i) )>0){
			i++;
		}
		while (i<length && String.CASE_INSENSITIVE_ORDER.compare(value,(String)AllContracts.getItemAt(i) )==0){
			i++;	
		}
		
		AllContracts.insertItemAt(value, i);
	}
	public static JPanel createSecurityMenu(){
		new SecurityMen();
		return panel ;
	}
	
	
}
