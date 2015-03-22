package logistics;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class accountantPanel extends JPanel {
	
	private static JPanel accountantMenu;
	
	public static  JComboBox<String> AllCustomers;

	// Buttons //
	private JButton btnSendProformaDocumet;
	private JButton btnSendInvoiceTo;
	
	
	public accountantPanel() {
		
	    btnSendProformaDocumet = new JButton("Export All Proformas");
	
		btnSendProformaDocumet.setBounds(21, 62, 162, 27);
		
		JButton btnSendInvoiceTo = new JButton("Send Invoice to");
		btnSendInvoiceTo.setBounds(21, 121, 162, 27);
		
	    AllCustomers = new JComboBox<String>();
		AllCustomers.setBounds(241, 122, 227, 27);
		setLayout(null);
		add(btnSendInvoiceTo);
		add(btnSendProformaDocumet);
		add(AllCustomers);
		addButtonsFuctionalities();
	}
	
	
	public void addButtonsFuctionalities(){
		
		btnSendProformaDocumet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ExportProformaButton().start();
			}
		});
	}
	public static JPanel createAccountantMenu(){
		accountantMenu = new accountantPanel();
		return accountantMenu;
	}
}
