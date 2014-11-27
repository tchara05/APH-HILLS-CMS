package Threads;

import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManagePropForm;
import Forms.Property;
import Forms.PropertyForm;

public class BtnEditProperty implements Runnable {

	@Override
	public void run() {
		
		int go = 0;
		if (MainForm.getProperties().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no Properties!",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			go = 1;
		}

		if (go == 0) {
			String name_sur = ManagePropForm.list.getSelectedValue().toString();

			Property prop = MainForm.getProperties().get(0);

			String[] name = name_sur.split("\\s+");
			String idnum = name[0];

			int id_num = Integer.parseInt(idnum.toString());
			for (int i = 0; i < MainForm.getProperties().size(); i++) {
				String id_prop = MainForm.getProperties().get(i).getPlotID();
				int propID = Integer.parseInt(id_prop);
				if (id_num == propID) {
					prop = MainForm.getProperties().get(i);
					break;
				}
			}

			PropertyForm.setVisible(true);
/*
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
*/
		}
		
	}

	
}
