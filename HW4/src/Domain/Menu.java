package Domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public String userName(){
		Scanner scan = new Scanner(System.in);
		int flag=0;
		String userName;
		System.out.println("Please enter your name only alph. chars allowed:");
		do{
			if(flag!=0)
				System.out.println("Given username was not valid. Try Again:");
			userName=scan.nextLine();
			if(userName=="")
				return null;
			flag=1;
		}while(!userName.matches("[a-zA-Z]+"));
		return userName;
	}
	public int pickCardUser(ArrayList<Card> cards){
		String indexString;
		System.out.println("Please pick your card with the given index next to card:");
		for(int i=0;i<cards.size();i++){
			System.out.println(i+"."+"("+cards.get(i).getType().toString()+ " - " + cards.get(i).getNumber() + ")");
		}
		System.out.println("Your Choice:");
		Scanner scan = new Scanner(System.in);
		int flag=0;
		do{
			if(flag!=0)
				System.out.println("The given input is not valid. Try Again:");
			indexString=scan.nextLine();
			flag=1;
		}while((!indexString.matches("[0-9]+")) || !(Integer.parseInt(indexString)<cards.size()));
		return Integer.parseInt(indexString);
	}
}
