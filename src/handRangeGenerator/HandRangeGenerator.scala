package handRangeGenerator
import scala.swing.GridBagPanel
import scala.swing.GridPanel
import scala.swing.Button
import java.awt.Color
import java.awt.Font
import java.awt.Dimension
import scala.swing.BoxPanel
import scala.swing.Orientation
import scala.swing.Label
import java.awt.Insets
import javax.swing.BorderFactory
import scala.swing.CheckBox
import scala.swing.TextField
import scala.swing.Slider
import scala.swing.event.ButtonClicked
import scala.swing.event.ValueChanged
import scala.swing.event.EditDone
import scala.swing.Component
import scala.swing.FormattedTextField
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import scala.swing.event.KeyPressed
import scala.collection.mutable.Publisher
import scala.collection.mutable.Subscriber
import scala.swing._

class HandRangeGenerator extends GridBagPanel{ game: Game =>	  	
	
	def format(f: Float) = "%7s".format("%5.2f".formatLocal(Locale.US, f))
		
	def getCurrentHandList = Model.currentHandList

	def Maincourante = 	Model.currentHandList.toString
	def resetCourant = {Model.currentHandList = List[String]()
						Model.update}
//   	def clean =
//   	{
//		handRange.text = ""
//		Model.update(handRangeToHandList(handRange.text))
//   	}
	
	
	object Model extends Publisher[(List[String], String)] {	
	  var currentHandList = List[String]()
	  
	  def update = {	  
	    val currentHandRange = game.compact(currentHandList mkString ",")
	    publish((currentHandList, currentHandRange))	    
	  }
	  
	  def update(handList: List[String]): Unit = {	  	 		  
	    def hasChanged(handList: List[String]) = !(currentHandList.sorted sameElements handList.sorted)	  
	    if (hasChanged(handList)) {
	      currentHandList = handList
	      update
	    }	 
	  }
	}
	
	//The different views of Model
  	val handGrid = new GridPanel(game.height, game.width) with Model.Sub {
  	  	 val colors = Array(new Color(201, 201, 201), new Color(255, 36, 0), new Color(255, 127, 0), new Color(255, 215, 0))
  	  	 class HandButton(s: String, i: Int, j: Int) extends Button(s) {
  	  	   private var in = false
  	  	   def inRange = in
  	  	   def inRange_=(b: Boolean) = { select(b); in = b }  
  	  	   def select(b: Boolean) =
  	  	     if (b) { background = if (i == j) colors(2) else { if (i < j) colors(1) else colors(3) } }			
		     else background = colors(0)
  	  	 }
		 var handsButton = Map[String, HandButton]()
		 for (i <- 0 until game.height; j <- 0 until game.width) {
			 val handButton = new HandButton(game.description(i, j), i, j) {
				 margin = new Insets(0, 0, 0, 0)
				 background = colors(0)
			 }
			 handsButton += game.description(i, j) -> handButton
			 contents += handButton		   
		 }
		 preferredSize = new Dimension(550, 450)
		 Model.subscribe(this)
		 def notify(pub: Model.Pub, evt: (List[String], String)) = {
		   for (handButton <- handsButton.values) handButton.inRange = false
		   evt._1 foreach (handsButton(_).inRange = true)
		 }
	 }
  	
	 val predefinedHandRange = new BoxPanel(Orientation.Vertical) with Model.Sub {		
	   class PredefinedRangeButton(s: String, r: String) extends CheckBox(s) {
	     val handList = game.handRangeToHandList(r)
	     def range = r
  	   }
	   val predefinedRangesButton = new Array[PredefinedRangeButton](game.nbPredefinedHandRanges)
	   for (i <- 0 until game.nbPredefinedHandRanges) {
	     predefinedRangesButton(i) = new PredefinedRangeButton(game.predefinedHandRangesDescription(i), game.predefinedHandRanges(i))
	     contents += predefinedRangesButton(i)
	   }
	   border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Predefined hand range")
	   Model.subscribe(this)
	   def notify(pub: Model.Pub, evt: (List[String], String)) = {
	     def intersectionLength(handList1: List[String], handList2: List[String]) = {
	       (handList1 intersect handList2) length
	     }
	     for (button <- predefinedRangesButton) {
	       if (intersectionLength(evt._1, button.handList) == button.handList.length) button.selected = true
	       else if (intersectionLength(evt._1, button.handList) == 0) button.selected = false
	     }
	   }
	 }
	 
