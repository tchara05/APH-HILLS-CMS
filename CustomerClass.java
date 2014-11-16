public class CustomerClass {

	int accountCode;
	String fname;
	String lname;
	String email1;
	String email2;
	String phonemob;
	String phonebus;
	String phonecon;
	String fax;
	
	
	
	boolean closeAccount;
	boolean informationMaterial;
	String address;
	String city;
	String country;
	String zipCode;
	String note;

	public CustomerClass(String fname, String lname, int accountCode,
			String email1, String email2, String phonemob, String phonebus,
			String phonecon, String fax, boolean closeAccount,
			boolean informationMaterial, String address, String city,
			String country, String zipCode, String note) {

		this.accountCode = accountCode;
		this.fname = fname;
		this.lname = lname;
		this.email1 = email1;
		this.email2 = email2;
		this.phonemob = phonemob;
		this.phonebus = phonebus;
		this.phonecon = phonecon;
		this.fax = fax;
		this.closeAccount = closeAccount;
		this.informationMaterial = informationMaterial;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.note = note;

	}

}
