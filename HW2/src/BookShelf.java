/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.util.ArrayList;

public class BookShelf {
	private ArrayList<Book> books;
	public BookShelf(){
		books = new ArrayList<Book>();
	}
	public int size(){
		return books.size();
	}
	public void addBook(Book book){
		if(!books.contains(book) && !book.equals(null)){
			books.add(book);
		}
	}
	public Book researchBook(String isbnNumber){
		for(int index=0;index<books.size();index++){
			if(books.get(index).getIsbnNumber().equals(isbnNumber)){
				return books.get(index);
			}
		}
		return null;
	}
	public void removeBook(Book book){
		for(int index=0;index<books.size();index++){
			if(books.get(index).equals(book)){
				books.remove(index);
				break;
			}
		}
	}
	public void searchGenre(Genre genre){
		System.out.println("The books according to selected genre are: ");
		for(Book eachBook : books){
			if(eachBook.getGenre().equals(genre));{
				System.out.println(eachBook.getTitle());
			}
		}

	}
	public void searchPublishingYear(int year){
		for(Book eachBook : books){
			if(eachBook.getPublishingYear()==year)
				System.out.println(eachBook.getTitle());
		}
		System.out.println("The books according to given year are: ");
	}
	public void searchPrice(double lowerPrice, double upperPrice){
		System.out.println("The books according to given price range are: ");
		for(Book eachBook : books){
			if(lowerPrice<eachBook.getPrice() && eachBook.getPrice()<upperPrice)
				System.out.println(eachBook.getTitle());
		}

	}
	public void printTotalPrice(){
		double totalPrice=0.0;
		for(int index=0;index<books.size();index++){
			if(books.get(index).getPrice()!=0.0){
				totalPrice+=books.get(index).getPrice();
			}
		}
		System.out.println("Total price of the books on bookshelf is: " + totalPrice + "$");
	}
}
