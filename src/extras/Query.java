package extras;

public class Query {
	
	public static final String PROPERTY_ID_NAME_NUMBER = "SELECT plotID, plotName , PlotNumber FROM " +
														  "Property " +
														  "	ORDER BY plotName , plotNumber";

	public static final String CLASS_NO_NAME = "SELECT propertyClassNo, className FROM Class";	
	
	public static final String CUSTOMER_NO_FNAME_LNAME ="SELECT customerID, firstName , lastName " +
														"FROM Customer " +
														"ORDER BY firstName , lastName";
	public static final String PARCEL_NO_NAME="SELECT * FROM Parcel";
	
	public static final String STATUS_NO_NAME="SELECT * FROM PropertyStatus";
	
	public static final String COUNTRY ="SELECT * Country";
	
	public static final String CONTRACT_NO = "SELECT MAX(justID)  FROM ContractIds";
	
	public static final String CLASS_NO = "SELECT MAX(PropertyClassNo) FROM Class";
	
	public static final String PARCEL_NO="SELECT MAX(parcelNo) FROM Parcel_";
	
	public static final String STATUS_NO="SELECT MAX(statusID) FROM PropertyStatus";
	
	public static final DatabaseConnection database = new DatabaseConnection();
	
	
	
}
