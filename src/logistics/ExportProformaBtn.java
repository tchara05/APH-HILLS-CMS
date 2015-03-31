package logistics;

import extras.Messages;


public class ExportProformaBtn extends Thread {
	
	
	
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
