package contract;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import userMenus.LogIn;

import extras.ListManager;
import extras.Query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("serial")
public class ContractMenu extends JPanel {
	
	//The Box //
	private static JPanel contPanel;
	private static JPanel wrapper;
	
	public static JComboBox<String> AllProperties ;
	public static JComboBox<String> AllClasses ;
	public static JComboBox<String> AllParcels ;
	
	@SuppressWarnings("unused")
	private static ContractForm contractform ;
	
	//Buttons //
	private static JButton btnFilter;
	private static JButton btnAddNewContract;
	private static JButton btnFilterByNo;
		
	
	public ContractMenu(){
		setBorder(new LineBorder(new Color(0, 0, 128), 0));
		 contractform = new ContractForm();
		 setLayout(null);
		
	    wrapper = new JPanel();
		wrapper.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		wrapper.setBounds(31, 89, 552, 257);
		add(wrapper);
		wrapper.setLayout(null);
		contPanel = new JPanel();
		contPanel.setBounds(47, 36, 488, 192);
		wrapper.add(contPanel);
		contPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		contPanel.setBackground(new Color(204, 204, 153));
		contPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//DropDown List: //
		 AllProperties = new JComboBox<String>();
		 AllProperties.setBounds(86, 18, 199, 27);
		 ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
		 AllParcels = new JComboBox<String>();
		 AllParcels.setBounds(202, 85, 280, 27);
		 AllClasses = new JComboBox<String>();
		 AllClasses.setBounds(7, 85, 189, 27);
		 AllParcels.addItem("0 None");
		 AllClasses.addItem("0 None");
		 ListManager.setUpTwoColumnsList(AllClasses,Query.CLASS_NO_NAME);
		 ListManager.setUpTwoColumnsList(AllParcels,Query.PARCEL_NO_NAME);
		 
		// Labels // 
		JLabel label_1 = new JLabel("Class:");
		label_1.setBounds(7, 63, 38, 16);
		JLabel label = new JLabel("Plot:");
		label.setBounds(7, 22, 28, 16);
		JLabel label_2 = new JLabel("Parcel:");
		label_2.setBounds(202, 63, 41, 16);
		
		// Buttons: //
		btnFilter = new JButton("Filter");
		btnFilter.setBounds(7, 137, 135, 29);
		btnAddNewContract = new JButton("Add New Contract");
		btnAddNewContract.setBounds(329, 137, 158, 29);
		btnFilterByNo = new JButton("Filter by No Contract");
		btnFilterByNo.setBounds(148, 137, 175, 29);
		contPanel.setLayout(null);
		contPanel.add(label);
		contPanel.add(AllProperties);
		contPanel.add(label_1);
		contPanel.add(AllClasses);
		contPanel.add(label_2);
		contPanel.add(AllParcels);
		contPanel.add(btnFilter);
		contPanel.add(btnFilterByNo);
		contPanel.add(btnAddNewContract);
		
		addButtonsFuctionalities();

	}
	
	public static JPanel createContractMenu() {
		 new ContractMenu();
		 return wrapper;
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
		btnFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ContractFilterButton().start();
			}
		});
		
		 btnFilterByNo.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		new FilterByNoContractButton().start();
		    	}
		    });
		
	}
	
	
	public boolean existContract() {
		
		String plot = (String)ContractMenu.AllProperties.getSelectedItem();
		String Plot[]=ListManager.SplitTwoItem(plot);
		String query="SELECT contractID, plotID FROM Contract WHERE plotID='"+Plot[0]+"'";
		ResultSet rst;
		try {
			rst = 	LogIn.database.getStatement().executeQuery(query);
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
