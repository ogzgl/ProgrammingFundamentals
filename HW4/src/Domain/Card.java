package Domain;

public class Card {
	private int number,score;
	private CardType type;
	public Card(int number, int score, CardType type){
		this.number=number;
		this.score=score;
		this.type=type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
}
