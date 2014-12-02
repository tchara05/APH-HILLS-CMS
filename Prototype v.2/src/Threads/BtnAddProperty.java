package Threads;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import Forms.MainForm;
import Forms.ManageCustForm;
import Forms.ManagePropertyForm;
import Forms.Property;
import Forms.PropertyForm;

public class BtnAddProperty extends Thread {

	public static Property p;

	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public void run() {

		if (p == null) {

			p = new Property();
			
			p.setPlotID(PropertyForm.plotID +"" );
			p.setDeedNumber(PropertyForm.getDeedNumber());
			p.setDetails(PropertyForm.getDetails());
			p.setLandUse(PropertyForm.getLandUse());
			p.setNumberOfAirConditionUnits(PropertyForm
					.getNumberOfAirConditionUnits());
			
			p.setNumberOfBathrooms(PropertyForm.getNumberOfBathrooms());
			p.setNumberOfFloors(PropertyForm.getNumberOfFloors());
			p.setNumberOfRooms(PropertyForm.getNumberOfRooms());
			p.setParcel(PropertyForm.getParcel());
			p.setPerChance(PropertyForm.getPerChance());
			p.setPlotName(PropertyForm.getPlotName());
			p.setPlotNumber(PropertyForm.getPlotID());
			p.setPlots(PropertyForm.getPlots());
			p.setPropertyClass(PropertyForm.getPropertyClass());
			p.setPropertyStatus(PropertyForm.getPropertyStatus());
			p.setPropertyDelivered(PropertyForm.getPropertyDeli());
			p.setRentalGuarantee(PropertyForm.getRentalGuarantee());
			p.setParking(PropertyForm.getParking());
			p.setPool(PropertyForm.getPool());
			p.setPoolHeading(PropertyForm.getPoolHeading());
			p.setTitleDeed(PropertyForm.getTitleDeed());
			p.setAircond(PropertyForm.getAirCond());
			p.setGrandView(PropertyForm.getGrandeView());
			p.setGarden(PropertyForm.getGarden());
			p.setCommited(PropertyForm.getCommited());
			p.setRentalPlan(PropertyForm.getRentalPlan());
			p.setBasement(PropertyForm.getBasement());
			
			MainForm.getProperties().add(p);
			
			PropertyForm.plotID++;
			p=null;
		}else{
			p.setDeedNumber(PropertyForm.getDeedNumber());
			p.setDetails(PropertyForm.getDetails());
			p.setLandUse(PropertyForm.getLandUse());
			p.setNumberOfAirConditionUnits(PropertyForm
					.getNumberOfAirConditionUnits());
			
			p.setNumberOfBathrooms(PropertyForm.getNumberOfBathrooms());
			p.setNumberOfFloors(PropertyForm.getNumberOfFloors());
			p.setNumberOfRooms(PropertyForm.getNumberOfRooms());
			p.setParcel(PropertyForm.getParcel());
			p.setPerChance(PropertyForm.getPerChance());
			p.setPlotName(PropertyForm.getPlotName());
			p.setPlotNumber(PropertyForm.getPlotID());
			p.setPlots(PropertyForm.getPlots());
			p.setPropertyClass(PropertyForm.getPropertyClass());
			p.setPropertyStatus(PropertyForm.getPropertyStatus());
			p.setPropertyDelivered(PropertyForm.getPropertyDeli());
			p.setRentalGuarantee(PropertyForm.getRentalGuarantee());
			p.setParking(PropertyForm.getParking());
			p.setPool(PropertyForm.getPool());
			p.setPoolHeading(PropertyForm.getPoolHeading());
			p.setTitleDeed(PropertyForm.getTitleDeed());
			p.setAircond(PropertyForm.getAirCond());
			p.setGrandView(PropertyForm.getGrandeView());
			p.setGarden(PropertyForm.getGarden());
			p.setCommited(PropertyForm.getCommited());
			p.setRentalPlan(PropertyForm.getRentalPlan());
			p.setBasement(PropertyForm.getBasement());

			p = null;
			
			
		}
		
		PropertyForm.setAirCond(false);
		PropertyForm.setBasement(false);
		PropertyForm.setCentralHeading(false);
		PropertyForm.setCommited(false);
		PropertyForm.setDeedNymber("");
		PropertyForm.setDetails("");
		PropertyForm.setGrandeView(false);
		PropertyForm.setLandUse("");
		PropertyForm.setNumberOfAirConditionUnits("");
		PropertyForm.setNumberOfBathrooms("");
		PropertyForm.setNumberOfFloors("");
		PropertyForm.setNumberOfRooms("");
		PropertyForm.setParcel("");
		PropertyForm.setPerChance("");
		PropertyForm.setPropertyClass("");
		PropertyForm.setPlotName("");
		PropertyForm.setPlotNumber("");
		PropertyForm.setPlots("");
		PropertyForm.setPool(false);
		PropertyForm.setPoolHeading(false);
		PropertyForm.setPropertyClass("");
		PropertyForm.setPropertyDeli(false);
		PropertyForm.setPropertyStatus("");
		PropertyForm.setRentalGuarantee(false);
		PropertyForm.setRentalPlan(false);
		PropertyForm.setTitleDeed(false);
		PropertyForm.setGarden(false);
		PropertyForm.setPlotID(PropertyForm.plotID +"");
		
		
		ManagePropertyForm.list.removeAll();
		ManagePropertyForm.list.setModel(new AbstractListModel() {
			String[] values = new String[MainForm.getProperties().size()];
			{
				if (values.length != 0)
					for (int i = 0; i < MainForm.getProperties().size(); i++) {
						values[i] = MainForm.getProperties().get(i).getPlotID()
								+ "  "
								+ MainForm.getProperties().get(i).getPlotName()
								+ "  "
								+ MainForm.getProperties().get(i).getPlotNumber();
					}
			}

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		
		
		JOptionPane.showMessageDialog(null, "Property Added OK", "ADDED",
		JOptionPane.INFORMATION_MESSAGE);
		
		PropertyForm.setVisible(false);
		
		
		
	}
	
	
	
	
	private  boolean EmptyField() {
		
	/**	
		int blank = 0;

		if (PlotID.getText().equals(""))
			blank = 1;

		if (PlotNumber.getText().equals(""))
			blank = 1;

		if (PlotName.getText().equals(""))
			blank = 1;

		if (PropertyClass.getText().equals(""))
			blank = 1;

		if (Parcel.getText().equals(""))
			blank = 1;

		if (LandUse.getText().equals(""))
			blank = 1;

		if (PerChance.getText().equals(""))
			blank = 1;

		if (Plots.getText().equals(""))
			blank = 1;

		if (Details.getText().equals(""))
			blank = 1;

		if (PropertyStatus.getText().equals(""))
			blank = 1;

		if (DeedNumber.getText().equals(""))
			blank = 1;

		if (NumberOfRooms.getText().equals(""))
			blank = 1;

		if (NumberOfBathrooms.getText().equals(""))
			blank = 1;

		if (NumberOfFloors.getText().equals(""))
			blank = 1;

		if (NumberOfAirConditionUnits.getText().equals(""))
			blank = 1;

		if (blank == 1) {
			JOptionPane.showMessageDialog(null,
					"There are empty fields. \nPlease, check again",
					"Warning", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		*/
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	

}
