package contract;

import org.junit.Test;

import extras.ListManager;
import extras.Query;

public class ContractFilterButton extends Thread {
	
	
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
