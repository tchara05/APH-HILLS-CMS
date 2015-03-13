package admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class statusPanel extends JPanel {
	
	// Input fields //
	public static JTextField txtStatusID;
	public static  JTextField txtStatus;
	public static JComboBox AllStatus;


	public statusPanel() {
		
		// Labels //
		JLabel lblStatusId = new JLabel("Status ID:");
		JLabel lblStatusName = new JLabel("Status:");
		JLabel lblStatus = new JLabel("Status:");
		
		// Drop Down //
		AllStatus = new JComboBox();
		
		// Buttons //
		JButton btnAddStatus = new JButton("Add Status");
		JButton btnDeleteStatus = new JButton("Delete Status");
		JButton btnEditStatus = new JButton("Edit Status");
		
		// Text Boxes //
		txtStatusID = new JTextField();
		txtStatusID.setEditable(false);
		txtStatusID.setColumns(10);
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStatus)
						.addComponent(lblStatusId)
						.addComponent(lblStatusName))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(AllStatus, 0, 257, Short.MAX_VALUE)
						.addComponent(txtStatusID, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(txtStatus, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAddStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDeleteStatus, 0, 0, Short.MAX_VALUE)
						.addComponent(btnEditStatus, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(AllStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditStatus))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusId)
						.addComponent(txtStatusID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddStatus))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatusName)
						.addComponent(btnDeleteStatus))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
