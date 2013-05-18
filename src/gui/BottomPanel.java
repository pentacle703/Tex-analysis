package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JSeparator;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	KnowCardsPanel knownCards;

	public BottomPanel(MouseListener onCalculateClick,
			MouseListener onClearAllClick) {
		super();
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		
		knownCards = new KnowCardsPanel(onCalculateClick, onClearAllClick);
		
		ImageDisplayer background = new ImageDisplayer("background3.png");
		
		background.setLayout(new BorderLayout());
		background.add(new JSeparator(), BorderLayout.NORTH);
		background.add(knownCards, BorderLayout.CENTER);
		this.add(background, BorderLayout.CENTER);
	}

	public String getPlayerCard() {
		return knownCards.getPlayerCard();
	}

	public String getFlop() {
		return knownCards.getFlop();
	}

	public void clearAll() {
		knownCards.clearAll();
	}

}
