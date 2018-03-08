import java.util.Scanner;

/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
public class Menu {
	
	public void start(){
		System.out.println(".:Menu:.");
		System.out.println("1. Add a new poem by giving file path.");
		System.out.println("2. Find the poem that has maximum occurrence of the word.");
		System.out.println("3. Top-10 popular words.");
		System.out.println("4. Find poems that begins with the given word.");
		System.out.println("5. Find Acrostics.");
		System.out.println("6. Exit");
		Scanner scan = new Scanner(System.in);
		boolean flag=true;
		do{
			
			int choice = scan.nextInt();
			switch(choice){
			/*case 1: addBook();
					flag=false;
					break;
			case 2: remover();
					flag=false;
					break;
			case 3: searchGenre();
					flag=false;
					break;
			case 4: searchPublishingYearX();
					flag=false;
					break;
			case 5: searchAuthorName();
					flag=false;
					break;*/
			case 6 : System.exit(-1);
			default: System.out.println("The given input is not valid. Try Again.");
			
			}
		}while(flag);
		
		
	}
}
