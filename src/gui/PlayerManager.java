package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * this class is contain the each line of player hand
 * @author clement & camille
 *
 */
public class PlayerManager extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagLayout layout = new GridBagLayout();
	
	private JLabel rangeLabel;
	private JLabel winningLabel;
	private JLabel oddsLabel;
	private JLabel players[];
	private JTextField ranges[];
	private JButton selectRange[];
	private JTextField result[];
	private JButton details[];
	
	private JLabel myOddsLabel;
	private JTextField myOdds;
	
	private GridBagConstraints gbc;
	
	public PlayerManager() {
		super();
		this.setLayout(layout);
		this.setOpaque(false);
	
		players = new JLabel[9];
		ranges = new JTextField[9];
		selectRange = new JButton[9];
		result = new JTextField[9];
		details = new JButton[9];
		
		gbc = new GridBagConstraints();
		
		//Setting the title line
		setTitleLine();
		
		//Setting the player's odds
		setMyOdds();
		
		for(int i = 0; i < 9; i++)
		{
			setLine(i);
		}
	}
	
	public void setTitleLine(){
		rangeLabel = new SmallTitleLabel("Range");
		winningLabel = new SmallTitleLabel("Winning");
		oddsLabel = new SmallTitleLabel("Odds");
		
		//Adding the "Range" label
		GUIUtilities.setGridBagConstraint(gbc, 1, 1, 1, 1, 1, 0);
		this.add(rangeLabel, gbc);
		
		//Adding the "Winning" label
		GUIUtilities.setGridBagConstraint(gbc, 3, 1, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 0, 20);
		this.add(winningLabel, gbc);
		
		//Adding the "odds" label underneath the "Winning" label
		GUIUtilities.setGridBagConstraint(gbc, 3, 2, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 10, 20);
		this.add(oddsLabel, gbc);
	}
	
	public void setMyOdds(){
		myOddsLabel = new JLabel("MY ODDS");
		myOdds = new JTextField();
		myOdds.setPreferredSize(new Dimension(75, 22));
		myOdds.setMinimumSize(myOdds.getPreferredSize());
		myOdds.setEditable(false);
		myOdds.setBorder(BorderFactory.createLineBorder(new Color(22, 92, 109)));
		
		//Setting the "My Odds" label
		GUIUtilities.setGridBagConstraint(gbc, 0, 0, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 50, 20, 20);
		this.add(myOddsLabel, gbc);
						
		//Setting the text field
		GUIUtilities.setGridBagConstraint(gbc, 3, 0, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 20, 20);
		this.add(myOdds, gbc);
	}
	
	public void setLine(int n){
		players[n] = new JLabel("Opponent " + (n+1));
		ranges[n] = new JTextField();
		ranges[n].setPreferredSize(new Dimension(200, 22));
		ranges[n].setMinimumSize(ranges[n].getPreferredSize());
		selectRange[n] = new JButton("Select range");
		result[n] = new JTextField();
		result[n].setEditable(false);
		result[n].setPreferredSize(new Dimension(75, 22));
		result[n].setMinimumSize(result[n].getPreferredSize());
		details[n] = new JButton("See details");
		
		//JLabel player
		GUIUtilities.setGridBagConstraint(gbc, 0, n+3, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 50, 10, 20);
		this.add(players[n], gbc);
		
		//JTextField range
		GUIUtilities.setGridBagConstraint(gbc, 1, n+3, 1, 1, 1, 0);
		gbc.insets = new Insets(0, 0, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(ranges[n], gbc);
		
		//JButton selectRange
		GUIUtilities.setGridBagConstraint(gbc, 2, n+3, 1, 1, 0, 0);
		gbc.insets = new Insets(0, 0, 10, 20);
		this.add(selectRange[n], gbc);
		
		//JTextField result
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		this.add(result[n], gbc);
		
		//JButton details
		gbc.gridx = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 10, 50);
		this.add(details[n], gbc);
	}
}
