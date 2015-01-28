package Property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class PropertyMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JComboBox<String> AllProperties;
	private PropertyForm propertyform;
	private JTextField txtPropertySearch;
	private JLabel lblPropertyDescriptions;
	private static JPanel PropertyPanel;
		
	
	
	public PropertyMenu() {
		
		PropertyPanel = new JPanel();
		propertyform = new PropertyForm();
	    AllProperties = new JComboBox<String>();
		
		JLabel lblProperrty = new JLabel("Properties:");
		lblPropertyDescriptions = new JLabel("");
		
		JButton btnAddNewProperty = new JButton("Add New Property");
		btnAddNewProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddNewProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				propertyform.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				String description = "<html>Button Description:<br><br> Adding new property into " +
									 "datababe with all its features!<html>";
				
				
				lblPropertyDescriptions.setText(description);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblPropertyDescriptions.setText("");
			}
		});
		
		JButton btnNewButton = new JButton("Delete Property");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				String description = "<html>Button Description:<br><br> Delete the selected property " +
						 "from database if it has " +
						 "no connection with any Customer!<html>";
						
				lblPropertyDescriptions.setText(description);
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblPropertyDescriptions.setText("");
			}
		});
		
		JButton btnEditProperrty = new JButton("Edit/View Property");
		btnEditProperrty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String description = "<html>Button Description:<br><br> The property form shows with  " +
						 "all features and details about " +
						 "the selected property!<html>";
						
				lblPropertyDescriptions.setText(description);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPropertyDescriptions.setText("");
			}
		});
		
		
		txtPropertySearch = new JTextField();
		txtPropertySearch.setColumns(10);
		
		JLabel lblSearchPropertyBy = new JLabel("Search Property by Name:");
		
		JButton button = new JButton("Search");
		
		JButton btnShowPropertyReport = new JButton("Show Report");
		btnShowPropertyReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String description = "<html>Button Description:<br><br> Shows all owners and details of  " +
						 "the selected property!" +
						 "<html>";
						
				lblPropertyDescriptions.setText(description);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPropertyDescriptions.setText("");
			}
		});
		
		
		GroupLayout gl_PropertyPanel = new GroupLayout(PropertyPanel);
		gl_PropertyPanel.setHorizontalGroup(
			gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PropertyPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addComponent(lblProperrty)
							.addContainerGap(474, Short.MAX_VALUE))
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtPropertySearch, Alignment.LEADING)
										.addComponent(AllProperties, Alignment.LEADING, 0, 209, Short.MAX_VALUE))
									.addGap(79))
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addComponent(lblSearchPropertyBy)
									.addGap(128))
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(132)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addComponent(lblPropertyDescriptions, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_PropertyPanel.createSequentialGroup()
									.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnShowPropertyReport, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEditProperrty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAddNewProperty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
									.addContainerGap())))))
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
					.addGap(18)
					.addComponent(btnShowPropertyReport)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PropertyPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGap(75)
							.addComponent(lblSearchPropertyBy)
							.addGap(18)
							.addComponent(txtPropertySearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addGroup(gl_PropertyPanel.createSequentialGroup()
							.addGap(43)
							.addComponent(lblPropertyDescriptions, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addGap(115))
		);
		PropertyPanel.setLayout(gl_PropertyPanel);
			

	}
	
	public static JPanel createPropertyMenu(){
		
		new PropertyMenu();
		return PropertyPanel;
	}
	
	
	public static void main(String args[]){
		
		new PropertyMenu().setVisible(true);
	}



}
