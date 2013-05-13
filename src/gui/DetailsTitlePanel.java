package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class DetailsTitlePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel playerId = new JLabel("Player 1");
	
	public DetailsTitlePanel(){
		super();
		this.setLayout(new BorderLayout());
		
		Font titleFont = new Font("Helvetica", Font.BOLD, 20);
		playerId.setFont(titleFont);
		JSeparator separator = new JSeparator();
		
		this.add(playerId, BorderLayout.CENTER);
		this.add(separator, BorderLayout.SOUTH);
	}
}
