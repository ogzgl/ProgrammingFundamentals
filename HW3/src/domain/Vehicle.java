/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;
import java.util.ArrayList;
import java.util.Date;

public class Vehicle {

	private String id;
	private Date departureDate;
	private TransType type;
	private ArrayList<Cargo> cargoes;
	private int upperLimit;

	public Vehicle() {
		cargoes = new ArrayList<Cargo>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public TransType getType() {
		return type;
	}

	public void setType(TransType type) {
		this.type = type;
	}

	public double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public void addCargo(Cargo cargo) {
		if (cargo != null && cargoes.contains(cargo)) {
			cargoes.add(cargo);
		}
	}
	
	public void checkWeight(int weigth){
		int totalCargoWeight = 0;
		for(int index = 0 ; index < cargoes.size() ; index ++){
			totalCargoWeight = (int) (totalCargoWeight + cargoes.get(index).getWeight());
		}
	}
}
