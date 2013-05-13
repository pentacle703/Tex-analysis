package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSeparator;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BottomPanel(){
		super();
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		
		KnowCardsPanel knownCards = new KnowCardsPanel();
		
		ImageDisplayer background = new ImageDisplayer("background3.png");
		
		background.setLayout(new BorderLayout());
		background.add(new JSeparator(), BorderLayout.NORTH);
		background.add(knownCards, BorderLayout.CENTER);
		
		this.add(background, BorderLayout.CENTER);
	}

}
