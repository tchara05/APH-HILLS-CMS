package security;

import security.CheckOut;

public class CheckOutClearButton {
	
	public static void start(int clear) {
		
		String value = "";
	
		if(clear==1){
			CheckOut.txtNotes.setText(value);
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
