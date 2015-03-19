package contract;

import extras.ListManager;
import extras.Query;

public class FilterByNoContractButton extends Thread {
	
	public void run(){
		
		

		ContractMenu.AllProperties.removeAllItems();
		ListManager.setUpTwoColumnsList(ContractMenu.AllProperties, Query.PLOTS_WITH_NO_CONTRACTS);
	}

}
