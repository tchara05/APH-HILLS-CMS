package customer;

import java.awt.Color;

import javax.swing.border.Border;


public class CustomerClearButton{
	
	
	public static void start(){
			CustomerForm.chckbxCloseAccound.setSelected(false);
			CustomerForm.chckbxInformationMaterial.setSelected(false);
			CustomerForm.txtCity.setText("");
			try {
				CustomerForm.setID();
			} catch (Exception e) {
				
			}
			Border compound = CustomerForm.txtID.getBorder();
			
			CustomerForm.txtFname.setText("");
			CustomerForm.txtFname.setBorder(compound);
			
			CustomerForm.txtLastName.setText("");
			CustomerForm.txtLastName.setBorder(compound);
			
			CustomerForm.txtNote.setText("");
			
			CustomerForm.txtPhoneMobile.setText("");
			CustomerForm.txtPhoneMobile.setBorder(compound);
			
			CustomerForm.txtPrimaryMail.setText("");
			CustomerForm.txtPrimaryMail.setBorder(compound);
			
			CustomerForm.txtSeconadaryMail.setText("");
			CustomerForm.txtSeconadaryMail.setBorder(compound);
			
			CustomerForm.txtZipCode.setText("");
			CustomerForm.txtZipCode.setBorder(compound);
			
			CustomerForm.txtBussinesNumber.setText("");
			CustomerForm.txtBussinesNumber.setBorder(compound);
			
			CustomerForm.txtCity.setText("");
			CustomerForm.txtCity.setBorder(compound);
			
			CustomerForm.txtContactNumber.setText("");
			CustomerForm.txtContactNumber.setBorder(compound);
			
			CustomerForm.txtFaxNumber.setText("");
			CustomerForm.txtFaxNumber.setBorder(compound);
			
			CustomerForm.txtAddress.setText("");
			CustomerForm.txtAddress.setBorder(compound);
			
			CustomerForm.edit=false;
			
	}

}
