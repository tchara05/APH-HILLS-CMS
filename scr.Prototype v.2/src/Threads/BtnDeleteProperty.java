package Threads;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManageCustForm;
import Forms.ManagePropertyForm;
import Forms.Property;
import Forms.PropertyForm;

public class BtnDeleteProperty extends Thread {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void run() {

			int go = 0;
			if (MainForm.getProperties().isEmpty()) {
				JOptionPane.showMessageDialog(null, "There are no Properties!",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				// setVisible(false);
				// dispose();
				go = 1;
			}

			if (go == 0) {

				String name_sur = ManagePropertyForm.list.getSelectedValue().toString();
				String[] name = name_sur.split("\\s+");
				String idnum = name[0];
				int id_num = Integer.parseInt(idnum.toString());

				for (int i = 0; i < MainForm.getProperties().size(); i++) {
					String id_prop = MainForm.getProperties().get(i).getPlotID();
					int propID = Integer.parseInt(id_prop);
					if (id_num == propID) {
						MainForm.getProperties().remove(i);
						ManagePropertyForm.list.removeAll();
						ManagePropertyForm.list.setModel(new AbstractListModel() {
							String[] values = new String[MainForm.getProperties()
									.size()];
							{
								if (values.length != 0)
									for (int i = 0; i < MainForm.getProperties()
											.size(); i++) {
										values[i] = MainForm.getProperties().get(i).getPlotID();
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

				JOptionPane.showMessageDialog(null, "Selected Property deleted!",
						"Action Completed", JOptionPane.ERROR_MESSAGE);

				if (MainForm.getProperties().isEmpty()) {
					JOptionPane.showMessageDialog(null, "There are no Properties!",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					// setVisible(false);
					// dispose();
					go = 1;
				}
			}
	}
}
