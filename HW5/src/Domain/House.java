/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package Domain;
public class House {
	private int houseID;
	private double price, size,numberOfRooms; //size thought in square meters.
	private int numberOfBathrooms;
	private boolean havingAirconditioner; //true if there is airconditioner.
	public House(){
		houseID = UniqueID.getNewID();
		this.price=0;
		this.size=0;
		this.numberOfRooms=0;
		this.numberOfBathrooms=0;
		this.havingAirconditioner=false;
		
	}
	public House(double price, double size, int numberOfRooms, int numberOfBathrooms, boolean airConditioner){
		houseID = UniqueID.getNewID();
		this.price=price;
		this.size=size;
		this.numberOfRooms=numberOfRooms;
		this.numberOfBathrooms=numberOfBathrooms;
		this.havingAirconditioner=airConditioner;
	}
	public int getHouseID(){
		return houseID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(double numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}
	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}
	public boolean isHavingAirconditioner() {
		return havingAirconditioner;
	}
	public void setHavingAirconditioner(boolean havingAirconditioner) {
		this.havingAirconditioner = havingAirconditioner;
	}
	
}
