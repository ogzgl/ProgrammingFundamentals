/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
public class Employee {
	private String name;
	private Integer age,saleAmount;
	private Double normalHours, overtimeHours, salary;
	private Type type;
	
	public Employee(){
		this.normalHours=0.0;
		this.overtimeHours=0.0;
		this.salary=0.0;
		this.saleAmount=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getNormalHours() {
		return normalHours;
	}

	public void setNormalHours(Double normalHours) {
		this.normalHours = normalHours;
	}

	public Double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(Double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public Integer getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
