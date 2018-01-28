package simplified.iomonads

import simplified.lib.IO

import scala.io.StdIn.readLine

object IOMonad1 extends App {

//  def printStr(str: String): IO[Unit] = IO(println(str))
//  def userInput: IO[String] = IO(readLine())

  /*def program: IO[Unit] = for {
    _ <- printStr("Enter user name: ")
    input <- userInput
    _ <- printStr(s"Hello $input")
    _ <- printStr("Please enter (c)ontinue and (q)uit: ")
    signal <- userInput
    _ <- if(signal.trim.equalsIgnoreCase("q")) IO(Unit) else program
  } yield ()

  program*/

  /*def getLine: IO[String] = IO(scala.io.StdIn.readLine())
  def putStrLn(s: String): IO[Unit] = IO(println(s))

  def loop: IO[Unit] = for {
    _     <- putStrLn("Type something: ")
    input <- getLine
    _     <- putStrLn(s"You said '$input'.")
    _     <- if (input == "quit") IO(Unit) else loop  //RECURSE
  } yield ()

  loop*/

  def getLine: IO[String] = IO(scala.io.StdIn.readLine())
  def putStrLn(s: String): IO[Unit] = IO(println(s))

  def forExpression: IO[Unit] = for {
    _         <- putStrLn("First name?")
    firstName <- getLine
    _         <- putStrLn(s"Last name?")
    lastName  <- getLine
    fNameUC   =  firstName.toUpperCase
    lNameUC   =  lastName.toUpperCase
    _         <- putStrLn(s"First: $fNameUC, Last: $lNameUC")
  } yield ()

  // run the block of code whenever you want to ...
  forExpression
}
