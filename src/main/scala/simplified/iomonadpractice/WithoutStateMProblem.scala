package simplified.iomonadpractice

object WithoutStateMProblem extends App {

  case class CricketShot(score: Int)

  def nextShot(shots: CricketShot, newScore: Int): CricketShot = {
    CricketShot(newScore + shots.score)
  }

  val ball0 = CricketShot(0)
  val ball1 = nextShot(ball0, 2)
  val ball2 = nextShot(ball1, 4)
  val ball3 = nextShot(ball2, 6)

  println(ball3.score)
}