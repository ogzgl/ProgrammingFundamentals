/*
 * 
 * @author OğuzGül-BuğrahanDönmez , 220201015-220201053
 * 
 */
package Domain;

public class UniqueID {
	private static int id=1;
	public static int getNewID(){
		return id++;
	}
	
}
