package Threads;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Forms.Contract;
import Forms.ContractForm;

import Forms.MainForm;
import Forms.Customer;
import Forms.Property;




public class BtnAddContract extends Thread {
	
	public void run(){
		
		
		
		if (!EmptyField()){
					
		Contract c = new Contract();
		c.setCode(ContractForm.getCode());
		ArrayList<Customer> cust=MainForm.getCustomers();
		
		Customer cu=cust.get(0);
		
		
		for (int i=0;i<cust.size();i++){
			
			
			cu=cust.get(i);
			
			
			if(cu.getCode()!=ContractForm.getCode()){
				break;
		}
		
			
			
		}
		c.setLName(cu.getLName());
		c.setFName(cu.getFName());
		c.setSFName(ContractForm.getSFName());
		c.setSLName(ContractForm.getSLName());
		c.setPEmail(cu.getEmail1());
		c.setSEmail(cu.getEmail2());
		c.setCity(cu.getCity());
		c.setCountry(cu.getCountry());
		c.setZipCode(cu.getZipCode());
		c.setAddress(cu.getAddress());
		c.setBusinessPhone(cu.getPhoneBus());
		c.setMobilePhone(cu.getPhoneMobile());
		c.setContactPhone(cu.getPhoneCon());
		c.setFax(cu.getFax());
		//c.setIMaterial(Integer.parseInt(ContractForm.getIMaterial()));
		c.setNote(cu.getNote());
		
		ArrayList<Property> prop=MainForm.getProperties();
		
		Property pro=prop.get(0);
		for(int j=0;j<prop.size();j++){
			
			pro=prop.get(j);
			if (pro.getPlotID() == ContractForm.getPlotID()){
				break;
			}
	
		
		}

		c.setPlotID(pro.getPlotID());
		
		cu.getPropertys().add(pro);
		
		MainForm.getContracts().add(c);
		
		//ContractForm.setAccountClosed(false);
		ContractForm.setLName("");
		ContractForm.setSFName("");
		ContractForm.setSLName("");
		ContractForm.setFName("");
		ContractForm.setPEmail("");
		ContractForm.setSEmail("");
		ContractForm.setCity("");
		ContractForm.setCountry("");
		ContractForm.setZipCode("");
		ContractForm.setAddress("");
		ContractForm.setCode("");
		ContractForm.setBusinessPhone("");
		ContractForm.setMobilePhone((""));
		ContractForm.setContactPhone((""));
		ContractForm.setFax("");
		//ContractForm.setIMaterial("");
		ContractForm.setNote("");
		ContractForm.setPlotID("");
		
		
		
		
		System.out.println(MainForm.getProperties());
		JOptionPane.showMessageDialog(null,
			"Contract Added OK",
				"ADDED", JOptionPane.INFORMATION_MESSAGE);
		
		}
		
		
		
		
	}
	
	public boolean EmptyField(){
		
		if (ContractForm.getLName().equals("")){
			
			JOptionPane.showMessageDialog(null,
					"LName Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);	
			return true;
		}
		
		if (ContractForm.getSFName().equals("")){
			JOptionPane.showMessageDialog(null,
					"SFName Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		if (ContractForm.getSLName().equals("")){
			JOptionPane.showMessageDialog(null,
					"SLName Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		if (ContractForm.getFName().equals("")){
			JOptionPane.showMessageDialog(null,
					"FName Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		if (ContractForm.getPEmail().equals("")){
			JOptionPane.showMessageDialog(null,
					"PEmail Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (ContractForm.getSEmail().equals("")){
			JOptionPane.showMessageDialog(null,
					"SEmail Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		if (ContractForm.getCity().equals("")){
			JOptionPane.showMessageDialog(null,
					"City Name Field is Empty \n" +
					"If you want thes field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (ContractForm.getCountry().equals("")){
			JOptionPane.showMessageDialog(null,
					"Country Name Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		if (ContractForm.getZipCode().equals("")){
			JOptionPane.showMessageDialog(null,
					"Zip Code Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (ContractForm.getAddress().equals("")){
			JOptionPane.showMessageDialog(null,
					"Address Phone Field is Empty \n" +
					"If you want thes field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
//		if (ContractForm.getCode()!=){
//			JOptionPane.showMessageDialog(null,
//					"Code Field is Empty \n" +
//					"If you want this field empty add <none>",
///					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
//			return true;
			
	///	}
		
		if (ContractForm.getBusinessPhone().equals("")){
			JOptionPane.showMessageDialog(null,
					"Business Phone Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		if (ContractForm.getMobilePhone().equals("")){
			JOptionPane.showMessageDialog(null,
					"Mobile Phone Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		if (ContractForm.getContactPhone().equals("")){
			JOptionPane.showMessageDialog(null,
					"Contact Phone Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		if (ContractForm.getFax().equals("")){
			JOptionPane.showMessageDialog(null,
					"Fax Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
	/*	if (ContractForm.getIMaterial().equals("")){
			JOptionPane.showMessageDialog(null,
					"Material Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}*/
		if (ContractForm.getNote().equals("")){
			JOptionPane.showMessageDialog(null,
					"Note Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		if (ContractForm.getPlotID().equals("")){
			JOptionPane.showMessageDialog(null,
					"PlotID Field is Empty \n" +
					"If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		
		
		
		return false;
		
	}

}
