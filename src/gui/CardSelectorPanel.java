package gui;

//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
import javax.swing.JPanel;
//
public class CardSelectorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	/**
	//	 * 
	//	 */
	//	private static final long serialVersionUID = 1L;
	//	
	//	private ArrayList<Integer> chosenCards = new ArrayList<Integer>();
	//	private DisplayOnClick displayOnClick = new DisplayOnClick();
	//	private CardButton actualButton;
	//
	//	public DisplayOnClick getDisplayOnClick() {
	//		return displayOnClick;
	//	}
	//
	//	public CardSelectorPanel(){
	//		super();
	//		this.setLayout(new BorderLayout());
	//		this.setBackground(new Color(246, 246, 248));
	//		
	////		JButton okButton = new JButton("OK");
	////		JButton cancelButton = new JButton("Cancel");
	//		JPanel p = new JPanel();
	//		p.setOpaque(false);
	////		p.add(okButton);
	////		p.add(cancelButton);
	////		
	////		this.add(new CardsGrid(), BorderLayout.CENTER);
	//		this.add(p, BorderLayout.SOUTH);
	//	}
	//	
	//	/**
	//	 * use for CardButton object only
	//	 * @author clement
	//	 *
	//	 */
	//	private class DisplayOnClick implements MouseListener
	//	{
	//
	//		@Override
	//		public void mouseClicked(MouseEvent e) {
	//			if(! (e.getComponent() instanceof CardButton))
	//			{
	//				throw new IllegalArgumentException("DisplayOnClick has been used on a non CardButton object");
	//			}
	//			else
	//			{
	//				actualButton = (CardButton) e.getComponent();
	//				setVisible(true);
	//			}
	//		}
	//
	//		@Override
	//		public void mouseEntered(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseExited(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mousePressed(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseReleased(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//	}
	//	
	//	private class onCardButtonClick implements MouseListener
	//	
	//	{
	//
	//		@Override
	//		public void mouseClicked(MouseEvent e) {
	//			if(! (e.getComponent() instanceof CardButton))
	//			{
	//				throw new IllegalArgumentException("DisplayOnClick has been used on a non CardButton object");
	//			}
	//			else
	//			{
	//				CardButton clickedButton = (CardButton) e.getComponent();
	//				if(actualButton.getValue() == -1);
	//				{
	//					actualButton.setValue(clickedButton.getValue());
	//					actualButton.setImg(clickedButton.getImg());
	//				}
	//			}
	//		}
	//
	//		@Override
	//		public void mouseEntered(MouseEvent arg0) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseExited(MouseEvent arg0) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mousePressed(MouseEvent arg0) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseReleased(MouseEvent arg0) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//		
	//	}
}
