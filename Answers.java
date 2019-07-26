package EntityClassesPackage;

import java.sql.Date;

public class Answers {

	private int ans_id;
	private String answer_desc;
	private Date date;
	private Employee emp;
	
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answers(int ans_id, String answer_desc, Date date,Employee emp) {
		super();
		this.ans_id = ans_id;
		this.answer_desc = answer_desc;
		this.date = date;
		this.emp=emp;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}
	public String getAnswer_desc() {
		return answer_desc;
	}
	public void setAnswer_desc(String answer_desc) {
		this.answer_desc = answer_desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return answer_desc+"\n"+date+"  "+emp.getEmp_name();
	}
	
	
}
