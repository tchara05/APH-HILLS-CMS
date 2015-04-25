package property;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import userMenus.LogIn;
import extras.DatabaseConnection;
import extras.ListManager;


public class PropertyEditButton extends Thread {

	public void run() {


		PropertyForm.edit = true;


		ResultSet rst = null;

		String property = (String) PropertyMenu.AllProperties.getSelectedItem();
		if (property != null) {
			String[] Property = ListManager.SplitThreeItem(property);
			DatabaseConnection database = new DatabaseConnection();
			try {
				rst =  database.getStatement().executeQuery("SELECT * FROM Property WHERE PlotID ='" + Property[0] +"'");
				
				if (rst.next() && (rst.getString(1) != null)) {
					setForm(rst);
				}
				PropertyForm.setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				database.closeDatabaseConnection();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nothing To Edit",
					"Information Message", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private static void setForm(ResultSet rst) throws SQLException {

		if (rst.getInt(26) == 1) {
			PropertyForm.chckbxPoolHeading.setSelected(true);
		} else {
			PropertyForm.chckbxPoolHeading.setSelected(false);
		}

		if (rst.getInt(25) == 1) {
			PropertyForm.chckbxAirCondition.setSelected(true);
		} else {
			PropertyForm.chckbxAirCondition.setSelected(false);
		}

		if (rst.getInt(24) == 1) {
			PropertyForm.chckbxBasement.setSelected(true);
		} else {
			PropertyForm.chckbxBasement.setSelected(false);
		}

		if (rst.getInt(23) == 1) {
			PropertyForm.chckbxCentralHeading.setSelected(true);
		} else {
			PropertyForm.chckbxCentralHeading.setSelected(false);
		}

		if (rst.getInt(22) == 1) {
			PropertyForm.chckbxGarden.setSelected(true);
		} else {
			PropertyForm.chckbxGarden.setSelected(false);
		}

		if (rst.getInt(21) == 1) {
			PropertyForm.chckbxParking.setSelected(true);
		} else {
			PropertyForm.chckbxParking.setSelected(false);
		}

		if (rst.getInt(20) == 1) {
			PropertyForm.chckbxPool.setSelected(true);
		} else {
			PropertyForm.chckbxPool.setSelected(false);
		}

		if (rst.getInt(19) == 1) {
			PropertyForm.TitleDeed.setSelected(true);
		} else {
			PropertyForm.TitleDeed.setSelected(false);
		}

		PropertyForm.txtDeedNo.setText(rst.getString(18));
		PropertyForm.txtBathrooms.setText(rst.getString(17));
		PropertyForm.txtBedrooms.setText(rst.getString(16));
		PropertyForm.txtFloors.setText(rst.getString(15));

		
		if (rst.getInt(13) == 1) {
			PropertyForm.chckbxRentalPlan.setSelected(true);
		} else {
			PropertyForm.chckbxRentalPlan.setSelected(false);
		}

		if (rst.getInt(12) == 1) {
			PropertyForm.chckbxCommited.setSelected(true);
		} else {
			PropertyForm.chckbxCommited.setSelected(false);
		}

		if (rst.getInt(11) == 1) {
			PropertyForm.chckbxRentalGuarantee.setSelected(true);
		} else {
			PropertyForm.chckbxRentalGuarantee.setSelected(false);
		}

		if (rst.getInt(10) == 1) {
			PropertyForm.chckbxPropertyDelivered.setSelected(true);
		} else {
			PropertyForm.chckbxPropertyDelivered.setSelected(false);
		}

		PropertyForm.txtExtraDetails.setText(rst.getString(9));
		PropertyForm.txtPlots.setText(rst.getString(8));
		PropertyForm.txtPerChange.setText(rst.getString(7));
		PropertyForm.txtLandUse.setText(rst.getString(6));
		PropertyForm.txtPlotName.setText(rst.getString(3));
		PropertyForm.txtPlotNo.setText(rst.getString(2));
		PropertyForm.txtPlotID.setText(rst.getString(1));
		
		
		setDropDownListEdit(rst);
	}
	
	
    private static void setDropDownListEdit(ResultSet rst) throws SQLException{
		
		int  generalID= rst.getInt(4);
		int i;
		for (i =0; i<PropertyForm.AllClasses.getItemCount();i++){
			String classess[]=ListManager.SplitTwoItem((String)PropertyForm.AllClasses.getItemAt(i));
			if (Integer.parseInt(classess[0])==generalID){
				break;
			}
		}
		PropertyForm.AllClasses.setSelectedIndex(i);
		
		generalID = rst.getInt(5);
		for (i =0; i<PropertyForm.AllParcels.getItemCount();i++){
			
			String parcels[]=ListManager.SplitTwoItem((String)PropertyForm.AllParcels.getItemAt(i));
			if (Integer.parseInt(parcels[0])==generalID){
				break;
			}
		}	
		PropertyForm.AllParcels.setSelectedIndex(i);	
		
		generalID = rst.getInt(14);
		for (i =0; i<PropertyForm.AllStatus.getItemCount();i++){
			
			String status[]=ListManager.SplitTwoItem((String)PropertyForm.AllStatus.getItemAt(i));
			if (Integer.parseInt(status[0])==generalID){
				break;
			}
		}
		PropertyForm.AllStatus.setSelectedIndex(i);	
		
	}	
	

}
