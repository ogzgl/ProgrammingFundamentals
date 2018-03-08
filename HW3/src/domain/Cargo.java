/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package domain;
import java.util.Date;
 
public class Cargo {
    private static int ID=1;
    private Integer cargoID;
    private double weight,price;
    private Date date;
    private Customer sender,receiver, payer;
    private TransType type;
    
    public Cargo(){
        this.cargoID=Cargo.ID;
        ID+=1;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Customer getSender() {
        return sender;
    }
    public void setSender(Customer sender) {
        this.sender = sender;
    }
    public Customer getReceiver() {
        return receiver;
    }
    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
    public Customer getPayer() {
        return payer;
    }
    public void setPayer(Customer payer) {
        this.payer = payer;
    }
    public int getCargoID() {
        return cargoID;
    }
    public void setType(TransType type){
    	this.type = type;
    }
    
    public TransType getType(){
    	 return type;
    }
}