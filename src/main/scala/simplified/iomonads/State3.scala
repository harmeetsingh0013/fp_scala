package simplified.iomonads

import simplified.lib.StateV1

object State3 extends App {

  val result = for {
    i <- StateV1(2)
    j <- StateV1(i + 4)
    k <- StateV1(j + 0)
  } yield k

  println(result)
}
