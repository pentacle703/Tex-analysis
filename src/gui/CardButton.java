package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class CardButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	
	public CardButton(){
		InputStream input = ClassLoader.getSystemResourceAsStream("nocard.png");
		try {
			img = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CardButton(int i){
		InputStream input = ClassLoader.getSystemResourceAsStream(Integer.toString(i) + ".png");
		try{
			img = ImageIO.read(input);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
