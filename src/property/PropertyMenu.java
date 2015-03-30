
package property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import extras.Query;

import extras.ListManager;
import javax.swing.border.LineBorder;
import java.awt.Color;


@SuppressWarnings("serial")
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
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		PropertyPanel.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		propertyform = new PropertyForm();
		
		// Labels: //
		JLabel lblProperrty = new JLabel("Properties:");
		lblProperrty.setBounds(33, 42, 67, 16);
		JLabel lblSearchPropertyBy = new JLabel("Search Property:");
		lblSearchPropertyBy.setBounds(33, 287, 101, 16);
		JLabel lblParcels = new JLabel("Parcels:");
		lblParcels.setBounds(219, 309, 48, 16);
		JLabel lblNewLabel = new JLabel("Classes:");
		lblNewLabel.setBounds(33, 309, 52, 16);
		
		//DropDown List: //
	    AllProperties = new JComboBox<String>();
	    AllProperties.setBounds(33, 71, 209, 27);
	    ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
	    AllParcels= new JComboBox<String>();
	    AllParcels.setBounds(219, 331, 218, 27);
	    AllParcels.addItem("0 None");
	    ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
		AllClasses = new JComboBox<String>();
		AllClasses.setBounds(33, 331, 174, 27);
		AllClasses.addItem("0 None");
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		

		
		// Buttons: //
		btnAddNewProperty = new JButton("Add New Property");
		btnAddNewProperty.setBounds(289, 70, 177, 29);
		btnNewButton = new JButton("Delete Property");
		btnNewButton.setBounds(289, 117, 177, 29);
		btnEditProperrty = new JButton("Edit/View Property");
		btnEditProperrty.setBounds(289, 164, 177, 29);
		btnSearch = new JButton("Search");
		btnSearch.setBounds(33, 364, 85, 29);
		PropertyPanel.setLayout(null);
		PropertyPanel.add(lblSearchPropertyBy);
		PropertyPanel.add(btnSearch);
		PropertyPanel.add(lblProperrty);
		PropertyPanel.add(AllProperties);
		PropertyPanel.add(btnAddNewProperty);
		PropertyPanel.add(btnNewButton);
		PropertyPanel.add(btnEditProperrty);
		PropertyPanel.add(AllClasses);
		PropertyPanel.add(lblNewLabel);
		PropertyPanel.add(lblParcels);
		PropertyPanel.add(AllParcels);
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