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

/**
 * 
 * Graphics for the Class Panel form.
 * 
 * @author TeamD
 *
 */
@SuppressWarnings("serial")
public class classPanel extends JPanel {
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
		lblClasses.setBounds(10, 11, 38, 16);
		JLabel lblName = new JLabel("New Class:");
		lblName.setBounds(10, 50, 84, 16);
		
		// DropDown //
		AllClasses  = new JComboBox<String>();
		AllClasses.setBounds(90, 6, 215, 27);
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		
		// Buttons //
		btnEditClass = new JButton("Edit Class");
		btnEditClass.setBounds(327, 5, 122, 29);
		btnAddClass = new JButton("Add Class");
		btnAddClass.setBounds(327, 44, 122, 29);
		btnDeleteClass = new JButton("Delete Class");
		btnDeleteClass.setBounds(327, 84, 122, 29);
		txtName = new JTextField();
		txtName.setBounds(90, 44, 215, 28);
		txtName.setColumns(10);
		
		setLayout(null);
		add(lblClasses);
		add(lblName);
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
				new btnAdd().start();
			}
		});
		btnEditClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnEdit().start();
			}
		});
		
	}
	
	/**
	 * 
	 * The purpose of this function is to delete the class of
	 * a property using a query.
	 *
	 */
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
	

	/**
	 * 
	 * The purpose of this function is to edit the class of
	 * a property using a query.
	 *
	 */
	private class btnEdit extends Thread {

		public void run() {
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				String input = JOptionPane.showInputDialog(null,
						"Enter Status Name:", "Dialog for Input",
						JOptionPane.WARNING_MESSAGE);
				input = Checker.clearString(input);
				while (!Checker.checkEmpty(input)) {
					input = JOptionPane.showInputDialog(null,
							"Enter Status Name:", "Dialog for Input",
							JOptionPane.WARNING_MESSAGE);
				}

				DatabaseConnection database = new DatabaseConnection();

				String c = (String) AllClasses.getSelectedItem();
				int index = AllClasses.getSelectedIndex();
				AllClasses.removeItemAt(index);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Update Class SET className='" + input
									+ "' WHERE propertyClassNo='" + clas[0] + "'");

					Messages.showWarningMessage("Please restart The System!");
				} catch (SQLException e) {
					System.out.println("Update Class Query");
					e.printStackTrace();
				} finally {
					database.closeDatabaseConnection();
				}
			}
		}
	}

	
	/**
	 * 
	 * The purpose of this function is to add the class of
	 * a property using a query.
	 *
	 */
	private class btnAdd extends Thread {

		public void run() {

			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String name = txtName.getText();
			name = Checker.clearString(name);
			if (response == JOptionPane.YES_OPTION && !name.equals("")) {

				DatabaseConnection database = new DatabaseConnection();

				String query = "INSERT INTO  Class VALUES('" + name + "')";
				
				try {
					database.getStatement().executeUpdate(query);
					ResultSet rs= database.getStatement().executeQuery(Query.CLASS_NO);
					rs.next();
					
					AllClasses.addItem(rs.getString(1) + " "
							+ txtName.getText());
					txtName.setText("");
					Messages.showSaveMessage("Status Added");
					Messages.showWarningMessage("Please restart The System!");
				} catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				} finally {
					database.closeDatabaseConnection();
				}
			} else {
				Messages.showWarningMessage("Empty Class Name");
			}
		}
	}

	
	/**
	 * 
	 * The purpose of this function is to delete the property
	 * status of a property using a query.
	 *
	 */
	private class btnDelete extends Thread {
		public void run() {
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			String input = (String) AllClasses.getSelectedItem();
			String Status[] = ListManager.SplitTwoItem(input);
			if (response == JOptionPane.YES_OPTION) {
				DatabaseConnection database = new DatabaseConnection();
				String c = (String) AllClasses.getSelectedItem();
				int index = AllClasses.getSelectedIndex();
				AllClasses.removeItemAt(index);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Delete PropertyStatus WHERE statusID='" + clas[0] + "'");
					Messages.showSaveMessage("Status Deleted");
					Messages.showWarningMessage("Please restart The System!");
				} catch (SQLException e) {
					System.out.println("Update Class Query");
					e.printStackTrace();
				} finally {
					database.closeDatabaseConnection();
				}
			}
		}
	}

}	

