package usercases.mtransfomer

trait Monad[M[_]] {

  def pure[A] (a: A): M[A]

  def map[A, B] (fa: M[A]) (f: A => B): M[B]

  def flatMap[A, B] (fa: M[A]) (f: A => M[B]): M[B]
}
