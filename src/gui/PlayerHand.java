package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerHand extends JPanel{

	/**
	 * this class is used to represent a player's hand
	 */
	protected String name;
	private static final long serialVersionUID = 1L;
	public PlayerHand(String name)
	{
		this.name = name;
		this.setLayout(new GridLayout(1,4));
		this.add(new JLabel(name));
		this.add(new JTextField());
		this.add(new JLabel("Résultat : "));
		JTextField result = new JTextField();
		result.setEditable(false);
		this.add(result);
	}

}
