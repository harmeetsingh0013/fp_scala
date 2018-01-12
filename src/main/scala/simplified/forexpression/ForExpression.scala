package simplified.forexpression

object ForExpression extends App {

  val list = List(1, 2, 3, 4, 5)
  val result = for {
    i <- list
    j <- list
    k <- list
  } yield i + j + k

  println(s"THe list size result is: ${result.size}")




  val result_ = list.flatMap { i =>
    list.flatMap { j =>
      list.map ( k => i + j + k)
    }
  }

  println(s"THe list size result_ is: ${result_.size}")
}
