package Domain;
import java.util.ArrayList;
import java.util.Random;
public class Deck {
	private ArrayList<Card> deck;
	private ArrayList<Card> shuffledDeck;
	public Deck(){
		deck = new ArrayList<Card>();
		shuffledDeck = new ArrayList<Card>();
	}
	public ArrayList<Card> init(){
		for(int i=1;i<14;i++){
			Card tempCard=new Card(i,i*5,CardType.SPADES);
			Card tempCard_2=new Card(i,i*7,CardType.HEARTS);
			Card tempCard_3=new Card(i,i*9,CardType.DIAMONDS);
			Card tempCard_4=new Card(i,i*11,CardType.CLUBS);
			deck.add(tempCard);
			deck.add(tempCard_2);
			deck.add(tempCard_3);
			deck.add(tempCard_4);
			
		}
		return shuffle();
	}
	private ArrayList<Card> shuffle(){
		Random r = new Random();
		int element;
		int bound = deck.size();
		while(!deck.isEmpty()){
			element=r.nextInt(bound);
			shuffledDeck.add(deck.get(element));
			deck.remove(element);
			bound=deck.size();
		}
		return shuffledDeck;
	}
}
