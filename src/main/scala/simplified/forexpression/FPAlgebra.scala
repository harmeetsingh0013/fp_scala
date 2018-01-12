package simplified.forexpression

object FPAlgebra extends App {

  def f(i: Int) = i + 1
  def g(i: Int) = i + 2
  def h(i: Int) = i + 3

  val fv = f(1)
  val gv = g(fv)
  val hv = h(gv)

  val result = fv + gv + hv
  println(s" THe Result of f, g, v is: $result")

  println(s" THe Result of f, g, v is: ${h(g(f(1)))}")
}
