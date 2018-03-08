/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.util.*;
public class Author {
	private String name,birthPlace;
	private int birthYear;
	private ArrayList<Book> books;
	public Author(){
		books = new ArrayList<Book>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public void addBook(Book book){
		if(!books.contains(book) && !book.equals(null)){
			books.add(book);
		}
	}
	public ArrayList<Book> getBooks(){
		return this.books;
	}
	public void deleteBook(Book book){
		for(int index=0;index<books.size();index++){
			if(books.get(index).equals(book)){
				books.remove(index);
			}
		}
	}
		
}
