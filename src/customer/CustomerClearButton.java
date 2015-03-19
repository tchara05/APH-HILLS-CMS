package customer;

import java.awt.Color;


public class CustomerClearButton{
	
	
	public static void start(){
			CustomerForm.chckbxCloseAccound.setSelected(false);
			CustomerForm.chckbxInformationMaterial.setSelected(false);
			CustomerForm.txtAddress.setText("");
			CustomerForm.txtBussinesNumber.setText("");
			CustomerForm.txtCity.setText("");
			CustomerForm.txtContactNumber.setText("");
			CustomerForm.txtFaxNumber.setText("");
			try {
				CustomerForm.setID();
			} catch (Exception e) {
				
			}
			CustomerForm.txtFname.setText("");
			CustomerForm.txtFname.setBackground(Color.WHITE);
			CustomerForm.txtLastName.setText("");
			CustomerForm.txtLastName.setBackground(Color.WHITE);
			CustomerForm.txtNote.setText("");
			CustomerForm.txtPhoneMobile.setText("");
			CustomerForm.txtPhoneMobile.setBackground(Color.WHITE);
			CustomerForm.txtPrimaryMail.setText("");
			CustomerForm.txtPrimaryMail.setBackground(Color.WHITE);
			CustomerForm.txtSeconadaryMail.setText("");
			CustomerForm.txtSeconadaryMail.setBackground(Color.WHITE);
			CustomerForm.txtZipCode.setText("");
			CustomerForm.txtZipCode.setBackground(Color.WHITE);
			CustomerForm.edit=false;
			
	}

}
