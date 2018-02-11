package usercases.mtransfomer

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Example3 extends App {

  case class FutOpt[A](value: Future[Option[A]]) {
    def pure[A](a: A): FutOpt[A] = FutOpt(Future.successful(Some(a)))

    def flatMap[A, B](fa: FutOpt[A])(f: A => FutOpt[B]): FutOpt[B] =

  }

  new Monad[FutOpt] {

    def pure[A](a: => A): FutOpt[A] = FutOpt(a.pure[Option].pure[Future])

    def map[A, B](fa: FutOpt[A])(f: A => B): FutOpt[B] =
      FutOpt(fa.value.map(optA => optA.map(f)))

    def flatMap[A, B](fa: FutOpt[A])(f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(fa.value.flatMap(opt => opt match {
        case Some(a) => f(a).value
        case None => (None: Option[B]).pure[Future]
      }))

  }
}
