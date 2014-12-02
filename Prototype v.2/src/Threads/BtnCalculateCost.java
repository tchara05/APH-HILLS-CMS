package Threads;

import java.util.ArrayList;

import Forms.Customer;
import Forms.MainForm;

public class BtnCalculateCost extends Thread {

	
	
	public void run(){
		
		ArrayList<Customer> customers = MainForm.getCustomers();
		
		Customer c ;
		for (int i = 0; i<customers.size();i++){
			
			c = customers.get(i);
			c.CalculateCost();
			
				
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
