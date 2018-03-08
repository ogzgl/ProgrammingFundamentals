/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class CompanyApp {
	public static Company readFile(String fileName) throws NumberFormatException, IOException{
//		reading the file which is given in the homework and
//		add the employees to newly created company object.
		Company company = new Company();
		Employee tempEmployee = new Employee();
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
			String line;
			int setCounter = 1; //counter for string tokenizer tokens.
			while((line = inputStream.readLine()) != null){
				StringTokenizer employeeData = new StringTokenizer(line, "\n.,");
				while(employeeData.hasMoreTokens()){
			        switch (setCounter) {
		            case 1:  tempEmployee.setName(employeeData.nextToken());
		            		 setCounter++;
		                     break;
		            case 2:  tempEmployee.setAge(Integer.parseInt(employeeData.nextToken().trim()));
           		 			 setCounter++;		            
		                     break;
		            case 3:  tempEmployee.setType(Type.valueOf(employeeData.nextToken().trim()));
  		 			 		 setCounter++;			            
		                     break;
		            case 4:  tempEmployee.setNormalHours(Double.parseDouble((employeeData.nextToken().trim())));
  		 			  		 setCounter++;			            
		                     break;
		            case 5:  tempEmployee.setOvertimeHours(Double.parseDouble(employeeData.nextToken().trim()));
  		 			 		 setCounter++;	
		                     break;
		            case 6:  tempEmployee.setSaleAmount(Integer.parseInt(employeeData.nextToken().trim()));
  		 			 		 setCounter++;	
		                     break;
		            case 7:  tempEmployee.setSalary(Double.parseDouble(employeeData.nextToken().trim()));
  		 			 		 setCounter++;	
                    		 break;
                    default:
                    	break;
			        }
				}
				setCounter=1;
				company.addEmployee(tempEmployee);
				tempEmployee = new Employee();//to erase data, initialized as empty again.

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return company;
	}
	public static void addEmployee(Company company){
		Employee employee = new Employee();
		String name;
		Integer age = null,selectedType = null;
		Type type = null;
		Scanner inputName = new Scanner(System.in);
		int nameFlag=0;
		do{
			System.out.println("Enter the employee name:\n");
			name = inputName.nextLine();
			try{
				  int num = Integer.parseInt(name);
				  nameFlag=1;
				  System.out.println("You can not enter name full integer!");
				} catch (NumberFormatException e) {
				  nameFlag=0;
				}
		}while(nameFlag==1);
		Scanner inputAge = new Scanner(System.in);
		int intFlag = 0;
		do{
			try{
				
				System.out.println("Enter the employee age:\n");
				age = inputAge.nextInt();
				intFlag=0;
			}catch(InputMismatchException e){
				intFlag = 1;
			}
		}while(intFlag==1);
		System.out.println("Please select the employee type:");
		System.out.println("1.Staff");
		System.out.println("2.Part-Time");
		System.out.println("3.Intern");
		boolean flag=true;
		Scanner inputType = new Scanner(System.in);
		do{
			selectedType = inputType.nextInt();
			switch(selectedType){
				case 1: type = Type.STAFF;
						flag=false;
						break;
				case 2: type = Type.PART_TIME;
						flag=false;
						break;
				case 3: type = Type.INTERN;
						flag=false;
						break;
				default: System.out.println("The given input is not valid. Try again.");
			}
		}while(flag);
		employee.setName(name);
		employee.setAge(age);
		employee.setType(type);
		company.addEmployee(employee);
		System.out.println("User succesfully added.");
		menu(company);
	}
	public static void removeEmployee(Company company){
		String userName;
		boolean isDeleted;
		System.out.println("Please enter the name of employee to remove:");
		int checkFirst=0;
		Scanner removeEmployee = new Scanner(System.in);
		do{
			if(checkFirst!=0)
				System.out.println("User could not be found please try again:");
			userName = removeEmployee.nextLine();
			isDeleted=company.removeEmployee(userName);
			checkFirst=1;
		}while(isDeleted);
		System.out.println("User succesfully deleted.");
		menu(company);
	}
	public static void calcSalary(Company company){
		Double normalHours,overtimeHours;
		int saleAmount;
		for(int index=0;index<company.returnSize();index++){
			if(company.isSalaryCalculated(index)){
				continue;
			}
			normalHours=0.0;
			overtimeHours=0.0;
			saleAmount=0;
			boolean checkNormalHours=true;
			Scanner scanNormal = new Scanner(System.in);
			System.out.println("Please enter the normal work hours:");
			do{
				try{
					normalHours = scanNormal.nextDouble();
					checkNormalHours=false;
					} catch(InputMismatchException e){
						System.out.println("You've entered wrong type of input try again.");
					
					  }
			}while(checkNormalHours);
			
			
			boolean checkOvertimeHours=true;
			Scanner scanOvertime= new Scanner(System.in);
			System.out.println("Please enter the overtime work hours:");
			do{
				try{
					overtimeHours = scanNormal.nextDouble();
					checkOvertimeHours=false;
					} catch(InputMismatchException e){
						System.out.println("You've entered wrong type of input try again.");
					
					  }
			}while(checkOvertimeHours);
			
			boolean saleAmountCheck=true;
			Scanner scanSaleAmount= new Scanner(System.in);
			System.out.println("Please enter the sale amount:");
			do{
				try{
					saleAmount = scanSaleAmount.nextInt();
					saleAmountCheck=false;
					} catch(InputMismatchException e){
						System.out.println("You've entered wrong type of input try again.");
					
					  }
			}while(saleAmountCheck);
			
			company.calcSalary(index, normalHours, overtimeHours, saleAmount);

			
		}
		System.out.println("All employees whom salary is not predefined are calculated.");
		menu(company);
	}
	public static void saveToFile(Company company){
		for(int index=0;index<company.returnSize();index++){
			company.saveInfoFile(index);
		}
		System.out.println("User files are created and saved.");
		menu(company);
	}
	public static void saveAvgSalary(Company company){
		company.averageSalary();
		System.out.println("Average salary file created and average salary saved.");
		menu(company);
	}
	public static void menu(Company company){
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("..::Menu::..\n"
				+ "1.Add employee\n"
				+ "2.Remove employee\n"
				+ "3.Calculate salary\n"
				+ "4.Save employee information to file\n"
				+ "5.Save average of the salaries to file\n"
				+ "--------------------------------------");
		boolean flag=true;
		System.out.println("Choice: ");
		do{
			
			choice = input.nextInt();
			switch(choice){
			case 1: addEmployee(company);
					flag=false;
					break;
			case 2: removeEmployee(company);
					flag=false;
					break;
			case 3: calcSalary(company);
					flag=false;
					break;
			case 4: saveToFile(company);
					flag=false;
					break;
			case 5: saveAvgSalary(company);
					flag=false;
					break;
			default: System.out.println("The given input is not valid. Try Again.");
			
			}
		}while(flag);	
	}
	public static void main(String args[]) throws IOException{
		Company company = readFile("employeeInfo.dir");
		menu(company);

	}
}
