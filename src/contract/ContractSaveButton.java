package contract;

import java.sql.SQLException;

import extras.DatabaseConnection;
import extras.ListManager;
import extras.Messages;


/**
 * 
 * Thread that save contract data into database.
 * Connect to database and execute query to save contract
 * or update a contract (base on the flag edit).
 * @author TeamD
 *
 */

public class ContractSaveButton extends Thread {
	
	/**
	 * 
	 * Method that connect to a database and execute querie to save
	 * a new contract and disable an old one if exist.
	 * 
	 * After the execution of the querie the lists of the contract 
	 * form updated.
	 * 
	 */

	public void run() {

			boolean act = ContractForm.chckActive.isSelected();
			int active = 0;
			if (act) {
				active = 1;
			}
			DatabaseConnection database= new DatabaseConnection();
			try {
				String plotID = ContractForm.txtPlotID.getText();
				String queryDeactiveOld = "UPDATE Contract SET active='" + 0
						+ "' WHERE plotID='" + plotID + "'";
				String contractID = ContractForm.txtContractID.getText();
				database.getStatement().executeUpdate(queryDeactiveOld);
				while (!ContractForm.AllOwners.isEmpty()) {
					String[] customer = ListManager
							.removeShare(ContractForm.AllOwners.remove(0));
					String[] Customer = ListManager.SplitThreeItem(customer[1]);
					String query = "INSERT INTO Contract VALUES ('"
							+ contractID + "','" + Customer[0] + "','" + plotID
							+ "','" + customer[0] + "','" + active + "')";
					ListManager.UpdateList(Customer[0], Customer[1],
							Customer[2], ContractForm.AllCustomers);
					database.getStatement().executeUpdate(query);

				}
				contractID = ((Integer.parseInt(contractID) + 1) + "");
				queryDeactiveOld = "UPDATE DocumentsIDS SET docID='"
						+ contractID + "' WHERE docType='Contract'";
				database.getStatement().executeUpdate(queryDeactiveOld);
				ContractForm.txtContractID.setText(contractID);
				ContractForm.totalShare=0;

			} catch (SQLException e) {
				System.out
						.println("Can not execut query in contract save button");
				e.printStackTrace();
			}finally{
				database.closeDatabaseConnection();
			}

		ContractForm.setVisible(false);
		Messages.showSaveMessage("Contract Added");
		
	}

}
