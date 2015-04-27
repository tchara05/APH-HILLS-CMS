package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
import extras.Query;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class parcelPanel extends JPanel {

	// TxtBoxes //
	public static JTextField txtParcelName;
	// Dropdown list //
	public static JComboBox<String> AllParcels;

	// Buttons //
	private JButton btnEditParcel;
	private JButton btnAddParcel;
	private JButton btnDeleteParcel;

	public parcelPanel() {

		// Labels //
		JLabel lblParcel = new JLabel("Parcel:");
		lblParcel.setBounds(10, 11, 41, 16);
		JLabel lblPercelName = new JLabel("New Parcel:");
		lblPercelName.setBounds(10, 50, 81, 16);

		// DropDownList //
		AllParcels = new JComboBox<String>();
		AllParcels.setBounds(92, 6, 215, 27);
		ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
		// TextBoxes //
		txtParcelName = new JTextField();
		txtParcelName.setBounds(92, 44, 215, 28);
		txtParcelName.setColumns(10);

		// Buttons //
		btnEditParcel = new JButton("Edit Parcel");
		btnEditParcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnEdit().start();
			}
		});
		btnEditParcel.setBounds(329, 5, 125, 29);
		btnAddParcel = new JButton("Add Parcel");
		btnAddParcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnAdd().start();
			}
		});
		btnAddParcel.setBounds(329, 44, 125, 29);
		btnDeleteParcel = new JButton("Delete Parcel");
		btnDeleteParcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new btnDelete().start();
			}
		});
		btnDeleteParcel.setBounds(329, 84, 125, 29);
		setLayout(null);
		add(lblPercelName);
		add(txtParcelName);
		add(lblParcel);
		add(AllParcels);
		add(btnDeleteParcel);
		add(btnAddParcel);
		add(btnEditParcel);
		
	}


	@SuppressWarnings("unused")
	private class btnEdit extends Thread {

		public void run() {
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				String input = JOptionPane.showInputDialog(null,
						"Enter Parcel Name:", "Dialog for Input",
						JOptionPane.WARNING_MESSAGE);
				input = Checker.clearString(input);
				while (!Checker.checkEmpty(input)) {
					input = JOptionPane.showInputDialog(null,
							"Enter Parcel Name:", "Dialog for Input",
							JOptionPane.WARNING_MESSAGE);
				}

				DatabaseConnection database = new DatabaseConnection();

				String c = (String) AllParcels.getSelectedItem();
				int index = AllParcels.getSelectedIndex();
				AllParcels.removeItemAt(index);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Update Parcel SET parcelName='" + input
									+ "' WHERE parcleNo='" + clas[0] + "'");

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
			String name = txtParcelName.getText();
			name = Checker.clearString(name);
			if (response == JOptionPane.YES_OPTION && !name.equals("")) {

				DatabaseConnection database = new DatabaseConnection();

				try {

					String query = "INSERT INTO  Parcel VALUES('" + name + "')";
					
					database.getStatement().executeUpdate(query);
					ResultSet rs= database.getStatement().executeQuery(Query.PARCEL_NO);
					rs.next();
					
					AllParcels.addItem(rs.getString(1) + " "
							+ txtParcelName.getText());

				
					txtParcelName.setText("");
					Messages.showSaveMessage("Parcel Added");
					Messages.showWarningMessage("Please restart The System!");
				} catch (SQLException e) {
					System.out.println("Class Delete Query");
					e.printStackTrace();
				} finally {
					database.closeDatabaseConnection();
				}
			} else {
				Messages.showWarningMessage("Empty Parcel Name");
			}
		}
	}

	private class btnDelete extends Thread {

		public void run() {
			int response = JOptionPane.showConfirmDialog(null,
					"Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			String input =(String) AllParcels.getSelectedItem();
			String parcel[] = ListManager.SplitTwoItem(input);
			if (response == JOptionPane.YES_OPTION) {


				DatabaseConnection database = new DatabaseConnection();

				String c = (String) AllParcels.getSelectedItem();
				int index = AllParcels.getSelectedIndex();
				AllParcels.removeItemAt(index);
				String[] clas = ListManager.SplitTwoItem(c);
				try {
					database.getStatement().executeUpdate(
							"Delete Parcel WHERE parcleNo='" + clas[0] + "'");
					Messages.showSaveMessage("Parcel Deleted");
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
	
	
