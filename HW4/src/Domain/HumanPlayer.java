package Domain;

import java.util.ArrayList;

public class HumanPlayer extends Player {
	private String name;
	private int score;
	private ArrayList<Card> playerCards;
	public HumanPlayer(String name){
		if(name==null)
			this.name="humanPlayer#1";
		else
			this.name=name;
		score=0;
		playerCards = new ArrayList<Card>();
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		if(name==null)
			this.name="humanPlayer#1";
		else{
			this.name = name;
		}
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score+=score;
	}
	public void setPlayerCard(ArrayList<Card> cards){
		this.playerCards = cards;
	}
	public ArrayList<Card> getPlayerCards(){
		return this.playerCards;
	}
	public Card getNextCard(int index){
		return playerCards.get(index);
	}
	
}
