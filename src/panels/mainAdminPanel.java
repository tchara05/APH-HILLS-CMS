package panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class mainAdminPanel extends JPanel {
	
	private static JPanel adminMainPanel;
	
	
	
	public mainAdminPanel() {	
		adminMainPanel = new JPanel();
		
		//Class Panel //
		JPanel  classPanel = new classPanel();
		//Parcel Panel //
		JPanel parcelPanel = new parcelPanel();
		
		
		// Positioning //
		GroupLayout groupLayout = new GroupLayout(adminMainPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(classPanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addComponent(parcelPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(classPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(parcelPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		adminMainPanel.setLayout(groupLayout);
		
	}
	
	
	
	
	public static JPanel createAdminMenu(){
		new mainAdminPanel();
		return adminMainPanel;
		
	}
	
		
	
}
