package customer;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import userMenus.LogIn;
import contract.ContractForm;
import extras.Checker;
import extras.ListManager;
import extras.Messages;

public class CustomerSaveButton extends Thread {

	public void run() {

		boolean checked = true;

		String country = (String) CustomerForm.Country.getSelectedItem();

		String nFname = Checker.clearString(CustomerForm.txtFname.getText());
		nFname = Checker.clearString(nFname);
		if (!Checker.checkString(nFname) || (nFname.isEmpty())) {
			CustomerForm.txtFname.setBackground(Color.RED);
			checked = false;
		}

		String nLname = Checker.clearString(CustomerForm.txtLastName.getText());
		nLname = Checker.clearString(nLname);
		if (!Checker.checkString(nLname) || (nLname.isEmpty())) {
			CustomerForm.txtLastName.setBackground(Color.YELLOW);
			checked = false;
		}

		String address = CustomerForm.txtAddress.getText();

		String city = CustomerForm.txtCity.getText();
		city = Checker.clearString(city);
		if (!Checker.checkString(city) || (city.isEmpty())) {

			checked = false;
		}

		String bussinesNumber = CustomerForm.txtBussinesNumber.getText();
		if (!Checker.checkNumber(bussinesNumber)) {

			checked = false;
		}

		String contactNumber = CustomerForm.txtContactNumber.getText();
		contactNumber = contactNumber.trim();
		if (!Checker.checkNumber(contactNumber)) {

			checked = false;
		}

		String faxNumber = CustomerForm.txtFaxNumber.getText();
		faxNumber = faxNumber.trim();
		if (!Checker.checkNumber(faxNumber)) {

			checked = false;
		}

		String note = CustomerForm.txtNote.getText();

		String mobileNum = CustomerForm.txtPhoneMobile.getText();
		mobileNum = mobileNum.trim();
		if (!Checker.checkNumber(mobileNum)) {

			checked = false;
		}

		String primaryMail = CustomerForm.txtPrimaryMail.getText();
		primaryMail = primaryMail.trim();
		if (!Checker.checkEmailAddress(primaryMail)) {

			checked = false;
		}

		String secondaryMail = CustomerForm.txtSeconadaryMail.getText();
		secondaryMail = secondaryMail.trim();
		if (!secondaryMail.isEmpty()) {
			if (!Checker.checkEmailAddress(secondaryMail)) {

				checked = false;
			}
		}
		String zipcode = CustomerForm.txtZipCode.getText();

		short infoMaterial = 0;
		if (CustomerForm.chckbxInformationMaterial.isSelected()) {
			infoMaterial = 1;
		}

		short closeAccount = 0;
		if (CustomerForm.chckbxCloseAccound.isSelected()) {
			closeAccount = 1;
		}

		if (!checked) {
			Messages.showWarningMessage("Complete All Details");
		}
		try {

				Statement st = LogIn.database.getStatement();
				int countryID = getCountry(country, st);
				if (countryID > 0 && checked) {
					// Confirm Dialog //
					int response = JOptionPane.showConfirmDialog(null,
							"Do you want to save changes?", "Confirm",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {

						String query = "";
						if (!CustomerForm.edit) {
							query = "INSERT INTO CUSTOMER VALUES ('" + nFname
									+ "','" + nLname + "','" + address + "','"
									+ primaryMail + "','" + secondaryMail
									+ "','" + countryID + "','" + city + "','"
									+ zipcode + "','" + bussinesNumber + "','"
									+ mobileNum + "','" + contactNumber + "','"
									+ faxNumber + "','" + closeAccount + "','"
									+ infoMaterial + "','" + note + "')";
						} else {

							query = "UPDATE Customer SET firstName = '"
									+ nFname + "', lastName = '" + nLname
									+ "', address = '" + address
									+ "', primaryEmail ='" + primaryMail
									+ "', secondaryEmail = '" + secondaryMail
									+ "', countryID = '" + countryID
									+ "', city ='" + city + "', zipCode= '"
									+ zipcode + "', bussinesPhone = '"
									+ bussinesNumber + "', mobilePhone = '"
									+ mobileNum + "', contactPhone ='"
									+ contactNumber + "', fax = '" + faxNumber
									+ "', closeAccount = '" + closeAccount
									+ "', informationMaterial = '"
									+ infoMaterial + "', note ='" + note
									+ "' WHERE  customerID = '"
									+ CustomerForm.txtID.getText() + "'";

							ListManager.DeleteFromList(CustomerMenu.AllCustomers);
						}

						st.executeUpdate(query);
						ListManager.UpdateList(CustomerForm.txtID.getText(),
								nFname, nLname, CustomerMenu.AllCustomers);
						ListManager.UpdateList(CustomerForm.txtID.getText(),
								nFname, nLname, ContractForm.AllCustomers);
						CustomerClearButton.start();
						Messages.showSaveMessage("Customer added");

						CustomerForm.setVisible(false);
					}
				} else {
					System.out
							.println("Invalid Character or Country Somewhere");
				}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (NullPointerException e) {

			e.printStackTrace();
		}

		CustomerForm.edit = false;

	}

	private static int getCountry(String country, Statement st)
			throws SQLException {

		int countryID = -1;
		ResultSet result = LogIn.database.getStatement().executeQuery("SELECT countryID FROM Country " +
																	"WHERE countryName='"+ country + "'");
		if (result.next()) {
			countryID = Integer.parseInt(result.getString(1));
		} else {
			countryID = -1;
		}
		return countryID;
	}

}
