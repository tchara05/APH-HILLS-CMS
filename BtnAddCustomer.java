package Threads;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import Forms.Customer;
import Forms.CustomerForm;
import Forms.MainForm;
import Forms.ManageCustForm;

public class BtnAddCustomer extends Thread {
	
	public static  Customer c = null;

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public void run() {

		if (!EmptyField()) {

			if (c == null) {
				c = new Customer();

				c.setName(CustomerForm.getFname());
				c.setLName(CustomerForm.getLname());
				c.setAddress(CustomerForm.getAddress());
				c.setCity(CustomerForm.getCity());
				c.setCloseAcount(CustomerForm.getAccountClose());
				c.setCountry(CustomerForm.getCountry());
				c.setEmail1(CustomerForm.getEmail1());
				c.setEmail2(CustomerForm.getEmail2());
				c.setFax(CustomerForm.getFax());
				c.setInfoMaterials(CustomerForm.getInfoMaterial());
				c.setNote(CustomerForm.getNote());
				c.setPhoneBussines(CustomerForm.getPhoneBussines());
				c.setPhoneContact(CustomerForm.getPhoneConnection());
				c.setPhoneMobile(CustomerForm.getPhoneMob());
				MainForm.getCustomers().add(c);
				CustomerForm.id++;
				c = null;
			} else {
				c.setName(CustomerForm.getFname());
				c.setLName(CustomerForm.getLname());
				c.setAddress(CustomerForm.getAddress());
				c.setCity(CustomerForm.getCity());
				c.setCloseAcount(CustomerForm.getAccountClose());
				c.setCountry(CustomerForm.getCountry());
				c.setEmail1(CustomerForm.getEmail1());
				c.setEmail2(CustomerForm.getEmail2());
				c.setFax(CustomerForm.getFax());
				c.setInfoMaterials(CustomerForm.getInfoMaterial());
				c.setNote(CustomerForm.getNote());
				c.setPhoneBussines(CustomerForm.getPhoneBussines());
				c.setPhoneContact(CustomerForm.getPhoneConnection());
				c.setPhoneMobile(CustomerForm.getPhoneMob());
				c = null;

			}

			CustomerForm.setAccountClosed(false);
			CustomerForm.setAddress("");
			CustomerForm.setCity("");
			CustomerForm.setContact("");
			CustomerForm.setEmail1("");
			CustomerForm.setEmail2("");
			CustomerForm.setFax("");
			CustomerForm.setFName("");
			CustomerForm.setInfoMaterial(false);
			CustomerForm.setLName("");
			CustomerForm.setPhoneBussines("");
			CustomerForm.setPhoneMob("");
			CustomerForm.setZip("");
			CustomerForm.setCountry("");
			CustomerForm.setNote("");
			CustomerForm.setAccountCode("" + CustomerForm.id);
		
			
			ManageCustForm.list.removeAll();
			ManageCustForm.list.setModel(new AbstractListModel() {
				String[] values = new String[MainForm.getCustomers().size()];
				{
					if (values.length != 0)
						for (int i = 0; i < MainForm.getCustomers().size(); i++) {
							values[i] = MainForm.getCustomers().get(i)
									.getCustomerID()
									+ "  "
									+ MainForm.getCustomers().get(i).getFName()
									+ "  "
									+ MainForm.getCustomers().get(i).getLName();
						}
				}

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});

			JOptionPane.showMessageDialog(null, "Customer Added OK", "ADDED",
					JOptionPane.INFORMATION_MESSAGE);
			
			
			CustomerForm.setVisible(false);

		}

	}

	private boolean EmptyField() {

		if (CustomerForm.getAddress().equals("")) {

			JOptionPane.showMessageDialog(null, "Address Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}

		if (CustomerForm.getCity().equals("")) {
			JOptionPane.showMessageDialog(null, "City Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getCountry().equals("")) {
			JOptionPane.showMessageDialog(null, "Country Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getEmail1().equals("")) {
			JOptionPane.showMessageDialog(null, "Email1 Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getEmail2().equals("")) {
			JOptionPane.showMessageDialog(null, "Email2 Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (CustomerForm.getFax().equals("")) {
			JOptionPane.showMessageDialog(null, "Fax Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}
		if (CustomerForm.getFname().equals("")) {
			JOptionPane.showMessageDialog(null, "First Name Field is Empty \n"
					+ "If you want thes field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (CustomerForm.getLname().equals("")) {
			JOptionPane.showMessageDialog(null, "Last Name Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getNote().equals("")) {
			JOptionPane.showMessageDialog(null, "Note Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		if (CustomerForm.getPhoneBussines().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Bussines Phone Field is Empty \n"
							+ "If you want thes field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getPhoneConnection().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Contact Phone Field is Empty \n"
							+ "If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		if (CustomerForm.getPhoneMob().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Mobile Phone Field is Empty \n"
							+ "If you want this field empty add <none>",
					"Empty Field", JOptionPane.INFORMATION_MESSAGE);
			return true;

		}
		if (CustomerForm.getZipCode().equals("")) {
			JOptionPane.showMessageDialog(null, "Zip Code Field is Empty \n"
					+ "If you want this field empty add <none>", "Empty Field",
					JOptionPane.INFORMATION_MESSAGE);
			return true;

		}

		return false;

	}

}
