package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CardsGrid extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CardsGrid(MouseListener listener){
		super();
		GridLayout layout = new GridLayout(4, 13);
		this.setLayout(layout);
		this.setOpaque(false);
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14; j++){
				CardButton c = new CardButton(13*i+j);
				JPanel p = new JPanel();
				p.setOpaque(false);
				p.add(c);
				c.addMouseListener(listener);
				c.setPreferredSize(new Dimension(45, 61));
				this.add(p);
			}
		}
	}
}
