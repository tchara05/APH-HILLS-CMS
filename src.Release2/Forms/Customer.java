package Forms;
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
	

}
