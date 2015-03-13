package admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class mainAdminPanel extends JPanel {
	
	private static JPanel adminMainPanel;
	private static classPanel  clPanel;
	private static parcelPanel parPanel;
	private static statusPanel statPanel;

	
	public mainAdminPanel() {	
		adminMainPanel = new JPanel();
		
		//Class Panel //
		clPanel = new classPanel();
		parPanel = new parcelPanel();
		statPanel = new statusPanel();
	
		// Positioning //
		GroupLayout groupLayout = new GroupLayout(adminMainPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(parPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
								.addComponent(clPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
							.addContainerGap(129, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(statPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(39))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(clPanel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(parPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		adminMainPanel.setLayout(groupLayout);
		
	}
	
	
	public static JPanel createAdminMenu(){
		new mainAdminPanel();
		return adminMainPanel;
		
	}
}
