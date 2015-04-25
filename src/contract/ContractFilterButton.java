package contract;

import extras.ListManager;
import extras.Query;

/**
 * Thread that helps user to retrieve specific properties from the 
 * Database and puts the results into a DropDownList. 
 * @author TeamD
 *
 */

public class ContractFilterButton extends Thread {
	
	
	/**
	 *  Overwrite the Thread's method run.
	 *  
	 *  The specific thread connects with the database and retrieves (filters) 
	 *  properties with specific characteristic.
	 *  The user choose from AllParcel (DropDownList) and AllClasses(DropDownList)
	 *  and the thread retrieves the Properties with these characteristic.
	 *  All results (Properties) goes into AllProperties (DropdownList) and user
	 *  can choose something from there.
	 *  
	 * @author TeamD
	 */
	
	public void run(){
		
		String parcel[] = ListManager.SplitTwoItem((String)ContractMenu.AllParcels.getSelectedItem());
		String classes[] = ListManager.SplitTwoItem((String)ContractMenu.AllClasses.getSelectedItem());
		String query="";
		ContractMenu.AllProperties.removeAllItems();
		if (!parcel[0].equals("0") && !classes[0].equals("0") ){
			query = "SELECT plotID, plotName , PlotNumber FROM Property " +
						"WHERE propertyClassNo ='"+classes[0]+"' AND parcelNo ='"+parcel[0]+"'"+
						"ORDER BY plotName , plotNumber";
		}else if(parcel[0].equals("0") && !classes[0].equals("0")){
			query = "SELECT plotID, plotName , PlotNumber FROM Property " +
					"WHERE propertyClassNo ='"+classes[0]+
					"' ORDER BY plotName , plotNumber";
		}else if (!parcel[0].equals("0") && classes[0].equals("0")) {
			query = "SELECT plotID, plotName , PlotNumber FROM Property " +
					"WHERE parcelNo ='"+parcel[0]+
					"' ORDER BY plotName , plotNumber";
		}else{
			ListManager.setUpThreeList(ContractMenu.AllProperties,Query.PROPERTY_ID_NAME_NUMBER);
			return ;
		}
		ListManager.setUpThreeList(ContractMenu.AllProperties, query);
	}
	
}
