package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HoleCardsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardButton card1;
	private CardButton card2;
	
	public HoleCardsPanel(){
		super();
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel myHoleCardsLabel = new SmallTitleLabel("My hole cards");
		card1 = new CardButton();
		card1.setPreferredSize(new Dimension(45, 61));
		card1.setMinimumSize(card1.getPreferredSize());
		card2 = new CardButton();
		card2.setPreferredSize(new Dimension(45, 61));
		card2.setMinimumSize(card1.getPreferredSize());
		
		this.setOpaque(false);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 10, 0);
		this.add(myHoleCardsLabel, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 1, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 0, 10);
		this.add(card1, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 1, 1, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(card2, gbc);
	}
}
