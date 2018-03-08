/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */

import java.util.*;
public class Book {
	private String title, isbnNumber, publisher;
	private Genre genre;
	private int publishingYear;
	private double price;
	private ArrayList<Author> authors;
	public Book(){
		authors = new ArrayList<Author>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbnNumber() {
		return isbnNumber;
	}
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void addAuthor(Author author){
		if (!authors.contains(author) && !author.equals(null)){
			authors.add(author);
		}
	}
	public String getAuthorString(){
		String author = "";
		for(int index=0; index<this.authors.size();index++){
			author+=this.authors.get(index).getName();
		}
		return author;
	}
	public ArrayList<Author> getAuthors(){
		return this.authors;
	}
	
}
