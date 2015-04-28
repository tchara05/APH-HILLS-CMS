package property;


import extras.ListManager;
import extras.Query;



/**
 * Thread that search properties by categories
 * 
 * 
 * 
 * @author TeamD
 *
 */

public class PropertySearchButton extends Thread {
	
	
	/**
	 * Method for thread to start and search for properties in database.
	 * 
	 * Takes data from dropdown list,connects to database and finds 
	 * the specific property
	 * 
	 * 
	 * 
	 * 
	 */
	

		
		
		public void run(){
			
			String parcel[] = ListManager.SplitTwoItem((String)PropertyMenu.AllParcels.getSelectedItem());
			String classes[] = ListManager.SplitTwoItem((String)PropertyMenu.AllClasses.getSelectedItem());
			String query="";
			PropertyMenu.AllProperties.removeAllItems();
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
				ListManager.setUpThreeList(PropertyMenu.AllProperties,Query.PROPERTY_ID_NAME_NUMBER);
				return ;
			}
			ListManager.setUpThreeList(PropertyMenu.AllProperties, query);
			
			
		}
		



}
