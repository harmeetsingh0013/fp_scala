package usercases.mtransfomer

trait Monad[F[_]] {

  def map[A, B] (fa: F[A]) (f: A => B): F[B]

  def flatMap[A, B] (fa: F[A]) (f: A => F[B]): F[B]
}
