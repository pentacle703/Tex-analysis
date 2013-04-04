package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * this class is contain the each line of player hand
 * @author clement
 *
 */
public class PlayerManager extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GridBagLayout layout = new GridBagLayout();
	public PlayerManager() {
		super();
		this.setLayout(layout);
		GridBagConstraints g = new GridBagConstraints();
		JButton button = new JButton("test");
		GUIUtilities.setGridBagConstraint(g, 0, 0, 1, 1, 1, 1);
		layout.setConstraints(button, g);
		this.add(button,g);
		for(int i = 1; i < 11; i++)
		{
			PlayerHand pl = new PlayerHand("Player "+i);
			GUIUtilities.setGridBagConstraint(g, 0, i+1, 1, 1, 1, 1);
			this.add(pl, g);
		}
	}
	
	
}
