package dynamicdata;



public class UserData {
	public String name;
	public String email;
	public String phone;
	public String pan;
	public String aadhar;

	public UserData(String name, String email, String phone, String pan, String aadhar) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pan = pan;
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

}
