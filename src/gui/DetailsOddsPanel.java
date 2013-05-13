package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DetailsOddsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel hand_title;
	private JLabel odds_title;
	
	private JLabel royalstraightflush_label;
	private JLabel straightflush_label;
	private JLabel fourofakind_label;
	private JLabel fullhouse_label;
	private JLabel flush_label;
	private JLabel straight_label;
	private JLabel threeofakind_label;
	private JLabel twopairs_label;
	private JLabel singlepair_label;
	private JLabel kicker_label;
	
	private ImageDisplayer royalStraightFlush_img;
	private ImageDisplayer straightFlush_img;
	private ImageDisplayer fourOfAKind_img;
	private ImageDisplayer fullHouse_img;
	private ImageDisplayer flush_img;
	private ImageDisplayer straight_img;
	private ImageDisplayer threeOfAKind_img;
	private ImageDisplayer twoPairs_img;
	private ImageDisplayer singlePair_img;
	private ImageDisplayer kicker_img;
	
	private JTextField royalstraightflush_odds;
	private JTextField straightflush_odds;
	private JTextField fourofakind_odds;
	private JTextField fullhouse_odds;
	private JTextField flush_odds;
	private JTextField straight_odds;
	private JTextField threeofakind_odds;
	private JTextField twopairs_odds;
	private JTextField singlepair_odds;
	private JTextField kicker_odds;
	
	public DetailsOddsPanel(){
		super();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBackground(new Color(246, 246, 248));
		
		hand_title = new SmallTitleLabel("Hand");
		odds_title = new SmallTitleLabel("Odds");
		
		royalstraightflush_label = new JLabel("Royal Straight flush");
		straightflush_label = new JLabel("Straight flush");
		fourofakind_label = new JLabel("4 of a kind");
		fullhouse_label = new JLabel("Full House");
		flush_label = new JLabel("Flush");
		straight_label = new JLabel("Straight");
		threeofakind_label = new JLabel("3 of a kind");
		twopairs_label = new JLabel("2 pairs");
		singlepair_label = new JLabel("Single pair");
		kicker_label = new JLabel("Kicker");
		
		royalStraightFlush_img = new ImageDisplayer("royalstraightflush.png");
		royalStraightFlush_img.setPreferredSize(new Dimension(185, 50));
		royalStraightFlush_img.setMinimumSize(royalStraightFlush_img.getPreferredSize());
		straightFlush_img = new ImageDisplayer("straightflush.png");
		straightFlush_img.setPreferredSize(new Dimension(185, 50));
		straightFlush_img.setMinimumSize(straightFlush_img.getPreferredSize());
		fourOfAKind_img = new ImageDisplayer("fourofakind.png");
		fourOfAKind_img.setPreferredSize(new Dimension(185, 50));
		fourOfAKind_img.setMinimumSize(fourOfAKind_img.getPreferredSize());
		fullHouse_img = new ImageDisplayer("fullhouse.png");
		fullHouse_img.setPreferredSize(new Dimension(185, 50));
		fullHouse_img.setMinimumSize(fullHouse_img.getPreferredSize());
		flush_img = new ImageDisplayer("flush.png");
		flush_img.setPreferredSize(new Dimension(185, 50));
		flush_img.setMinimumSize(flush_img.getPreferredSize());
		straight_img = new ImageDisplayer("straight.png");
		straight_img.setPreferredSize(new Dimension(185, 50));
		straight_img.setMinimumSize(straight_img.getPreferredSize());
		threeOfAKind_img = new ImageDisplayer("threeofakind.png");
		threeOfAKind_img.setPreferredSize(new Dimension(185, 50));
		threeOfAKind_img.setMinimumSize(threeOfAKind_img.getPreferredSize());
		twoPairs_img = new ImageDisplayer("twopairs.png");
		twoPairs_img.setPreferredSize(new Dimension(185, 50));
		twoPairs_img.setMinimumSize(twoPairs_img.getPreferredSize());
		singlePair_img = new ImageDisplayer("singlepair.png");
		singlePair_img.setPreferredSize(new Dimension(185, 50));
		singlePair_img.setMinimumSize(singlePair_img.getPreferredSize());
		kicker_img = new ImageDisplayer("kicker.png");
		kicker_img.setPreferredSize(new Dimension(185, 50));
		kicker_img.setMinimumSize(kicker_img.getPreferredSize());
		
		royalstraightflush_odds = new JTextField();
		royalstraightflush_odds.setEditable(false);
		straightflush_odds = new JTextField();
		straightflush_odds.setEditable(false);
		fourofakind_odds = new JTextField();
		fourofakind_odds.setEditable(false);
		fullhouse_odds = new JTextField();
		fullhouse_odds.setEditable(false);
		flush_odds = new JTextField();
		flush_odds.setEditable(false);
		straight_odds = new JTextField();
		straight_odds.setEditable(false);
		threeofakind_odds = new JTextField();
		threeofakind_odds.setEditable(false);
		twopairs_odds = new JTextField();
		twopairs_odds.setEditable(false);
		singlepair_odds = new JTextField();
		singlepair_odds.setEditable(false);
		kicker_odds = new JTextField();
		kicker_odds.setEditable(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Title line
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, 2, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 30, 20);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(hand_title, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 0, GridBagConstraints.REMAINDER, 1, 0, 0);
		gbc.insets = new Insets(0, 50, 10, 20);
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(odds_title, gbc);
		
		//Royal Straight Flush line
		GUIUtilities.setGridBagConstraint(gbc, 0, 1, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(royalstraightflush_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(royalStraightFlush_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 1, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(royalstraightflush_odds, gbc);
		
		//Straight flush line
		GUIUtilities.setGridBagConstraint(gbc, 0, 2, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(straightflush_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(straightFlush_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 2, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(straightflush_odds, gbc);
		
		//Four of a kind line
		GUIUtilities.setGridBagConstraint(gbc, 0, 3, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(fourofakind_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(fourOfAKind_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 3, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(fourofakind_odds, gbc);
		
		//Full house line
		GUIUtilities.setGridBagConstraint(gbc, 0, 4, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(fullhouse_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(fullHouse_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 4, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(fullhouse_odds, gbc);
		
		//Flush line
		GUIUtilities.setGridBagConstraint(gbc, 0, 5, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(flush_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(flush_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 5, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(flush_odds, gbc);
		
		//Straight line
		GUIUtilities.setGridBagConstraint(gbc, 0, 6, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(straight_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(straight_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 6, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(straight_odds, gbc);
		
		//Three of a kind line
		GUIUtilities.setGridBagConstraint(gbc, 0, 7, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(threeofakind_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(threeOfAKind_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 7, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(threeofakind_odds, gbc);
		
		//Two pairs line
		GUIUtilities.setGridBagConstraint(gbc, 0, 8, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(twopairs_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(twoPairs_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 8, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(twopairs_odds, gbc);
		
		
		//Single pair line
		GUIUtilities.setGridBagConstraint(gbc, 0, 9, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(singlepair_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(singlePair_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 9, GridBagConstraints.REMAINDER, 1, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(singlepair_odds, gbc);
		
		//Kicker line
		GUIUtilities.setGridBagConstraint(gbc, 0, 10, 1, GridBagConstraints.REMAINDER, 0, 0);
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(kicker_label, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.insets = new Insets(0, 20, 10, 0);
		this.add(kicker_img, gbc);
		
		GUIUtilities.setGridBagConstraint(gbc, 2, 10, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER, 1, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(kicker_odds, gbc);
	}
}
