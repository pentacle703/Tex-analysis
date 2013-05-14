package handRangeGenerator

trait HandRange {
	def in(hand: String): Boolean
	def allHands(): List[String]
}

class BadHandRangeError extends Exception