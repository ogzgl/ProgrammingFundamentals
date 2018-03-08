/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;

import java.util.ArrayList;

public class SenderCustomer extends Customer {
	
	private ArrayList<Cargo> sendingCargoes;
	
	public SenderCustomer(){
		super();
		sendingCargoes = new ArrayList<Cargo>();
	}
	
	public void addCargo(Cargo cargo){
		if(cargo != null && sendingCargoes.contains(cargo)){
			sendingCargoes.add(cargo);
		}
	}

}
