package gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	/**
	 * this class contain the main window of the program
	 */
	private static final long serialVersionUID = 1L;
	public MainWindow()
	{
		this.setTitle("Tex'Analysis 5");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 645);
		this.setResizable(false);
		this.setContentPane(new MainPanel());
		this.setVisible(true);
	}

}
