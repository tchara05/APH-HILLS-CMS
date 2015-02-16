package property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import customer.CustomerForm;

import extras.DatabaseConnection;

/**
 * Issue Here
 * 
 * We dont know yet about parcel, class, land use and some other things which
 * maybe they will be dropdown lists
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Theodoros
 * 
 */

public class PropertyEditButton extends Thread {

	public void run() {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();

		/*************************/

		CustomerForm.edit = true;

		// Statement st = LogIn.database.getStatement();

		ResultSet rst = null;

		String property = (String) PropertyMenu.getSelectedProperty();
		String plotName = "";
		String plotNo = "";
		int i = 0;

		if (property != null) {
			while (property.charAt(i) != ' ' && i < property.length()) {
				plotName = plotNo + property.charAt(i);
				i++;
			}
			i++;
			while (i < property.length()) {
				plotNo = plotNo + property.charAt(i);
				i++;
			}

			try {
				rst = st.executeQuery("SELECT * FROM Property WHERE plotName='"
						+ plotName + "' and plotNo ='" + plotNo + "'");
				if (rst.next() && (rst.getString(1) != null)) {

					new PropertySaveButton().start();
				}
				PropertyForm.setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nothing To Edit",
					"Information Message", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private static void setForm(ResultSet rst) throws SQLException {

		if (rst.getInt(26) == 1) {
			PropertyForm.setPoolHeading(true);
		} else {
			PropertyForm.setPoolHeading(false);
		}

		if (rst.getInt(25) == 1) {
			PropertyForm.setAirCondition(true);
		} else {
			PropertyForm.setAirCondition(false);
		}

		if (rst.getInt(24) == 1) {
			PropertyForm.setBasement(true);
		} else {
			PropertyForm.setBasement(false);
		}

		if (rst.getInt(23) == 1) {
			PropertyForm.setCentralHeading(true);
		} else {
			PropertyForm.setCentralHeading(false);
		}

		if (rst.getInt(22) == 1) {
			PropertyForm.setGarder(true);
		} else {
			PropertyForm.setGarder(false);
		}

		if (rst.getInt(21) == 1) {
			PropertyForm.setParking(true);
		} else {
			PropertyForm.setParking(false);
		}

		if (rst.getInt(20) == 1) {
			PropertyForm.setPool(true);
		} else {
			PropertyForm.setPool(false);
		}

		if (rst.getInt(19) == 1) {
			PropertyForm.setTitleDeed(true);
		} else {
			PropertyForm.setTitleDeed(false);
		}

		PropertyForm.setDeedNo(rst.getString(18));
		PropertyForm.setBathrooms(rst.getString(17));
		PropertyForm.setBedrooms(rst.getString(16));
		PropertyForm.setFloors(rst.getString(15));
		PropertyForm.setStatus(rst.getString(14));

		if (rst.getInt(13) == 1) {
			PropertyForm.setRentalPlan(true);
		} else {
			PropertyForm.setRentalPlan(false);
		}

		if (rst.getInt(12) == 1) {
			PropertyForm.setCommitted(true);
		} else {
			PropertyForm.setCommitted(false);
		}

		if (rst.getInt(11) == 1) {
			PropertyForm.setRentalGuarantte(true);
		} else {
			PropertyForm.setRentalGuarantte(false);
		}

		if (rst.getInt(10) == 1) {
			PropertyForm.setPropertyDelivered(true);
		} else {
			PropertyForm.setPropertyDelivered(false);
		}

		PropertyForm.settxtAreaDetails(rst.getString(9));
		PropertyForm.setPlots(rst.getString(8));
		PropertyForm.setPerChange(rst.getString(7));
		PropertyForm.setLandUse(rst.getString(6));
		PropertyForm.setParcel(rst.getString(5));
		PropertyForm.setPlotClass(rst.getString(4));
		PropertyForm.setPlotName(rst.getString(3));
		PropertyForm.setPlotNo(rst.getString(2));
		PropertyForm.setIDByEdit(rst.getString(1));
	}

}
