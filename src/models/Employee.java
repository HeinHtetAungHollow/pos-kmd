package models;

public class Employee {
	
	private int emp_id;
	private String emp_name;
	private String emp_phone;
	private String emp_mail;
	private String emp_address;
	private String username;
	private String password;
	private String role;
	private boolean active;
	
	public Employee() {}
	
	public Employee(int emp_id, String emp_name, String emp_phone, String emp_mail, String emp_address, String username,
			String password, String role, boolean active) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.emp_mail = emp_mail;
		this.emp_address = emp_address;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_mail() {
		return emp_mail;
	}
	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean b) {
		this.active = b;
	}
	
	
}
