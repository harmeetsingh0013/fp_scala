package simplified.iomonadpractice

import scala.io.StdIn._

object IOExample1 extends App {

  def printStr(str: String) = IO { println(str) }
  def getString = IO { readLine() }

  val result: IO[Unit] = for {
    _ <- printStr("Please enter you name: ")
    input <- getString
    _ <- printStr(s"Hello $input")
  } yield ()

  result.run
}
