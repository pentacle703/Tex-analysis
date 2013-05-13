package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageDisplayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image img;
	
	public ImageDisplayer(String str){
		super();
		InputStream input = ClassLoader.getSystemResourceAsStream(str);
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
