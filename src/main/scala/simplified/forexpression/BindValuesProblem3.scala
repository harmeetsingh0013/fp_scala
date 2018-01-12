package simplified.forexpression


object BindValuesProblem3 extends App {

  /*
  * for {
  *  fResult <- f(1)
  *  gResult <- g(fResult)
  *  hResult <- h(gResult)
  * } yield hResult
  */

  def f(i : Int): Debuggable = {
    val result = i + 1
    Debuggable(result, s"f Result is: $result")
  }

  def g(i: Int): Debuggable = {
    val result = i + 2
    Debuggable(result, s"g Result is: $result")
  }

  def h(i: Int): Debuggable = {
    val result = i + 3
    Debuggable(result, s"h Result is: $result")
  }

  val result: Debuggable = for {
    fResult <- f(1)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s" Result: ${ result.value }\n Logs are: ${ result.log }")
}

case class Debuggable(value: Int, log: String) {

  def map(f: Int => Int): Debuggable = {
    val result = f(value)
    Debuggable(result, log)
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val result = f(value)
    Debuggable(result.value, log + " " + result.log)
  }
}
