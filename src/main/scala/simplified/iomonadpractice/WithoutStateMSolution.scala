package simplified.iomonadpractice

object WithoutStateMSolution extends App {

  case class CricketShot(score: Int) {

    def map(f: Int => Int): CricketShot = {
      CricketShot(f(score))
    }

    def flatMap(f: Int => CricketShot): CricketShot = f(score)
  }

  val totalScore: CricketShot = for {
    ball0 <- CricketShot(0)
    ball1 <- CricketShot(ball0 + 2)
    ball2 <- CricketShot(ball1 + 4)
    ball3 <- CricketShot(ball2 + 6)
  } yield  ball3

 println(totalScore)
}
