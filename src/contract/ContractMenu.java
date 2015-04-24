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
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
@SuppressWarnings("serial")
public class ContractMenu extends JPanel {
	
	//The Box //
	private static JPanel contPanel;
	private static JPanel wrapper;
	private static JPanel panel;
	
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
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contractform = new ContractForm();
	    setLayout(null);
		
		panel.setLayout(null);
		
	    wrapper = new JPanel();
	    wrapper.setBounds(22, 21, 792, 473);
	    wrapper.setBackground(new Color(255, 255, 255));
		wrapper.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "CONTRACT MENU", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(wrapper);
		wrapper.setLayout(null);
		contPanel = new JPanel();
		contPanel.setBounds(93, 89, 605, 300);
		contPanel.setForeground(new Color(0, 0, 128));
		wrapper.add(contPanel);
		contPanel.setBackground(new Color(173, 216, 230));
		contPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		//DropDown List: //
		 AllProperties = new JComboBox<String>();
		 AllProperties.setBounds(100, 66, 199, 27);
		 ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
		 AllParcels = new JComboBox<String>();
		 AllParcels.setBounds(257, 142, 280, 27);
		 AllClasses = new JComboBox<String>();
		 AllClasses.setBounds(62, 142, 149, 27);
		 AllParcels.addItem("0 None");
		 AllClasses.addItem("0 None");
		 ListManager.setUpTwoColumnsList(AllClasses,Query.CLASS_NO_NAME);
		 ListManager.setUpTwoColumnsList(AllParcels,Query.PARCEL_NO_NAME);
		 
		// Labels // 
		JLabel label_1 = new JLabel("Class:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_1.setBounds(62, 120, 38, 16);
		JLabel label = new JLabel("Plot:");
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setBounds(62, 71, 28, 16);
		JLabel label_2 = new JLabel("Parcel:");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_2.setBounds(257, 120, 41, 16);
		
		// Buttons: //
		btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnFilter.setBounds(62, 213, 149, 33);
		btnAddNewContract = new JButton("Add New Contract");
		btnAddNewContract.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAddNewContract.setBounds(384, 213, 153, 33);
		btnFilterByNo = new JButton("Filter by No Contract");
		btnFilterByNo.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnFilterByNo.setBounds(223, 213, 149, 33);
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
