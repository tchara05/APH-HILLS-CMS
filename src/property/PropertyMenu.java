
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
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		PropertyPanel.setLocation(22, 0);
		PropertyPanel.setBackground(new Color(255, 255, 255));
		PropertyPanel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		propertyform = new PropertyForm();
		PropertyPanel.setLayout(null);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Color.WHITE);
	    panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "PROPERTY DEPARTMENT", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	    panel_3.setBounds(22, 21, 792, 473);
	    PropertyPanel.add(panel_3);
	    panel_3.setLayout(null);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(80, 51, 635, 186);
	    panel_2.setBorder(new LineBorder(new Color(0, 0, 128)));
	    panel_2.setBackground(new Color(173, 216, 230));
	    panel_3.add(panel_2);
	    panel_2.setLayout(null);
	    
	    // Labels: //
	    JLabel lblProperrty = new JLabel("Properties:");
	    lblProperrty.setFont(new Font("Calibri", Font.PLAIN, 14));
	    lblProperrty.setBounds(77, 52, 84, 18);
	    panel_2.add(lblProperrty);
	    
	    //DropDown List: //
	    AllProperties = new JComboBox<String>();
	    AllProperties.setBounds(77, 81, 209, 27);
	    panel_2.add(AllProperties);
	    ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
	    

	    
	    // Buttons: //
	    btnAddNewProperty = new JButton("Add New Property");
	    btnAddNewProperty.setBounds(402, 28, 149, 33);
	    panel_2.add(btnAddNewProperty);
	    btnAddNewProperty.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnNewButton = new JButton("Delete Property");
	    btnNewButton.setBounds(402, 75, 149, 33);
	    panel_2.add(btnNewButton);
	    btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnEditProperrty = new JButton("Edit/View Property");
	    btnEditProperrty.setBounds(402, 122, 149, 33);
	    panel_2.add(btnEditProperrty);
	    btnEditProperrty.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    panel = new JPanel();
	    panel.setBounds(80, 284, 635, 139);
	    panel_3.add(panel);
	    panel.setBorder(new LineBorder(new Color(0, 0, 128)));
	    panel.setBackground(new Color(173, 216, 230));
	    panel.setLayout(null);
	    btnSearch = new JButton("Search");
	    btnSearch.setBounds(221, 84, 174, 33);
	    panel.add(btnSearch);
	    btnSearch.setFont(new Font("Calibri", Font.PLAIN, 14));
	    AllClasses = new JComboBox<String>();
	    AllClasses.setBounds(75, 46, 218, 27);
	    panel.add(AllClasses);
	    AllClasses.addItem("0 None");
	    ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
	    JLabel lblNewLabel = new JLabel("Classes:");
	    lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
	    lblNewLabel.setBounds(75, 24, 66, 16);
	    panel.add(lblNewLabel);
	    JLabel lblParcels = new JLabel("Parcels:");
	    lblParcels.setFont(new Font("Calibri", Font.PLAIN, 14));
	    lblParcels.setBounds(338, 24, 66, 16);
	    panel.add(lblParcels);
	    AllParcels= new JComboBox<String>();
	    AllParcels.setBounds(331, 46, 218, 27);
	    panel.add(AllParcels);
	    AllParcels.addItem("0 None");
	    ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
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