package handRangeGenerator

trait Holdem extends Game {		
	def width = Holdem.width
	def height = Holdem.height
	import Holdem._
	
	def description(i: Int, j: Int) = hands(i)(j)
	
	def parse(range: String) = {
		import HoldemHandRangeParsers._ 
		val rangeList = 
			parseAll(handRange, range) match {
	    		case Success(res, _) => res
	    		case f               => List[HandRange]()
		}
		val myOrdering = Ordering.fromLessThan[(Int, Int)]((c1, c2) =>  c1._1 * width + c1._2 < c2._1 * width + c2._2)
		var set = scala.collection.immutable.TreeSet.empty(myOrdering)
		for (r <- rangeList) set ++= r.allHands map handsToIndex
		set toList
	}
	
	def percentage(p: Float) = {
		var res = List[String]()
		import util.control.Breaks._
		var index = 0
 	    breakable {
			for (h <- sortedHands) {
				if (sortedHandsPercentages(index) > p) {
					if (index == 0 || sortedHandsPercentages(index) - p <= p - sortedHandsPercentages(index - 1)) res = res :+ h
					break
				} else res = res :+ h
				index += 1
			}
	    }
		parse(res mkString ", ")
	}
	
	def percentage(range: String) = {
	  ((0.0f /: parse(range)) ((sum, coordinate) => sum + nbHands(hands(coordinate._1)(coordinate._2)))) / numberOfHands   
	}
	
	def percentage(range: String, p: Float) = {
	  var rangeList = parse(range)
	  var bestHands = sortedHands map (handsToIndex(_))
	  var currentPercentage = percentage(range)
	  if (currentPercentage == p) rangeList
	  else if (currentPercentage < p) {
	      var lastPercentage = currentPercentage
		  while (!bestHands.isEmpty && currentPercentage < p) {
			  lastPercentage = currentPercentage
		      val coordinate = bestHands.head
			  bestHands = bestHands.tail
			  if (rangeList.find(_ == coordinate) == None) {			   			  
			    currentPercentage += nbHands(hands(coordinate._1)(coordinate._2)) / numberOfHands.toFloat
			    rangeList = coordinate +: rangeList
			  }			  
		  }
	      if (p - lastPercentage < currentPercentage - p) rangeList.tail
	      else rangeList
	  } else {
	      var lastPercentage = currentPercentage
	      var lastRangeList = rangeList
	      bestHands = bestHands.reverse
		  while (!bestHands.isEmpty && currentPercentage > p) {
			  lastPercentage = currentPercentage
			  lastRangeList = rangeList		      
			  val coordinate = bestHands.head
			  bestHands = bestHands.tail
			  if (rangeList.find (_ == coordinate) != None) {			   
			    currentPercentage -= nbHands(hands(coordinate._1)(coordinate._2)) / numberOfHands.toFloat
			    rangeList = rangeList filter (_ != coordinate)
			  }
		  }
		  if (lastPercentage - p < p - currentPercentage) lastRangeList 
	      else rangeList
	  }
	}
	
	def compact(range: String) = {
	  val coordinates = parse(range)
	  val (pairs, nonPairs) = coordinates partition (coordinate => coordinate._1 == coordinate._2)
	  def group(xs: List[(Int, Int)], p: ((Int, Int), (Int, Int)) => Boolean): List[List[(Int, Int)]] = {
	    var last: Option[(Int, Int)] = None
	    var res = List[List[(Int, Int)]]()
	    var partial = List[(Int, Int)]()
	    for (elt <- xs) {
	      last match {
	        case None => ()
	        case Some(elt1) => 
	          if (!p(elt1, elt)) {
	        	  res = res :+ partial
	        	  partial = List()
	          }
	      }
	      last = Some(elt)
	      partial = partial :+ elt
	    }
	    res :+ partial
	  }
	  def createRange(l: List[(Int, Int)]) = {
	      if (l isEmpty) ""
	      else if (l.length == 1) hands(l.head._1)(l.head._2)
	      	   else hands(l.head._1)(l.head._2) + "-" + hands(l.last._1)(l.last._2)  
	  }
	  def groupPairs(xs: List[(Int, Int)]) = {
		group(xs, (c1, c2) => c1._2 + 1 == c2._2) map createRange mkString ", "  
	  }
	  def groupNonPairs(xs: List[(Int, Int)]) = {	    
	    val (suited, offsuit) = xs partition (coordinate => coordinate._1 < coordinate._2)
	    val suitedGroup = group(suited, (c1, c2) => c1._1 == c2._1 && c1._2 + 1 == c2._2)
	    val offSuitGroup = group(offsuit sort ((c1, c2) => c1._2 * width + c1._1 <= c2._2 * width + c2._1), (c1, c2) => c1._1 + 1 == c2._1 && c1._2 == c2._2)
	    (suitedGroup map createRange mkString ", ") + (if (suited.isEmpty || offsuit.isEmpty) "" else ", ") + (offSuitGroup map createRange mkString ", ") 
	  }
	  groupPairs(pairs) + (if (pairs.isEmpty || nonPairs.isEmpty) "" else ", ") + groupNonPairs(nonPairs)
	}
	
