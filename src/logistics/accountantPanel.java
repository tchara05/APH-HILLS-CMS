package logistics;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import extras.ListManager;
import extras.Query;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class accountantPanel{
	


	private static JPanel accountantMenu;
	
	public static  JComboBox<String> AllCustomers;

	// Buttons //
	private JButton btnExportProforms;
	private JButton btnSendInvoiceTo;
	private JButton btnExportExcel; 
	private JButton btnImportExcel;
	private JPanel panel;
	
	public accountantPanel() {
		
		accountantMenu = new JPanel();
		accountantMenu.setBackground(new Color(255, 255, 255));
		accountantMenu.setBorder(new LineBorder(new Color(0, 0, 128)));
		accountantMenu.setLayout(null);
	    
	    panel = new JPanel();
	    panel.setBackground(new Color(173, 216, 230));
	    panel.setBounds(221, 142, 443, 248);
	    accountantMenu.add(panel);
	    panel.setLayout(null);
		
		// Buttons //
	    btnExportProforms = new JButton("Export All Proformas");
	    btnExportProforms.setBounds(17, 167, 149, 33);
	    panel.add(btnExportProforms);
	    btnExportProforms.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnSendInvoiceTo = new JButton("Send Invoice to");
	    btnSendInvoiceTo.setBounds(17, 122, 149, 33);
	    panel.add(btnSendInvoiceTo);
	    btnSendInvoiceTo.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    AllCustomers = new JComboBox<String>();
	    AllCustomers.setBounds(196, 170, 227, 27);
	    panel.add(AllCustomers);
	    ListManager.setUpThreeList(AllCustomers, Query.PROFORMA_CUSTOMERS);
	    btnExportExcel = new JButton("Export Excel File");
	    btnExportExcel.setBounds(17, 77, 149, 33);
	    panel.add(btnExportExcel);
	    btnExportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnImportExcel = new JButton("Import Excel File");
	    btnImportExcel.setBounds(17, 27, 149, 33);
	    panel.add(btnImportExcel);
	    btnImportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
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
		
		btnExportProforms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ExportProformaBtn().start();
			}
		});
		
		btnSendInvoiceTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ExportInvoiceBtn().start();
			}
		});
	}
	
	
	public static JPanel createAccountantMenu(){
		new accountantPanel();
		return accountantMenu;
	}
}
