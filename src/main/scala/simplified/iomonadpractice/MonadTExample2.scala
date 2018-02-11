package simplified.iomonadpractice

import scala.io.StdIn.readLine

object MonadTExample2 extends App {

  def printStr(str: String) = IO { println(str) }
  def getString = IO { readLine() }


}
