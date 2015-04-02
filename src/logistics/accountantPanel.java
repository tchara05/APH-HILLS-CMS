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
	private JPanel panel_1;
	
	public accountantPanel() {
		
		accountantMenu = new JPanel();
		accountantMenu.setBackground(new Color(255, 255, 255));
		accountantMenu.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		accountantMenu.setLayout(null);
	    
	    panel = new JPanel();
	    panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "LOGISTIC DEPARTMENT", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	    panel.setBackground(Color.WHITE);
	    panel.setBounds(22, 21, 792, 473);
	    accountantMenu.add(panel);
	    panel.setLayout(null);
	    
	    panel_1 = new JPanel();
	    panel_1.setBackground(new Color(173, 216, 230));
	    panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
	    panel_1.setBounds(107, 68, 582, 344);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
		
		// Buttons //
	    btnExportProforms = new JButton("Export All Proformas");
	    btnExportProforms.setBounds(86, 223, 149, 33);
	    panel_1.add(btnExportProforms);
	    btnExportProforms.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnSendInvoiceTo = new JButton("Send Invoice to");
	    btnSendInvoiceTo.setBounds(86, 178, 149, 33);
	    panel_1.add(btnSendInvoiceTo);
	    btnSendInvoiceTo.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    AllCustomers = new JComboBox<String>();
	    AllCustomers.setBounds(265, 226, 227, 27);
	    panel_1.add(AllCustomers);
	    ListManager.setUpThreeList(AllCustomers, Query.PROFORMA_CUSTOMERS);
	    btnExportExcel = new JButton("Export Excel File");
	    btnExportExcel.setBounds(86, 133, 149, 33);
	    panel_1.add(btnExportExcel);
	    btnExportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnImportExcel = new JButton("Import Excel File");
	    btnImportExcel.setBounds(86, 83, 149, 33);
	    panel_1.add(btnImportExcel);
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
