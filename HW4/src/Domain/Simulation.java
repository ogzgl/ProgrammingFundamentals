package Domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Simulation {
	private ArrayList<Card> cards;
	private Deck deck = new Deck();
	private HumanPlayer human;
	private ComputerPlayer comp = new ComputerPlayer();
	private Menu menu;
	public Simulation(){
		cards = deck.init();
		System.out.println("Deck Shuffled.");
		menu=new Menu();
	}
	public void startGame() throws FileNotFoundException, IOException{
		createUsers();
		play();
	}
	public void createUsers(){
		human = new HumanPlayer(menu.userName());
		human.setPlayerCard(new ArrayList<Card> (cards.subList(0, 26)));
		comp.setComputerCards(new ArrayList<Card> (cards.subList(26, 52)));
		System.out.println("Cards dealed.");
	}
	public void play() throws FileNotFoundException, IOException{
		Random r = new Random();
		int starter = r.nextInt(2);
		boolean firstHand=true;
		Card compPick;
		Card humanPick;
		int firstPlayer=0;
		while(human.getPlayerCards().size()!=0 && comp.getComputerCards().size()!=0){
			if(firstHand){
				if(starter==0){
					compPick = comp.getNextCard(true,null);
					System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
					humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
					firstPlayer = handWinner(humanPick, compPick);	
					firstHand=false;
				}
				else{
					humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
					compPick = comp.getNextCard(false,humanPick);
					System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
					firstPlayer = handWinner(humanPick, compPick);	
					firstHand=false;
				}
			}
			else{
				if(firstPlayer==0){
					compPick = comp.getNextCard(true,null);
					System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
					humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
					firstPlayer = handWinner(humanPick, compPick);	
					firstHand=false;
				}
				else if(firstPlayer==1){
					humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
					compPick = comp.getNextCard(false,humanPick);
					System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
					firstPlayer = handWinner(humanPick, compPick);	
					firstHand=false;
				}
				else{
					Random t = new Random();
					int draw = t.nextInt(2);
					if(draw==0){
						compPick = comp.getNextCard(true,null);
						System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
						humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
						firstPlayer = handWinner(humanPick, compPick);	
						firstHand=false;
					}
					else{
						humanPick = human.getNextCard(menu.pickCardUser(human.getPlayerCards()));
						compPick = comp.getNextCard(false,humanPick);
						System.out.println("Computer Picked: " + compPick.getNumber() + " " + compPick.getType().toString());
						firstPlayer = handWinner(humanPick, compPick);	
						firstHand=false;
					}
				}
			}
		}
		if(human.getPlayerCards().size()==0 && comp.getComputerCards().size()==0){
			DataAccessLayer writer = new DataAccessLayer();
			if(human.getScore()>comp.getScore())
			{
				System.out.println("Victory");
				writer.writeFile(human,comp);
			}else if(comp.getScore()>human.getScore())
			{
				System.out.println("Defeat");
				writer.writeFile(human,comp);
			}else{
				System.out.println("Draw");
				writer.writeFile(human,comp);
			}
		}
		
	}
	public int handWinner(Card humanPick, Card compPick){
		int winner;
		if(compPick.getNumber()>humanPick.getNumber()){
			comp.setScore(compPick.getScore());
			human.getPlayerCards().remove(humanPick);
			comp.getComputerCards().remove(compPick);
			return winner=0;
		}
		else if(humanPick.getNumber()>compPick.getNumber())
		{
			human.setScore(humanPick.getScore());
			human.getPlayerCards().remove(humanPick);
			comp.getComputerCards().remove(compPick);
			return winner=1;
		}
		else{
			human.getPlayerCards().remove(humanPick);
			comp.getComputerCards().remove(compPick);
			return winner=2;
		}
		
	}

}
	