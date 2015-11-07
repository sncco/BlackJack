
package board;

import java.util.ArrayList;

public class Player {
	
    private String name;
    private int totalValue = 0;
    private ArrayList<Card> hand = new ArrayList<Card>();

	public Player(String name) {
        this.name = name;
    }
	
    public String getName() {
		return name;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public int getTotalValue() {
		this.totalValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			this.totalValue = this.totalValue + hand.get(i).getPoints();
		}
		return totalValue;
	}
	
}
