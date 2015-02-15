package property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extras.DatabaseConnection;


public class PropertyEditButton extends Thread {
	
	
	
	
		public void run(){
			
			
//			Statement st = LogIn.database.getStatement();
			
	
			/** Remove in the finish **/	
			DatabaseConnection	database= new DatabaseConnection();
			Statement st = null; 	
	
			/*************************/	
				st = database.getStatement();
			
			//	Statement st =	LogIn.database.getStatement();	
			

			
			ResultSet rst =null;
			
			String property = (String)PropertyMenu.getSelectedProperty();
			String plotName="";
			String plotNo="";
			int i = 0;
			while (property.charAt(i)!=' ' && i<property.length()){
				plotName = plotNo + property.charAt(i);
				i++;
			}
			i++;
			while(i<property.length()){
				plotNo = plotNo+property.charAt(i);
				i++;
			}
			
			
			
			try {
				rst = st.executeQuery("SELECT * FROM Property WHERE plotName='"+plotName+"' and plotNo ='"+plotNo+"'");
				if ( rst.next()&&(rst.getString(1)!=null)){
					

					
					
					
					
				}
				PropertyForm.setVisible(true);
				PropertyForm.edit=true;
				
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
		
		private static void setForm(Statement rst){
			
			
			
			
			PropertyForm.setAirCondition(val1);
			PropertyForm.setBasement(val1);
			PropertyForm.setBathrooms(val2);
			PropertyForm.setBedrooms(val2);
			PropertyForm.setCentralHeading(val1);
			PropertyForm.setCommitted(val1);
			PropertyForm.setDeedNo(val2);
			PropertyForm.setFloors(val2);
			PropertyForm.setGarder(val1);
			PropertyForm.setLandUse(val2);
			PropertyForm.setParcel(val2);
			PropertyForm.setParking(val1);
			PropertyForm.setPerChange(val2);
			PropertyForm.setPlotClass(val2);
			PropertyForm.setPlotID();
			PropertyForm.setPlotName(val2);
			PropertyForm.setPlotNo(val2);
			PropertyForm.setPlots(val2);
			PropertyForm.setPool(val1);
			PropertyForm.setPoolHeading(val1);
			PropertyForm.setPropertyDelivered(val1);
			PropertyForm.setRentalGuarantte(val1);
			PropertyForm.setRentalPlan(val1);
			PropertyForm.setStatus(val2);
			PropertyForm.setTitleDeed(val1);
			PropertyForm.settxtAreaDetails(val2);
			
		}
		
		
		

}
