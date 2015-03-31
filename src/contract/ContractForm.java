package contract;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import extras.Checker;
import extras.ListManager;
import extras.Messages;
import extras.Query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;

import userMenus.LogIn;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.Icon;


public class ContractForm {

	private static JFrame frame;
	
	// Text Boxes: //
	public static JTextField txtContractID;
	public static JTextField txtMail;
	public static JTextField txtContactPhone;
	public static JTextField txtMobilePhone;
	public static JTextField txtSharing;
	public static JTextField txtPlotID;
	public static JTextField txtPlotName;
	private static JTextField txtPlotNumber;
	
	// Check Box: //
	public static JCheckBox chckActive;
	
	// Variables: //
	public static int totalShare=0;
	public static boolean edit = false;
	
	//List for scroll; //
	public static DefaultListModel<String> AllCustomers;
	public static DefaultListModel<String> AllOwners;
	public JList<String> Owners;
	public JList<String> Customers;

	// Buttons: //
	private JButton btnRight;
	private JButton btnLeft;
	private JButton btnBack;
	private JButton btnSave;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		
					@SuppressWarnings("unused")
					ContractForm window = new ContractForm();
					ContractForm.setVisible(true);		
	}

	public ContractForm() {
		initialize();
	}
	private void initialize() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// Scroll Panels: //
		JScrollPane CustomersPane = new JScrollPane();
		CustomersPane.setBounds(7, 29, 194, 245);
		JScrollPane OwnerPane = new JScrollPane();
		OwnerPane.setBounds(382, 29, 198, 245);
		
		// Panels: //
		JPanel createContPanel = new JPanel();
		createContPanel.setBounds(28, 125, 590, 370);
		createContPanel.setBackground(new Color(173, 216, 230));
		createContPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(106, 90, 850, 520);
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Create New Contract", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		// Buttons: //
		btnRight = new JButton(">>");
		btnRight.setBounds(262, 46, 86, 29);
		btnLeft = new JButton("<<");
		btnLeft.setBounds(262, 81, 86, 29);
		
		
		
		JLabel label_3 = new JLabel("Primary Email:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_3.setBounds(7, 296, 89, 16);
		JLabel label_4 = new JLabel("Contact Phone:");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_4.setBounds(147, 296, 95, 16);
		JLabel label_5 = new JLabel("Mobile Phone:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_5.setBounds(299, 296, 88, 16);
		JLabel label_6 = new JLabel("Percentage:");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_6.setBounds(226, 134, 72, 16);
		JLabel label_7 = new JLabel("%");
		label_7.setBounds(367, 134, 9, 16);
		JLabel label_8 = new JLabel("Customer:");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_8.setBounds(7, 7, 65, 16);

	
		txtMail = new JTextField();
		txtMail.setBounds(7, 320, 128, 28);
		txtMail.setEditable(false);
		txtMail.setColumns(10);
		
		txtContactPhone = new JTextField();
		txtContactPhone.setBounds(147, 320, 134, 28);
		txtContactPhone.setEditable(false);
		txtContactPhone.setColumns(10);
		
		txtMobilePhone = new JTextField();
		txtMobilePhone.setBounds(299, 320, 134, 28);
		txtMobilePhone.setEditable(false);
		txtMobilePhone.setColumns(10);
		
		
		//Model List Initialize //
		AllCustomers = new DefaultListModel<String>();
		AllOwners = new DefaultListModel<String>();
		ListManager.SetUpThreeList(AllCustomers, Query.CUSTOMER_NO_FNAME_LNAME);
		
		 Owners=new JList<String>(AllOwners); 
		 Customers= new JList<String>(AllCustomers);
		
		 // JList //
		Customers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String customer =AllCustomers.get(Customers.getSelectedIndex());
				setTextFields(customer);
				
			}
		});
		frame.getContentPane().setLayout(null);

	
		// Variables //
		txtSharing = new JTextField();
		txtSharing.setBounds(299, 128, 62, 28);
		txtSharing.setColumns(5);
		
	    chckActive = new JCheckBox("Active");
	    chckActive.setFont(new Font("Calibri", Font.PLAIN, 14));
	    chckActive.setBackground(new Color(173, 216, 230));
	    chckActive.setBounds(290, 188, 71, 23);
		chckActive.setSelected(true);
		
		OwnerPane.setViewportView(Owners);
		CustomersPane.setViewportView(Customers);
		createContPanel.setLayout(null);
		createContPanel.add(CustomersPane);
		createContPanel.add(btnRight);
		createContPanel.add(btnLeft);
		createContPanel.add(chckActive);
		createContPanel.add(label_6);
		createContPanel.add(txtSharing);
		createContPanel.add(label_7);
		createContPanel.add(OwnerPane);
		createContPanel.add(label_8);
		createContPanel.add(txtMail);
		createContPanel.add(label_4);
		createContPanel.add(txtContactPhone);
		createContPanel.add(label_5);
		createContPanel.add(txtMobilePhone);
		createContPanel.add(label_3);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.add(createContPanel);
		
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		InfoPanel.setBounds(28, 28, 590, 85);
		InfoPanel.setBackground(new Color(173, 216, 230));
		mainPanel.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		// Labels For Panel 1: //
		JLabel label_9 = new JLabel("Contract ID:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_9.setBounds(17, 12, 76, 16);
		InfoPanel.add(label_9);
		

		// Text Boxes For Panel 1: //
		txtContractID = new JTextField();
		txtContractID.setBounds(105, 6, 134, 28);
		InfoPanel.add(txtContractID);
		txtContractID.setEditable(false);
		txtContractID.setColumns(10);
		JLabel lblPlotNumberr = new JLabel("Plot Number:");
		lblPlotNumberr.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPlotNumberr.setBounds(17, 50, 82, 16);
		InfoPanel.add(lblPlotNumberr);
		JLabel lblPlotName = new JLabel("Plot Name:");
		lblPlotName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPlotName.setBounds(263, 50, 68, 16);
		InfoPanel.add(lblPlotName);
		
		txtPlotNumber = new JTextField();
		txtPlotNumber.setBounds(105, 44, 134, 28);
		InfoPanel.add(txtPlotNumber);
		txtPlotNumber.setEditable(false);
		txtPlotNumber.setColumns(10);
		
		txtPlotName = new JTextField();
		txtPlotName.setBounds(343, 44, 155, 28);
		InfoPanel.add(txtPlotName);
		txtPlotName.setEditable(false);
		txtPlotName.setColumns(10);
		
			// Text Boxes For Pane 2 //
			txtPlotID = new JTextField();
			txtPlotID.setBounds(342, 6, 156, 28);
			InfoPanel.add(txtPlotID);
			txtPlotID.setEditable(false);
			txtPlotID.setColumns(10);
			
				// Labels For Panel 2 //
				JLabel lblPlotid = new JLabel("PlotID:");
				lblPlotid.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblPlotid.setBounds(265, 12, 42, 16);
				InfoPanel.add(lblPlotid);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new LineBorder(new Color(0, 0, 128)));
				panel.setBackground(new Color(211, 211, 211));
				panel.setBounds(638, 28, 183, 467);
				mainPanel.add(panel);
				btnSave = new JButton("Save");
				btnSave.setBounds(27, 356, 122, 29);
				panel.add(btnSave);
				btnBack = new JButton("Back");
				btnBack.setBounds(27, 409, 126, 29);
				panel.add(btnBack);
				
				lblNewLabel = new JLabel(image);
				lblNewLabel.setBounds(10, 92, 163, 181);
				panel.add(lblNewLabel);
		frame.setVisible(false);
		
		addButtonsFuctionalities();
		setContractID();
	}
	
	// Add Events to Buttons//
	private void addButtonsFuctionalities(){
		
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String share =  txtSharing.getText();
				
				if (Checker.checkNumber(share)){
					String customer =AllCustomers.remove(Customers.getSelectedIndex());
					totalShare = totalShare + Integer.parseInt(share);
					AllOwners.addElement(customer + " " +share);
					txtSharing.setText("");
					Messages.showWarningMessage("" + totalShare);
				}else{
					Messages.showWarningMessage("Percentage is not valid");
				}
				
			}
		});

		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String customer = AllOwners.remove(Owners.getSelectedIndex());
					String[] Customer = ListManager.removeShare(customer);
					String[] sameCustomer =ListManager.SplitThreeItem(Customer[1]);
					ListManager.UpdateList(sameCustomer[0], sameCustomer[1], sameCustomer[2],AllCustomers);
					totalShare = totalShare  - Integer.parseInt(Customer[0]);
				}
		});

		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (totalShare==100){
					new ContractSaveButton().start();
				}else{
					Messages.showWarningMessage("The owners percentage is not 100 %");
				}
				
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContractForm.setVisible(false);
			}
		});
	}

	private static void setTextFields(String str){
		

		str = ListManager.SplitOneItem(str);
		
		try {
			ResultSet rst = LogIn.database.getStatement().executeQuery("SELECT primaryEmail , contactPhone , mobilePhone"
							+" FROM Customer WHERE customerID ='" +str +"'"  );
			
			while (rst.next()&& rst.getString(1)!=null){
				txtMail.setText(rst.getString(1));
				txtContactPhone.setText(rst.getString(2));
				txtMobilePhone.setText(rst.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void setContractID() {


		ResultSet rs;
		try {
			rs = LogIn.database.getStatement().executeQuery(Query.CONTRACT_NO);

			if (rs.next()) {
				if (rs.getString(1) != null) {
					txtContractID.setText(rs.getString(1));
				}
			} else {
				txtContractID.setText("1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void setVisible(boolean val){
		String property ="";
		try{
			 property = (String)ContractMenu.AllProperties.getSelectedItem();
		}catch(Exception e){
		System.out.println("Nohing"); }
		setPropertyTextFields(property);
		frame.setVisible(val);
	}
	
	public static void setPropertyTextFields(String property){
		String[] Property = ListManager.SplitThreeItem(property);
		txtPlotID.setText(Property[0]);
		txtPlotNumber.setText(Property[2]);
		txtPlotName.setText(Property[1]);
	}
}
