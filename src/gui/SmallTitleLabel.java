package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class SmallTitleLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SmallTitleLabel(String str){
		super(str);
		Font titleFont = new Font("Helvetica", Font.BOLD, 14);
		this.setFont(titleFont);
		this.setForeground(new Color(13, 81, 121));
	}

}
