package panels;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Query;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class classPanel extends JPanel {
	
	
	
	// For Data //
	public static JTextField txtID;
	public static JTextField txtName;
	public static JComboBox<String> AllClasses ;
	
	// Buttons //
	private JButton btnEditClass;
	private JButton btnAddClass ;
	private JButton btnDeleteClass;
	
	
	public classPanel() {
		
		
		//Labels //
		JLabel lblClasses = new JLabel("Classes:");
		JLabel lblClassId = new JLabel("Class ID:");
		JLabel lblName = new JLabel("Name:");
		
		// DropDown //
		AllClasses  = new JComboBox<String>();
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		
		// Buttons //
		btnEditClass = new JButton("Edit Class");
		btnAddClass = new JButton("Add Class");
		btnDeleteClass = new JButton("Delete Class");
	
		// TextBoxes //
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtName = new JTextField();
		txtName.setColumns(10);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblClasses)
								.addComponent(lblName))
							.addGap(15))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClassId)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtID)
						.addComponent(txtName)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAddClass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDeleteClass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEditClass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClasses)
						.addComponent(btnEditClass))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblClassId))
						.addComponent(btnAddClass))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteClass)
						.addComponent(lblName))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		addButtonsFuctionalities();

	}
	
	
	// Thread For Deleted Class //
	private class delBtn extends Thread{
			public void run(){
				DatabaseConnection database= new DatabaseConnection();
				
				String  c = (String)AllClasses.getSelectedItem();
				AllClasses.removeItem(c);
				String[] 	clas = ListManager.SplitTwoItem(c);
				String query="DELETE Class WHERE propertyClassNo= '"+ clas[0]+"'";
				try {
					database.getStatement().executeUpdate(query);
				} catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				}
				
				
			}
	}
	
	private class addBtn extends Thread {
		
		public void run(){
	
		}
		
	}
	
	
	// Buttons Fuctionalities //
	private void addButtonsFuctionalities(){
		btnDeleteClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new delBtn().start();
			}
		});
		
		
		
	}
	
	
}
