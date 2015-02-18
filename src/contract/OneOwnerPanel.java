package contract;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import extras.DatabaseConnection;
import extras.ListManager;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListModel;

public class OneOwnerPanel extends JPanel {
	
	private static JTextField txtContract;
	private static JTextField txtEmail;
	private static JTextField txtContactPhone;
	private static JTextField txtMobilePhone;
	private static JComboBox<String> AllProperties;
	private static JComboBox<String> AllClasses;
	private static JComboBox<String> AllParcels;
	private static JTextField txtSharing;
	private static DefaultListModel<String> AllCustomers;
	private static DefaultListModel<String> AllOwners;
	private static int totalShare = 0;
	
	public OneOwnerPanel(){
		
		
		
JLabel lblContratid = new JLabel("Contract ID:");
		
		txtContract = new JTextField();
		txtContract.setEditable(false);
		txtContract.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		
		JButton btnBack = new JButton("Back");
		
		JPanel Cpanel = new JPanel();
		Cpanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GroupLayout gl_oneOwner = new GroupLayout(this);
		gl_oneOwner.setHorizontalGroup(
			gl_oneOwner.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oneOwner.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_oneOwner.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
						.addGroup(gl_oneOwner.createSequentialGroup()
							.addComponent(lblContratid)
							.addGap(57)
							.addComponent(txtContract, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_oneOwner.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addComponent(Cpanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_oneOwner.setVerticalGroup(
			gl_oneOwner.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oneOwner.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_oneOwner.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContratid)
						.addComponent(txtContract, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Cpanel, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_oneOwner.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		JLabel lblPlot = new JLabel("Plot:");
		
		String query = "SELECT plotID, plotName, plotNumber FROM Property";
		
		AllProperties = new JComboBox<String>();
		
		ListManager.setUpThreeList(AllProperties, query);
		
		 AllClasses = new JComboBox<String>();
		 query = "SELECT propertyClassNo, className FROM Class";
		 ListManager.setUpTwoColumnsList(AllClasses, query);
		
		JLabel lblClass = new JLabel("Class:");
		
		/** Parcel query Needed **/
		 AllParcels = new JComboBox<String>();
		
		JLabel lblParcel = new JLabel("Parcel:");
		
		JButton btnSearch = new JButton("Filter");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPlot)
							.addGap(51)
							.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblClass)
									.addGap(157))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblParcel)
								.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlot)
						.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClass)
						.addComponent(lblParcel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
					.addGap(4))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblCustomer = new JLabel("Customer:");
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("Primary Email:");
		
		JLabel lblNewLabel = new JLabel("Contact Phone:");
		
		txtContactPhone = new JTextField();
		txtContactPhone.setEditable(false);
		txtContactPhone.setColumns(10);
		
		txtMobilePhone = new JTextField();
		txtMobilePhone.setEditable(false);
		txtMobilePhone.setColumns(10);
		
		AllCustomers = new DefaultListModel<String>();
		AllOwners = new DefaultListModel<String>();
		JLabel lblMobilePhone = new JLabel("Mobile Phone:");
		final JList Customers = new JList(AllCustomers);
		final JList Owners = new JList(AllOwners);
		Customers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String customer =AllCustomers.get(Customers.getSelectedIndex());
				setTextFields(customer);
				
			}
		});
		
		 query = "SELECT customerID, firstName, lastName FROM Customer ORDER BY firstName , LastName";
		 ListManager.SetUpThreeList(AllCustomers, query);
		
		JButton rigthButton = new JButton(">>");
		rigthButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String share =  txtSharing.getText();
				String customer =AllCustomers.remove(Customers.getSelectedIndex());
				totalShare = totalShare + Integer.parseInt(share);
				AllOwners.addElement(customer + " " +share);
				txtSharing.setText("");
				
			}
		});
		
		JButton leftBtn = new JButton("<<");
		leftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String customer = AllOwners.remove(Owners.getSelectedIndex());
				String[] Customer = ListManager.removeShare(customer);
				String[] sameCustomer =ListManager.SplitThreeItem(Customer[1]);
				ListManager.UpdateList(sameCustomer[0], sameCustomer[1], sameCustomer[2],AllCustomers);
				totalShare = totalShare  - Integer.parseInt(Customer[0]);
				
				
			}
		});
		
		txtSharing = new JTextField();
		txtSharing.setColumns(5);
		
		JLabel label = new JLabel("%");
		
		JLabel lblPercentage = new JLabel("Percentage:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_Cpanel = new GroupLayout(Cpanel);
		gl_Cpanel.setHorizontalGroup(
			gl_Cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cpanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Cpanel.createSequentialGroup()
							.addComponent(lblCustomerId)
							.addGap(51)
							.addComponent(lblNewLabel)
							.addGap(45)
							.addComponent(lblMobilePhone))
						.addGroup(gl_Cpanel.createSequentialGroup()
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtMobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Cpanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Cpanel.createSequentialGroup()
									.addGap(36)
									.addComponent(rigthButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Cpanel.createSequentialGroup()
									.addGap(36)
									.addComponent(leftBtn, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Cpanel.createSequentialGroup()
									.addComponent(lblPercentage)
									.addGap(1)
									.addComponent(txtSharing, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
							.addGap(2)
							.addComponent(label)
							.addGap(23)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCustomer))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_Cpanel.setVerticalGroup(
			gl_Cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cpanel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblCustomer)
					.addGap(6)
					.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Cpanel.createSequentialGroup()
							.addGap(17)
							.addComponent(rigthButton)
							.addGap(6)
							.addComponent(leftBtn)
							.addGap(18)
							.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Cpanel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblPercentage))
								.addComponent(txtSharing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Cpanel.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1)
								.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_Cpanel.createSequentialGroup()
										.addGap(97)
										.addComponent(label))
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))))
					.addGap(6)
					.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomerId)
						.addComponent(lblNewLabel)
						.addComponent(lblMobilePhone))
					.addGap(6)
					.addGroup(gl_Cpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtContactPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMobilePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		
		
		scrollPane_1.setViewportView(Owners);
		scrollPane.setViewportView(Customers);
		Cpanel.setLayout(gl_Cpanel);
		setLayout(gl_oneOwner);
		
	}
	
	private static void setTextFields(String str){
		
		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/
		
		str = ListManager.SlitOneItem(str);
		
		try {
			ResultSet rst = st.executeQuery("SELECT primaryEmail , contactPhone , mobilePhone" +
					" FROM Customer WHERE customerID ='" +str +"'"  );
			
			while (rst.next()&& rst.getString(1)!=null){
				txtEmail.setText(rst.getString(1));
				txtContactPhone.setText(rst.getString(2));
				txtMobilePhone.setText(rst.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
