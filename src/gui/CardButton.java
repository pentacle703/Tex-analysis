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
	private int value;
	private static Image voidCard;
	{
		InputStream input = ClassLoader.getSystemResourceAsStream("nocard.png");
		try {
			voidCard = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public CardButton(){
		value = -1;
		img = voidCard;
	}

	public CardButton(int i){
		value = i;
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

	public void setImgToVoid() {
		img = voidCard;
		updateUI();
	}
}
