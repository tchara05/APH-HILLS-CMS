package logistics;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class accountantPanel extends JPanel {
	


	private static JPanel accountantMenu;
	
	public static  JComboBox<String> AllCustomers;

	// Buttons //
	private JButton btnSendProformaDocumet;
	private JButton btnSendInvoiceTo;
	
	
	public accountantPanel() {
		setBorder(new LineBorder(new Color(0, 0, 128)));
		
	    btnSendProformaDocumet = new JButton("Export All Proformas");
	
		btnSendProformaDocumet.setBounds(262, 234, 162, 27);
		
		JButton btnSendInvoiceTo = new JButton("Send Invoice to");
		btnSendInvoiceTo.setBounds(262, 189, 162, 27);
		
	    AllCustomers = new JComboBox<String>();
		AllCustomers.setBounds(25, 189, 227, 27);
		setLayout(null);
		add(btnSendInvoiceTo);
		add(btnSendProformaDocumet);
		add(AllCustomers);
		
		JButton btnExportExcel = new JButton("Export Excel File");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExportExcel.setBounds(25, 54, 162, 27);
		add(btnExportExcel);
		
		JButton btnImportProforma = new JButton("Import Proforma");
		btnImportProforma.setBounds(221, 54, 162, 27);
		add(btnImportProforma);
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
