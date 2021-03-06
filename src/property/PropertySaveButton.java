package property;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import userMenus.LogIn;
import contract.ContractMenu;
import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
/**
 * Class that can insert a Customer into Database.
 * Take all values from field and checked. 
 * Then Connect to database and execute query to save Customer
 *
 *
 * @author TeamD
 *
 */
public class PropertySaveButton extends Thread {


	/**
	 * This method take all value from fields and checked if are correct. 
	 * If all value from field are not correct set red Boarder all incorrect fields.
	 * If all value from field are  correct connect to database and execute query 
	 * to save Property.Method that connect to a database and execute query to insert
	 * a Property into Database.
	 * 
	 * 
	 */
	public void run() {

		boolean checked = true;
		
		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red,2);
		
		Border correct =PropertyForm.txtPlotID.getBorder();
		String id = PropertyForm.txtPlotID.getText();

		String plotName = PropertyForm.txtPlotName.getText();
		//plotName = Checker.clearString(plotName);
		if ( (!Checker.checkString(plotName) )|| (plotName.isEmpty()) ) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPlotName.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtPlotName.setBorder(correct);
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
			PropertyForm.txtPlotNo.setBorder(correct);
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
			
		}else{
			PropertyForm.txtLandUse.setBorder(correct);
		}

		String percentage = PropertyForm.txtPerChange.getText();
		if (!Checker.checkNumber(percentage)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPerChange.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtPerChange.setBorder(correct);
		}

		String plots = PropertyForm.txtPlots.getText();
		if ( !Checker.checkNumber(plots))  {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtPlots.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtPlots.setBorder(correct);
		}

		String details = PropertyForm.txtExtraDetails.getText();

		String floorsNo = PropertyForm.txtFloors.getText();
		if (!Checker.checkNumber(floorsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtFloors.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtFloors.setBorder(correct);
		}

		String bedroomsNo = PropertyForm.txtBedrooms.getText();
		if (!Checker.checkNumber(bedroomsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtBedrooms.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtBedrooms.setBorder(correct);
		}

		String bathroomsNo = PropertyForm.txtBathrooms.getText();
		if (!Checker.checkNumber(bathroomsNo)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtBathrooms.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtBathrooms.setBorder(correct);
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
		
		
		
		String deedNum = PropertyForm.txtDeedNo.getText();
		if (titleDeed==1 && !Checker.checkNumber(deedNum)) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			PropertyForm.txtDeedNo.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			PropertyForm.txtDeedNo.setBorder(correct);
		}
		
		if (!checked){
			Messages.showWarningMessage("Complete All Details");
		}
		DatabaseConnection database = new DatabaseConnection();
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
					database.getStatement().executeUpdate(query);
					PropertyForm.setVisible(false);
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
		}finally{
			database.closeDatabaseConnection();
		}

	}
}
