package admin;

import java.sql.SQLException;

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
import extras.ListManager;
import extras.Messages;

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
		JLabel lblParcelId = new JLabel("Parcel ID:");
		JLabel lblPercelName = new JLabel("Percel Name:");
		
		// DropDownList //
		AllParcels = new JComboBox<String>();
		
		// TextBoxes //
		txtParceID = new JTextField();
		txtParceID.setEditable(false);
		txtParceID.setColumns(10);
		txtParcelName = new JTextField();
		txtParcelName.setColumns(10);
		
		//Buttons //
		 btnEditParcel = new JButton("Edit Parcel");
		 btnAddParcel = new JButton("Add Parcel");
		 btnDeleteParcel = new JButton("Delete Parcel");
		
		 // Positions //
		 GroupLayout groupLayout = new GroupLayout(this);
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addGap(26)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addPreferredGap(ComponentPlacement.RELATED)
		 					.addComponent(lblPercelName)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addComponent(txtParcelName, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 						.addComponent(lblParcelId)
		 						.addComponent(lblParcel))
		 					.addGap(34)
		 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 						.addComponent(txtParceID, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
		 						.addComponent(AllParcels, 0, 270, Short.MAX_VALUE))))
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
		 				.addComponent(btnDeleteParcel)
		 				.addComponent(btnAddParcel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(btnEditParcel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
		 			.addContainerGap())
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addGap(33)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(btnEditParcel)
		 				.addComponent(lblParcel))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblParcelId)
		 				.addComponent(txtParceID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(btnAddParcel))
		 			.addGap(12)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(txtParcelName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblPercelName)
		 				.addComponent(btnDeleteParcel))
		 			.addContainerGap(32, Short.MAX_VALUE))
		 );
		setLayout(groupLayout);
	}
	
	@SuppressWarnings("unused")
	private class btnEdit extends Thread{
		
		
		
		
		public void run(){
				
				int response = JOptionPane.showConfirmDialog(null,
						"Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				String name=Checker.clearString(txtParcelName.getText());
				if (response == JOptionPane.YES_OPTION && !name.equals("")) {
					
				
					String c = (String) AllParcels.getSelectedItem();
					int index = AllParcels.getSelectedIndex();
					AllParcels.removeItemAt(index);
					String[] clas = ListManager.SplitTwoItem(c);
					try {
						mainAdminPanel.database.getStatement().executeUpdate(
								"Update Class SET className='" + txtParcelName.getText()
										+ "' WHERE propertyClassNo='" + clas[0] + "'");
						AllParcels.insertItemAt(clas[0]+" "+name, index);
						txtParcelName.setText("");
					} catch (SQLException e) {
						System.out.println("Update Class Query");
						e.printStackTrace();
					}
				}else{
					Messages.showWarningMessage("Empty Class Name");
				}
			
		}
		
		
	}
	

}
