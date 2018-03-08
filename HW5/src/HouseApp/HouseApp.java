/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package HouseApp;
import Presentation.SwingGUI;

import java.io.FileNotFoundException;

import DataAccessLayer.DataAccessLayer;
import Domain.AllHouses;
public class HouseApp {
	public static void main(String args[]) throws FileNotFoundException{
		DataAccessLayer fileAccess = new DataAccessLayer();
		AllHouses allHouse = new AllHouses();
		SwingGUI userInterface = new SwingGUI();		
		allHouse.init(fileAccess, userInterface);
	}
}
