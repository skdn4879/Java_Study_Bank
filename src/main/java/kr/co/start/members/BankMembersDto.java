package kr.co.start.members;

public class BankMembersDto {

	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	public BankMembersDto() {}

	public BankMembersDto(String userName, String password, String name, String email, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "BankMembersDto [userName= " + userName + ", password= " + password + ", name= " + name + ", email= " + email
				+ ", phone= " + phone + "]";
	}
	
	
}
