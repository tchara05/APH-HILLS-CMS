package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

@SuppressWarnings("serial")
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
	
	
	public classPanel() {
			
		//Labels //
		JLabel lblClasses = new JLabel("Class:");
		lblClasses.setBounds(14, 30, 38, 16);
		JLabel lblClassId = new JLabel("Class ID:");
		lblClassId.setBounds(14, 72, 56, 16);
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(14, 112, 40, 16);
		
		// DropDown //
		AllClasses  = new JComboBox<String>();
		AllClasses.setBounds(76, 26, 215, 27);
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		
		// Buttons //
		btnEditClass = new JButton("Edit Class");
		btnEditClass.setBounds(388, 24, 122, 29);
		btnAddClass = new JButton("Add Class");
		btnAddClass.setBounds(388, 65, 122, 29);
		btnDeleteClass = new JButton("Delete Class");
		btnDeleteClass.setBounds(388, 107, 122, 29);
	
		// TextBoxes //
		txtID = new JTextField();
		txtID.setBounds(76, 66, 215, 28);
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtName = new JTextField();
		txtName.setBounds(76, 106, 215, 28);
		txtName.setColumns(10);
		
		setID();
		setLayout(null);
		add(lblClassId);
		add(lblClasses);
		add(lblName);
		add(txtID);
		add(txtName);
		add(AllClasses);
		add(btnEditClass);
		add(btnAddClass);
		add(btnDeleteClass);
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
		
			DatabaseConnection database = new DatabaseConnection();
			try{
				ResultSet t=database.getStatement().executeQuery(Query.STATUS_NO);
				if (t.next()){
					txtID.setText((t.getInt(1)+1)+"");
				}
			}catch (SQLException e){
				System.out.println("Class Txt Id");
				e.printStackTrace();
			}finally{
				database.closeDatabaseConnection();
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
					}finally{
						database.closeDatabaseConnection();
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
				
				DatabaseConnection database = new DatabaseConnection();
			
				String query="INSERT INTO  Class VALUES('"+ name+"')";
				AllClasses.addItem(txtID.getText()+" "+txtName.getText());
				
				try {
					database.getStatement().executeUpdate(query);
					setID();
					txtName.setText("");
				}catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				}finally{
					database.closeDatabaseConnection();
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
				
				DatabaseConnection database = new DatabaseConnection();
				
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
				}finally{
					database.closeDatabaseConnection();
				}

			}else{
				Messages.showWarningMessage("Empty Class Name");
			}
		}	
	}
}	

