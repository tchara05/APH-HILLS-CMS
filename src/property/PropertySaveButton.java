package property;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.Checker;
import extras.DatabaseConnection;

public class PropertySaveButton extends Thread {

	/* This classes need improvements */

	public void run() {

		boolean checked = true;

		String plotName = PropertyForm.getPlotName();
		if (!Checker.checkString(plotName) && checked) {
			JOptionPane.showMessageDialog(null,
					"Plot Name has invalid characters", "Inane warning",
					JOptionPane.WARNING_MESSAGE);
			checked = false;
		}

		// Check Variables Below //
		String plotNumber = PropertyForm.getPlotNo();
		String propertyClass = PropertyForm.getPlotClass();
		String parcel = PropertyForm.getParcel();
		String landUse = PropertyForm.getLandUse();
		String percentage = PropertyForm.getPercentage();
		String plots = PropertyForm.getPlots();
		String details = PropertyForm.getDetails();
		String status = PropertyForm.getStatus();
		String floorsNo = PropertyForm.getFloors();
		String berdroomsNo = PropertyForm.getBedrooms();
		String bathroomsNo = PropertyForm.getBathrooms();
		String deedNum = PropertyForm.getDeedNo();

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

						// UpdateQuery Here //
					}

					st.executeUpdate(query);
					PropertyClearButton.start();
					JOptionPane.showMessageDialog(null, "Preperty Added",
							"Information Message",
							JOptionPane.INFORMATION_MESSAGE);

					PropertyForm.setVisible(false);
					PropertyMenu.UpdatePropertyList(plotName, plotNumber);
					PropertyForm.edit = false;

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
