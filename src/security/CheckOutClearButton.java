package security;

import javax.swing.border.Border;
import security.CheckOut;

/**
 * 
 * This class clear all fields in Checkout form
 * 
 * @author TeamD
 * 
 */

public class CheckOutClearButton {

	/**
	 * this method clear all fields in checkout form 
	 * 
	 * 
	 * @param clear-to define the clear values
	 */
	public static void start(int clear) {

		String value = "";

		Border correct = CheckOut.txtNotes.getBorder();
		if (clear == 1) {

			CheckOut.txtNotes.setText(value);
			CheckOut.txtPlotName.setText(value);
			CheckOut.txtPlotName.setBorder(correct);
			CheckOut.txtPlotNumber.setText(value);
			CheckOut.txtPlotNumber.setBorder(correct);
			CheckOut.txtKeyId.setText(value);
			CheckOut.txtKeyId.setBorder(correct);

		} else {
			CheckOut.txtKey.setText(value);
			CheckOut.txtKey.setBorder(correct);
			CheckOut.txtAvailability.setText(value);
			CheckOut.txtPerson.setText(value);
			CheckOut.txtPerson.setBorder(correct);
			CheckOut.txtDetails.setText(value);
			CheckOut.txtNotes.setText(value);
			CheckOut.txtKeyId.setText(value);
			CheckOut.txtPlotName.setText(value);
			CheckOut.txtPlotNumber.setText(value);

		}
	}
}
