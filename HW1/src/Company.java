import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
public class Company {
	private ArrayList<Employee> company;
	public Company(){
		company = new ArrayList<Employee>();
	}
	public void addEmployee(Employee employee){
		if(employee!=null){
			company.add(employee);
		}
	}
	public boolean removeEmployee(String name){
		boolean deleteCheck=true;
		for(int index=0;index<company.size();index++){
			if(company.get(index).getName().equals(name)){
				company.remove(index);
				deleteCheck=false;
				return deleteCheck;
			}	
		}
		return deleteCheck;
	}
	public boolean isSalaryCalculated(int index){
		Double x = 0.0;
		if(company.get(index).getSalary().equals(x)){
			System.out.println(company.get(index).getName());
			return false;
		}
		else{
			return true;
		}
	}
	public void calcSalary(int index,Double normalHours, Double overtimeHours, int saleAmount){
		Double salary=0.0;
		double hourlyWage=0.0,overtimeWage=0.0;
		int promotion=0;
		if(company.get(index).getType()==Type.STAFF){
			hourlyWage=35.00;
			overtimeWage=17.50;
			if(saleAmount>=50)
				promotion=100;
			salary=normalHours*hourlyWage + overtimeHours*overtimeWage+promotion;
		}
		if(company.get(index).getType()==Type.INTERN){
			hourlyWage=5.0;
			overtimeWage=2.5;
			if(saleAmount>=30)
				promotion=10;
			salary=normalHours*hourlyWage + overtimeHours*overtimeWage+promotion;
		}
		if(company.get(index).getType()==Type.PART_TIME){
			hourlyWage=20.00;
			overtimeWage=10.00;
			if(saleAmount>=70)
				promotion=100;
			salary=normalHours*hourlyWage + overtimeHours*overtimeWage+promotion;
		}
		company.get(index).setNormalHours(normalHours);
		company.get(index).setOvertimeHours(overtimeHours);
		company.get(index).setSaleAmount(saleAmount);
		company.get(index).setSalary(salary);
		System.out.println("Salary of "+ company.get(index).getName()+" is $" + salary);
		return;
	}
	public void saveInfoFile(int index){
		String tempEmployee = new String();
		tempEmployee = company.get(index).getName().toString() + ", " + company.get(index).getAge().toString() + ", " + company.get(index).getType().toString() + ", " + company.get(index).getNormalHours().toString() + ", " + company.get(index).getOvertimeHours().toString() + ", " + company.get(index).getSaleAmount().toString() + ", " + company.get(index).getSalary().toString();
		FileOutputStream employeeWriter = null;
		try {
			employeeWriter = new FileOutputStream(company.get(index).getName() + ".dat");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		PrintWriter outputStream = new PrintWriter(employeeWriter);
		outputStream.println(tempEmployee);
		System.out.println(tempEmployee);
		outputStream.close();
	}
	public void averageSalary(){
		ArrayList<Double> allSalary = new ArrayList<Double>();
		String fileName=null,line=null;
		String salary = null;
		Double avgSalary=0.0;
		for(int index=0;index<company.size();index++){
			fileName=company.get(index).getName()+".dat";
			try {
				BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
				try {
					line=inputStream.readLine();
					StringTokenizer employeeData = new StringTokenizer(line, "\n,");
					for(int i=0;i<7;i++){
						salary=employeeData.nextToken();
					}
					allSalary.add(Double.parseDouble(salary));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		for(int j=0;j<allSalary.size();j++){
			avgSalary=avgSalary+allSalary.get(j);
		}
		avgSalary=avgSalary/allSalary.size();
		try {
			FileOutputStream avgWriter = new FileOutputStream("averageSalary.dat", false);
			PrintWriter avgOutput = new PrintWriter(avgWriter);
			avgOutput.println("Average Salary: " + avgSalary);
			avgOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public int returnSize(){
		return company.size();
	}
}