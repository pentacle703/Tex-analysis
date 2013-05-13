package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class DetailsMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DetailsTitlePanel title = new DetailsTitlePanel();
	private DetailsOddsPanel oddsDetail = new DetailsOddsPanel();
	
	public DetailsMainPanel(){
		super();
		this.setLayout(new BorderLayout());
		
		this.add(title, BorderLayout.NORTH);
		this.add(oddsDetail, BorderLayout.CENTER);
	}
}
