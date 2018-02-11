package simplified.iomonadpractice

object MonadTExample1 extends App {

  implicit val IOMonad = new Monad[IO] {
    override def flatMap[A, B] (ma: IO[A]) (f: A => IO[B]): IO[B] = ma.flatMap(f)
    override def lift[A] (a: => A): IO[A] = IO(a)
  }

  implicit val OptionMonad = new Monad[Option] {
    override def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] = ma.flatMap(f)
    override def lift[A](a: => A): Option[A] = Some(a)
  }

  case class IntState(value: Int)

  def add(value: Int): StateT[IO, IntState, Int] = StateT[IO, IntState, Int] { oldState: IntState =>
    val newValue =  value + oldState.value
    val newState = oldState.copy(value = newValue)
    IO(newState, newValue)
  }

  def multiply(value: Int): StateT[IO, IntState, Int] = StateT[IO, IntState, Int] { oldState: IntState =>
    val newValue =  value * oldState.value
    val newState = oldState.copy(value = newValue)
    IO(newState, newValue)
  }

 /* val a: StateT[IO, IntState, Int] = add(1)
  val b: IO[(IntState, Int)] = a.run(IntState(1))

  b.map(t => println(s"b State ${t._1}"))
*/
  val forExpression: StateT[IO, IntState, Int] = for {
    _ <- add(2)
    _ <- add(3)
    x <- multiply(10)
  } yield x

  val result: IO[(IntState, Int)] = forExpression.run(IntState(1))
  result.map(tuple => println(s"IntState = ${tuple._1}"))

  val forExpression1: StateT[IO, IntState, Int] = add(2).flatMap { i =>
    add(3).flatMap { j =>
      multiply(10).map { k =>
        k
      }
    }
  }

  val result1: IO[(IntState, Int)] = forExpression1.run(IntState(1))
  result1.map(tuple => println(s"IntState = ${tuple._1}"))
}
