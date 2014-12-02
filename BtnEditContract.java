package Threads;



import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManagePropForm;
import Forms.Contract;
import Forms.ContractForm;
import Forms.PropertyForm;


public class BtnEditContract implements Runnable {

	

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

			Contract contr = MainForm. getContracts().get(0);

			String[] name = name_sur.split("\\s+");
			String idnum = name[0];

			int id_num = Integer.parseInt(idnum.toString());
			for (int i = 0; i < MainForm.getProperties().size(); i++) {
				String id_prop = MainForm.getProperties().get(i).getPlotID();
				int propID = Integer.parseInt(id_prop);
				if (id_num == propID) {
					contr = MainForm. getContracts().get(i);
					break;
				}
			}

			ContractForm.setVisible(true);
			
		
			
			ContractForm.setLName(contr.getLName());
			ContractForm.setSFName(contr.getSFName());
			ContractForm.setSLName(contr.getSLName());
			ContractForm.setFName(contr.getFName());
			ContractForm.setPEmail(contr.getPEmail());
			ContractForm.setSEmail(contr.getSEmail());
			ContractForm.setCity(contr.getCity());
			ContractForm.setCountry(contr.getCountry());
			ContractForm.setZipCode(contr.getZipCode());
			ContractForm.setAddress(contr.getAddress());
			//ContractForm.setCode(Integer.parseInt(ContractForm.getCode()));
			ContractForm.setBusinessPhone(Integer.parseInt(ContractForm.getBusinessPhone()));
			ContractForm.setMobilePhone(Integer.parseInt(ContractForm.getMobilePhone()));
			ContractForm.setContactPhone(Integer.parseInt(ContractForm.getContactPhone()));
			ContractForm.setFax(contr.getFax());
			ContractForm.setNote(contr.getNote());
			ContractForm.setPlotID(contr.getPlotID());
			
			
			
			
	
}


		
	}}




