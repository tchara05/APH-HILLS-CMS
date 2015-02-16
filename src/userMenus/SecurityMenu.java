package userMenus;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class SecurityMenu extends JPanel {
	
	private JTextField textField;
	private static JComboBox<String> AllContracts;

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
		
		JButton btnNewButton_2 = new JButton("Show Report");
		btnNewButton_2.setBounds(342, 184, 148, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Search Contract By KeyID:");
		lblNewLabel.setBounds(28, 240, 186, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(28, 264, 186, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBounds(224, 263, 89, 23);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Key Contracts:");
		lblNewLabel_1.setBounds(28, 62, 113, 14);
		add(lblNewLabel_1);
		
		AllContracts = new JComboBox<String>();
		AllContracts.setBounds(28, 83, 285, 20);
		add(AllContracts);
		
		
	}
	public static Object getSelectedContract(){
		return AllContracts.getSelectedItem();
	}
	
	public static void DeletePropertyFromList(){
		if (AllContracts.getItemCount()>0){
				AllContracts.removeItemAt((AllContracts.getSelectedIndex()));
		}
	}
	
	
}
