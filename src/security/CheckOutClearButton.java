package security;

import javax.swing.border.Border;

import customer.CustomerForm;
import security.CheckOut;

public class CheckOutClearButton {
	
	public static void start(int clear) {
		
		String value = "";
		
		Border correct = CheckOut.txtPerson.getBorder();
		if(clear==1){
			
			CheckOut.txtNotes.setText(value);
			
			CheckOut.txtPropertyId.setText(value);
			CheckOut.txtPropertyId.setBorder(correct);
			
			CheckOut.txtKeyId.setText(value);
			CheckOut.txtKeyId.setBorder(correct);
			
			
		}else{
			CheckOut.txtKey.setText(value);
			
			
			CheckOut.txtAvailability.setText(value);
			CheckOut.txtPerson.setText(value);
			CheckOut.txtDetails.setText(value);
			CheckOut.txtNotes.setText(value);
			CheckOut.txtKeyId.setText(value);
			
			CheckOut.txtPropertyId.setText(value);
			
			
		}
		
	}
}
