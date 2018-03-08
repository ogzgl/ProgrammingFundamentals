/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
public class BookShelfApp {
	public static void main(String args[]){
		DataAccessLayer reader = new DataAccessLayer();
		BookShelf bookShelf = new BookShelf();
		AuthorList authorList = new AuthorList();
		reader.readFiles(bookShelf, authorList);
		BookShelfMenu userInterface = new BookShelfMenu();
		while(true){
			userInterface.init(bookShelf, authorList);
		}
	}
}
