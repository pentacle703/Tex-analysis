package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Pourcentage.PourcentageGain;

/**
 * this classes is used to display all the main elements of the gui
 * @author clement & camille
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	TopPanel top;
	PlayerManager hands;
	BottomPanel bottom;
	BorderLayout layout;
	JButton calculateButton;
	
	public MainPanel(){
		top = new TopPanel();
		hands = new PlayerManager();
		bottom = new BottomPanel(new OnCalculateClick(),new OnClearAllClick());
		layout = new BorderLayout();
		calculateButton = new JButton();
		calculateButton.addMouseListener(new OnCalculateClick());

		this.setLayout(layout);
		this.setBackground(new Color(246, 246, 248));

		this.add(top, BorderLayout.NORTH);
		this.add(hands, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

	}

	private class OnCalculateClick implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String playerRange =bottom.getPlayerCard();
			if(playerRange.length()!=4)// if the player has not given his hand
			{
				JOptionPane.showMessageDialog(null, "You have to give your hand","Missing information",JOptionPane.ERROR_MESSAGE);
				return;
			}

			ArrayList<String> opponentRanges = hands.getRanges();
			String ranges[] = new String[opponentRanges.size()+1];
			ranges[0] = playerRange;
			int i= 1;
			for(String range : opponentRanges)
			{
				ranges[i] = range;
				i++;
			}
			hands.setPercentWinning(PourcentageGain.PercentWin(ranges, "", bottom.getFlop(), opponentRanges.size()+1));
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
	
	private class OnClearAllClick implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			hands.clearAll();
			bottom.clearAll();
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
