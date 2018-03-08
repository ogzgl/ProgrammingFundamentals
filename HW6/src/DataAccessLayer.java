import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * @author OğuzGül-BuğrahanDönmez , 220201015-220201053
 * 
 */
public class DataAccessLayer {
	
	private int wordNumberInLine = 0;
	private StringTokenizer trackedWord = null;
	private int wordLineCheck = 0;
	private boolean oneUseFlag = true;
	
	public DataAccessLayer(){
		
	}
	
	public void readFile() throws FileNotFoundException{ //reads and creates poems
		Scanner scan = new Scanner(new File("poems.txt"));
		Poem tempPoem = new Poem();
		String title = "";
		int orderCounter=0;	//keep track of order in the file.
		int wordCounter=0;
		String line = null;
		while(scan.hasNextLine()){
			line = scan.nextLine();
			if(line.isEmpty())
				continue;
			StringTokenizer titleFinder = new StringTokenizer(line , " ");
			if(titleFinder.nextToken().contains("Title:")){
				wordCounter=0;
				while(titleFinder.hasMoreTokens()){
					title+=titleFinder.nextToken()+" ";
					wordCounter += 1; 
				}
				tempPoem.setTitle(title.trim());
				title="";
				orderCounter += 1;
			}
			wordCounter+=titleFinder.countTokens();
			tempPoem.setFileOrder(orderCounter);
			tempPoem.setNumberOfWords(wordCounter);
		}
	}
	
	public void IndexHashMapMaker() throws FileNotFoundException{
		HashMap<String, ArrayList<Integer>> hmIndex = new HashMap<String, ArrayList<Integer>>();
		HashMap<String, Integer> hmCount = new HashMap<String, Integer>();
		Scanner scan1 = new Scanner(new File("poemse.txt"));
		String line1 = null;
		String line2 = null;
		String word = null;
		String word1 = null;
		boolean lineCheck = false;
		int occurenceCount = 1;
		//int emptyLineCheck = 0;
		int comparedWordCount = 0;
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		
		while(scan1.hasNextLine()){
			if(wordNumberInLine == 0 || wordNumberInLine == wordLineCheck){
				line1 = scan1.nextLine();
				wordNumberInLine = 0;
				if(line1.isEmpty()){
					continue;
				}
				try {
					trackedWord = new StringTokenizer(line1 , " ");
				} catch (Exception e) {
					continue;
				}
				finally {
					trackedWord = new StringTokenizer(line1 , " ");
				}
				wordLineCheck = trackedWord.countTokens();
			}
			word = trackedWord.nextToken();
			Scanner scan2 = new Scanner(new File("poemse.txt"));
			if(word.contains("Title:"))
				continue;
			if(hmIndex.get(word) == null){
				while(scan2.hasNextLine()){
					line2 = scan2.nextLine();
					lineCheck = true;
					if(line2.isEmpty())
						continue;
					StringTokenizer comparedWord = new StringTokenizer(line2 , " ");
					word1 = comparedWord.nextToken();
					comparedWordCount = comparedWord.countTokens();
					if(word1.contains("Title:"))
						continue;
					for(int index = 0 ; index <= comparedWordCount ; index ++){
						if((word.toLowerCase()).equals(word1.toLowerCase()) && lineCheck == true){
							indexList.add(-(index + occurenceCount));
							lineCheck = false;
							if(oneUseFlag == true){
								oneUseFlag = false;
								occurenceCount = 0;								
							}
							//occurenceCount = occurenceCount + 1;
							if(index == comparedWordCount)
								continue;
							word1 = comparedWord.nextToken();
						}
						else  if((word.toLowerCase()).equals(word1.toLowerCase()) && lineCheck == false){
							indexList.add(index + occurenceCount);
							lineCheck = false;
							//occurenceCount = occurenceCount + 1;
							if(index == comparedWordCount)
								continue;
							word1 = comparedWord.nextToken();
						}
						else{
							//occurenceCount = occurenceCount + 1;
							lineCheck = false;
							if(index == comparedWordCount)
								continue;
							word1 = comparedWord.nextToken();
						}
					}
					occurenceCount = occurenceCount + 2;
			}
				hmIndex.put(word, indexList);
				wordNumberInLine = wordNumberInLine + 1;
				indexList = new ArrayList<Integer>();
			}
			else
				continue;
		}
		System.out.println(hmIndex.get("Just"));
	}
}