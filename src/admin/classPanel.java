package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
import extras.Query;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	// Database Connection //
	DatabaseConnection database;
	
	public classPanel() {
		
		
		database= new DatabaseConnection();
			
		//Labels //
		JLabel lblClasses = new JLabel("Class:");
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
		
		setID();
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClassId)
						.addComponent(lblClasses)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtID)
						.addComponent(txtName)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEditClass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddClass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDeleteClass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblClasses))
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
					.addContainerGap(32, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		addButtonsFuctionalities();

	}

	// Buttons Fuctionalities //
	private void addButtonsFuctionalities(){
		btnDeleteClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new delBtn().start();
			}
		});	
		
		btnAddClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new addBtn().start();
			}
		});
		btnEditClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnEdit().start();
			}
		});
		
	}
	
	// Set txtID from database // 
	private void setID(){
		
			try{
				ResultSet t= database.getStatement().executeQuery("SELECT MAX(PropertyClassNo) FROM Class");
				if (t.next()){
					txtID.setText((t.getInt(1)+1)+"");
				}
			}catch (SQLException e){
				System.out.println("Class Txt Id");
				e.printStackTrace();
			}
	}	
	
	
	
	// Thread For Deleted Class //
	private class delBtn extends Thread{
			public void run(){
				
				
				int response = JOptionPane.showConfirmDialog(null,
						"Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					DatabaseConnection database= new DatabaseConnection();
				
					String  c = (String)AllClasses.getSelectedItem();
					AllClasses.removeItem(c);
					String[] 	clas = ListManager.SplitTwoItem(c);
					String query="DELETE Class WHERE propertyClassNo= '"+ clas[0]+"'";
					try {
						database.getStatement().executeUpdate(query);
					}catch (SQLException e) {
						System.out.println("Class Delete Query");
						e.printStackTrace();
					}
				
				
				}
			}
	}	
	
	
	
	//Thread for addbutton //
	private class addBtn extends Thread {
		
		public void run(){
			
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String name=txtName.getText();
			name=Checker.clearString(name);
			if (response == JOptionPane.YES_OPTION&&!name.equals("")) {
			
				String query="INSERT INTO  Class VALUES('"+ name+"')";
				AllClasses.addItem(txtID.getText()+" "+txtName.getText());
				
				try {
					database.getStatement().executeUpdate(query);
					setID();
					txtName.setText("");
				}catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				}
				
			
			
			}else{
				Messages.showWarningMessage("Empty Class Name");
			}
			
		}
	}
	
	private class btnEdit extends Thread {
		
		
		public void run(){
			
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String name=Checker.clearString(txtName.getText());
			if (response == JOptionPane.YES_OPTION && !name.equals("")) {
				
			
				String c = (String) AllClasses.getSelectedItem();
				int index = AllClasses.getSelectedIndex();
				AllClasses.removeItem(c);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Update Class SET className='" + txtName.getText()
									+ "' WHERE propertyClassNo='" + clas[0] + "'");
					AllClasses.insertItemAt(clas[0]+" "+name, index);
					txtName.setText("");
				} catch (SQLException e) {
					System.out.println("Update Class Query");
					e.printStackTrace();
				}

			}else{
				Messages.showWarningMessage("Empty Class Name");
			}

		}	
		
	}
	
	
}	

