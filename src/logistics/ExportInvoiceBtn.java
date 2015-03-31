package logistics;

public class ExportInvoiceBtn extends Thread {
	
	public void run(){
		
		String customer = (String) accountantPanel.AllCustomers.getSelectedItem();
		try {
			CompanyDocument.CreateInvoice(customer);
		} catch (Exception e) {
			System.out.println("Create Invoice");
			e.printStackTrace();
		}
		
	}

}
