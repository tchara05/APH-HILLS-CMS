package security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import extras.DatabaseConnection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Securitymenu extends JPanel {

	public static JTextField txtSearchKey;
	public static JComboBox<String> AllContracts;
	public static JTextField txtShowIfFound;
	public static DatabaseConnection database;
	private static CheckIn checkIn;
	private static CheckOut checkOut;
	private static SecurityForm securityForm;
	private static SecuritySearchKey search;
	private static JPanel panel;
	
	public Securitymenu() {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		
		checkOut = new CheckOut();
		checkIn = new CheckIn();
		database = new DatabaseConnection();
		panel=new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		securityForm = new SecurityForm();
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(165, 198, 243));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(517, 22, 188, 304);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(10, 55, 168, 129);
		panel_2.add(lblimage);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnExit.setBounds(35, 248, 117, 34);
		panel_2.add(btnExit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(165, 198, 243));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(28, 22, 461, 304);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
				JLabel lblSearch = new JLabel("Search Contract By KeyID:");
				lblSearch.setBounds(30, 22, 176, 23);
				panel_3.add(lblSearch);
				lblSearch.setFont(new Font("Calibri", Font.PLAIN, 12));
				
						AllContracts = new JComboBox<String>();
						AllContracts.setBounds(30, 92, 176, 33);
						panel_3.add(AllContracts);
						
								JButton btnSearchKey = new JButton("Search");
								btnSearchKey.setBounds(245, 49, 184, 33);
								panel_3.add(btnSearchKey);
								btnSearchKey.setFont(new Font("Calibri", Font.PLAIN, 12));
								
								txtShowIfFound = new JTextField();
								txtShowIfFound.setBounds(245, 93, 184, 32);
								panel_3.add(txtShowIfFound);
								txtShowIfFound.setFont(new Font("Calibri", Font.PLAIN, 12));
								txtShowIfFound.setEnabled(false);
								txtShowIfFound.setEditable(false);
								txtShowIfFound.setText("Key not Found");
								txtShowIfFound.setColumns(10);
								
										txtSearchKey = new JTextField();
										txtSearchKey.setBounds(30, 49, 176, 32);
										panel_3.add(txtSearchKey);
										txtSearchKey.setColumns(10);
										

										JButton btnAddContract = new JButton("Add New Key Contract");
										btnAddContract.setBounds(245, 162, 184, 33);
										panel_3.add(btnAddContract);
										btnAddContract.setFont(new Font("Calibri", Font.PLAIN, 12));
										
												JButton btnDeleteContract = new JButton("Delete Key Contract");
												btnDeleteContract.setBounds(244, 208, 185, 33);
												panel_3.add(btnDeleteContract);
												btnDeleteContract.setFont(new Font("Calibri", Font.PLAIN, 12));
												
														JButton btnEditContract = new JButton("Edit/View Key Contract");
														btnEditContract.setBounds(245, 252, 184, 33);
														panel_3.add(btnEditContract);
														btnEditContract.setFont(new Font("Calibri", Font.PLAIN, 12));
														
														JButton btnCheckOut = new JButton("Check out a Key");
														btnCheckOut.setBounds(30, 208, 134, 33);
														panel_3.add(btnCheckOut);
														btnCheckOut.setFont(new Font("Calibri", Font.PLAIN, 12));
														
														JButton btnCheckIn = new JButton("Check in a Key");
														btnCheckIn.setBounds(30, 252, 134, 33);
														panel_3.add(btnCheckIn);
														btnCheckIn.setFont(new Font("Calibri", Font.PLAIN, 12));
														btnCheckIn.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																CheckIn.frmCheckIn.setVisible(true);
															}
														});
														btnCheckOut.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																checkOut.frmService.setVisible(true);
															}
														});
														btnEditContract.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
															}
														});
												btnDeleteContract.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														SecurityDeleteButton.start();
													}
												});
										btnAddContract.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												securityForm.frame.setVisible(true);
											}
										});
										
										JPanel panel_4 = new JPanel();
										panel_4.setBackground(new Color(255, 255, 255));
										panel_4.setBorder(new LineBorder(new Color(51, 51, 153), 3));
										panel_4.setBounds(0, 0, 735, 351);
										panel.add(panel_4);
								btnSearchKey.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										new SecuritySearchKey().start();
									}
								});
		
		
		
		setUpContractList();
	}
	
	

	public static Object getSelectedContract() {
		return AllContracts.getSelectedItem();
	}

	public static void DeleteKeyContractFromList() {

		if (AllContracts.getItemCount() > 0) {
			AllContracts.removeItemAt((AllContracts.getSelectedIndex()));
		}
	}

	public static void setUpContractList() {

		
		Statement stment = database.getStatement();

		ResultSet rset = null;

		try {
			rset = stment.executeQuery("SELECT keyID FROM KeyContract ORDER BY keyID");

			while (rset.next() && rset.getString(1) != null) {
				AllContracts.addItem(rset.getString(1));
			}
			

		} catch (SQLException e1) {
			System.out.println("Can execute the query in setUpContractList");
			e1.printStackTrace();
		}
		try {
		} catch (Exception e) {
			System.out.println("Empty Contract List");
			e.printStackTrace();
		}
	}
	
	public static JPanel createSecurityMenu(){
		new Securitymenu();
		return panel ;
	}
}
