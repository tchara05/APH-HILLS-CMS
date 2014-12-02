package Forms;

public class Cost {
	
	
	private double Service = 400;
	private double Proforma;
	private double Invoice ;
	int  customerID;
	
	public Cost(){
		
		Proforma = 0;
		Invoice = 0;
	}
	
	public void CalculateProforma(int visited){
		
		Proforma  = visited*Service; 
	}
	
	public void CalculateInvoiceCost(){
		
		Invoice =Invoice + Proforma *18 /100;
	}
	
	
	public double getInvoiceCost(){
		
		return Invoice;
		
	}
	
	public double getProforma(){
		return Proforma;
	}
	
	

}
