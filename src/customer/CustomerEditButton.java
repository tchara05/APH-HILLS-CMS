package customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import extras.DatabaseConnection;
import extras.ListManager;

import userMenus.LogIn;

public class CustomerEditButton extends Thread {

	public void run() {

		DatabaseConnection database= new DatabaseConnection();
		Statement st = database.getStatement();
		ResultSet rst = null;
		
		String customer = (String) CustomerMenu.getSelectedCustomer();
		
		if (customer != null) {
			String[] Customer = ListManager.SplitThreeItem(customer);
			try {
				
				rst = st.executeQuery("SELECT * FROM Customer WHERE firstName='"
						+ Customer[1] + "' and lastName ='" + Customer[2] + "' and customerID = '" + Customer[0] +"'");
				
				
				if (rst.next() && (rst.getString(1) != null)) {
					setForm(rst);
				}
				CustomerForm.setVisible(true);
				CustomerForm.edit = true;

			} catch (SQLException e) {
				System.out.println("Cannot execute the query EditCustomer");
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nothing To Edit",
					"Information Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void setForm(ResultSet rst) throws SQLException {

		
		CustomerForm.txtAddress.setText(rst.getString(4));
		CustomerForm.txtBussinesNumber.setText(rst.getString(10));
		CustomerForm.txtCity.setText(rst.getString(8));
		CustomerForm.txtContactNumber.setText(rst.getString(12));
		CustomerForm.txtFaxNumber.setText(rst.getString(13));
		CustomerForm.txtFname.setText(rst.getString(2));
		CustomerForm.txtLastName.setText(rst.getString(3));
		CustomerForm.txtNote.setText(rst.getString(16));
		CustomerForm.txtPhoneMobile.setText(rst.getString(11));
		CustomerForm.txtPrimaryMail.setText(rst.getString(5));
		CustomerForm.txtSeconadaryMail.setText(rst.getString(6));
		CustomerForm.txtZipCode.setText(rst.getString(9));
		CustomerForm.txtID.setText(rst.getString(1));
		CustomerForm.Country.setSelectedIndex(rst.getShort(7));
		
		
		if (rst.getInt(14) == 0) {
			CustomerForm.chckbxCloseAccound.setSelected(false);
		} else
			CustomerForm.chckbxCloseAccound.setSelected(true);

		if (rst.getInt(15) == 0) {
			CustomerForm.chckbxInformationMaterial.setSelected(false);
		} else {
			CustomerForm.chckbxInformationMaterial.setSelected(true);
		}

	}

}
