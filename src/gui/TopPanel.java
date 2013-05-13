package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class TopPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TopPanel(){
		super();
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Tex' Analysis");
		Font titleFont = new Font("Helvetica", Font.BOLD, 26);
		title.setFont(titleFont);
		title.setForeground(new Color(250, 250, 248));
		
		ImageDisplayer background = new ImageDisplayer("top_background.png");
		
		background.setLayout(new BorderLayout());
		background.add(title, BorderLayout.CENTER);
		background.add(new JSeparator(), BorderLayout.SOUTH);
		
		this.add(background, BorderLayout.CENTER);
	}

}
