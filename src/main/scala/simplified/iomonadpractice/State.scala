package simplified.iomonadpractice

case class State[S, A](run: S => (S, A)) {

  def map[B](f: A => B): State[S, B] = flatMap(a => State.point(f(a)))

  def flatMap[B] (f: A => State[S, B]): State[S, B] = State { (s0: S) =>
    println(s"Current State: $s0")
    val (s1, value) = run(s0) // run contains the stroke method StateV1 lambda expression
    println(s"State: $s1 and Value: $value")
    val stateChangeToB: State[S, B] = f(value)
    val (s2, value2) = stateChangeToB.run(s1)
    println(s" State change is Executed: $s2 and $value2")
    (s2, value2)
  }
}

object State {
  def point[S, A](v: A): State[S, A] = State(s => (s, v))
}