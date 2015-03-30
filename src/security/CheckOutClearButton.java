package security;

import javax.swing.border.Border;

import customer.CustomerForm;
import security.CheckOut;

public class CheckOutClearButton {
	
	public static void start(int clear) {
		
		String value = "";
		
		Border correct = CheckOut.txtNotes.getBorder();
		if(clear==1){
			
			CheckOut.txtNotes.setText(value);
			
			CheckOut.txtPropertyId.setText(value);
			CheckOut.txtPropertyId.setBorder(correct);
			
			CheckOut.txtKeyId.setText(value);
			CheckOut.txtKeyId.setBorder(correct);
			
			
		}else{
			CheckOut.txtKey.setText(value);
			CheckOut.txtKey.setBorder(correct);
			
			
			CheckOut.txtAvailability.setText(value);
			
			CheckOut.txtPerson.setText(value);
			CheckOut.txtPerson.setBorder(correct);
			
			CheckOut.txtDetails.setText(value);
			CheckOut.txtNotes.setText(value);
			CheckOut.txtKeyId.setText(value);
			
			CheckOut.txtPropertyId.setText(value);
			
			
		}
		
	}
}
