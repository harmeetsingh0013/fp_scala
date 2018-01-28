package simplified.iomonads

import scala.io.StdIn._

/**
  * Write a program which accepts user name as an input and greetings as output
  */
object Recursion1 extends App {

  var option = ""


  while (!option.trim.equalsIgnoreCase("q")){
    println("Enter user name: ")
    val input = readLine()
    println(s"Hello $input")
    println("Please enter (c)ontinue and (q)uit: ")
    option = readLine()
  }



}
