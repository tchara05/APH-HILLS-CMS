package property;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import contract.ContractMenu;

import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;

public class PropertySaveButton extends Thread {

	/* This classes need improvements */

	public void run() {

		boolean checked = true;

		String plotName = PropertyForm.txtPlotName.getText();
		plotName = Checker.clearString(plotName);
		if (!Checker.checkString(plotName) || (plotName.isEmpty())) {
			String msg = "Plot Name has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		// Check Variables Below //
		String plotNumber = PropertyForm.txtPlotNo.getText();
		if (!Checker.checkNumber(plotNumber)) {
			String msg = "Plot Number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String[] propertyClasses = ListManager.SplitTwoItem((String)PropertyForm.AllClasses.getSelectedItem());
		int propertyClass = Integer.parseInt(propertyClasses[0]);
		String parcel = PropertyForm.txtParcel.getText();

		parcel = Checker.clearString(parcel);

		String landUse = PropertyForm.txtLandUse.getText();
		if (!Checker.checkNumber(landUse)) {
			String msg = "Parcel has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String percentage = PropertyForm.txtPerChange.getText();
		if (!Checker.checkNumber(percentage)) {
			String msg = "Percentage has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String plots = PropertyForm.txtPlots.getText();
		if (!plots.isEmpty()) {
			if (!Checker.checkNumber(plots)) {
				String msg = "Plot has invalid characters";
				Messages.showWarningMessage(msg);
				checked = false;
			}
		}

		String details = PropertyForm.txtExtraDetails.getText();

		String status = PropertyForm.txtStatus.getText();
		status = Checker.clearString(status);
		if ( status.isEmpty()) {
			String msg = "Status has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String floorsNo = PropertyForm.txtFloors.getText();
		if (!Checker.checkNumber(floorsNo)) {
			String msg = "Floors Number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String berdroomsNo = PropertyForm.txtBedrooms.getText();
		if (!Checker.checkNumber(berdroomsNo)) {
			String msg = "Bedrooms number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String bathroomsNo = PropertyForm.txtBathrooms.getText();
		if (!Checker.checkNumber(bathroomsNo)) {
			String msg = "Bathrooms number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String deedNum = PropertyForm.txtDeedNo.getText();
		if (!Checker.checkNumber(deedNum)) {
			String msg = "Deed number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		short rentalGarante = 0;
		if (PropertyForm.chckbxRentalGuarantee.isSelected()) {
			rentalGarante = 1;
		}

		short committed = 0;
		if (PropertyForm.chckbxCommited.isSelected()) {
			committed = 1;
		}

		short rentalPlan = 0;
		if (PropertyForm.chckbxRentalPlan.isSelected()) {
			rentalPlan = 1;
		}

		short titleDeed = 0;
		if (PropertyForm.TitleDeed.isSelected()) {
			titleDeed = 1;
		}
		short pool = 0;
		if (PropertyForm.chckbxPool.isSelected()) {
			pool = 1;
		}
		short parking = 0;
		if (PropertyForm.chckbxParking.isSelected()) {
			parking = 1;
		}
		short garden = 0;
		if (PropertyForm.chckbxGarden.isSelected()) {
			garden = 1;
		}
		short centralHeading = 0;
		if (PropertyForm.chckbxCentralHeading.isSelected()) {
			centralHeading = 1;
		}
		short basement = 0;
		if (PropertyForm.chckbxBasement.isSelected()) {
			basement = 1;
		}

		short airCondition = 0;
		if (PropertyForm.chckbxAirCondition.isSelected()) {
			airCondition = 1;
		}
		short propertyDelivered = 0;
		if (PropertyForm.chckbxPropertyDelivered.isSelected()) {
			propertyDelivered = 1;
		}
		short poolHeading = 0;
		if (PropertyForm.chckbxPoolHeading.isSelected()) {
			poolHeading = 1;
		}

		try {

			/** Remove in the finish **/
			DatabaseConnection database = new DatabaseConnection();
			Statement st = null;
			/*************************/
			st = database.getStatement();

			// Statement st = LogIn.database.getStatement();

			if (checked) {

				int response = JOptionPane
						.showConfirmDialog(null,
								"Do you want to save changes?", "Confirm",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {

					String query = "";
					if (!PropertyForm.edit) {

						query = "INSERT INTO Property VALUES ('" + plotNumber
								+ "','" + plotName + "','" + propertyClass
								+ "','" + parcel + "','" + landUse + "','"
								+ percentage + "','" + plots + "','" + details
								+ "','" + propertyDelivered + "','"
								+ rentalGarante + "','" + committed + "','"
								+ rentalPlan + "','" + status + "','"
								+ floorsNo + "','" + berdroomsNo + "','"
								+ bathroomsNo + "','" + deedNum + "','"
								+ titleDeed + "','" + pool + "','" + parking
								+ "','" + garden + "','" + centralHeading
								+ "','" + basement + "','" + airCondition
								+ "','" + poolHeading + "')";
					} else {
						// 	Need query Here //
					}

					st.executeUpdate(query);
					PropertyClearButton.start();

					PropertyForm.setVisible(false);
					String id = PropertyForm.txtPlotID.getText();
					ListManager.UpdateList(id, plotName, plotNumber, PropertyMenu.AllProperties);
					ListManager.UpdateList(id, plotName, plotNumber, ContractMenu.AllProperties);
					PropertyForm.edit = false;
					Messages.showSaveMessage("Property Added");
				}

			} else {
				System.out.println("Invalid Character or Country Somewhere");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (NullPointerException e) {

			e.printStackTrace();
		}

	}
}
