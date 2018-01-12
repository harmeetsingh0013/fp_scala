package simplified.forexpression

object BindValuesProblem1 extends App {

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

  val (fResult, log) = f(1)
  val (gResult, log1) = g(fResult)
  val (hResult, log2) = h(gResult)

  val logs = log +" " + log1 + " " + log2

  println(s" Result: $hResult \n Logs are: $logs")
}