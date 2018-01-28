package simplified.lib

case class StateV3[S, A](run: S => (S, A)) {

  // this code is like: `xs.filter { i : Int => i < 3 }`
  def flatMap[B](g: A => StateV3[S, B]): StateV3[S, B] = StateV3 { (s0: S) =>

    // create a new (StateV3,value) by applying `run` to the initial StateV3, `s0`.
    // as shown above, `run` transforms an S to an (S,A).
    val (s1, a) = run(s0) //(S,A) <~~ the type `S` here, not a StateV3

    // create a new StateV3 by applying `g` to `a`. as shown above,
    // `g` transforms an A to a `StateV3[S,B]`.
    val s2 = g(a) //StateV3[S,B]

    // create a final result by applying s2.run to s1.
    // once again, `run` transforms an S to an (S,A).
    val rez = s2.run(s1) //(S,B)

    // yield this value; it is the param that's passed to StateV3's
    // constructor, so this function yields a StateV3[S,B] as its
    // final result
    rez
  }

  def map[B](f: A => B): StateV3[S, B] = flatMap(a => StateV3.point(f(a)))
}

object StateV3 {
  /**
    * "lifts" a value and a StateV3 into a StateV3[S,A]
    */
  def point[S, A](v: A): StateV3[S, A] = StateV3(run = s => (s, v))
}