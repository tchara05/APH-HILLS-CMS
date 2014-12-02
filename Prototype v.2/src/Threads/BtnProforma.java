package Threads;

import java.util.ArrayList;

import Forms.Customer;
import Forms.MainForm;
import Forms.PDFexporter;

public class BtnProforma extends Thread {
	
	
	public void run(){
		
		ArrayList<Customer> t = new ArrayList<Customer>();
		
		t = MainForm.getCustomers();
		
		
		System.out.println(t);
		
		for (int i = 0;i<t.size();i++){
			
			PDFexporter tt = new PDFexporter();
			Customer c = t.get(i);
			tt.setCustomer(c);
			tt.setDocType(2);
			System.out.println(c.getPropertys());
			
			
			try {
				
				tt.creat_Invoice(2);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
	
	
	

}
