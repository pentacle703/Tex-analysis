package handRangeGenerator

trait HoldemHandRange extends HandRange {
  val cards = Holdem.cards
  def isDefined(v: Char) = cards.indexOf(v) != -1
  def wellFormed(hand: String) = hand.length == 2 && isDefined(hand(0)) && isDefined(hand(1)) && cards.indexOf(hand(0)) > cards.indexOf(hand(1)) 
}

trait SimpleHoldemHandRange extends HoldemHandRange {
  override def in(h: String) = h == toString
  override def allHands = List(toString)
}

trait ComposedHoldemHandRange extends HoldemHandRange

case class Pair(v: Char) extends SimpleHoldemHandRange {
  if (!isDefined(v)) throw new BadHandRangeError
  def <=(that: Pair) = cards.indexOf(v) - cards.indexOf(that.v) <= 0
  override def toString = v.toString + v.toString
}

case class SuitedHand(hand: String) extends SimpleHoldemHandRange {
  if (!wellFormed(hand)) throw new BadHandRangeError
  def <=(that: SuitedHand) = (cards.indexOf(hand(0)) - cards.indexOf(that.hand(0))) * cards.length + cards.indexOf(hand(1)) - cards.indexOf(that.hand(1)) <= 0   
  override def toString = hand + "s"
}

case class OffSuitHand(hand: String) extends SimpleHoldemHandRange {
  if (!wellFormed(hand)) throw new BadHandRangeError
  def <=(that: OffSuitHand) = (cards.indexOf(hand(0)) - cards.indexOf(that.hand(0))) * cards.length + cards.indexOf(hand(1)) - cards.indexOf(that.hand(1)) <= 0
  override def toString = hand + "o"
}

case class Hand(hand: String) extends SimpleHoldemHandRange {
  if (!wellFormed(hand)) throw new BadHandRangeError
  def <=(that: Hand) = (cards.indexOf(hand(0)) - cards.indexOf(that.hand(0))) * cards.length + cards.indexOf(hand(1)) - cards.indexOf(that.hand(1)) <= 0
  override def in(h: String) = h == toString + "o" || h == toString + "s" 
  override def toString = hand
  override def allHands = List(hand + "s", hand + "o")
}

case class Plus(simpleHandRange: SimpleHoldemHandRange) extends ComposedHoldemHandRange {
  val range =
	 simpleHandRange match {
      case Pair(v) => 
      	for (i <- cards.indexOf(v) until cards.length) yield (cards(i).toString + cards(i).toString)
      case SuitedHand(hand) =>
      	for (i <- cards.indexOf(hand(1)) until cards.indexOf(hand(0))) yield (hand(0).toString + cards(i).toString + "s")
      case OffSuitHand(hand) =>
      	for (i <- cards.indexOf(hand(1)) until cards.indexOf(hand(0))) yield (hand(0).toString + cards(i).toString + "o")
      case Hand(hand) =>
        (for (i <- cards.indexOf(hand(1)) until cards.indexOf(hand(0))) yield (hand(0).toString + cards(i).toString + "s")) ++
        (for (i <- cards.indexOf(hand(1)) until cards.indexOf(hand(0))) yield (hand(0).toString + cards(i).toString + "o"))
    }
  override def in(h: String) = {
    range exists (_ == h)
  }
  override def toString = simpleHandRange.toString + "+"
  override def allHands = range toList
}

case class Interval(simpleHandRange1: SimpleHoldemHandRange, simpleHandRange2: SimpleHoldemHandRange) extends ComposedHoldemHandRange {
  if (!
	  ((simpleHandRange1, simpleHandRange2) match {
      	case (Pair(v1), Pair(v2)) => 
      	  cards.indexOf(v1) >= cards.indexOf(v2)
      	case (SuitedHand(hand1), SuitedHand(hand2)) =>
      	  hand1(0) == hand2(0) && cards.indexOf(hand1(1)) >= cards.indexOf(hand2(1))
      	case (OffSuitHand(hand1), OffSuitHand(hand2)) =>
      	  hand1(0) == hand2(0) && cards.indexOf(hand1(1)) >= cards.indexOf(hand2(1))
      	case (Hand(hand1), Hand(hand2)) =>
      	  hand1(0) == hand2(0) && cards.indexOf(hand1(1)) >= cards.indexOf(hand2(1))
      	case _ => false
      })
  ) throw new BadHandRangeError
  val range =
	 (simpleHandRange1, simpleHandRange2) match {
      case (Pair(v1), Pair(v2)) => 
      	for (i <- cards.indexOf(v2) to cards.indexOf(v1)) yield (cards(i).toString + cards(i).toString)
      case (SuitedHand(hand1), SuitedHand(hand2)) =>
        for (i <- cards.indexOf(hand2(1)) to cards.indexOf(hand1(1))) yield (hand1(0).toString + cards(i).toString + "s")
      case (OffSuitHand(hand1), OffSuitHand(hand2)) =>
        for (i <- cards.indexOf(hand2(1)) to cards.indexOf(hand1(1))) yield (hand1(0).toString + cards(i).toString + "o")
      case (Hand(hand1), Hand(hand2)) =>
        (for (i <- cards.indexOf(hand2(1)) to cards.indexOf(hand1(1))) yield (hand1(0).toString + cards(i).toString + "s")) ++
        (for (i <- cards.indexOf(hand2(1)) to cards.indexOf(hand1(1))) yield (hand1(0).toString + cards(i).toString + "o"))
      case _ => IndexedSeq[String]()
    }
  override def in(h: String) = range exists (_ == h)
  override def toString = simpleHandRange1.toString + "-" + simpleHandRange2.toString
  override def allHands = range toList
}
