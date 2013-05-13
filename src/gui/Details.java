package gui;

import javax.swing.JFrame;

public class Details extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Details(){
		super();
		this.setSize(480, 710);
		this.setResizable(false);
		this.setContentPane(new DetailsMainPanel());
		this.setVisible(true);
	}
}
