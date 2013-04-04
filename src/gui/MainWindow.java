package gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	/**
	 * this class contain the main window of the program
	 */
	private static final long serialVersionUID = 1L;
	public MainWindow()
	{
		this.setTitle("Tex'Analysis");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.add(new PlayerManager());
		this.setVisible(true);
	}

}
