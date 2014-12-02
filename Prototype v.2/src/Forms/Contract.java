package Forms;

import javax.swing.JTextField;

public class Contract {

	private String contractID;
	private String Lname;
	private String SFname;
	private String SLname;
	private String Fname;
	private String Pemail;
	private String Semail;
	private String city;
	private String country;
	private String zipCode;
	private String address;
	private int code;
	private int businessPhone;
	private int mobilePhone;
	private int contactPhone;
	private String fax;
	private JTextField iMaterial;
	private String note;
	private String plotID;



	// public void setContractID(String contractID){
	// this.contractID = contractID;
	// }
	public void setLName(String Lname) {
		this.Lname = Lname;
	}
	public void setSFName(String SFname) {
		this.SFname = SFname;
	}
	public void setSLName(String SLname) {
		this.SLname = SLname;
	}
	public void setFName(String Fname) {
		this.Fname = Fname;
	}
	public void setPEmail(String Pemail) {
		this.Pemail = Pemail;
	}
	public void setSEmail(String Semail) {
		this.Semail = Semail;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setBusinessPhone(int businessPhone) {
		this.businessPhone = businessPhone;
	}
	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public void setContactPhone(int contactPhone) {
		this.contactPhone = contactPhone;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	// public void setIMaterial(boolean iMaterial){
	// this.iMaterial = iMaterial;
	// }
	public void setNote(String note) {
		this.note = note;
	}
	public void setPlotID(String plotID) {
		this.plotID = plotID;
	}
	
	


	//public int getContractID(){
		//return ContractID;
	//}
	public String getLName(){
		return Lname;
	}
	public String getSFName(){
		return SFname;
	}
	public String getSLName(){
		return SLname;
	}
	public String getFName(){
		return SFname;
	}
	public String getPEmail(){
		return Pemail;
	}
	public String getSEmail(){
		return Semail;
	}
	public String getCity(){
		return city;
	}
	public String getCountry(){
		return country;
	} 
	public String getZipCode (){
		return zipCode ;
	}
	public String getAddress(){
		return address;
	}
	public int getCode(){
		return code;
	}
	public int getBusinessPhone(){
		return businessPhone;
	}
	public int getContactPhone(){
		return contactPhone ;
	}
	public int getMobilePhone (){
		return mobilePhone ;
	}
	public String getFax(){
		return fax;
	}
	//public boolean getIMaterial() {
	//	return IMaterial;
	//}	
	public String getNote(){
		return note;
	}
	public String getPlotID() {
		return plotID;
	}
}