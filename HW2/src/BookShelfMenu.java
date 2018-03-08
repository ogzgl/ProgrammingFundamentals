/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BookShelfMenu {
	private BookShelf bookShelf ;
	private AuthorList authorList;
	public void init(BookShelf bookShelf, AuthorList authorList){
		this.bookShelf=bookShelf;
		this.authorList=authorList;
		Scanner scan = new Scanner(System.in);
		System.out.println("..::Menu::..");
		System.out.println("1. Add Book:");
		System.out.println("2. Remove a Book:");
		System.out.println("3. Search by Genre:");
		System.out.println("4. Search by Publishing Year:");
		System.out.println("5. Search by Author Name:");
		System.out.println("6. Search by Price:");
		System.out.println("7. Total Price of All Books:");
		System.out.println("8. Total Price of an Authors All Books:");
		System.out.println("9. Exit");
		System.out.println("Choice: ");
		boolean flag=true;
		do{
			
			int choice = scan.nextInt();
			switch(choice){
			case 1: addBook();
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
					break;
			case 6: searchPrice();
					flag=false;
					break;
			case 7: totalPrice();
					flag=false;
					break;
			case 8: totalPriceAuthor();
					flag=false;
					break;
			case 9: System.exit(-1);
			default: System.out.println("The given input is not valid. Try Again.");
			
			}
		}while(flag);	
	}
	public void addBook(){
		Book bookToAdd = new Book();
		String title=null, isbnNumber=null, publisher=null;
		Genre genre=null;
		int publishingYear=0, selectedGenre;
		double price=0;
		ArrayList<Author> authors= new ArrayList<Author>();
		Scanner scan = new Scanner(System.in);
		do{	
			if(title==null)
				System.out.println("Please enter the title of the book: ");
			else
				System.out.println("Given title was not valid. Try again: ");
			title = scan.nextLine();
		}while(!title.matches("[a-zA-Z\\d\\s\\.]+"));
		
		
		do{
			if(isbnNumber==null)
				System.out.println("Please enter the ISBN number: ");
			else
				System.out.println("Given ISBN was not valid. Try again: ");
			isbnNumber=scan.nextLine();
		}while(!isbnNumber.matches("[\\d\\-]+"));
		
		boolean flag=true;
		System.out.println("Please enter the genre of the book:");
		System.out.println("1.Science");
		System.out.println("2.Drama");
		System.out.println("3.Adventure");
		System.out.println("4.Horror");
		System.out.println("5.History");
		System.out.println("6.Comics");	
		do{
			selectedGenre = scan.nextInt();
			switch(selectedGenre){
				case 1: genre = Genre.SCIENCE;
						flag=false;
						break;
				case 2: genre = Genre.DRAMA;
						flag=false;
						break;
				case 3: genre = Genre.ADVENTURE;
						flag=false;
						break;
				case 4: genre = Genre.HORROR;
						flag=false;
						break;
				case 5: genre = Genre.HISTORY;
						flag=false;
						break;
				case 6: genre = Genre.COMICS;
						flag=false;
						break;
				default: System.out.println("The given genre is not valid. Try again.");
			}
		}while(flag);
		
		scan = new Scanner(System.in);
		String publishYearString=null;
		do{
			if(publishYearString==null)
				System.out.println("Please enter the publishing year: ");
			else
				System.out.println("Given year was not valid. Try again: ");
			
			publishYearString=scan.nextLine();
		}while(!publishYearString.matches("[\\d]+"));
		publishingYear=Integer.parseInt(publishYearString);
		
		do{
			if(publisher==null)
				System.out.println("Please enter the publisher of the book: ");
			else
				System.out.println("Given publisher was not valid. Try again: ");
			publisher = scan.nextLine();
		}while(!publisher.matches("[a-zA-Z\\d\\s\\.]+"));
		
		String priceString = null;
		do{
			if(priceString==null)
				System.out.println("Please enter price of the book(Ex.99.99):");
			else
				System.out.println("Given price value was not valid. Try again: ");
			priceString = scan.nextLine();
		}while(!priceString.matches("[\\d\\.]+"));
		price = Double.parseDouble(priceString);
		
		int authorNumber=0;
		String authorNumberStr = null;
		do{
			if(authorNumberStr == null)
				System.out.println("Enter the number of authors for the book:");
			else
				System.out.println("Given input was not valid. Try Again: ");
			authorNumberStr = scan.nextLine();
		}while(!authorNumberStr.matches("[1-9]+"));
		authorNumber=Integer.parseInt(authorNumberStr);
		bookToAdd.setTitle(title);
		bookToAdd.setGenre(genre);
		bookToAdd.setIsbnNumber(isbnNumber);
		bookToAdd.setPrice(price);
		bookToAdd.setPublisher(publisher);
		bookToAdd.setPublishingYear(publishingYear);
		String tempAuthorName;
		ArrayList<Author> tempAuthors=authorList.returnAuthors();
		for(int i=0;i<authorNumber;i++){
			System.out.println("Please enter the name of the author "+ (i+1));
			boolean isAuthorRegistered = false;
			tempAuthorName=scan.nextLine();
			for(Author eachBook : tempAuthors){
				if(eachBook.getName().equals(tempAuthorName)) {
					bookToAdd.addAuthor(eachBook);
					eachBook.addBook(bookToAdd);
					isAuthorRegistered = true;
				}

			}
			if(isAuthorRegistered==false){
				Author tempAuthor = new Author();
				String name=null,birthPlace=null;
				int birthYear=0;
				do{	
					if(name==null)
						System.out.println("Please enter name of the author: ");
					else
						System.out.println("Given name was not valid. Try again: ");
					name = scan.nextLine();
				}while(!name.matches("[a-zA-Z\\d\\s\\.]+"));
				
				do{	
					if(birthPlace==null)
						System.out.println("Please enter the birth place of the author: ");
					else
						System.out.println("Given birth place was not valid. Try again: ");
					birthPlace = scan.nextLine();
				}while(!birthPlace.matches("[a-zA-Z\\d\\s\\.]+"));
				
				String birthYearString=null;
				do{
					if(birthYearString==null)
						System.out.println("Please enter the birth year: ");
					else
						System.out.println("Given year was not valid. Try again: ");
					birthYearString=scan.nextLine();
					
				}while(!birthYearString.matches("[\\d]+"));
				birthYear=Integer.parseInt(birthYearString);
				
				tempAuthor.setName(name);
				tempAuthor.setBirthYear(birthYear);
				tempAuthor.setBirthPlace(birthPlace);
				tempAuthor.addBook(bookToAdd);
				bookToAdd.addAuthor(tempAuthor);
				authorList.addAuthor(tempAuthor);
				bookShelf.addBook(bookToAdd);
				
				
			}
		}
		System.out.println(bookShelf.size());
	}
	public void remover(){
		String remover = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ISBN number of the book you wan to delete.");
		remover = input.nextLine();
		removeBook(remover);
		
	}
	public void removeBook(String isbnNumber){
		Book bookDelete = new Book();
		ArrayList<Author> authorsOfBook = new ArrayList<Author>();
		ArrayList<Book> booksOfAuthor = new ArrayList<Book>();
		bookDelete = bookShelf.researchBook(isbnNumber);
		if(bookDelete!=null){
			authorsOfBook = bookDelete.getAuthors();
			for(int iteraAuthor=0;iteraAuthor<authorsOfBook.size();iteraAuthor++){
				booksOfAuthor = authorsOfBook.get(iteraAuthor).getBooks();
				for(int iteraBook=0;iteraBook<booksOfAuthor.size();iteraBook++){
					if(booksOfAuthor.get(iteraBook).equals(bookDelete)){
						booksOfAuthor.remove(iteraBook);
					}
				}
			}
		}
		for(int index=0;index<authorsOfBook.size();index++){
			if(authorsOfBook.get(index).getBooks().size()==0){
				authorList.removeAuthor(authorsOfBook.get(index));
			}
		}
		bookShelf.removeBook(bookDelete);
	}
	public void searchAuthorName(){
		Scanner scan = new Scanner(System.in);
		String name=null;
		do{	
			if(name==null)
				System.out.println("Please enter name of the author: ");
			else
				System.out.println("Given name was not valid. Try again: ");
			name = scan.nextLine();
		}while(!name.matches("[a-zA-Z\\d\\s\\.]+"));
		authorList.searchByAuthor(name);
	}
	public void searchGenre(){
		Scanner scan = new Scanner(System.in);
		Genre genre;
		int selectedGenre;
		boolean flag=true;
		System.out.println("Please enter the genre of the book:");
		System.out.println("1.Science");
		System.out.println("2.Drama");
		System.out.println("3.Adventure");
		System.out.println("4.Horror");
		System.out.println("5.History");
		System.out.println("6.Comics");	
		do{
			selectedGenre = scan.nextInt();
			switch(selectedGenre){
				case 1: genre = Genre.SCIENCE;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				case 2: genre = Genre.DRAMA;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				case 3: genre = Genre.ADVENTURE;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				case 4: genre = Genre.HORROR;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				case 5: genre = Genre.HISTORY;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				case 6: genre = Genre.COMICS;
						bookShelf.searchGenre(genre);
						flag=false;
						break;
				default: System.out.println("The given genre is not valid. Try again.");
			}
		}while(flag);

	}
	public void searchPublishingYearX(){
		Scanner scan = new Scanner(System.in);
		int year;
		String yearString=null;
		do{
			if(yearString==null)
				System.out.println("Please enter the publishing year: ");
			else
				System.out.println("Given year was not valid. Try again: ");
			
			yearString=scan.nextLine();
		}while(!yearString.matches("[0-9]+"));
		year=Integer.parseInt(yearString);
		bookShelf.searchPublishingYear(year);
	}
	public void searchPrice(){
		double lowerPrice, upperPrice;
		Scanner scan = new Scanner(System.in);
		String priceString = null;
		do{
			if(priceString==null)
				System.out.println("Please enter lower price of the book(Ex.99.99):");
			else
				System.out.println("Given price value was not valid. Try again: ");
			priceString = scan.nextLine();
		}while(!priceString.matches("[\\d\\.]+"));
		lowerPrice = Double.parseDouble(priceString);
		
		priceString = null;
		scan = new Scanner(System.in);
		do{
			if(priceString==null)
				System.out.println("Please enter upper price of the book(Ex.99.99):");
			else
				System.out.println("Given price value was not valid. Try again: ");
			priceString = scan.nextLine();
		}while(!priceString.matches("[\\d\\.]+"));
		upperPrice = Double.parseDouble(priceString);
		bookShelf.searchPrice(lowerPrice, upperPrice);
		
	}
	public void totalPrice(){
		bookShelf.printTotalPrice();
	}
	public void totalPriceAuthor(){
		Scanner scan = new Scanner(System.in);
		String name=null;
		do{	
			if(name==null)
				System.out.println("Please enter name of the author: ");
			else
				System.out.println("Given name was not valid. Try again: ");
			name = scan.nextLine();
		}while(!name.matches("[a-zA-Z\\d\\s\\.]+"));
		authorList.totalPriceAuthor(name);
	}

}
