package admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import extras.DatabaseConnection;

@SuppressWarnings("serial")
public class mainAdminPanel extends JPanel {
	
	private static JPanel adminMainPanel;
	private static parcelPanel parPanel;
	private static statusPanel statPanel;
	private static classPanel clasPanel;
	
	public mainAdminPanel() {	
		adminMainPanel = new JPanel();
		parPanel = new parcelPanel();
		parPanel.setBounds(6, 176, 549, 152);
		statPanel = new statusPanel();
		statPanel.setBounds(6, 351, 549, 134);
		clasPanel = new classPanel();
		clasPanel.setBounds(6,351,549,132);
		adminMainPanel.setLayout(null);
		adminMainPanel.add(parPanel);
		adminMainPanel.add(statPanel);
	}
	
	
	public static JPanel createAdminMenu(){
		new mainAdminPanel();
		return adminMainPanel;
	}
}
