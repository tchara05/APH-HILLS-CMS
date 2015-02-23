
package property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import contract.ContractForm;

import extras.DatabaseConnection;
import extras.Query;
/*
 * We have to make status fields and add the id to dropdowlist
 * filter the dropdown list to remove the id with Checker.StringRemoveID
 * 
 * 
 * 
 * 
 */
import extras.ListManager;


public class PropertyMenu extends JPanel {

	private PropertyForm propertyform;
	private static JPanel PropertyPanel;
	
	//Buttons Variable
	private JButton btnAddNewProperty;
	private JButton btnNewButton;
	private JButton btnEditProperrty;
	private JButton btnSearch;
	
	// DropDown Variables //
	public  static JComboBox<String> AllProperties;
	public static JComboBox<String> AllClasses;
	public  static JComboBox<String> AllParcels;
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		propertyform = new PropertyForm();
		
		// Labels: //
		JLabel lblProperrty = new JLabel("Properties:");
		JLabel lblSearchPropertyBy = new JLabel("Search Property:");
		JLabel lblParcels = new JLabel("Parcels:");
		JLabel lblNewLabel = new JLabel("Classes:");
		
		//DropDown List: //
	    AllProperties = new JComboBox<String>();
	    ListManager.setUpThreeList(AllProperties, Query.PROPERTY_ID_NAME_NUMBER);
	    AllParcels= new JComboBox<String>();
				// We dont know for parcel yet //
		AllClasses = new JComboBox<String>();
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		

		
		// Buttons: //
		btnAddNewProperty = new JButton("Add New Property");
		btnNewButton = new JButton("Delete Property");
		btnEditProperrty = new JButton("Edit/View Property");
		btnSearch = new JButton("Search");
		
		
		// Postitons: //
		GroupLayout gl_PropertyPanel = new GroupLayout(PropertyPanel);
		gl_PropertyPanel.setHorizontalGroup(
			gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PropertyPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSearchPropertyBy)
						.addComponent(btnSearch)
						.addComponent(lblProperrty)
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnAddNewProperty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEditProperrty, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblParcels)
								.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_PropertyPanel.setVerticalGroup(
			gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PropertyPanel.createSequentialGroup()
					.addGap(39)
					.addComponent(lblProperrty)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddNewProperty))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnEditProperrty)
					.addGap(94)
					.addComponent(lblSearchPropertyBy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblParcels)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
					.addGap(53))
		);
		
		
		PropertyPanel.setLayout(gl_PropertyPanel);
		addButtonsFuctionalities();

	}
	
	
	

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
			
			
		});
		
	}
	
	public static JPanel createPropertyMenu(){
		new PropertyMenu();
		return PropertyPanel;
	}
	
	public static void main(String args[]){
		
		new PropertyMenu().setVisible(true);
	}

}