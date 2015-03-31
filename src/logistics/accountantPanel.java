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

public class accountantPanel{
	


	private static JPanel accountantMenu;
	
	public static  JComboBox<String> AllCustomers;

	// Buttons //
	private JButton btnSendProformaDocumet;
	private JButton btnSendInvoiceTo;
	private JButton btnExportExcel; 
	private JButton btnImportExcel; 
	
	
	public accountantPanel() {
		
		accountantMenu = new JPanel();
		accountantMenu.setBorder(new LineBorder(new Color(0, 0, 128)));
		
	    btnSendProformaDocumet = new JButton("Export All Proformas");
	    btnSendProformaDocumet.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    	}
	    });
	
		btnSendProformaDocumet.setBounds(25, 151, 162, 27);
		
		JButton btnSendInvoiceTo = new JButton("Send Invoice to");
		btnSendInvoiceTo.setBounds(262, 189, 162, 27);
		
	    AllCustomers = new JComboBox<String>();
		AllCustomers.setBounds(197, 244, 227, 27);
		accountantMenu.setLayout(null);
		accountantMenu.add(btnSendInvoiceTo);
		accountantMenu.add(btnSendProformaDocumet);
		accountantMenu.add(AllCustomers);
		
		 btnExportExcel = new JButton("Export Excel File");
		
		btnExportExcel.setBounds(25, 54, 162, 27);
		accountantMenu.add(btnExportExcel);
		
		btnImportExcel = new JButton("Import Excel File");

		btnImportExcel.setBounds(25, 102, 162, 27);
		accountantMenu.add(btnImportExcel);
		addButtonsFuctionalities();
	}
	
	
	public void addButtonsFuctionalities(){
		
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExportExcelBtn().start();
			}
		});
		
		btnImportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReadExcelBtn().start();
			}
		});
		
		btnSendProformaDocumet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ExportProformaBtn().start();
			}
		});
	}
	
	
	public static JPanel createAccountantMenu(){
		new accountantPanel();
		return accountantMenu;
	}
}
