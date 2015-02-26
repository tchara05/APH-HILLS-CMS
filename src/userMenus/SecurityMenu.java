package userMenus;

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

public class SecurityMenu extends JPanel {

	private JTextField textField;
	private static JComboBox<String> AllContracts;
	private JTextField txtKeyNotFound;

	/**
	 * Create the panel.
	 */
	public SecurityMenu() {
		setLayout(null);

		JButton btnAddNew = new JButton("Add New Key Contract");
		btnAddNew.setBounds(342, 82, 148, 23);
		add(btnAddNew);

		JButton btnNewButton = new JButton("Delete Key Contract");
		btnNewButton.setBounds(342, 116, 148, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit/View Key Contract");
		btnNewButton_1.setBounds(342, 150, 148, 23);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Search Contract By KeyID:");
		lblNewLabel.setBounds(28, 57, 186, 14);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(28, 83, 186, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBounds(224, 82, 89, 23);
		add(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("Key Contracts:");
		lblNewLabel_1.setBounds(28, 22, 113, 14);
		add(lblNewLabel_1);

		AllContracts = new JComboBox<String>();
		AllContracts.setBounds(28, 151, 285, 20);
		add(AllContracts);
		
		JButton btnCheckOutA = new JButton("Check out a Key");
		btnCheckOutA.setBounds(342, 230, 113, 23);
		add(btnCheckOutA);
		
		JButton btnCheckInA = new JButton("Check in a Key");
		btnCheckInA.setBounds(342, 270, 113, 23);
		add(btnCheckInA);
		
		txtKeyNotFound = new JTextField();
		txtKeyNotFound.setEnabled(false);
		txtKeyNotFound.setEditable(false);
		txtKeyNotFound.setText("key not found");
		txtKeyNotFound.setBounds(28, 117, 186, 20);
		add(txtKeyNotFound);
		txtKeyNotFound.setColumns(10);

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

		DatabaseConnection database = new DatabaseConnection();
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
}
