package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
import extras.Query;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class parcelPanel extends JPanel {
	
	// TxtBoxes //
	public static JTextField txtParceID;
	public static JTextField txtParcelName;
	// Dropdown list //
	public static JComboBox<String> AllParcels;
	
	// Buttons //
	private	JButton btnEditParcel ;
	private JButton btnAddParcel ;
	private JButton btnDeleteParcel;

	public parcelPanel() {
		
		// Labels //
		JLabel lblParcel = new JLabel("Parcel:");
		lblParcel.setBounds(26, 38, 41, 16);
		JLabel lblParcelId = new JLabel("Parcel ID:");
		lblParcelId.setBounds(26, 80, 59, 16);
		JLabel lblPercelName = new JLabel("Percel Name:");
		lblPercelName.setBounds(26, 122, 81, 16);
		
		// DropDownList //
		AllParcels = new JComboBox<String>();
		AllParcels.setBounds(119, 34, 278, 27);
		ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
		// TextBoxes //
		txtParceID = new JTextField();
		txtParceID.setBounds(119, 74, 278, 28);
		txtParceID.setEditable(false);
		txtParceID.setColumns(10);
		txtParcelName = new JTextField();
		txtParcelName.setBounds(119, 116, 278, 28);
		txtParcelName.setColumns(10);
		
		//Buttons //
		 btnEditParcel = new JButton("Edit Parcel");
		 btnEditParcel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new btnEdit().start();
		 	}
		 });
		 btnEditParcel.setBounds(403, 33, 125, 29);
		 btnAddParcel = new JButton("Add Parcel");
		 btnAddParcel.setBounds(403, 75, 125, 29);
		 btnDeleteParcel = new JButton("Delete Parcel");
		 btnDeleteParcel.setBounds(403, 117, 125, 29);
		setLayout(null);
		add(lblPercelName);
		add(txtParcelName);
		add(lblParcelId);
		add(lblParcel);
		add(txtParceID);
		add(AllParcels);
		add(btnDeleteParcel);
		add(btnAddParcel);
		add(btnEditParcel);
		setID();
	}
	
	private void setID(){
		
		DatabaseConnection database = new DatabaseConnection();
		try{
			ResultSet t=database.getStatement().executeQuery(Query.PARCEL_NO);
			if (t.next()){
				txtParceID.setText((t.getInt(1)+1)+"");
			}
		}catch (SQLException e){
			System.out.println("Class Txt Id");
			e.printStackTrace();
		}finally{
			database.closeDatabaseConnection();
		}
}	
	
	@SuppressWarnings("unused")
	private class btnEdit extends Thread{
		
		public void run(){
				int response = JOptionPane.showConfirmDialog(null,
						"Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					
					   String input = JOptionPane.showInputDialog(null, "Enter Parcel Name:", "Dialog for Input",
						        JOptionPane.WARNING_MESSAGE);
						while (!Checker.checkEmpty(input)){
							input = JOptionPane.showInputDialog(null, "Enter Parcel Name:", "Dialog for Input",
							        JOptionPane.WARNING_MESSAGE);
						}
						    
						    
					DatabaseConnection database = new DatabaseConnection();
				
					String c = (String) AllParcels.getSelectedItem();
					int index = AllParcels.getSelectedIndex();
					AllParcels.removeItemAt(index);
					String[] clas = ListManager.SplitTwoItem(c);
					try {
						database.getStatement().executeUpdate(
								"Update Parcel SET parcelName='" + input
										+ "' WHERE parcleNo='" + clas[0] + "'");
								
						Messages.showWarningMessage("Restart The System!");
					} catch (SQLException e) {
						System.out.println("Update Class Query");
						e.printStackTrace();
					}finally{
						database.closeDatabaseConnection();
					}
				}
				
			
		}
		
		
	}
	

	
}
