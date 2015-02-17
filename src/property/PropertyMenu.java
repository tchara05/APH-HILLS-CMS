
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

import extras.DatabaseConnection;
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

	
	
	/**
	 * Create the panel.
	 */
	
	private static JComboBox<String> AllProperties;
	private PropertyForm propertyform;
	private static JPanel PropertyPanel;
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		propertyform = new PropertyForm();
	    AllProperties = new JComboBox<String>();
	    String query = "SELECT plotID, plotNumber , PlotName FROM Property ORDER BY plotName , plotNumber";
	    ListManager.setUpThreeList(AllProperties, query);
		
		JLabel lblProperrty = new JLabel("Properties:");
		
		JButton btnAddNewProperty = new JButton("Add New Property");
		btnAddNewProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		btnAddNewProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyForm.setPlotID();	
				PropertyForm.setVisible(true);
			}

		});
		
		JButton btnNewButton = new JButton("Delete Property");
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				PropertyDeleteButton.start();
			}
		});
		
		JButton btnEditProperrty = new JButton("Edit/View Property");
		btnEditProperrty.addMouseListener(new MouseAdapter() {

		});
		
		JLabel lblSearchPropertyBy = new JLabel("Search Property:");
		
		JButton button = new JButton("Search");
		
		JComboBox<String> AllParcels= new JComboBox<String>();
		
		JComboBox<String> AllClasses = new JComboBox<String>();
		
		JLabel lblParcels = new JLabel("Parcels:");
//		query = "SELECT parcelNo, parcellName, parcelOwner FROM Parcel";
//		ListManager.setUpList(AllParcels, query);
		query = "SELECT propertyClassNo, className FROM Class";
		ListManager.setUpTwoColumnsList(AllClasses, query);
		
		JLabel lblNewLabel = new JLabel("Classses:");
		
		
		GroupLayout gl_PropertyPanel = new GroupLayout(PropertyPanel);
		gl_PropertyPanel.setHorizontalGroup(
			gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PropertyPanel.createSequentialGroup()
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchPropertyBy)
								.addComponent(lblProperrty)
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(AllParcels, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(AllProperties, Alignment.LEADING, 0, 209, Short.MAX_VALUE)
										.addComponent(button, Alignment.LEADING))
									.addGap(18)
									.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(AllClasses, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAddNewProperty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
												.addComponent(btnEditProperrty, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))))))
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblParcels)))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditProperrty)
					.addGap(40)
					.addComponent(lblSearchPropertyBy)
					.addGap(22)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblParcels)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(95)
					.addComponent(button)
					.addGap(26))
		);
		PropertyPanel.setLayout(gl_PropertyPanel);
			

	}
	
	
	public static Object getSelectedProperty(){
		return AllProperties.getSelectedItem();
	}
	

	public static void DeletePropertyFromList(){
		
		ListManager.DeleteFromList(AllProperties);
	}
	
	public static void UpdatePropertyFormList(String id, String name , String number){
		
		ListManager.UpdateList(id, name, number,AllProperties);
	}
	
	
	public static JPanel createPropertyMenu(){
		new PropertyMenu();
		return PropertyPanel;
	}
	
	public static void main(String args[]){
		
		new PropertyMenu().setVisible(true);
	}
}