package simplified.forexpression

object BindValuesProblem2 extends App {

  /*
  *   val fResult = f(100)
  *   val gResult = bind(g, fResult)
  *   val hResult = bind(h, gResult)
  */

  def f(i : Int): (Int, String) = {
    val result = i + 1
    (result, s"f Result is: $result")
  }

  def g(i: Int): (Int, String) = {
    val result = i + 2
    (result, s"g Result is: $result")
  }

  def h(i: Int): (Int, String) = {
    val result = i + 3
    (result, s"h Result is: $result")
  }

  def bind(f: Int => (Int, String), tuple2: (Int, String)) = {
    val (value, log) = tuple2
    val (v, l) = f(value)
    (v, log + " " + l)
  }

  val fResult = f(1)
  val gResult = bind(g, fResult)
  val (hResult, logs) = bind(h, gResult)

  println(s" Result: $hResult \n Logs are: $logs")
}
