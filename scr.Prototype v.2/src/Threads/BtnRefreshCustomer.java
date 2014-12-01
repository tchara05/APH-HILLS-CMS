package Threads;

import javax.swing.AbstractListModel;

import Forms.MainForm;
import Forms.ManageCustForm;

public class BtnRefreshCustomer extends Thread {

	@SuppressWarnings("unchecked")
	public void run() {

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

		ManageCustForm.callRepaint();

	}
}
