package panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class parcelPanel extends JPanel {
	
	
	// Box //
	private static JPanel panel;
	
	// TxtBoxes //
	public static JTextField txtParceID;
	public static JTextField txtParcelName;
	
	// Dropdown list //
	public static JComboBox comboBox;
	
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
		comboBox = new JComboBox<String>();
		/** We need List Manager Here **/
		
		
		panel=new JPanel();
		
		
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
		 GroupLayout groupLayout = new GroupLayout(panel);
		 groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPercelName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtParcelName, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblParcelId)
								.addComponent(lblParcel))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtParceID, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 270, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDeleteParcel)
						.addComponent(btnAddParcel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnEditParcel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout);

	}
	

}
