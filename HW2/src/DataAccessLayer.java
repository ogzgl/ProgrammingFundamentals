/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DataAccessLayer {
	public DataAccessLayer(){
		
	}
	public void readFiles(BookShelf bookShelf, AuthorList authorList){
		ArrayList<Author> tempAuthors = new ArrayList<Author>();
		ArrayList<Book> tempBooks = new ArrayList<Book>();
		Author tempAuthor = new Author();
		Book tempBook = new Book();
		String lineAuthor = null;
		String lineBook = null;
		try{
			Scanner authorFile = new Scanner(new File("authors.dat"));
			while(authorFile.hasNextLine())
			{
				lineAuthor = authorFile.nextLine();
				StringTokenizer authorFinder = new StringTokenizer(lineAuthor , ",");
				tempAuthor.setName(authorFinder.nextToken());
				tempAuthor.setBirthYear(Integer.parseInt(authorFinder.nextToken()));
				tempAuthor.setBirthPlace(authorFinder.nextToken());
				tempAuthors.add(tempAuthor);
				tempAuthor = new Author();
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			Scanner bookFile = new Scanner(new File("books.dat"));
			while(bookFile.hasNextLine()){
				lineBook = bookFile.nextLine();
				StringTokenizer bookFinder = new StringTokenizer(lineBook, ",");
				tempBook.setTitle(bookFinder.nextToken());
				tempBook.setIsbnNumber(bookFinder.nextToken());
				String a = bookFinder.nextToken();
				tempBook.setGenre(findGenre(a));
				tempBook.setPublishingYear(Integer.parseInt(bookFinder.nextToken()));
				tempBook.setPublisher(bookFinder.nextToken());
				tempBook.setPrice(Double.parseDouble(bookFinder.nextToken()));
				tempBooks.add(tempBook);
				tempBook= new Book();
				
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		for(int index=0;index<tempAuthors.size();index++){
			tempAuthors.get(index).addBook(tempBooks.get(index));
			tempBooks.get(index).addAuthor(tempAuthors.get(index));
		}
		for(int index=0;index<tempAuthors.size();index++){
			bookShelf.addBook(tempBooks.get(index));
			authorList.addAuthor(tempAuthors.get(index));
		}
	}
	public Genre findGenre(String genreToken){
		if(genreToken.toLowerCase()=="science")
			return Genre.SCIENCE;
		else if(genreToken.toLowerCase()=="drama")
			return Genre.DRAMA;
		else if(genreToken.toLowerCase().equals("adventure"))
			return Genre.ADVENTURE;
		else if(genreToken.toLowerCase()=="horror")
			return Genre.HORROR;
		else if(genreToken.toLowerCase()=="history")
			return Genre.HISTORY;
		else 
			return Genre.COMICS;
	}
}
