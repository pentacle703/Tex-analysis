package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardSelector extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> chosenCards = new ArrayList<Integer>();
	public CardButton actualButton;
	private DisplayOnClick displayListener = new DisplayOnClick();

	public CardSelector(){
		super();
		this.setTitle("Card Selector");
		this.setSize(700, 350);
		this.setResizable(false);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(246, 246, 248));

		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new QuitOnClick());
		//JButton cancelButton = new JButton("Cancel");
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(okButton);
		//p.add(cancelButton);

		this.add(new CardsGrid(new OnCardButtonClick()), BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
	}

	public CardSelector(JFrame owner){
		super(owner);
		this.setTitle("Card Selector");
		this.setSize(700, 350);
		this.setResizable(false);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.setContentPane(new CardSelectorPanel());
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(246, 246, 248));

		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new QuitOnClick());
		//JButton cancelButton = new JButton("Cancel");
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(okButton);
		//p.add(cancelButton);

		this.add(new CardsGrid(new OnCardButtonClick()), BorderLayout.CENTER);
		this.add(p, BorderLayout.SOUTH);
	}

	public DisplayOnClick getDisplayListener() {
		return displayListener;
	}



	private class QuitOnClick implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			setVisible(false);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	/**
	 * use for CardButton object only
	 * @author clement
	 *
	 */
	private class DisplayOnClick implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(! (e.getComponent() instanceof CardButton))
			{
				throw new IllegalArgumentException("DisplayOnClick has been used on a non CardButton object");
			}
			else
			{
				actualButton = (CardButton) e.getComponent();
				setVisible(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	private class OnCardButtonClick implements MouseListener

	{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(! (e.getComponent() instanceof CardButton))
			{
				throw new IllegalArgumentException("DisplayOnClick has been used on a non CardButton object");
			}
			else
			{
				CardButton clickedButton = (CardButton) e.getComponent();
				if(!chosenCards.contains(clickedButton.getValue()))
				{
					if(actualButton.getValue() != -1)
					{
						chosenCards.remove((Integer)actualButton.getValue());
					}
					actualButton.setValue(clickedButton.getValue());
					actualButton.setImg(clickedButton.getImg());
					chosenCards.add(actualButton.getValue());
					setVisible(false);
				}
				else
				{
					if(actualButton.getValue() == clickedButton.getValue())
					{
						chosenCards.remove((Integer)actualButton.getValue());
						actualButton.setValue(-1);
						actualButton.setImgToVoid();
					}
					else
					{
						//do nothing or tell to the user that this card is already useds
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
