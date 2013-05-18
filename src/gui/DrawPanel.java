package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CardButton card1;
	private CardButton card2;
	private CardButton card3;
	private CardButton card4;
	private CardButton card5;
	
	public DrawPanel(){
		super();
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel drawLabel = new SmallTitleLabel("Draw");
		
		card1 = new CardButton();
		card1.setPreferredSize(new Dimension(45, 61));
		card1.setMinimumSize(card1.getPreferredSize());
		card2 = new CardButton();
		card2.setPreferredSize(new Dimension(45, 61));
		card2.setMinimumSize(card1.getPreferredSize());
		card3 = new CardButton();
		card3.setPreferredSize(new Dimension(45, 61));
		card3.setMinimumSize(card1.getPreferredSize());
		card4 = new CardButton();
		card4.setPreferredSize(new Dimension(45, 61));
		card4.setMinimumSize(card1.getPreferredSize());
		card5 = new CardButton();
		card5.setPreferredSize(new Dimension(45, 61));
		card5.setMinimumSize(card1.getPreferredSize());
		
		this.setOpaque(false);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 10, 0);
		this.add(drawLabel, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 1, 1, GridBagConstraints.REMAINDER, 0, 0);
		gbc.insets = new Insets(0, 0, 0, 10);
		this.add(card1, gbc);
		
		gbc.gridx = 1;
		this.add(card2, gbc);
		
		gbc.gridx = 2;
		this.add(card3, gbc);
		
		gbc.gridx = 3;
		this.add(card4, gbc);
		
		gbc.gridx = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(card5, gbc);
	}
	
	public DrawPanel(CardSelector selector){
		super();
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel drawLabel = new SmallTitleLabel("Draw");
		
		card1 = new CardButton();
		card1.setPreferredSize(new Dimension(45, 61));
		card1.setMinimumSize(card1.getPreferredSize());
		card1.addMouseListener(selector.getDisplayListener());
		card2 = new CardButton();
		card2.setPreferredSize(new Dimension(45, 61));
		card2.setMinimumSize(card1.getPreferredSize());
		card2.addMouseListener(selector.getDisplayListener());
		card3 = new CardButton();
		card3.setPreferredSize(new Dimension(45, 61));
		card3.setMinimumSize(card1.getPreferredSize());
		card3.addMouseListener(selector.getDisplayListener());
		card4 = new CardButton();
		card4.setPreferredSize(new Dimension(45, 61));
		card4.setMinimumSize(card1.getPreferredSize());
		card4.addMouseListener(selector.getDisplayListener());
		card5 = new CardButton();
		card5.setPreferredSize(new Dimension(45, 61));
		card5.setMinimumSize(card1.getPreferredSize());
		card5.addMouseListener(selector.getDisplayListener());
		
		this.setOpaque(false);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 10, 0);
		this.add(drawLabel, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 0, 1, 1, GridBagConstraints.REMAINDER, 0, 0);
		gbc.insets = new Insets(0, 0, 0, 10);
		this.add(card1, gbc);
		
		gbc.gridx = 1;
		this.add(card2, gbc);
		
		gbc.gridx = 2;
		this.add(card3, gbc);
		
		gbc.gridx = 3;
		this.add(card4, gbc);
		
		gbc.gridx = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(card5, gbc);
	}

	public String getFlop() {
		return card1.getCard()+" "+card2.getCard()+" "+ card3.getCard()+" "+card4.getCard()+" "+card5.getCard()+" ";
	}

	public void clearAll() {
		card1.setValue(-1);
		card1.setImgToVoid();
		card2.setValue(-1);
		card2.setImgToVoid();
		card3.setValue(-1);
		card3.setImgToVoid();
		card4.setValue(-1);
		card4.setImgToVoid();
		card5.setValue(-1);
		card5.setImgToVoid();
	}

}
