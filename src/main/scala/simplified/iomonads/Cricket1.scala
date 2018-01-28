package simplified.iomonads

import simplified.lib.StateV2

object Cricket1 extends App {

  case class PlayerState(score: Int)

  def stroke(score: Int): StateV2[PlayerState, Int] = StateV2 { (s0: PlayerState) =>
    val newScore = s0.score + score
    (PlayerState(newScore), newScore)
  }

  val playerTotalScore: StateV2[PlayerState, Int] = for {
    _ <- stroke(1)
    _ <- stroke(6)
    totalScore <- stroke(0)
  } yield totalScore

  val beginScoreState = PlayerState(0)

  val result = playerTotalScore.run(beginScoreState)
  println(s"Player Score ${result._1}")
  println(s" Team total Score ${result._2}")
}
