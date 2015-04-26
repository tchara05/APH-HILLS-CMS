package customer;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import contract.ContractForm;
import extras.Checker;
import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;
/**
 * Class that can insert a Customer into Database.
 * Take all values from field and checked. 
 * Then Connect to database and execute query to save Customer
 *
 *
 * @author TeamD
 *
 */
public class CustomerSaveButton extends Thread {
	

	/**
	 * This method take all value from fields and checked if are correct. 
	 * If all value from field are not correct set red Boarder all incorrect fields.
	 * If all value from field are  correct connect to database and execute query 
	 * to save Customer.Method that connect to a database and execute query to insert
	 * a Customer into Database.
	 * 
	 * 
	 */

	public void run() {

		boolean checked = true;
		
		Border compound = null;
		Border redline = BorderFactory.createLineBorder(Color.red,2);
		
		Border correct = CustomerForm.txtID.getBorder();
		String id =CustomerForm.txtID.getText();
		
		String country = (String) CustomerForm.Country.getSelectedItem();
		
		String nFname = Checker.clearString(CustomerForm.txtFname.getText());
		nFname = Checker.clearString(nFname);
		if (!Checker.checkString(nFname) || (nFname.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtFname.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtFname.setBorder(correct);
		}

		String nLname = Checker.clearString(CustomerForm.txtLastName.getText());
		nLname = Checker.clearString(nLname);
		if (!Checker.checkString(nLname) || (nLname.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtLastName.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtLastName.setBorder(correct);
		}

		String address = CustomerForm.txtAddress.getText();
		if(address.isEmpty()){
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtAddress.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtAddress.setBorder(correct);
		}
	

		String city = CustomerForm.txtCity.getText();
		city = Checker.clearString(city);
		if (!Checker.checkString(city) || (city.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtCity.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtCity.setBorder(correct);
		}
		
		

		String bussinesNumber = CustomerForm.txtBussinesNumber.getText();
		if (!Checker.checkNumber(bussinesNumber)||(bussinesNumber.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtBussinesNumber.setBorder(compound);
			checked = false;
			compound = null;
			
		}else{
			CustomerForm.txtBussinesNumber.setBorder(correct);
		}

		String contactNumber = CustomerForm.txtContactNumber.getText();
		contactNumber = contactNumber.trim();
		if (!Checker.checkNumber(contactNumber)||(contactNumber.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtContactNumber.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtContactNumber.setBorder(correct);
		}

		String faxNumber = CustomerForm.txtFaxNumber.getText();
		faxNumber = faxNumber.trim();
		if (!Checker.checkNumber(faxNumber)||(faxNumber.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtFaxNumber.setBorder(compound);

			checked = false;
			compound = null;
		}else{
			CustomerForm.txtFaxNumber.setBorder(correct);
		}

		String note = CustomerForm.txtNote.getText();

		String mobileNum = CustomerForm.txtPhoneMobile.getText();
		mobileNum = mobileNum.trim();
		if (!Checker.checkNumber(mobileNum)||(mobileNum.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtPhoneMobile.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtPhoneMobile.setBorder(correct);
		}

		String primaryMail = CustomerForm.txtPrimaryMail.getText();
		primaryMail = primaryMail.trim();
		if (!Checker.checkEmailAddress(primaryMail)||(primaryMail.isEmpty())) {
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtPrimaryMail.setBorder(compound);
			checked = false;
			compound = null;
		}else{
			CustomerForm.txtPrimaryMail.setBorder(correct);
		}
		
		
		String secondaryMail = CustomerForm.txtSeconadaryMail.getText();
		secondaryMail = secondaryMail.trim();
		if (!secondaryMail.isEmpty() && !Checker.checkEmailAddress(secondaryMail)) {
				compound = BorderFactory.createCompoundBorder(redline, compound);
				CustomerForm.txtSeconadaryMail.setBorder(compound);
				checked = false;
				compound = null;
		}else{
				CustomerForm.txtSeconadaryMail.setBorder(correct);
		}
		
		String zipcode = CustomerForm.txtZipCode.getText();
		if(zipcode.isEmpty()){
			compound = BorderFactory.createCompoundBorder(redline, compound);
			CustomerForm.txtZipCode.setBorder(compound);
			checked = false;
			compound = null;
			
		}else{
			CustomerForm.txtZipCode.setBorder(correct);
		}

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
		
		DatabaseConnection database = new DatabaseConnection();
		try {

				Statement st = database.getStatement();
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

							String s =  ListManager.DeleteFromList(CustomerMenu.AllCustomers);
							ContractForm.AllCustomers.removeElement(s);
						}
						st.executeUpdate(query);
						ListManager.UpdateList(CustomerForm.txtID.getText(),   //Customer
								nFname, nLname, CustomerMenu.AllCustomers);
						ListManager.UpdateList(CustomerForm.txtID.getText(),  // Contract
								nFname, nLname, ContractForm.AllCustomers);
						CustomerMenu.addListListener();
						
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

		CustomerForm.edit= false;
		
	}

	/**
	 * This method connect to database and execute query 
	 * to find country ID for customer's country
	 * 
	 * @param country // name of country
	 * @param st  //answer for Database
	 */

	private static int getCountry(String country, Statement st){

		int countryID = -1;
		DatabaseConnection database= new DatabaseConnection();
		ResultSet result;
		try {
			result = database.getStatement().executeQuery("SELECT countryID FROM Country " +
																		"WHERE countryName='"+ country + "'");
			
			if (result.next()) {
				countryID = Integer.parseInt(result.getString(1));
			} else {
				countryID = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			database.closeDatabaseConnection();
		}
		
		return countryID;
	}

}
