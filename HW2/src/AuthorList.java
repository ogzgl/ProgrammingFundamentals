/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.util.ArrayList;

public class AuthorList {
	private ArrayList<Author> authors;
	public AuthorList(){
		authors = new ArrayList<Author>();

	}
	public void addAuthor(Author author){
		if(!authors.contains(author) && !author.equals(null)){
			authors.add(author);
		}
	}
	public void removeAuthor(Author author){
		for(int index=0;index<authors.size();index++){
			if(authors.get(index).equals(author)){
				authors.remove(index);
				break;
			}
		}
	}
	public void searchByAuthor(String name){
		ArrayList<Book> booksToPrint = new ArrayList<Book>();
		for(int index=0;index<authors.size();index++){
			if(authors.get(index).getName().equals(name)){
				booksToPrint = authors.get(index).getBooks();
				break;
			}
		}
		System.out.println("The books according to given author: ");
		for(int index=0;index<booksToPrint.size();index++){
			System.out.println(booksToPrint.get(index).getTitle());
		}
	}
	public void totalPriceAuthor(String name){
		double totalPrice=0;
		ArrayList<Book> booksToCalc = new ArrayList<Book>();
		for(int index=0;index<authors.size();index++){
			if(authors.get(index).getName().equals(name)){
				booksToCalc = authors.get(index).getBooks();
				break;
			}
		}
		for(int index=0;index<booksToCalc.size();index++){
			totalPrice+=booksToCalc.get(index).getPrice();
		}
		System.out.println("Total price of all books of given author is: " + totalPrice);
	}
	public int size(){
		return authors.size();
	}
	public ArrayList<Author> returnAuthors(){
		return authors;
	}
}