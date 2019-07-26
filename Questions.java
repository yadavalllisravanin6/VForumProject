package EntityClassesPackage;

import java.sql.Date;

public class Questions {
private Category category;
private String quesDesc;
private Employee employee;
private Date date;
public Questions() {
	super();
	// TODO Auto-generated constructor stub
}
public Questions(Category category, String quesDesc, Employee employee,Date date) {
	super();
	this.category = category;
	this.quesDesc = quesDesc;
	this.employee = employee;
	this.date=date;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public String getQuesDesc() {
	return quesDesc;
}
public void setQuesDesc(String quesDesc) {
	this.quesDesc = quesDesc;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "ItQuestion [category=" + category + ", quesDesc=" + quesDesc + ", employee=" + employee +  ", date=" + date + "]";
}

}
