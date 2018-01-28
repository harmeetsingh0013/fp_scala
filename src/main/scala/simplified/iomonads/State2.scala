package simplified.iomonads

object State2 extends App {

  case class GolfState(strokes: List[Int])

  def nextStroke(s: GolfState, distanceOfNextHit: Int): GolfState = {
    GolfState(distanceOfNextHit :: s.strokes)
  }

  val state0 = GolfState(Nil)
  val state1 = nextStroke(state0, 20)
  val state2 = nextStroke(state1, 15)
  val state3 = nextStroke(state2, 0)

  println(state3)  //prints "GolfState(List(0, 15, 20))"
}
