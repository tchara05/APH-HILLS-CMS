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
		parPanel.AllParcels.setBounds(92, 6, 215, 27);
		parPanel.setBounds(16, 201, 549, 157);
		clasPanel = new classPanel();
		clasPanel.setBounds(16,17,549,157);
		adminMainPanel.setLayout(null);
		adminMainPanel.add(parPanel);
		adminMainPanel.add(clasPanel);
		statPanel = new statusPanel();
		statPanel.txtStatusName.setLocation(95, 44);
		statPanel.AllStatus.setLocation(95, 6);
		statPanel.setBounds(16, 380, 549, 134);
		adminMainPanel.add(statPanel);
	}
	
	
	public static JPanel createAdminMenu(){
		new mainAdminPanel();
		return adminMainPanel;
	}
}
