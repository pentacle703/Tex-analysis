package handRangeGenerator

trait Game {
	def width: Int
	def height: Int
	def description(i: Int, j: Int): String
	def parse(handRange: String): List[(Int, Int)]
	def handRangeToHandList(handRange: String): List[String] = {
	  parse(handRange) map (coordinate => description(coordinate._1, coordinate._2))
	}
	def percentage(p: Float): List[(Int, Int)]
	def percentage(range: String): Float
	def percentage(range: String, p: Float): List[(Int, Int)]
	def compact(range: String): String
	def nbPredefinedHandRanges: Int
	def predefinedHandRangesDescription(i: Int): String
	def predefinedHandRanges(i: Int): String
}