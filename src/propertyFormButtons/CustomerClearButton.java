package propertyFormButtons;

import customer.CustomerForm;

public class CustomerClearButton extends Thread {
	
	
	
	public void run(){
		
			String val ="";
			CustomerForm.setAddress(val);
			CustomerForm.setBussinesNumber(val);
			CustomerForm.setCity(val);
			CustomerForm.setCloseAccound(false);
			CustomerForm.setContactNumber(val);
			CustomerForm.setFaxNumber(val);
			CustomerForm.setFname(val);
			CustomerForm.setID(val);
			CustomerForm.setInformationMaterial(false);
			CustomerForm.setLastName(val);
			CustomerForm.setNote(val);
			CustomerForm.setPhoneMobile(val);
			CustomerForm.setPrimaryMail(val);
			CustomerForm.setSecondaryMail(val);
			CustomerForm.setZipCode(val);		
	}

}
