package simplified.iomonadpractice

class IO[A] private (run0: => A) {

  def run = run0

  def map[B](f: A => B): IO[B] = flatMap(a => IO(f(a)))

  def flatMap[B] (f: A => IO[B]): IO[B] = IO { f(run).run }

}

object IO {
  def apply[A](run: => A): IO[A] = new IO(run)
}