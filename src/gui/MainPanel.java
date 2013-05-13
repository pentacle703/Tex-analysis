package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * this classes is used to display all the main elements of the gui
 * @author clement & camille
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	TopPanel top;
	PlayerManager hands;
	BottomPanel bottom;
	BorderLayout layout;
	
	public MainPanel(){
		top = new TopPanel();
		hands = new PlayerManager();
		bottom = new BottomPanel();
		layout = new BorderLayout();
		
		this.setLayout(layout);
		this.setBackground(new Color(246, 246, 248));

		this.add(top, BorderLayout.NORTH);
		this.add(hands, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

	}
}
