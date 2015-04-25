package contract;

import extras.ListManager;
import extras.Query;


/**
 * Thread that retrieves all properties without contracts.
 * 
 * Connects to database and execute a query.
 * 
 * @author TeamD
 *
 */



public class FilterByNoContractButton extends Thread {
	
	public void run(){
		
		ContractMenu.AllProperties.removeAllItems();
		ListManager.setUpTwoColumnsList(ContractMenu.AllProperties, Query.PLOTS_WITH_NO_CONTRACTS);
	}

}
