package simplified.lib

case class StateV2[S, A](run: S => (S, A)) {

  def flatMap[B](g: A => StateV2[S, B]): StateV2[S, B] = StateV2 { (s0: S) =>
    val (s1, a) = run(s0)
    g(a).run(s1)
  }

  def map[B](f: A => B): StateV2[S, B] = flatMap(a => StateV2.point(f(a)))
}

object StateV2 {
  def point[S, A](v: A): StateV2[S, A] = StateV2(run = s => (s, v))
}

