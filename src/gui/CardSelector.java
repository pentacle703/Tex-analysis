package gui;

import javax.swing.JFrame;

public class CardSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardSelector(){
		super();
		this.setTitle("Card Selector");
		this.setSize(700, 350);
		this.setResizable(false);
		this.setContentPane(new CardSelectorPanel());
		this.setVisible(true);
	}
}