	 val handRange = new TextField with Model.Sub {
	   Model.subscribe(this)
	   def notify(pub: Model.Pub, evt: (List[String], String)) = {
	     text = evt._2
	   }
	 }
	 
	 val percentageSlider = new Slider with Model.Sub {
	   min = 0
	   max = 1000
	   value = 0
	   Model.subscribe(this)
	   def notify(pub: Model.Pub, evt: (List[String], String)) = {	      
	     value = (game.percentage(evt._2) * 1000).toInt
	   }
	 }
	 
	 val percentageValue = new TextField(4) with Model.Sub {
	   text = format(0)
	   Model.subscribe(this)
	   def notify(pub: Model.Pub, evt: (List[String], String)) = {
	     text = format(game.percentage(evt._2) * 100)
	   }
	 }
	 
	  
	
	 
	 //Controllers		 
	 listenTo(handRange, percentageSlider, percentageValue)
	 for (button <- handGrid.handsButton.values) listenTo(button)
	 for (button <- predefinedHandRange.predefinedRangesButton) listenTo(button)
	 reactions += {		   
	 	case EditDone(`handRange`) =>	       	 	  
	 	  val handList = game.handRangeToHandList(handRange.text)	         
	 	  Model.update(handList)
	 	  handRange.text = game.compact(Model.currentHandList mkString ",")
	 	   	 	 	  	  
	 }
	 
	 reactions += {		 	
	 	case ValueChanged(`percentageSlider`) => 		 			 	
	 	  val handList = game.percentage(Model.currentHandList mkString ",", percentageSlider.value / 1000f) map (coordinate => game.description(coordinate._1, coordinate._2))
	 	  Model.update(handList)
	 }
	 
	 reactions += {	   
	 	case EditDone(`percentageValue`) =>		 	  		 		 	
	 	  val handList = game.percentage(Model.currentHandList mkString ",", percentageValue.text.toFloat / 100) map (coordinate => game.description(coordinate._1, coordinate._2))
	 	  Model.update(handList)
	 }
	 
	 
	 reactions += {
	 	case ButtonClicked(button: handGrid.HandButton) =>	 	
	 	  val handButton = button.asInstanceOf[handGrid.HandButton]
	 	  if (handButton.inRange) Model.currentHandList = Model.currentHandList filter (_ != handButton.text)
	 	  else Model.currentHandList = handButton.text :: Model.currentHandList
	 	  handButton.inRange = !handButton.inRange
	 	  Model.update 	 	 
	 }
	 
	 reactions += {
	 	case ButtonClicked(button: predefinedHandRange.PredefinedRangeButton) =>	     		
	 	  val predefinedRangeButton = button.asInstanceOf[predefinedHandRange.PredefinedRangeButton]
	 	  var handList = Model.currentHandList
	 	  if (button.selected) handList = handList ++ (game.handRangeToHandList(button.range))
	 	  else handList = handList -- (game.handRangeToHandList(button.range))
	 	  Model.update(handList)	 	 	 	  
	 }
	List
	 
	 //Views layout
	 val percentageBox =new BoxPanel(Orientation.Horizontal) {
		 contents += percentageValue
		 contents += new Label("% ")
		 contents += percentageSlider
	 }
	 
	 layout(handGrid) = new Constraints {
	   fill = GridBagPanel.Fill.Horizontal
	   gridx = 0
	   gridy = 0
	   insets = new Insets(10, 10, 0, 0)
	 }
	 layout(predefinedHandRange) = new Constraints {
	   fill = GridBagPanel.Fill.Horizontal
	   gridx = 1
	   gridy = 0
	   insets = new Insets(0, 10, 0, 10)
	 }
	 layout(handRange) = new Constraints {
	   fill = GridBagPanel.Fill.Horizontal
	   gridx = 0
	   gridy = 1
	   insets = new Insets(0, 10, 10, 0)
	 }
	 layout(percentageBox) = new Constraints {
	   fill = GridBagPanel.Fill.Horizontal
	   gridx = 1
	   gridy = 1
	   insets = new Insets(0, 10, 10, 10)
	 }
}