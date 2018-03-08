import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Operation {
	
	public void addPoem() throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		String title = input.nextLine();
		DataAccessLayer.addPoem(title);
		input.close();
	}
	
	public void maximumOccurenceFinder(){
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		input.close();
		
	}
	
	public void list10Popular(){
		
	}

}
