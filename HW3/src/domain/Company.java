/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company {
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Cargo> cargoes;
	private ArrayList<SenderCustomer> senderCustomers;
	private ArrayList<ReceiverCustomer> receiverCustomers;
	private Cargo newCargo;

	public Company() {
		vehicles = new ArrayList<Vehicle>();
		cargoes = new ArrayList<Cargo>();
		senderCustomers = new ArrayList<SenderCustomer>();
		receiverCustomers = new ArrayList<ReceiverCustomer>();
	}
	
	public Cargo getCargo(int index){
		return cargoes.get(index);
	}

	public void addVehicle(Vehicle vehicle) {
		if (vehicle != null && !vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
		}
	}

	public void addCargo() {
		cargoes.add(newCargo);
	}
	
	public void addCustomer(SenderCustomer customer){
		if(customer != null && !senderCustomers.contains(customer)){
			senderCustomers.add(customer);
		}
	}

	public int getSizeVehicles() {
		return vehicles.size();
	}

	public int getSizeCargoes() {
		return cargoes.size();
	}
	
	public int getSizeSenderCustomers(){
		return senderCustomers.size();
	}

	public Vehicle getVehicle(int index) {
		return vehicles.get(index);
	}
	
	public double weightAllCargoes(){
		double totalWeight = 0.0;
		for(int index = 0 ; index < cargoes.size() ; index ++){
			totalWeight = totalWeight + cargoes.get(index).getWeight();
		}
		return totalWeight;
	}
	
	public int upperLimitVehicles(TransType type){
		int upperLimit = 0;
		for(int index = 0 ; index < vehicles.size() ; index++){
			if(vehicles.get(index).getType() == type){
				upperLimit = (int) (upperLimit + vehicles.get(index).getUpperLimit());
			}
		}
		return upperLimit;
	}
	
	public boolean dateCheckVehicles(TransType type , Date date){
		Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
		if(type == TransType.AIR){
			cal1.setTime(vehicles.get(1).getDepartureDate());
			if(cal1.after(cal2)){
				return true;
			}
			else{
				return false;
			}
		}
		else if(type == TransType.ROAD){
			cal1.setTime(vehicles.get(3).getDepartureDate());
			if(cal1.after(cal2)){
				return true;
			}
			else{
				return false;
			}
		}
		else if(type == TransType.RAIL){
			cal1.setTime(vehicles.get(5).getDepartureDate());
			if(cal1.after(cal2)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
	public boolean checkPayer(String string){
		String check = new String("sender");
		if(Objects.equals(string, check)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean inputCheck(ArrayList<String> strings) throws ParseException{
		newCargo = new Cargo();
		if(strings.get(0).matches("[0-9]+")){
			newCargo.setWeight(Double.parseDouble(strings.get(0)));
		}
		else{
			return false;
		}
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(strings.get(1));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(matcher.matches()){
			newCargo.setDate(formatter.parse(strings.get(1)));
		}
		else{
			return false;
		}
		newCargo.setDate(formatter.parse(strings.get(1)));
		if(strings.get(2).matches("[a-zA-Z]+")){
			newCargo.setType(TransType.valueOf(strings.get(2)));
		}
		else{
			return false;
		}
		if(newCargo.getWeight() + weightAllCargoes() < upperLimitVehicles(newCargo.getType())){
			if(dateCheckVehicles(newCargo.getType(),newCargo.getDate())){
				return true;
			}
		}
		return false;
	}
	
	public String getCargoPrice(){
		double price = 1.0;
		if(newCargo.getType() == TransType.AIR){
			price = newCargo.getWeight()*5;
		}
		else if(newCargo.getType() == TransType.ROAD){
			price = newCargo.getWeight()*3.5;
		}
		else if(newCargo.getType() == TransType.RAIL){
			price = newCargo.getWeight()*2;
		}
		newCargo.setPrice(price);
		return String.valueOf(price);
	}
	
	public void customerInfo(ArrayList<String> strings, ArrayList<String> strings1, String string){
		SenderCustomer customerS = new SenderCustomer();
		ReceiverCustomer customerR = new ReceiverCustomer();
		customerS.setNationalID(Integer.parseInt(strings.get(0)));
		customerS.setName(strings.get(1));
		customerS.setPhoneNumber(Integer.parseInt(strings.get(2)));
		customerS.setAddress(strings.get(3));
		customerR.setNationalID(Integer.parseInt(strings1.get(0)));
		customerR.setName(strings1.get(1));
		customerR.setPhoneNumber(Integer.parseInt(strings1.get(2)));
		customerR.setAddress(strings.get(3));
		newCargo.setSender(customerS);
		newCargo.setReceiver(customerR);
		receiverCustomers.add(customerR);
		if(!senderCustomers.contains(customerS)){
			senderCustomers.add(customerS);
		}
		if(checkPayer(string)){
			newCargo.setPayer(customerS);
		}
		else{
			newCargo.setPayer(customerR);
		}
		customerS.addCargo(newCargo);
		customerR.addCargo(newCargo);
		
	}
	


}
