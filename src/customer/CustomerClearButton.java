package customer;


public class CustomerClearButton{
	
	
	public static void start(){	
			String val ="";
			CustomerForm.chckbxCloseAccound.setSelected(false);
			CustomerForm.chckbxInformationMaterial.setSelected(false);
			CustomerForm.txtAddress.setText("");
			CustomerForm.txtBussinesNumber.setText("");
			CustomerForm.txtCity.setText("");
			CustomerForm.txtContactNumber.setText("");
			CustomerForm.txtFaxNumber.setText("");
			try {
				CustomerForm.setID() ;
			} catch (Exception e) {
				
			}
			CustomerForm.txtFname.setText("");
			CustomerForm.txtLastName.setText("");
			CustomerForm.txtNote.setText("");
			CustomerForm.txtPhoneMobile.setText("");
			CustomerForm.txtPrimaryMail.setText("");
			CustomerForm.txtSeconadaryMail.setText("");
			CustomerForm.txtZipCode.setText("");
			CustomerForm.edit=false;
			
	}

}
