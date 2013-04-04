package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * this classes is used to display all the main elements of the gui
 * @author clement
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	PlayerManager hands;	
	GridBagLayout layout;
	
	public MainPanel(){
		hands = new PlayerManager();
		layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints g = new GridBagConstraints();
		
		GUIUtilities.setGridBagConstraint(g, 0, 0, 1, 1, 0, 0);
		layout.setConstraints(hands, g);
		this.add(hands);
		
		
	}
}
