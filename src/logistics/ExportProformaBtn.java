package logistics;

import extras.Messages;
/**
 * Class create the all Proforma for any customer 
 * has property in active when the ExportProforma 
 * button clicked. And create pdf file for each 
 * customer.
 *
 *
 * @author TeamD
 *
 */

public class ExportProformaBtn extends Thread {
	/**
	 * 
	 * Method that  create pdf file (proforma) for each 
	 * customer and show the proper messages.
	 * 
	 * 
	 * 
	 */
	public void run(){
		
		try {
			CompanyDocument.createAllProforma();
			Messages.showSaveMessage("All Proforma Created");
		} catch (Exception e1) {
			System.out.println("Proforma Exporting");
			e1.printStackTrace();
		}
		
	}

}
