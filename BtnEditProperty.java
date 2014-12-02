package Threads;

import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManagePropertyForm;
import Forms.Property;
import Forms.PropertyForm;

public class BtnEditProperty extends Thread {

	
	@Override
	public void run() {
		
		
		if (MainForm.getProperties().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no Properties!",
					"ERROR", JOptionPane.ERROR_MESSAGE);

		}else{

		
			String name_sur = ManagePropertyForm.list.getSelectedValue().toString();

			Property p = MainForm.getProperties().get(0);

			String[] name = name_sur.split("\\s+");
			String idnum = name[0];

			int id_num = Integer.parseInt(idnum.toString());
			for (int i = 0; i < MainForm.getProperties().size(); i++) {
				String id_prop = MainForm.getProperties().get(i).getPlotID();
				int propID = Integer.parseInt(id_prop);
				if (id_num == propID) {
					p = MainForm.getProperties().get(i);
					break;
				}
			}
			
			BtnAddProperty.p = p;

			PropertyForm.setVisible(true);
			PropertyForm.setPlotID(p.getPlotID());
			PropertyForm.setAirCond(p.getAirCond());
			PropertyForm.setBasement(p.getBasement());
			PropertyForm.setCentralHeading(p.getCentralHeading());
			PropertyForm.setCommited(p.getCommited());
			PropertyForm.setDeedNymber(p.getDeedNumber());
			PropertyForm.setDetails(p.getDetails());
			PropertyForm.setGrandeView(p.getGrandeView());
			PropertyForm.setLandUse(p.getLandUse());
			PropertyForm.setNumberOfAirConditionUnits(p.getNumberOfAirConditionUnits());
			PropertyForm.setNumberOfBathrooms(p.getNumberOfBathrooms());
			PropertyForm.setNumberOfFloors(p.getNumberOfFloors());
			PropertyForm.setNumberOfRooms(p.getNumberOfRooms());
			PropertyForm.setParcel(p.getParcel());
			PropertyForm.setPerChance(p.getPerChance());
			PropertyForm.setPlotName(p.getPlotName());
			PropertyForm.setPlotNumber(p.getPlotNumber());
			PropertyForm.setPlots(p.getPlots());
			PropertyForm.setPool(p.getPool());
			PropertyForm.setPoolHeading(p.getPoolHeading());
			PropertyForm.setPropertyClass(p.getPropertyClass());
			
			PropertyForm.setPropertyDeli(p.getPropertyDeli());
			PropertyForm.setPropertyStatus(p.getPropertyStatus());
			PropertyForm.setRentalGuarantee(p.getRentalGuarantee());
			PropertyForm.setRentalPlan(p.getRentalPlan());
			PropertyForm.setTitleDeed(p.getTitleDeed());
			PropertyForm.setGarden(p.getGarden());
			PropertyForm.setPlotID(PropertyForm.plotID + 1 +"");
			
			
			
			


		}
		
	}

	
}
