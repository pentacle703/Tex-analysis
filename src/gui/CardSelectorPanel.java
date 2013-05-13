package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CardSelectorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardSelectorPanel(){
		super();
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(246, 246, 248));
		
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(okButton);
		p.add(cancelButton);
		
		this.add(new CardsGrid(), BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
	}
}
