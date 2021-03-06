package property;

import javax.swing.border.Border;

/**
 * Class that clear a window for the property form .
 *
 *
 * @author TeamD
 *
 */

public class PropertyClearButton  {
	/**
	 * This method clear all fields on Property form 
	 * window
	 *
	 */
	
	public static void start(){
		
		
		
				
		PropertyForm.chckbxAirCondition.setSelected(false);
		PropertyForm.chckbxBasement.setSelected(false);
		PropertyForm.chckbxCentralHeading.setSelected(false);
		PropertyForm.chckbxCommited.setSelected(false);
		PropertyForm.chckbxGarden.setSelected(false);
		PropertyForm.chckbxParking.setSelected(false);
		PropertyForm.chckbxPool.setSelected(false);
		PropertyForm.chckbxPoolHeading.setSelected(false);
		PropertyForm.chckbxPropertyDelivered.setSelected(false);
		PropertyForm.TitleDeed.setSelected(false);
		
		
		Border compound = PropertyForm.txtPlotID.getBorder();
		
		PropertyForm.txtBathrooms.setText("");
		PropertyForm.txtBathrooms.setBorder(compound);
		
		PropertyForm.txtBedrooms.setText("");
		PropertyForm.txtBedrooms.setBorder(compound);
		
		PropertyForm.txtDeedNo.setText("");
		PropertyForm.txtDeedNo.setBorder(compound);
		
		PropertyForm.txtExtraDetails.setText("");
		
		PropertyForm.txtPlotName.setText("");
		PropertyForm.txtPlotName.setBorder(compound);
		
		PropertyForm.txtPlotNo.setText("");
		PropertyForm.txtPlotNo.setBorder(compound);
		
		PropertyForm.txtPlots.setText("");
		PropertyForm.txtPlots.setBorder(compound);
		
		PropertyForm.txtFloors.setText("");
		PropertyForm.txtFloors.setBorder(compound);
		
		PropertyForm.txtLandUse.setText("");
		PropertyForm.txtLandUse.setBorder(compound);
		
		PropertyForm.txtPerChange.setText("");
		PropertyForm.txtPerChange.setBorder(compound);
		
		PropertyForm.setPlotID();
		
		PropertyForm.chckbxRentalGuarantee.setSelected(false);
		PropertyForm.chckbxRentalPlan.setSelected(false);
		PropertyForm.edit = false;
		PropertyForm.AllStatus.setSelectedIndex(0);
		PropertyForm.AllClasses.setSelectedIndex(0);
		PropertyForm.AllParcels.setSelectedIndex(0);
		
	}
	
	

}
