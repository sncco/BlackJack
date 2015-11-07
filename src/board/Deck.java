
package board;

import java.util.*;


public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int points;
	
	public Deck() {
		for (Suit naipe : Suit.values()) {
			for (Value valor : Value.values()) {
				if (valor == Value.AS) {
					this.points = 11;
				}else if (valor == Value.DOIS) {
					this.points = 2;
				}else if (valor == Value.TRES) {
					this.points = 3;
				}else if (valor == Value.QUATRO) {
					this.points = 4;
				}else if (valor == Value.CINCO) {
					this.points = 5;
				}else if (valor == Value.SEIS) {
					this.points = 6;
				}else if (valor == Value.SETE) {
					this.points = 7;
				}else if (valor == Value.OITO) {
					this.points = 8;
				}else if (valor == Value.NOVE) {
					this.points = 9;
				}else {
					this.points = 10;
				}
			cards.add(new Card(naipe, valor,  naipe.toString() + "/" + valor.toString() + ".png", points));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public String toString() {
		return cards.toString();
	}

}