	def nbPredefinedHandRanges = Holdem.nbPredefinedHandRanges
	
	def predefinedHandRangesDescription(i: Int) = predefinedDescriptions(i)
	
	def predefinedHandRanges(i: Int) = predefined(i)
}

object Holdem {
	val width = 13
	val height = 13
	val numberOfHands = 1326
	val cards = Array('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
	val hands = Array(
			Array("AA",  "AKs", "AQs", "AJs", "ATs", "A9s", "A8s", "A7s", "A6s", "A5s", "A4s", "A3s", "A2s"),
			Array("AKo", "KK",  "KQs", "KJs", "KTs", "K9s", "K8s", "K7s", "K6s", "K5s", "K4s", "K3s", "K2s"),
			Array("AQo", "KQo", "QQ",  "QJs", "QTs", "Q9s", "Q8s", "Q7s", "Q6s", "Q5s", "Q4s", "Q3s", "Q2s"),
			Array("AJo", "KJo", "QJo", "JJ",  "JTs", "J9s", "J8s", "J7s", "J6s", "J5s", "J4s", "J3s", "J2s"),
			Array("ATo", "KTo", "QTo", "JTo", "TT",  "T9s", "T8s", "T7s", "T6s", "T5s", "T4s", "T3s", "T2s"),
			Array("A9o", "K9o", "Q9o", "J9o", "T9o", "99",  "98s", "97s", "96s", "95s", "94s", "93s", "92s"),
			Array("A8o", "K8o", "Q8o", "J8o", "T8o", "98o", "88",  "87s", "86s", "85s", "84s", "83s", "82s"),
			Array("A7o", "K7o", "Q7o", "J7o", "T7o", "97o", "87o", "77",  "76s", "75s", "74s", "73s", "72s"),
			Array("A6o", "K6o", "Q6o", "J6o", "T6o", "96o", "86o", "76o", "66",  "65s", "64s", "63s", "62s"),
			Array("A5o", "K5o", "Q5o", "J5o", "T5o", "95o", "85o", "75o", "65o", "55",  "54s", "53s", "52s"),
			Array("A4o", "K4o", "Q4o", "J4o", "T4o", "94o", "84o", "74o", "64o", "54o", "44",  "43s", "42s"),
			Array("A3o", "K3o", "Q3o", "J3o", "T3o", "93o", "83o", "73o", "63o", "53o", "43o", "33",  "32s"),
			Array("A2o", "K2o", "Q2o", "J2o", "T2o", "92o", "82o", "72o", "62o", "52o", "42o", "32o", "22")
	)
	val sortedHands = Array(
	    "AA", "KK", "QQ", "AKs", "AKo", "JJ", "TT", "99", "AQs", "AQo", "AJs", "88", "ATs",
	    "AJo", "77", "ATo", "A9s", "A8s", "KQs", "KQo", "66", "A9o", "A8o", "A7s", "A6s", "A5s",
	    "KJs", "KJo", "KTs", "QJs", "55", "A7o", "A4s", "KTo", "K9s", "QJo", "QTs", "JTs", "T9s",
	    "A6o", "A5o", "A3s", "A2s", "K8s", "K7s", "JTo", "J9s", "98s", "87s", "76s", "44", "33", 
	    "22", "A4o", "A3o", "A2o", "K9o", "K6s", "K5s", "K8o", "K4s", "Q9s", "QTo", "K7o", "K3s", 
	    "K2s", "Q8s", "Q9o", "K6o", "K5o", "K4o", "Q7s", "Q6s", "Q5s", "Q8o", "Q4s", "Q3s", "Q7o", 
	    "Q6o", "J8s", "J7s", "J9o", "J8o", "T8s", "T9o", "97s", "98o", "86s", "87o", "75s", "65s", 
	    "54s", "K3o", "K2o", "Q2s", "Q5o", "J6s", "T7s", "J5s", "Q4o", "J4s", "J7o", "Q3o", "T8o", 
	    "J3s", "T6s", "Q2o", "J2s", "J6o", "T7o", "96s", "J5o", "T5s", "T4s", "J4o", "T6o", "97o", 
	    "T3s", "95s", "J3o", "T2s", "85s", "96o", "T5o", "J2o", "94s", "T4o", "86o", "93s", "84s", 
	    "95o", "T3o", "76o", "92s", "74s", "T2o", "85o", "64s", "83s", "94o", "75o", "82s", "73s", 
	    "93o", "65o", "53s", "63s", "84o", "92o", "43s", "74o", "72s", "54o", "64o", "52s", "62s", 
	    "83o", "42s", "82o", "73o", "53o", "63o", "32s", "43o", "72o", "52o", "62o", "42o", "32o"
	)
	//		"AA, KK, AKs, QQ, AKo, JJ, AQs, TT, AQo, 99, AJs, 88, ATs, AJo, 77, 66, ATo, A9s, 55, A8s, KQs, 44, A9o, A7s, KJs, A5s, A8o, A6s, A4s, 33, KTs, A7o, A3s, KQo, A2s, A5o, A6o, A4o, KJo, QJs, A3o, 22, K9s, A2o, KTo, QTs, K8s, K7s, JTs, K9o, K6s, QJo, Q9s, K5s, K8o, K4s, QTo, K7o, K3s, K2s, Q8s, K6o, J9s, K5o, Q9o, JTo, K4o, Q7s, T9s, Q6s, K3o, J8s, Q5s, K2o, Q8o, Q4s, J9o, Q3s, T8s, J7s, Q7o, Q2s, Q6o, 98s, Q5o, J8o, T9o, J6s, T7s, J5s, Q4o, J4s, J7o, Q3o, 97s, T8o, J3s, T6s, Q2o, J2s, 87s, J6o, 98o, T7o, 96s, J5o, T5s, T4s, 86s, J4o, T6o, 97o, T3s, 76s, 95s, J3o, T2s, 87o, 85s, 96o, T5o, J2o, 75s, 94s, T4o, 65s, 86o, 93s, 84s, 95o, T3o, 76o, 92s, 74s, 54s, T2o, 85o, 64s, 83s, 94o, 75o, 82s, 73s, 93o, 65o, 53s, 63s, 84o, 92o, 43s, 74o, 72s, 54o, 64o, 52s, 62s, 83o, 42s, 82o, 73o, 53o, 63o, 32s, 43o, 72o, 52o, 62o, 42o, 32o"
	val sortedHandsPercentages = {
	  var sum = 0.0f
	  (for (h <- sortedHands) yield {sum += nbHands(h); sum / numberOfHands}) toArray
	}
	val handsToIndex = (for (i <- 0 until hands.length; j <- 0 until hands(0).length) yield hands(i)(j) -> (i,j)) toMap
	val predefinedDescriptions = Array("Pair", "Broadway", "AXs", "AX", "Suited connectors", "Suited one-gappers")
	val predefined = Array(
		"AA-22", 
		"AK-AT, KQ-KT, QJ-QT, JT",
		"A2s+",
		"A2+",
		"AKs, KQs, QJs, JTs, T9s, 98s, 87s, 76s, 65s, 54s, 43s, 32s",
		"AQs, KJs, QTs, J9s, T8s, 97s, 86s, 75s, 64s, 53s, 42s"
	)
	val nbPredefinedHandRanges = predefined length
	def nbHands(hand: String) = if (hand.length == 2) 6 else if (hand.charAt(2) == 's') 4 else 12 
}
