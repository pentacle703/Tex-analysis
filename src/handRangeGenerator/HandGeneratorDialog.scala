package handRangeGenerator;

import scala.swing.Dialog
import scala.swing.event.WindowClosed
import scala.swing.Button
import scala.swing.Panel
import scala.swing.BoxPanel
import scala.swing.Orientation
import javax.swing.JTextField
import scala.swing.event.ButtonClicked
import handRangeGenerator.Game

class HandGeneratorDialog extends Dialog {
  var fieldToModify : JTextField = null
  var handGenerator = new HandRangeGenerator with Holdem
  var buttonAccept = new Button("Valider");
  contents = new BoxPanel(Orientation.Vertical)
  {
	  contents += handGenerator
	  contents += buttonAccept
  }
 
  def focusOnDialog() =
  {
   visible = true
   handGenerator.handRange.requestFocusInWindow()
  }

  def setFieldToModify(field : JTextField) =
  {
    fieldToModify = field
    handGenerator.handRange.text = fieldToModify.getText();
  }
  
  def update = 
  {
	   val handList = handGenerator.handRangeToHandList(handGenerator.handRange.text)	         
	 	  handGenerator.Model.update(handList)
	 	  handGenerator.handRange.text = handGenerator.compact(handGenerator.Model.currentHandList mkString ",")
  }
  
  listenTo(buttonAccept)
	  reactions += {
	    case ButtonClicked(_) =>
	      visible = false
	      fieldToModify.setText(handGenerator.handRange.text)
	      fieldToModify.requestFocusInWindow()
	  }
  
}