package handRangeGenerator
import scala.util.parsing.combinator.RegexParsers

object HoldemHandRangeParsers extends RegexParsers {			
	def pair: Parser[Pair] = ("22" | "33" | "44" | "55" | "66" | "77" | "88" | "99" | "TT" | "JJ" | "QQ" | "KK" | "AA") ^^ { case s => Pair(s.charAt(0)) }	
	def card: Parser[Char] = "[2-9TJQKA]".r ^^ { case s => s.charAt(0) }	
	def handString: Parser[String] = 
	  	not(pair)~>card~card ^^ { case c1~c2 => import Holdem.cards; if (cards.indexOf(c1) >= cards.indexOf(c2)) c1.toString + c2.toString else c2.toString + c1.toString }
	def suitedHand: Parser[SuitedHand] = handString<~"s" ^^ { case h => SuitedHand(h) }	
	def offSuitHand: Parser[OffSuitHand] = handString<~"o" ^^ { case h => OffSuitHand(h) }	
	def hand: Parser[Hand] = handString ^^ { case h => Hand(h) }	
	def simpleHand: Parser[SimpleHoldemHandRange] = pair | suitedHand | offSuitHand | hand
	def plus: Parser[Plus] = simpleHand<~"+" ^^ { case h => Plus(h) }	
	def interval: Parser[Interval] = 
		(pair~"-"~pair ^^ { case h1~"-"~h2 => if (h2 <= h1) Interval(h1, h2) else Interval(h2, h1) }) |
		(suitedHand~"-"~suitedHand ^^ { case h1~"-"~h2 => if (h2 <= h1) Interval(h1, h2) else Interval(h2, h1) }) |
		(offSuitHand~"-"~offSuitHand ^^ { case h1~"-"~h2 => if (h2 <= h1) Interval(h1, h2) else Interval(h2, h1) }) |
		(hand~"-"~hand ^^ { case h1~"-"~h2 => if (h2 <= h1) Interval(h1, h2) else Interval(h2, h1) })		
	def handRange: Parser[List[HoldemHandRange]] = repsep(plus | interval | simpleHand, ",")
}