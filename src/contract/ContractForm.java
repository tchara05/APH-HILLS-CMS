package contract;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
import extras.Query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;

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
	protected static int totalShare=0;
	protected static boolean edit = false;
	
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

	public static void main(String[] args) {
		
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
		
		
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// Scroll Panels: //
		JScrollPane CustomersPane = new JScrollPane();
		JScrollPane OwnerPane = new JScrollPane();
		
		// Panels: //
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		JPanel panel_2 = new JPanel();
		
		// Buttons: //
		btnRight = new JButton(">>");
		btnBack = new JButton("Back");
		btnSave = new JButton("Save");
		btnLeft = new JButton("<<");
		
		// Labels For Panel 1: //
		JLabel label_9 = new JLabel("Contract ID:");
		JLabel label_3 = new JLabel("Primary Email:");
		JLabel label_4 = new JLabel("Contact Phone:");
		JLabel label_5 = new JLabel("Mobile Phone:");
		JLabel label_6 = new JLabel("Percentage:");
		JLabel label_7 = new JLabel("%");
		JLabel label_8 = new JLabel("Customer:");
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel label_10 = new JLabel(image);
		
		
		// Panel 1 Positions: //
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(396)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(638, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
		);
		

		// Text Boxes For Panel 1: //
		txtContractID = new JTextField();
		txtContractID.setEditable(false);
		txtContractID.setColumns(10);
		setContractID();
	
		txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setColumns(10);
		
		txtContactPhone = new JTextField();
		txtContactPhone.setEditable(false);
		txtContactPhone.setColumns(10);
		
		txtMobilePhone = new JTextField();
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

	
		// Variables //
		txtSharing = new JTextField();
		txtSharing.setColumns(5);
		
	    chckActive = new JCheckBox("Active");
		chckActive.setSelected(true);
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CustomersPane, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
									.addGap(25)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(36)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(chckActive)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addComponent(label_6)
													.addGap(1)
													.addComponent(txtSharing, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_7)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(OwnerPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_8)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4)
										.addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_5)
										.addComponent(txtMobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3)))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addComponent(label_8)
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(OwnerPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(17)
							.addComponent(btnRight)
							.addGap(6)
							.addComponent(btnLeft)
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(label_6))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtSharing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_7)))
							.addGap(32)
							.addComponent(chckActive))
						.addComponent(CustomersPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		
		OwnerPane.setViewportView(Owners);
		CustomersPane.setViewportView(Customers);
		panel_1.setLayout(gl_panel_1);
		

		
		
	
		// Labels For Panel 2 //
		JLabel lblPlotid = new JLabel("PlotID:");
		JLabel lblPlotName = new JLabel("Plot Name:");
		JLabel lblPlotNumberr = new JLabel("Plot Number:");
	
		
		// Text Boxes For Pane 2 //
		txtPlotID = new JTextField();
		txtPlotID.setEditable(false);
		txtPlotID.setColumns(10);
		
		txtPlotName = new JTextField();
		txtPlotName.setEditable(false);
		txtPlotName.setColumns(10);
		
		txtPlotNumber = new JTextField();
		txtPlotNumber.setEditable(false);
		txtPlotNumber.setColumns(10);
		
		
		// Panel 2 Positions: //
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(323, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtContractID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPlotid)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPlotID, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPlotName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPlotName, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPlotNumberr)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPlotNumber, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(txtContractID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlotid)
						.addComponent(txtPlotID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlotName)
						.addComponent(txtPlotName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPlotNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlotNumberr))
					.addGap(26)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(false);
		
		addButtonsFuctionalities();
		
	}
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
		
		
		
	}

	private static void setTextFields(String str){
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		str = ListManager.SplitOneItem(str);
		
		try {
			ResultSet rst = st.executeQuery("SELECT primaryEmail , contactPhone , mobilePhone" +
					" FROM Customer WHERE customerID ='" +str +"'"  );
			
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

		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();


		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT MAX(contractID)  FROM Contract");

			if (rs.next()) {
				if (rs.getString(1) != null) {
					txtContractID.setText("" + (rs.getInt(1) + 1));
				} else {
					txtContractID.setText("1");
				}
			} else {
				txtContractID.setText("1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static String getContractID(){
		return txtContractID.getText();
	}
	public static boolean getActive(){
		return chckActive.isSelected();
	}
	public static void setVisible(boolean val){
		
		String property ="";
		
		try{
			 property = (String)ContractMenu.AllProperties.getSelectedItem();
		}catch(Exception e){System.out.println("Nohing"); }
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


