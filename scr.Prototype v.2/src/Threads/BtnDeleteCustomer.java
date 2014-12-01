package Threads;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManageCustForm;

public class BtnDeleteCustomer extends Thread {

	@SuppressWarnings("unchecked")
	public void run() {

		int go = 0;
		if (MainForm.getCustomers().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no Customers!",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			// setVisible(false);
			// dispose();
			go = 1;
		}

		if (go == 0) {

			String name_sur = ManageCustForm.list.getSelectedValue().toString();
			String[] name = name_sur.split("\\s+");
			String idnum = name[0];
			int id_num = Integer.parseInt(idnum.toString());

			for (int i = 0; i < MainForm.getCustomers().size(); i++) {
				int id_cust = MainForm.getCustomers().get(i).getCustomerID();
				if (id_num == id_cust) {
					MainForm.getCustomers().remove(i);
					ManageCustForm.list.removeAll();
					ManageCustForm.list.setModel(new AbstractListModel() {
						String[] values = new String[MainForm.getCustomers()
								.size()];
						{
							if (values.length != 0)
								for (int i = 0; i < MainForm.getCustomers()
										.size(); i++) {
									values[i] = MainForm.getCustomers().get(i)
											.getCustomerID()
											+ "  "
											+ MainForm.getCustomers().get(i)
													.getFName()
											+ "  "
											+ MainForm.getCustomers().get(i)
													.getLName();
								}
						}

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
					});

					break;
				}
			}

			// ManageCustomers.this.revalidate();
			// ManageCustomers.this.repaint();

			JOptionPane.showMessageDialog(null, "Selected Customer deleted!",
					"Action Completed", JOptionPane.ERROR_MESSAGE);

			if (MainForm.getProperties().isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are no Customers!",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				// setVisible(false);
				// dispose();
				go = 1;
			}
		}
	}

}
