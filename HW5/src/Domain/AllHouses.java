/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package Domain;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import DataAccessLayer.DataAccessLayer;
import Presentation.SwingGUI;

public class AllHouses {
	private static ArrayList<House> houses;
	public AllHouses()
	{
		houses = new ArrayList<House>();
	}
	public static void addHouse(House house){
		houses.add(house);
	}
//	public void addHouses(ArrayList<House> addHouses){
//		for(House eachHouse: addHouses){
//			houses.add(eachHouse);
//		}
//	}
	public void init(DataAccessLayer dal, SwingGUI gui) throws FileNotFoundException{
		AllHouses.houses = dal.readData("housing.txt");
		SwingGUI.start();
	}
	public static boolean removeHouse(int id){
		boolean removed = false;
		for(int i=0;i<houses.size();i++){
			if(houses.get(i).getHouseID()==id){
				houses.remove(houses.get(i));
				removed = true;
			}
		}
		return removed;
	}
	public static ArrayList<House> searchHouse(double searchMinTerm, double searchMaxTerm, SearchType searchType){
		ArrayList<House> foundHouses = new ArrayList<House>();
		for(House eachHouse:houses){
			if(searchType==SearchType.PRICE){
				if(eachHouse.getPrice()>searchMinTerm && eachHouse.getPrice()<searchMaxTerm)
					foundHouses.add(eachHouse);
			}
			if(searchType==SearchType.SIZE){
				if(eachHouse.getSize()>searchMinTerm && eachHouse.getSize()<searchMaxTerm)
					foundHouses.add(eachHouse);
			}
			if(searchType==SearchType.NUMBEROFROOMS){
				if(eachHouse.getNumberOfRooms()==searchMinTerm)
					foundHouses.add(eachHouse);
			}
		}
		return foundHouses;
	}
	public static Object[][] getHouses(){
		Object[][] houseArray = new Object[houses.size()][6];
		for(int i=0;i<houses.size();i++){
			houseArray[i][0] = houses.get(i).getHouseID();
			houseArray[i][1] = houses.get(i).getPrice();
			houseArray[i][2] = houses.get(i).getSize();
			houseArray[i][3] = houses.get(i).getNumberOfRooms();
			houseArray[i][4] = houses.get(i).getNumberOfBathrooms();
			if(houses.get(i).isHavingAirconditioner() == true){
				houseArray[i][5] = "yes";
			}
			else{
				houseArray[i][5] = "no";
			}
		}
		return houseArray;
	}
	public static Object[][] getHouses(ArrayList<House> paramHouses){
		Object[][] houseArray = new Object[paramHouses.size()][6];
		for(int i=0;i<paramHouses.size();i++){
			houseArray[i][0] = paramHouses.get(i).getHouseID();
			houseArray[i][1] = paramHouses.get(i).getPrice();
			houseArray[i][2] = paramHouses.get(i).getSize();
			houseArray[i][3] = paramHouses.get(i).getNumberOfRooms();
			houseArray[i][4] = paramHouses.get(i).getNumberOfBathrooms();
			if(paramHouses.get(i).isHavingAirconditioner() == true){
				houseArray[i][5] = "yes";
			}
			else{
				houseArray[i][5] = "no";
			}
		}
		return houseArray;
	}
	public static ArrayList<House> ascendingOrder(){
		 ArrayList<House> ascendingHouse = new ArrayList<House>(houses);
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     House temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < ascendingHouse.size() -1;  j++ )
	            {
	                   if ( ascendingHouse.get(j).getPrice() > ascendingHouse.get(j+1).getPrice()  )   // change to > for ascending sort
	                   {
	                           temp = ascendingHouse.get(j);  
	                           ascendingHouse.set(j, ascendingHouse.get(j+1));
	                           ascendingHouse.set(j+1,temp);
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      }
	     return ascendingHouse;
	}
	public static ArrayList<House> descendingOrder(){
		 ArrayList<House> descendingHouse = new ArrayList<House>(houses);
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     House temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < descendingHouse.size() -1;  j++ )
	            {
	                   if ( descendingHouse.get(j).getPrice() < descendingHouse.get(j+1).getPrice()  )   // change to > for ascending sort
	                   {
	                           temp = descendingHouse.get(j);  
	                           descendingHouse.set(j, descendingHouse.get(j+1));
	                           descendingHouse.set(j+1,temp);
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      }
	     return descendingHouse;
	}
}
