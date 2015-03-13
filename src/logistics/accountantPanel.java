package logistics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;


public class accountantPanel extends JPanel {
	
	private static JPanel accountantMenu;
	
	

	/**
	 * Create the panel.
	 */
	public accountantPanel() {
		
		JButton btnSendProformaDocumet = new JButton("Send All Proformas");
		
		JButton btnSendInvoiceTo = new JButton("Send Invoice to");
		
		JComboBox AllCustomers = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSendInvoiceTo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSendProformaDocumet, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(AllCustomers, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(192))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(btnSendProformaDocumet)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSendInvoiceTo)
						.addComponent(AllCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(246, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	
	public static JPanel createAccountantMenu(){
		accountantMenu = new accountantPanel();
		return accountantMenu;
	}
}
