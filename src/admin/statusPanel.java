package admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Query;

@SuppressWarnings("serial")
public class statusPanel extends JPanel {
	
	// Input fields //
	public static JTextField txtStatusID;
	public static  JTextField txtStatus;
	public static JComboBox<String> AllStatus;
	
	
	public statusPanel() {
		
		// Labels //
		JLabel lblStatusId = new JLabel("Status ID:");
		lblStatusId.setBounds(21, 62, 61, 16);
		JLabel lblStatusName = new JLabel("Status:");
		lblStatusName.setBounds(21, 98, 43, 16);
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(21, 26, 43, 16);
		
		// Drop Down //
		AllStatus = new JComboBox<String>();
		AllStatus.setBounds(100, 22, 267, 27);
		ListManager.setUpTwoColumnsList(AllStatus, Query.STATUS_NO_NAME);
		
		// Buttons //
		JButton btnAddStatus = new JButton("Add Status");
		btnAddStatus.setBounds(433, 57, 123, 29);
		JButton btnDeleteStatus = new JButton("Delete Status");
		btnDeleteStatus.setBounds(433, 92, 123, 29);
		JButton btnEditStatus = new JButton("Edit Status");
		btnEditStatus.setBounds(433, 21, 123, 29);
		
		// Text Boxes //
		txtStatusID = new JTextField();
		txtStatusID.setBounds(100, 56, 267, 28);
		txtStatusID.setEditable(false);
		txtStatusID.setColumns(10);
		txtStatus = new JTextField();
		txtStatus.setBounds(100, 92, 267, 28);
		txtStatus.setColumns(10);
		setLayout(null);
		add(lblStatus);
		add(lblStatusId);
		add(lblStatusName);
		add(AllStatus);
		add(txtStatusID);
		add(txtStatus);
		add(btnAddStatus);
		add(btnDeleteStatus);
		add(btnEditStatus);
		setID();
	}
	
	private void setID(){
		DatabaseConnection database = new DatabaseConnection();
		try{
			ResultSet t=database.getStatement().executeQuery(Query.STATUS_NO);
			if (t.next()){
				txtStatusID.setText((t.getInt(1)+1)+"");
			}
		}catch (SQLException e){
			System.out.println("Class Txt Id");
			e.printStackTrace();
		}finally{
			database.closeDatabaseConnection();
		}
}	
}
