package userMenus;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;


public class accountantPanel extends JPanel {
	
	private static JPanel accountantMenu;
	
	

	/**
	 * Create the panel.
	 */
	public accountantPanel() {
		
		JButton btnSendProformaDocumet = new JButton("Send Proforma");
		
		JButton btnSendInvoiceTo = new JButton("Send Invoice");
		JButton btnSend = new JButton("Send Receipt");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSend, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSendInvoiceTo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSendProformaDocumet, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(273, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(btnSendProformaDocumet)
					.addGap(18)
					.addComponent(btnSendInvoiceTo)
					.addGap(18)
					.addComponent(btnSend)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	
	public static JPanel createAccountantMenu(){
		accountantMenu = new accountantPanel();
		return accountantMenu;
	}
}
