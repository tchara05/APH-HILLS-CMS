package extras;

/**
 * Class that has variables that keeps the standard queries to retrieve
 * some data.
 * 
 * @author TeamD
 *
 */

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
	
	public static final String COUNTRY ="SELECT * FROM Country";
	
	public static final String CONTRACT_NO = "SELECT MAX(docID)  FROM DocumentsIDS WHERE docType='Contract'";
	
	public static final String CLASS_NO = "SELECT MAX(PropertyClassNo) FROM Class";
	
	public static final String PARCEL_NO="SELECT MAX(parcleNo) FROM Parcel";
	
	public static final String STATUS_NO="SELECT MAX(statusID) FROM PropertyStatus";
	
	public static final String PLOTS_WITH_NO_CONTRACTS="SELECT P.plotID, P.plotName, P.PlotNumber " +
														" FROM Property P WHERE P.plotID NOT IN (" +
														" SELECT DISTINCT C.plotID FROM Contract C )";
	
	public static final String PLOTS_AND_ROOMS = "SELECT P.plotID, P.plotNumber, P.plotName, P.numberOfBedrooms " +
												  "FROM Property P, Service S, KeyContract KC " +
												  "WHERE P.plotID = KC.propertyID and KC.keyID = S.keyID "+
												  "ORDER BY P.plotID ASC";
	
	public static final String PROFORMA_CUSTOMERS = "SELECT DISTINCT customerID, firstName, lastName "
													+ "FROM Proforma "
													+ "WHERE toPaid = 0 "
													+" ORDER BY firstName , lastName";
	
	public static final String KEYID_SPECIFICKEY = "SELECT keyID, specificKey FROM Service WHERE checkInTime = 'Key is not checked in yet' ORDER BY keyID";
	
	public static final String KEYID_PLOTNAME_PLOTNUMBER = "SELECT keyID, plotName ,plotNumber FROM KeyContract K, Property P WhERE k.propertyID = P.plotID";

}
