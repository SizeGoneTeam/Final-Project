package entity;

public class Account {
	private int id;
	private String user;
	private String pass;
	private int isAdmin;
	
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public Account(int id, String name, String address, String phoneNumber, String email, String user,
			String pass, int isAdmin) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}

	public Account(int id,String user, String pass, int isAdmin) {
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Account [user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + "]";
	}
}
