
package board;

public class Card {
	
	private Suit suit;
	private Value value;
	private String imgName;
	private int points;

	public Card(Suit suit, Value value, String imgName, int points) {
		this.suit = suit;
		this.value = value;
		this.imgName = imgName;
		this.points = points;

	}
	
	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}
	
	public String getImgName() {
		return imgName;
	}	
	
	public int getPoints() {
		return points;
	}
		
	public String toString() {
		return getSuit() + " - " + getValue() + " - " + getImgName() + "-" + getPoints();

	}
}
