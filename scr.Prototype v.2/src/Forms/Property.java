package Forms;

public class Property {
	
	private String plotID ;
	private String plotNumber;
	private String PlotName;
	private String PropertyClass;
	private String Parcel;
	private String LandUse;
	private String PerChance;
	private String Plots;
	private String Details;
	private String PropertyStatus;
	private String DeedNumber;
	private String NumberOfRooms;
	private String NumberOfBathrooms;
	private String NumberOfAirConditionUnits;
	private String NumberOfFloors;
	private boolean PropertyDelivered;
	private boolean RentalGuarantee;
	private boolean Commited;
	private boolean RentalPlan;
	private boolean GrandView;
	private boolean TitleDeed;
	private boolean Pool;
	private boolean Garden;
	private boolean Parking;
	private boolean PoolHeading;
	private boolean CentralHeading;
	private boolean AirCond;
	private boolean Basement;
	public int service;


	/***********************************************All Setters***************************************/
	public void setPlotID(String s){
		this.plotID = s;
	}
	
	public void setPlotNumber(String plotNumber){
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
	
	public void setDeedNumber(String deedNumber) {
		this.DeedNumber = deedNumber;
	}
	
	public void setNumberOfRooms(String numberOfRooms) {
		this.NumberOfRooms = numberOfRooms;
	}
	
	public void setNumberOfBathrooms(String numberOfBathrooms) {
		this.NumberOfBathrooms = numberOfBathrooms;
	}
	
	public void setNumberOfAirConditionUnits(String numberOfAirConditionUnits) {
		this.NumberOfAirConditionUnits = numberOfAirConditionUnits;
	}
	
	public void setNumberOfFloors(String numberOfFloors) {
		this.NumberOfFloors = numberOfFloors;
	}
	
	public void setPropertyDelivered(boolean f){
		this.PropertyDelivered = f 	;
		
	}
	
	public void setAircond(boolean f){
		
		this.AirCond = f;
		
	}
	
	public void setCentralHeading(boolean f){
		this.CentralHeading = f;
	}
	public void setCommited(boolean f){
		this.Commited = f;
	}
	public void setGarden(boolean f){
		this.Garden = f;
	}
	public void setGrandView(boolean f){
		this.GrandView =f;
	}
	public void setParking(boolean f){
		this.Parking = f;
	}
	public void setPool(boolean f){
		this.Pool = f;
	}
	public void setPoolHeading(boolean f){
		this.PoolHeading = f;
	}
	public void setRentalGuarantee(boolean f){
		this.RentalGuarantee = f;
	}
	public void setRentalPlan(boolean f){
		this.RentalPlan = f;
	}
	public void setTitleDeed(boolean f){
		this.TitleDeed =f;
	}
	public void setBasement(boolean f){
		this.Basement = f;
	}

	/***********************************************All Getters***************************************/
	public String getPlotID() {
		return plotID;
	}
	
	public String getPlotNumber(){
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
	
	public String getDeedNumber() {
		return DeedNumber;
	}
	
	public String getNumberOfRooms() {
		return NumberOfRooms;
	}
	
	public String getNumberOfBathrooms() {
		return NumberOfBathrooms;
	}
	
	public String getNumberOfAirConditionUnits() {
		return NumberOfAirConditionUnits;
	}
	
	public String getNumberOfFloors() {
		return NumberOfFloors;
	}
	
	public boolean getPropertyDeli() {
		return PropertyDelivered;
	}
	
	public boolean getRentalGuarantee() {
		return RentalGuarantee;
	}
	
	public boolean getCommited() {
		return Commited;
	}
	
	public boolean getRentalPlan() {
		return RentalPlan;
	}
	
	public boolean getGrandeView() {
		return GrandView;
	}
	
	public boolean getTitleDeed() {
		return TitleDeed;
	}
	
	public boolean getPool() {
		return Pool;
	}
	
	public boolean getGarden() {
		return Garden;
	}
	public boolean getParking() {
		return Parking;
	}
	public boolean getPoolHeading() {
		return PoolHeading;
	}
	
	public boolean getCentralHeading() {
		return CentralHeading;
	}
	
	public boolean getAirCond() {
		return AirCond;
	}
	public boolean getBasement(){
		return Basement;
	}
	
	


}

