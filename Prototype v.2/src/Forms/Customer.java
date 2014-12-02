package Forms;

import java.util.ArrayList;

public class Customer {

	private static int accountCode = 1;
	
	private int id = accountCode;
	private String fname;
	private String lname;
	private String email1;
	private String email2;
	private String phonemob;
	private String phonebus;
	private String phonecon;
	private String fax;
	private boolean closeAccount;
	private boolean informationMaterial;
	private String address;
	private String city;
	private String country;
	private String zipCode;
	private String note;
	private ArrayList<Property> owns;

	public Customer (){
		accountCode ++;
		owns = new ArrayList<Property>();
	
	}

	public void setName(String fname){
		this.fname = fname;
	}
	public void setLName(String lname){
		this.lname = lname;
	}
	public void setEmail1(String email1){
		this.email1 = email1;
	}
	public void setEmail2(String email2){
		this.email2 = email2;
	}
	public void setPhoneMobile(String phonemob){
		this.phonemob = phonemob;
	}
	public void setPhoneBussines(String phonebus){
		this.phonebus = phonebus;
	}
	public void setPhoneContact(String phonecon){
		this.phonecon = phonecon;
	}
	public void setFax(String fax){
		this.fax = fax;
	}
	public void setCloseAcount(boolean f){
		this.closeAccount = f;
	}
	public void setInfoMaterials(boolean f){
		this.informationMaterial = f;
	}
	public void setAddress(String Address){
		this.address = Address;
	}
	public void setCity(String City){
		this.city = City;
	}
	public void setCountry(String Country){
		this.country = Country;
	}
	public void setZipCode(String zipcode){
		this.zipCode = zipcode;
	}
	public void setNote(String note){
		this.note = note;
	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public int getCustomerID(){
		return id;
	}
	public String getFName(){
		return fname;
	}
	public String getLName(){
		return lname;
	}
	public String getEmail1(){
		return email1;
	}
	public String getEmail2(){
		return email2;
	}
	public String getPhoneMobile(){
		return phonemob;
	}
	public String getPhoneBus(){
		return phonebus;
	} 
	public String getPhoneCon(){
		return phonecon;
	}
	public String getFax(){
		return fax;
	}
	public boolean getInfoMaterial() {
		return informationMaterial;
	}
	public boolean getAccountClosed() {
		return closeAccount;
	}
	public String getAddress(){
		return address;
	}
	public String getCity(){
		return city;
	}
	public String getCountry(){
		return country;
	}
	public String getZipCode(){
		return zipCode;
	}
	public String getNote(){
		return note;
	}
	public int getCode(){
		return accountCode;
	}

	
	public ArrayList<Property> getPropertys(){
		
		return owns;
		
	}

	public void CalculateCost(){
		
		
		
		
		for (int i=0;i<owns.size();i++){
			owns.get(i).calculateCost();
		}
		
		
		
	}

	
	
	public  String toString(){
		
		String s = fname +" \n" +lname;
		
		return s;
		
		
	}	
		
		
		
		
		
	



}
