
package board;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlackJackGUI {

	private Deck deck = new Deck();
	private Player player = new Player("player");
	private Player dealer = new Player("dealer");
	private JButton butaoPede = new JButton("Pedir");
	private JButton butaoFica = new JButton("Ficar");
	private JButton butaoJoga = new JButton("Novo Jogo");
	private JLabel painelStatus = new JLabel(" ", JLabel.CENTER);
	JPanel playerPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel statusPanel = new JPanel();

	public BlackJackGUI() {
		JFrame gameFrame = new JFrame("BlackJack");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonsPanel.add(butaoPede);
		buttonsPanel.add(butaoFica);
		buttonsPanel.add(butaoJoga);
		statusPanel.add(painelStatus);
		Listener listener = new Listener(this);

		butaoPede.addActionListener(listener);
		butaoFica.addActionListener(listener);
		butaoJoga.addActionListener(listener);

		butaoPede.setEnabled(false);
		butaoFica.setEnabled(false);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(dealerPanel, BorderLayout.NORTH);
		gameFrame.add(playerPanel, BorderLayout.CENTER);
		gameFrame.add(buttonsPanel, BorderLayout.SOUTH);
		gameFrame.add(statusPanel, BorderLayout.WEST);
		gameFrame.repaint();
		gameFrame.setSize(550, 350);
		gameFrame.setVisible(true);
	}

	private ImageIcon readImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(new File(fileName));
			Image imgScaled = img.getScaledInstance(img.getWidth() / 6, img.getHeight() / 6, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(imgScaled);
			return icon;
		} catch (IOException e) {
			return null;
		}
	}

	private void hitDealer() {
		JLabel carta = new JLabel();
		dealerPanel.add(carta);
		ImageIcon img = readImage(deck.getCards().get(0).getImgName().toString());
		dealer.getHand().add(deck.getCards().get(0));
		deck.getCards().remove(0);
		carta.setIcon(img);
		dealerPanel.updateUI();
	}

	private void hitDealerDown() {
		JLabel carta = new JLabel();
		dealerPanel.add(carta);
		ImageIcon img = readImage("back.png");
		dealer.getHand().add(deck.getCards().get(0));
		deck.getCards().remove(0);
		carta.setIcon(img);
		dealerPanel.updateUI();

	}

	private void hitPlayer() {
		JLabel carta = new JLabel();
		playerPanel.add(carta);
		ImageIcon img = readImage(deck.getCards().get(0).getImgName().toString());
		player.getHand().add(deck.getCards().get(0));
		deck.getCards().remove(0);
		carta.setIcon(img);
		playerPanel.updateUI();
	}

	public void newGame() {
		painelStatus.setText(" ");
		player.getHand().clear();
		dealer.getHand().clear();
		playerPanel.removeAll();
		dealerPanel.removeAll();
		playerPanel.updateUI();
		dealerPanel.updateUI();
		deck = new Deck();
		deck.shuffle();
		hitPlayer();
		hitDealerDown();
		hitPlayer();
		hitDealer();
		butaoPede.setEnabled(true);
		butaoFica.setEnabled(true);
		butaoJoga.setEnabled(false);
	}

	public void newCard() {
		hitPlayer();
		if (player.getTotalValue() > 21) {
			painelStatus.setText("Player Busts");
			butaoPede.setEnabled(false);
			butaoFica.setEnabled(false);
			butaoJoga.setEnabled(true);
		}
	}

	public void hitCard() {
		while (dealer.getTotalValue() < 17) {
			hitDealer();
		}
		if (dealer.getTotalValue() > 21) {
			painelStatus.setText("Dealer Busts");
			dealerPanel.removeAll();
			int size = dealer.getHand().size();
			for (int i = 0; i < size; i++) {
				JLabel carta = new JLabel();
				dealerPanel.add(carta);
				ImageIcon img = readImage(dealer.getHand().get(i).getImgName().toString());
				carta.setIcon(img);
				dealerPanel.updateUI();
			}
		} else if (dealer.getTotalValue() > player.getTotalValue()) {
			painelStatus.setText("Dealer Wins");
			dealerPanel.removeAll();
			int size = dealer.getHand().size();
			for (int i = 0; i < size; i++) {
				JLabel carta = new JLabel();
				dealerPanel.add(carta);
				ImageIcon img = readImage(dealer.getHand().get(i).getImgName().toString());
				carta.setIcon(img);
				dealerPanel.updateUI();
			}
		} else if (dealer.getTotalValue() == player.getTotalValue()) {
			painelStatus.setText("We have a Draw");
			dealerPanel.removeAll();
			int size = dealer.getHand().size();
			for (int i = 0; i < size; i++) {
				JLabel carta = new JLabel();
				dealerPanel.add(carta);
				ImageIcon img = readImage(dealer.getHand().get(i).getImgName().toString());
				carta.setIcon(img);
				dealerPanel.updateUI();
			}
		} else {
			painelStatus.setText("Player Wins");
			dealerPanel.removeAll();
			int size = dealer.getHand().size();
			for (int i = 0; i < size; i++) {
				JLabel carta = new JLabel();
				dealerPanel.add(carta);
				ImageIcon img = readImage(dealer.getHand().get(i).getImgName().toString());
				carta.setIcon(img);
				dealerPanel.updateUI();
			}
		}

		System.out.println(dealer.getTotalValue());
		System.out.println(player.getTotalValue());
		butaoPede.setEnabled(false);
		butaoFica.setEnabled(false);
		butaoJoga.setEnabled(true);
	}
}
