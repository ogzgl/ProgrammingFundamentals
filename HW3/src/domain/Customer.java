/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;

public class Customer {
	
	private int nationalID;
	private String name;
	private int phoneNumber;
	private String address;
	
	public Customer(){
		
	}

	public int getNationalID() {
		return nationalID;
	}

	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
