package logistics;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class accountantPanel{
	
	private static JPanel accountantMenu;
	public static  JComboBox<String> AllCustomers;
	private static JComboBox<String> AllCustomers1;
	
	private JFrame fileChooser;
	public static File file;

	// Buttons //
	private JButton btnExportProforms;
	private JButton btnSendInvoiceTo;
	private	JButton btnSendReceiptTo;
	private JButton btnExportExcel; 
	private JButton btnImportExcel;
	private JPanel panel;
	private JPanel panel_1;
	private JComboBox<String> Allcustomer2;
	
	public accountantPanel() {
		
		accountantMenu = new JPanel();
		accountantMenu.setBackground(new Color(255, 255, 255));
		accountantMenu.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		accountantMenu.setLayout(null);
		
		fileChooser = new FileChooser();
		fileChooser.setVisible(false);
	    
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
	    btnExportProforms.setBounds(391, 40, 149, 33);
	    panel_1.add(btnExportProforms);
	    btnExportProforms.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnSendInvoiceTo = new JButton("Send Invoice to");
	    btnSendInvoiceTo.setBounds(55, 227, 161, 33);
	    panel_1.add(btnSendInvoiceTo);
	    btnSendInvoiceTo.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    AllCustomers1 = new JComboBox<String>();
	    AllCustomers1.setBounds(240, 230, 227, 27);
	    panel_1.add(AllCustomers1);
	   ListManager.setUpThreeList(AllCustomers1, Query.PROFORMA_CUSTOMERS);
	    btnExportExcel = new JButton("Export Excel File");
	    btnExportExcel.setBounds(55, 40, 149, 33);
	    panel_1.add(btnExportExcel);
	    btnExportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnImportExcel = new JButton("Import Excel File");
	    btnImportExcel.setBounds(55, 100, 149, 33);
	    panel_1.add(btnImportExcel);
	    btnImportExcel.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    btnSendReceiptTo = new JButton("Send Receipt to");
	    
	    btnSendReceiptTo.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnSendReceiptTo.setBounds(55, 286, 161, 33);
	    panel_1.add(btnSendReceiptTo);
	    
	    AllCustomers = new JComboBox<String>();
	    AllCustomers.setBounds(240, 230, 227, 27);
	    panel_1.add(AllCustomers);
	   ListManager.setUpThreeList(AllCustomers, Query.PROFORMA_CUSTOMERS);
	  
	    
	    Allcustomer2 = new JComboBox<String>();
	    Allcustomer2.setBounds(240, 281, 227, 27);
	    panel_1.add(Allcustomer2);
	    ListManager.setUpThreeList(Allcustomer2, Query.PROFORMA_CUSTOMERS);
	    
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
				fileChooser.setVisible(true);
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
		
		btnSendReceiptTo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new ExportRecipt().start();
	    	}
	    });
	}
	
	
	public static JPanel createAccountantMenu(){
		new accountantPanel();
		return accountantMenu;
	}
}
