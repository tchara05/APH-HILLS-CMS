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
	/**
	 * 
	 * Method that connect to a database and execute querie for
	 * PLOTS WITH NO CONTRACTS
	 * 
	 * After the execution of the querie the lists of the All 
	 * property update
	 * 
	 */

	public void run(){
		
		ContractMenu.AllProperties.removeAllItems();
		ListManager.setUpThreeList(ContractMenu.AllProperties, Query.PLOTS_WITH_NO_CONTRACTS);
	}

}
