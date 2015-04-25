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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
import extras.Query;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class statusPanel extends JPanel {

	// Input fields //
	public static JTextField txtStatusName;
	public static JComboBox<String> AllStatus;

	public statusPanel() {
		JLabel lblStatusName = new JLabel("New Status:");
		lblStatusName.setBounds(21, 62, 87, 16);
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(21, 26, 43, 16);

		// Drop Down //
		AllStatus = new JComboBox<String>();
		AllStatus.setBounds(138, 22, 267, 27);
		ListManager.setUpTwoColumnsList(AllStatus, Query.STATUS_NO_NAME);

		// Buttons //
		JButton btnAddStatus = new JButton("Add Status");
		btnAddStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnAdd().start();
			}
		});
		btnAddStatus.setBounds(433, 57, 123, 29);
		JButton btnDeleteStatus = new JButton("Delete Status");
		btnDeleteStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnDelete().start();
			}
		});
		btnDeleteStatus.setBounds(433, 92, 123, 29);
		JButton btnEditStatus = new JButton("Edit Status");
		btnEditStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnEdit().start();
			}
		});
		btnEditStatus.setBounds(433, 21, 123, 29);

		txtStatusName = new JTextField();
		txtStatusName.setBounds(138, 56, 267, 28);
		txtStatusName.setColumns(10);
		setLayout(null);
		add(lblStatus);
		add(lblStatusName);
		add(AllStatus);
		add(txtStatusName);
		add(btnAddStatus);
		add(btnDeleteStatus);
		add(btnEditStatus);
	}

	

	@SuppressWarnings("unused")
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

				String c = (String) AllStatus.getSelectedItem();
				int index = AllStatus.getSelectedIndex();
				AllStatus.removeItemAt(index);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Update PropertyStatus SET propertyStatus='" + input
									+ "' WHERE statusID='" + clas[0] + "'");

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

	// Thread for addbutton //
	private class btnAdd extends Thread {

		public void run() {

			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			String name = txtStatusName.getText();
			name = Checker.clearString(name);
			if (response == JOptionPane.YES_OPTION && !name.equals("")) {

				DatabaseConnection database = new DatabaseConnection();

				String query = "INSERT INTO  PropertyStatus VALUES('" + name + "')";
				
				try {
					database.getStatement().executeUpdate(query);
					ResultSet rs= database.getStatement().executeQuery(Query.STATUS_NO);
					rs.next();
					
					AllStatus.addItem(rs.getString(1) + " "
							+ txtStatusName.getText());
					txtStatusName.setText("");
					Messages.showSaveMessage("Status Added");
					Messages.showWarningMessage("Please restart The System!");
				} catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				} finally {
					database.closeDatabaseConnection();
				}
			} else {
				Messages.showWarningMessage("Empty Status Name");
			}
		}
	}

	private class btnDelete extends Thread {

		public void run() {
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			String input = (String) AllStatus.getSelectedItem();
			String Status[] = ListManager.SplitTwoItem(input);
			if (response == JOptionPane.YES_OPTION) {
				DatabaseConnection database = new DatabaseConnection();
				String c = (String) AllStatus.getSelectedItem();
				int index = AllStatus.getSelectedIndex();
				AllStatus.removeItemAt(index);
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
