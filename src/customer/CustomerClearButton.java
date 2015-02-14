package customer;


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
			try {
				CustomerForm.setID() ;
			} catch (Exception e) {
				
			}
			CustomerForm.setInformationMaterial(false);
			CustomerForm.setLastName(val);
			CustomerForm.setNote(val);
			CustomerForm.setPhoneMobile(val);
			CustomerForm.setPrimaryMail(val);
			CustomerForm.setSecondaryMail(val);
			CustomerForm.setZipCode(val);		
	}

}
