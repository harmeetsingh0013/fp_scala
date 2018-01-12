package simplified.forexpression

/**
  * For expression is based on three properties. If container have these three properties support
  * for expression easily evaluate that container or collection.
  * These expressions are:
  *  1. p <- persons                // A Generator
  *  2. n = p.name                  // A Definition
  *  3. if(n startsWith "Some")     // A Filter
  *
  *  If you want to implement these three expressions with your container, you need to define some
  *  specific method, which for expression will loon after compile time. These methods are:
  *  a) def foreach(c: A => Unit): Unit { ... }
  *  b) def map[B](f: A => B): Sequence[B] { ... }
  *  c)
  */
object ForExpression1 extends App {

  val ints = CustomList(1, 2, 3)
  for( i <- ints) { println(i)}
  for( i <- ints; a = (i + 1)) {}

  val values1: CustomList[Int] = for(i <- ints; a = (i + 1)) yield a
  println(s"Map Values: $values1")

  val values2 = for {
    i <- ints
    if(i % 2 == 0)
  } yield i

  println(s"With Filter Values: $values2")

  val values3: CustomList[Int] = for(i <- ints; j <- ints; a = (i + j + 1)) yield a
  println(s"FlatMap Values: $values3")
}
