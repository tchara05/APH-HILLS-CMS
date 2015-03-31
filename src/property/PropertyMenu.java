
package property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import extras.Query;

import extras.ListManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;


public class PropertyMenu{

	@SuppressWarnings("unused")
	private static PropertyForm propertyform;
	private static JPanel PropertyPanel;
	
	//Buttons Variable
	private static JButton btnAddNewProperty;
	private static JButton btnNewButton;
	private static JButton btnEditProperrty;
	private static JButton btnSearch;
	
	// DropDown Variables //
	public  static JComboBox<String> AllProperties;
	public  static JComboBox<String> AllClasses;
	public  static JComboBox<String> AllParcels;
	private JPanel panel;
	private JPanel panel_1;
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		PropertyPanel.setBackground(new Color(255, 255, 255));
		PropertyPanel.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		propertyform = new PropertyForm();
		
		// Labels: //
		JLabel lblProperrty = new JLabel("Properties:");
		lblProperrty.setBounds(33, 42, 67, 16);
		
		//DropDown List: //
	    AllProperties = new JComboBox<String>();
	    AllProperties.setBounds(33, 71, 209, 27);
	    ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
		

		
		// Buttons: //
		btnAddNewProperty = new JButton("Add New Property");
		btnAddNewProperty.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAddNewProperty.setBounds(289, 70, 149, 33);
		btnNewButton = new JButton("Delete Property");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(289, 117, 149, 33);
		btnEditProperrty = new JButton("Edit/View Property");
		btnEditProperrty.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEditProperrty.setBounds(289, 164, 149, 33);
		PropertyPanel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Property Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(44, 231, 461, 192);
		PropertyPanel.add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(25, 25, 413, 141);
		panel_1.add(panel);
		panel.setLayout(null);
		btnSearch = new JButton("Search");
		btnSearch.setBounds(25, 95, 149, 33);
		panel.add(btnSearch);
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 14));
		AllClasses = new JComboBox<String>();
		AllClasses.setBounds(10, 44, 174, 27);
		panel.add(AllClasses);
		AllClasses.addItem("0 None");
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		JLabel lblNewLabel = new JLabel("Classes:");
		lblNewLabel.setBounds(21, 22, 52, 16);
		panel.add(lblNewLabel);
		JLabel lblParcels = new JLabel("Parcels:");
		lblParcels.setBounds(203, 22, 48, 16);
		panel.add(lblParcels);
		AllParcels= new JComboBox<String>();
		AllParcels.setBounds(196, 44, 218, 27);
		panel.add(AllParcels);
		AllParcels.addItem("0 None");
		ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
		PropertyPanel.add(lblProperrty);
		PropertyPanel.add(AllProperties);
		PropertyPanel.add(btnAddNewProperty);
		PropertyPanel.add(btnNewButton);
		PropertyPanel.add(btnEditProperrty);
		addButtonsFuctionalities();

	}
	
	
	// Adding events //
	private void addButtonsFuctionalities(){
		
		btnAddNewProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropertyForm.setPlotID();	
				PropertyForm.setVisible(true);
			}
		});
		btnAddNewProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyForm.setPlotID();	
				PropertyForm.setVisible(true);
			}

		});
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			new	PropertyDeleteButton().start();
			}
		});
		btnEditProperrty.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PropertyEditButton().start();
			}
		});
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PropertySearchButton().start();
			}
		});
		
	}
	
	
	public static JPanel createPropertyMenu(){
		new PropertyMenu();
		return PropertyPanel;
	}
	
	public static void main(String args[]){
		new PropertyMenu();
		PropertyPanel.setVisible(true);
	}

}