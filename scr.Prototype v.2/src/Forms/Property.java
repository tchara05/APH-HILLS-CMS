package Forms;

public class Property {
	
private static int plotNumberID = 1;
	
	private String plotID = String.valueOf(plotNumberID);
	private int plotNumber;
	private String PlotName;
	private String PropertyClass;
	private String Parcel;
	private String LandUse;
	private String PerChance;
	private String Plots;
	private String Details;
	private String PropertyStatus;
	private int DeedNumber;
	private int NumberOfRooms;
	private int NumberOfBathrooms;
	private int NumberOfAirConditionUnits;
	private int NumberOfFloors;



	public void setPlotNumber(int plotNumber){
		this.plotNumber = plotNumber;
	}
	
	public void setPlotName(String plotName) {
		this.PlotName = plotName;
	}
	
	public void setPropertyClass(String propertyClass) {
		this.PropertyClass = propertyClass;
	}
	
	public void setParcel(String parcel) {
		this.Parcel = parcel;
	}
	
	public void setLandUse(String landUse) {
		this.LandUse = landUse;
	}
	
	public void setPerChance(String perChance) {
		this.PerChance = perChance;
	}
	
	public void setPlots(String plots) {
		this.Plots = plots;
	}
	
	public void setDetails(String details) {
		this.Details = details;
	}
	
	public void setPropertyStatus(String propertyStatus) {
		this.PropertyStatus = propertyStatus;
	}
	
	public void setDeedNumber(int deedNumber) {
		this.DeedNumber = deedNumber;
	}
	
	public void setNumberOfRooms(int numberOfRooms) {
		this.NumberOfRooms = numberOfRooms;
	}
	
	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.NumberOfBathrooms = numberOfBathrooms;
	}
	
	public void setNumberOfAirConditionUnits(int numberOfAirConditionUnits) {
		this.NumberOfAirConditionUnits = numberOfAirConditionUnits;
	}
	
	public void setNumberOfFloors(int numberOfFloors) {
		this.NumberOfFloors = numberOfFloors;
	}
	
	public String getPlotID() {
		return plotID;
	}
	
	public int getPlotNumber(){
		return plotNumber;
	}
	
	public String getPlotName() {
		return PlotName;
	}
	
	public String getPropertyClass() {
		return PropertyClass;
	}
	
	public String getParcel() {
		return Parcel;
	}
	
	public String getLandUse() {
		return LandUse;
	}
	
	public String getPerChance() {
		return PerChance;
	}
	
	public String getPlots() {
		return Plots;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public String getPropertyStatus() {
		return PropertyStatus;
	}
	
	public int getDeedNumber() {
		return DeedNumber;
	}
	
	public int getNumberOfRooms() {
		return NumberOfRooms;
	}
	
	public int getNumberOfBathrooms() {
		return NumberOfBathrooms;
	}
	
	public int getNumberOfAirConditionUnits() {
		return NumberOfAirConditionUnits;
	}
	
	public int getNumberOfFloors() {
		return NumberOfFloors;
	}


}

