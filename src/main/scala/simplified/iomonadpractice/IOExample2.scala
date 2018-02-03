package simplified.iomonadpractice

import scala.io.StdIn.readLine

object IOExample2 extends App {

  def printStr(str: String) = IO { println(str) }
  def getString = IO { readLine() }

  def program: IO[Unit] = for {
    _ <- printStr("Please enter you name: ")
    input <- getString
    _ <- printStr(s"Hello $input")
    _ <- printStr("(q)uit or (c)ontinue ... ")
    r <- getString
    _ <- if(r.trim.equalsIgnoreCase("q")) IO { Unit } else program
  } yield ()

  program.run
}
