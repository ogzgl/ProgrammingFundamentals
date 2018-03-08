package Domain;
import java.util.ArrayList;
import java.util.Random;
public class ComputerPlayer extends Player {
	private String name;
	private int score;
	private ArrayList<Card> computerCards;
	public ComputerPlayer(){
		this.name="computerplayer#1";
		this.score=0;
		computerCards = new ArrayList<Card>();
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name){
		this.name=name;
	}
	@Override
	public int getScore() {
		return score;
	}
	@Override
	public void setScore(int score) {
		this.score+=score;
	}
	public void setComputerCards(ArrayList<Card> cards)
	{
		this.computerCards=cards;
	}
	public ArrayList<Card> getComputerCards(){
		return this.computerCards;
	}
	public Card getNextCard(boolean first, Card humanPick){ //first boolean checks for if the computer first player to play or not									
		if(first){											//returns true if it is.
			Random r = new Random();
			int index=r.nextInt(computerCards.size());
			return computerCards.get(index);
		}
		else{
			
			int bound=humanPick.getNumber();
			for(Card eachCard:computerCards){
				if(eachCard.getNumber()>bound)
					return eachCard;
			}
			for(Card eachCard:computerCards){
				if(eachCard.getNumber()==bound)
					return eachCard;
			}
			return computerCards.get(0);	
		}
	}
}
