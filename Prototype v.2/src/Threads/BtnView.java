package Threads;

import Forms.*;

import java.util.ArrayList;

import Forms.Contract;
import Forms.Customer;
import Forms.MainForm;
import Forms.Property;

public class BtnView extends Thread {

	public void run(){
	
	
	ArrayList<Customer> cust=MainForm.getCustomers();
	
	Customer cu= null;
	
	for (int i=0; i<cust.size();i++){
		
		cu =cust.get(i);
		
		if (cu.getCustomerID() == ContractForm.getCode()){
			break;
		}
		
	}
	ContractForm.setLName(cu.getLName());
	ContractForm.setFName(cu.getFName());
	ContractForm.setSFName("");
	ContractForm.setSLName("");
	ContractForm.setPEmail(cu.getEmail1());
	ContractForm.setSEmail(cu.getEmail2());
	ContractForm.setCity(cu.getCity());
	ContractForm.setCountry(cu.getCountry());
	ContractForm.setZipCode(cu.getZipCode());
	ContractForm.setAddress(cu.getAddress());
	ContractForm.setBusinessPhone(cu.getPhoneBus());
	ContractForm.setMobilePhone(cu.getPhoneMobile());
	ContractForm.setContactPhone(cu.getPhoneCon());
	ContractForm.setFax(cu.getFax());
	
	//c.setIMaterial(Integer.parseInt(ContractForm.getIMaterial()));
	ContractForm.setNote(cu.getNote());
	
ArrayList<Property> prop=MainForm.getProperties();
	
	Property pro=prop.get(0);

	for(int j = 0;j<prop.size();j++){
		pro=prop.get(j);
		if (ContractForm.getPlotID() ==pro.getPlotID() ){
			break;
		}
		
	}
	ContractForm.setPlotID(pro.getPlotID());	
	
	}
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
}
