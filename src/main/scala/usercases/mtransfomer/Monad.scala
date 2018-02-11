package usercases.mtransfomer

trait Monad[F[_]] {

  def pure[A] (a: => A): F[A]

  def map[A, B] (f: A => B) (fa: F[A]): F[B]

  def flatMap[A, B] (f: A => F[B]) (fa: F[A]): F[B]
}
