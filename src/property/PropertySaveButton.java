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

		String plotName = PropertyForm.getPlotName();
		plotName = Checker.clearString(plotName);
		if (!Checker.checkString(plotName) || (plotName.isEmpty())) {
			String msg = "Plot Name has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		// Check Variables Below //
		String plotNumber = PropertyForm.getPlotNo();
		if (!Checker.checkNumber(plotNumber)) {
			String msg = "Plot Number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		int propertyClass = PropertyForm.getPlotClass();

		String parcel = PropertyForm.getParcel();

		parcel = Checker.clearString(parcel);

		String landUse = PropertyForm.getLandUse();
		if (!Checker.checkNumber(landUse)) {
			String msg = "Parcel has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String percentage = PropertyForm.getPercentage();
		if (!Checker.checkNumber(percentage)) {
			String msg = "Percentage has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String plots = PropertyForm.getPlots();
		if (!plots.isEmpty()) {
			if (!Checker.checkNumber(plots)) {
				String msg = "Plot has invalid characters";
				Messages.showWarningMessage(msg);
				checked = false;
			}
		}

		String details = PropertyForm.getDetails();

		String status = PropertyForm.getStatus();
		status = Checker.clearString(status);
		if ( status.isEmpty()) {
			String msg = "Status has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String floorsNo = PropertyForm.getFloors();
		if (!Checker.checkNumber(floorsNo)) {
			String msg = "Floors Number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String berdroomsNo = PropertyForm.getBedrooms();
		if (!Checker.checkNumber(berdroomsNo)) {
			String msg = "Bedrooms number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String bathroomsNo = PropertyForm.getBathrooms();
		if (!Checker.checkNumber(bathroomsNo)) {
			String msg = "Bathrooms number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		String deedNum = PropertyForm.getDeedNo();
		if (!Checker.checkNumber(deedNum)) {
			String msg = "Deed number has invalid characters";
			Messages.showWarningMessage(msg);
			checked = false;
		}

		short rentalGarante = 0;
		if (PropertyForm.getRentalGuarantte()) {
			rentalGarante = 1;
		}

		short committed = 0;
		if (PropertyForm.getCommitted()) {
			committed = 1;
		}

		short rentalPlan = 0;
		if (PropertyForm.getRentalPlan()) {
			rentalPlan = 1;
		}

		short titleDeed = 0;
		if (PropertyForm.getTitleDeed()) {
			titleDeed = 1;
		}
		short pool = 0;
		if (PropertyForm.getPool()) {
			pool = 1;
		}
		short parking = 0;
		if (PropertyForm.getParking()) {
			parking = 1;
		}
		short garden = 0;
		if (PropertyForm.getGarder()) {
			garden = 1;
		}
		short centralHeading = 0;
		if (PropertyForm.getCentralHeading()) {
			centralHeading = 1;
		}
		short basement = 0;
		if (PropertyForm.getBasement()) {
			basement = 1;
		}

		short airCondition = 0;
		if (PropertyForm.getAirCondition()) {
			airCondition = 1;
		}
		short propertyDelivered = 0;
		if (PropertyForm.getPropertyDelivered()) {
			propertyDelivered = 1;
		}
		short poolHeading = 0;
		if (PropertyForm.getPoolHeading()) {
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
					JOptionPane.showMessageDialog(null, "Preperty Added",
							"Information Message",
							JOptionPane.INFORMATION_MESSAGE);

					PropertyForm.setVisible(false);
					String id = PropertyForm.getPlotID();
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
