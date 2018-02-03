package simplified.iomonadpractice

/**
  * for {
  *  _ <- stroke(2)
  *  _ <- stroke(4)
  *  total <- stroke(6)
  * } yield total
  */

object StateExample1 extends App {

  case class CricketShot(score: Int)

  def stroke(score: Int): State[CricketShot, Int] = State { state =>
    val newScore = state.score + score
    (CricketShot(newScore), newScore)
  }

  val startPlaying: State[CricketShot, Int] = for {
    _ <- stroke(2)
    _ <- stroke(4)
    total <- stroke(6)
  } yield total

  val (state, total) = startPlaying.run(CricketShot(0))
  println(s"Current State is: $state")
  println(s"Total Score Is : $total")

  /*val result: StateV1[CricketShot, Int] =
    stroke(2).flatMap { _ =>
      stroke(4).flatMap { _ =>
        stroke(6)
    }
  }

  val (state1, total1) = result.run(CricketShot(0))
  println(s"Current State is: $state1")
  println(s"Total Score Is : $total1")*/
}
