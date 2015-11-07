
package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Listener implements ActionListener {

	private BlackJackGUI game;

	public Listener(BlackJackGUI game) {
		super();
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText() == "Novo Jogo") {
			game.newGame();
		} else if (b.getText() == "Pedir") {
			game.newCard();
		} else if (b.getText() == "Ficar") {
			game.hitCard();
		}
	}
}
