package rs.ac.ftn.mrsisa.service_mrs_isa.dto;

public class RegisterRequestDTO {
	
	private String username;
	
	private String password;
	
	private String confirmPassvord;
	
	private String name;
	
	private String lastname;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String phoneNum;
	
	
	public RegisterRequestDTO() {}
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassvord() {
		return confirmPassvord;
	}

	public void setConfirmPassvord(String confirmPassvord) {
		this.confirmPassvord = confirmPassvord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	
}

