package simplified.iomonads

import scala.io.StdIn.readLine
import cats.effect.IO

object IOMonad2 extends App {

  def printStr(str: String): IO[Unit] = IO(println(str))
  def userInput: IO[String] = IO(readLine())

  def program: IO[Unit] = for {
    _ <- printStr("Enter user name: ")
    input <- userInput
    _ <- printStr(s"Hello $input")
    _ <- printStr("Please enter (c)ontinue and (q)uit: ")
    signal <- userInput
    _ <- if(signal.trim.equalsIgnoreCase("q")) IO(Unit) else program
  } yield ()

  program
}
