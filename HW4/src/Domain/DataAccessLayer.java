package Domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DataAccessLayer {

	public void writeFile(Player human, Player comp) throws FileNotFoundException, IOException{
		String string = human.getName();
		String string1 = comp.getName();
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(string + "_"+ string1+".txt",false));
		outputStream.println(human.getName()+":"+human.getScore());
		outputStream.println(comp.getName()+":"+comp.getScore());
		outputStream.close();
	}
}
