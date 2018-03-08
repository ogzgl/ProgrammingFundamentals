/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;

import java.util.ArrayList;

public class ReceiverCustomer extends Customer{
	
	private ArrayList<Cargo> receivingCargoes;
	
	public ReceiverCustomer(){
		super();
		receivingCargoes = new ArrayList<Cargo>();
	}
	
	public void addCargo(Cargo cargo){
		if(cargo != null && receivingCargoes.contains(cargo)){
			receivingCargoes.add(cargo);
		}
	}

}
