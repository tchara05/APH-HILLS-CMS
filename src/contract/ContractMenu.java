package contract;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;


import extras.DatabaseConnection;
import extras.ListManager;
import extras.Query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class ContractMenu extends JPanel {
	
	//The Box //
	private static JPanel panel;
	
	public static JComboBox<String> AllProperties ;
	public static JComboBox<String> AllClasses ;
	public static JComboBox<String> AllParcels ;
	
	@SuppressWarnings("unused")
	private static ContractForm contractform ;
	
	//Buttons //
	private JButton btnFilter;
	private JButton btnEditContract;
	private JButton btnAddNewContract;
		
	public static DatabaseConnection database;
	
	public ContractMenu(){
		 panel = new JPanel();
		 panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		 contractform = new ContractForm();
		 database = new DatabaseConnection();
		//DropDown List: //
		 AllProperties = new JComboBox<String>();
		 ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
		 AllParcels = new JComboBox<String>();
		 AllClasses = new JComboBox<String>();
		 ListManager.setUpTwoColumnsList(AllClasses,Query.CLASS_NO_NAME);
		 ListManager.setUpTwoColumnsList(AllParcels,Query.PARCEL_NO_NAME);
		 
		// Labels // 
		JLabel label_1 = new JLabel("Class:");
		JLabel label = new JLabel("Plot:");
		JLabel label_2 = new JLabel("Parcel:");
		
		// Buttons: //
		btnFilter = new JButton("Filter");
		btnEditContract = new JButton("Edit Contract");
		btnAddNewContract = new JButton("Add New Contract");
		
		//Panel Positions : //
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 590, Short.MAX_VALUE)
				.addGap(0, 588, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(51)
							.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(157))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditContract, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddNewContract)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE)
				.addGap(0, 148, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFilter)
						.addComponent(btnAddNewContract)
						.addComponent(btnEditContract)))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		addButtonsFuctionalities();

	}
	
	public static JPanel createContractMenu() {
		 new ContractMenu();
		 return panel;
	}

	//Buttons Fuctionalities //
	private void addButtonsFuctionalities(){
		btnAddNewContract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (existContract()){
				int response = JOptionPane.showConfirmDialog(null,
						"There is already a contract for that property\n" +
						"Deactive current contract and continue with a\n new contract?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					ContractForm.setVisible(true);
				}
				
				}else{
					ContractForm.setVisible(true);
				}
				
			}
		});
		
	}
	
	
	public boolean existContract() {
		
		Statement st = database.getStatement();
		String plot = (String)ContractMenu.AllProperties.getSelectedItem();
		String Plot[]=ListManager.SplitTwoItem(plot);
		String query="SELECT contractID, plotID FROM Contract WHERE plotID='"+Plot[0]+"'";
		ResultSet rst;
		try {
			rst = st.executeQuery(query);
			if (rst.next()){
				if (Plot[0].equals(rst.getString(2))){
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Existing Contract");
			e.printStackTrace();
		}
	return false;
	}
	
}
