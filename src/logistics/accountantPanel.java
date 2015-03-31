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

public class accountantPanel{
	


	private static JPanel accountantMenu;
	
	public static  JComboBox<String> AllCustomers;

	// Buttons //
	private JButton btnExportProforms;
	private JButton btnSendInvoiceTo;
	private JButton btnExportExcel; 
	private JButton btnImportExcel;
	
	public accountantPanel() {
		
		accountantMenu = new JPanel();
		accountantMenu.setBorder(new LineBorder(new Color(0, 0, 128)));
		
		// Buttons //
	    btnExportProforms = new JButton("Export All Proformas");
	    btnExportProforms.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnExportProforms.setBounds(25, 151, 149, 33);
		btnSendInvoiceTo = new JButton("Send Invoice to");
		btnSendInvoiceTo.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSendInvoiceTo.setBounds(25, 201, 149, 33);
		btnExportExcel = new JButton("Export Excel File");
		btnExportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnExportExcel.setBounds(25, 54, 149, 33);
		btnImportExcel = new JButton("Import Excel File");
		btnImportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnImportExcel.setBounds(25, 102, 149, 33);
		
	    AllCustomers = new JComboBox<String>();
	    AllCustomers.setBounds(254, 201, 227, 27);
		ListManager.setUpThreeList(AllCustomers, Query.PROFORMA_CUSTOMERS);
		accountantMenu.setLayout(null);
		accountantMenu.add(btnSendInvoiceTo);
		accountantMenu.add(btnExportProforms);
		accountantMenu.add(AllCustomers);
		accountantMenu.add(btnExportExcel);
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
