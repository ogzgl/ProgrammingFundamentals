import java.io.FileNotFoundException;

public class PoemApplication {
	public static void main(String args[]) throws FileNotFoundException{
		DataAccessLayer dal = new DataAccessLayer();
		dal.readFile();
		dal.IndexHashMapMaker();
	}
}