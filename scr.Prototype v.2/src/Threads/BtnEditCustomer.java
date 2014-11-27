package Threads;

import javax.swing.JOptionPane;
import Forms.Customer;
import Forms.CustomerForm;
import Forms.MainForm;
import Forms.ManageCustForm;

public class BtnEditCustomer implements Runnable {

	@Override
	public void run() {

		int go = 0;
		if (MainForm.getProperties().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no Customers!",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			go = 1;
		}

		if (go == 0) {
			String name_sur = ManageCustForm.list.getSelectedValue().toString();

			Customer cust = MainForm.getCustomers().get(0);

			String[] name = name_sur.split("\\s+");
			String idnum = name[0];

			int id_num = Integer.parseInt(idnum.toString());
			for (int i = 0; i < MainForm.getCustomers().size(); i++) {
				int id_cust = MainForm.getCustomers().get(i).getCustomerID();
				if (id_num == id_cust) {
					cust = MainForm.getCustomers().get(i);
					break;
				}
			}

			CustomerForm.setVisible(true);

			CustomerForm.setAccountCode(String.valueOf(cust.getCustomerID()));
			CustomerForm.setFName(cust.getFName());
			CustomerForm.setLName(cust.getLName());
			CustomerForm.setEmail1(cust.getEmail1());
			CustomerForm.setEmail2(cust.getEmail2());
			CustomerForm.setPhoneMob(cust.getPhoneMobile());
			CustomerForm.setPhoneBussines(cust.getPhoneBus());
			CustomerForm.setContact(cust.getPhoneCon());
			CustomerForm.setNote(cust.getNote());
			CustomerForm.setAddress(cust.getAddress());
			CustomerForm.setCity(cust.getCity());
			CustomerForm.setCountry(cust.getCountry());
			CustomerForm.setZip(cust.getZipCode());
			CustomerForm.setFax(cust.getFax());
			CustomerForm.setInfoMaterial(cust.getInfoMaterial());
			CustomerForm.setAccountClosed(cust.getAccountClosed());
		}

	}

}
