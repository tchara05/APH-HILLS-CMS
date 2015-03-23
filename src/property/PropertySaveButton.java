package property;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import userMenus.LogIn;
import contract.ContractMenu;
import customer.CustomerForm;
import extras.Checker;
import extras.ListManager;
import extras.Messages;

public class PropertySaveButton extends Thread {

	/* This classes need improvements */

	public void run() {

		boolean checked = true;
		
		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red,2);

		String plotName = PropertyForm.txtPlotName.getText();
		//plotName = Checker.clearString(plotName);
		if ( (!Checker.checkString(plotName) )|| (plotName.isEmpty()) ) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPlotName.setBorder(compound);
			checked = false;
			compound = null;
		}

		// Check Variables Below //
		String plotNumber = PropertyForm.txtPlotNo.getText();
		if (!Checker.checkNumber(plotNumber)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPlotNo.setBorder(compound);
			checked = false;
			compound = null;
		}
		else{
			PropertyForm.txtPlotNo.setBorder(compound);
		}

		String[] propertyClasses = ListManager.SplitTwoItem((String)PropertyForm.AllClasses.getSelectedItem());
		int propertyClass = Integer.parseInt(propertyClasses[0]);
		
		
		String propertyParcel[] =ListManager.SplitTwoItem((String)PropertyForm.AllParcels.getSelectedItem());
		String parcel=propertyParcel[0];
		
		String propertyStatus[] =ListManager.SplitTwoItem((String)PropertyForm.AllStatus.getSelectedItem());
		String status=propertyStatus[0];

		String landUse = PropertyForm.txtLandUse.getText();
		if (!Checker.checkNumber(landUse)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtLandUse.setBorder(compound);
			checked = false;
			compound = null;
			
		}

		String percentage = PropertyForm.txtPerChange.getText();
		if (!Checker.checkNumber(percentage)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPerChange.setBorder(compound);
			checked = false;
			compound = null;
		}

		String plots = PropertyForm.txtPlots.getText();
		if ( (!plots.isEmpty()) || (!Checker.checkNumber(plots)) ) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPlots.setBorder(compound);
			checked = false;
			compound = null;
		}

		String details = PropertyForm.txtExtraDetails.getText();

		String floorsNo = PropertyForm.txtFloors.getText();
		if (!Checker.checkNumber(floorsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtFloors.setBorder(compound);
			checked = false;
			compound = null;
		}

		String bedroomsNo = PropertyForm.txtBedrooms.getText();
		if (!Checker.checkNumber(bedroomsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtBedrooms.setBorder(compound);
			checked = false;
			compound = null;
		}

		String bathroomsNo = PropertyForm.txtBathrooms.getText();
		if (!Checker.checkNumber(bathroomsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtBathrooms.setBorder(compound);
			checked = false;
			compound = null;
		}

		String deedNum = PropertyForm.txtDeedNo.getText();
		if (!Checker.checkNumber(deedNum)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtDeedNo.setBorder(compound);
			checked = false;
			compound = null;
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
		
		if (!checked){
			Messages.showWarningMessage("Complete All Details");
		}
		
		

		try {

			

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
								+ floorsNo + "','" + bedroomsNo + "','"
								+ bathroomsNo + "','" + deedNum + "','"
								+ titleDeed + "','" + pool + "','" + parking
								+ "','" + garden + "','" + centralHeading
								+ "','" + basement + "','" + airCondition
								+ "','" + poolHeading + "')";
					} else {
						query = "UPDATE Property SET plotNumber='"+plotNumber
								+"', plotName='"+plotName+"', propertyClassNo='"+propertyClass
								+"', parcelNo='" +parcel+"', landUse='"+landUse+"',percentage= '"
								+percentage+"', plots='"+plots+"', details='"+details+"',propertyDelivered='"
								+propertyDelivered+"', rentalGuarantee='"+rentalGarante+"', committedProperty='"
								+committed+"',rentalPlan ='"+rentalPlan+"',propertyStatus='"+status
								+"', numberOfFloors='"+floorsNo+"',numberOfBedrooms ='"+bedroomsNo
								+"', numberOfBathrooms ='"+bathroomsNo +"', deedNumber='"+deedNum
								+"', titleDeed ='"+titleDeed+"', poolProperty ='"+pool+"', parking='"
								+parking +"', garden ='"+garden+"', centralHeading ='"+centralHeading
								+"', basement='"+basement+"', airCondition ='"+airCondition
								+"', poolHeading ='"+poolHeading+"' WHERE plotID='"+ PropertyForm.txtPlotID.getText()
								+"'";
						
								String del =ListManager.DeleteFromList(PropertyMenu.AllProperties);	
								ContractMenu.AllProperties.removeItem(del);
					}

					LogIn.database.getStatement().executeUpdate(query);
					PropertyForm.setVisible(false);
					String id = PropertyForm.txtPlotID.getText();
					ListManager.UpdateList(id, plotName, plotNumber, PropertyMenu.AllProperties);
					ListManager.UpdateList(id, plotName, plotNumber, ContractMenu.AllProperties);
					PropertyForm.edit = false;
					PropertyClearButton.start();
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
