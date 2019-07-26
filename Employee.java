package EntityClassesPackage;

public class Employee {
	private int emp_id;
	private String emp_name,emp_Designation,emp_Location,user_name,password;
	public Employee(int emp_id, String emp_name, String emp_Designation, String emp_Location, String user_name,
			String password) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_Designation = emp_Designation;
		this.emp_Location = emp_Location;
		this.user_name = user_name;
		this.password = password;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmp_Designation() {
		return emp_Designation;
	}
	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}
	public String getEmp_Location() {
		return emp_Location;
	}
	public void setEmp_Location(String emp_Location) {
		this.emp_Location = emp_Location;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_Designation=" + emp_Designation
				+ ", emp_Location=" + emp_Location + ", user_name=" + user_name + ", password=" + password + "]";
	}
	
	
}
