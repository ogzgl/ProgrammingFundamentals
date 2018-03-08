/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package DataAccessLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Domain.House;

public class DataAccessLayer {
	public DataAccessLayer(){
		
	}
	public ArrayList<House> readData(String fileName) throws FileNotFoundException{
		ArrayList<House> fileHouseList = new ArrayList<House>();
		Scanner input = new Scanner(new File("housing.txt"));
		House tempHouse = new House();
		input.nextLine();
		while(input.hasNextLine()){
			String fileInput = input.nextLine();
			StringTokenizer wordFinder = new StringTokenizer(fileInput, ",");
			String a =wordFinder.nextToken();
			tempHouse.setPrice(Double.parseDouble(wordFinder.nextToken()));
			tempHouse.setSize(Double.parseDouble(wordFinder.nextToken()));
			tempHouse.setNumberOfRooms(Double.parseDouble(wordFinder.nextToken()));
			tempHouse.setNumberOfBathrooms(Integer.parseInt(wordFinder.nextToken()));
			String tempCheck =wordFinder.nextToken();
			if(tempCheck.contains("yes")){
				tempHouse.setHavingAirconditioner(true);
			}
			else if(tempCheck.contains("no")){
				tempHouse.setHavingAirconditioner(false);
			}
			else{
				if(wordFinder.nextToken().contains("yes")){
					tempHouse.setHavingAirconditioner(true);
				}
			}
			fileHouseList.add(tempHouse);
			tempHouse = new House();
		}
		input.close();
		return fileHouseList;
	}
	
}
