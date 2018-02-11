package simplified.iomonadpractice


import scala.io.StdIn.{readInt, readLine}

object MonadTProblem extends App {

  type Stack = List[Int]
  def push(score: Int): State[Stack, Unit] = State[Stack, Unit] { scores =>
    (score :: scores, ())
  }

  def printStr(str: String) = IO { println(str) }
  def getInt = IO { readInt() }
  def getString = IO { readLine() }

  /*def main: IO[Unit] = for {
    _ <- printStr(s"Add new Score")
    score <- getInt
    _ <- push(score)
    _ <- if(score == 0) IO { Unit } else main
  } yield ()

  main.run*/

  /*printStr(s"Add new Score").flatMap { _ =>
    getInt.flatMap { _ =>
      push { score =>
        if(score == 0) IO { Unit } else main
      }
    }
  }*/
}
