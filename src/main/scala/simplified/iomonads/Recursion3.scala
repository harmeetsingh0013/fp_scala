package simplified.iomonads

import scala.io.StdIn.readLine

object Recursion3 extends App {

  def printStr(str: String) = println(str)
  def userInput = readLine()

  def program: Unit = {
    def loop(signal: String): Unit = {
      if(signal.trim.equalsIgnoreCase("q")) ()
      else {
        printStr("Enter user name: ")
        val input = userInput
        printStr(s"Hello $input")
        println("Please enter (c)ontinue and (q)uit: ")
        loop(userInput)
      }
    }
    loop("")
  }

  program
}
