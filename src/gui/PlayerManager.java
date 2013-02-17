package gui;

import java.awt.GridLayout;
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

	public PlayerManager() {
		super();
		setLayout(new GridLayout(10, 1));
		for(int i = 1; i < 11; i++)
		{
			this.add(new PlayerHand("player "+i));
		}
	}
	
	
}
