package simplified.forexpression

object ForExpression2 extends App {

  val sum = for {
    i <- CustomWrapper[Int](1)
    j <- CustomWrapper[Int](2)
    k <- CustomWrapper[Int](3)
  } yield 1 + j + k

  println(sum)

}
