package simplified.iomonads

import scala.io.StdIn.readLine

object Recursion2 extends App {

  def userPrompt = "Enter user name: "
  def userInput = readLine()
  def greetingPrompt(input: String) = s"Hello $input"
  def continuePrompt = "Please enter (c)ontinue and (q)uit: "

  def program: Unit = {
    def loop(input: String): Unit = {
      if(input.trim.equalsIgnoreCase("q")) ()
      else {
        println(userPrompt)
        val input = userInput
        println(greetingPrompt(input))
        println(continuePrompt)
        loop(userInput)
      }
    }
    loop("")
  }

  program
}
