package simplified.iomonadpractice

object StateExample2 extends App {

  type Stack = List[Int]
  def push(value: Int): State[Stack, Unit] = State[Stack, Unit] { xs =>
    (value :: xs, ())
  }

  def pop: State[Stack, Int] = State[Stack, Int] { xs =>
    (xs.tail, xs.head)
  }

  val program: State[Stack, Unit] = for {
    _ <- push(2)
    _ <- push(4)
    _ <- pop
    k <- push(6)
  } yield k

  val result = program.run(Nil)

  println(s"Stack $result")
}
