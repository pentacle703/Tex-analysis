package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KnowCardsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardSelector selector;

	public KnowCardsPanel(){
		super();
		this.setLayout(new GridBagLayout());

		selector = new CardSelector();

		HoleCardsPanel holeCards = new HoleCardsPanel(selector);
		DrawPanel draw = new DrawPanel(selector);
		JButton clearAll = new JButton("Clear All");
		JButton goButton = new JButton("Go");
		this.setOpaque(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Adding the hole cards panel
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, 1, 1, 0.35, 0);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 20);
		this.add(holeCards, gbc);
		
		//Adding the draw
		GUIUtilities.setGridBagConstraint(gbc, 1, 0, GridBagConstraints.REMAINDER, 1, 0.65, 0);
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(draw, gbc);
		
		//Adding the "Clear All" button
		GUIUtilities.setGridBagConstraint(gbc, 0, 1, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 0, 10, 0);
		this.add(clearAll, gbc);
		
		//Adding the "Go" button
		GUIUtilities.setGridBagConstraint(gbc, 0, 2, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.ipadx = 100;
		this.add(goButton, gbc);
	}
}
