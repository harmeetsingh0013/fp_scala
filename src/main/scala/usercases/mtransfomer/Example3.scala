package usercases.mtransfomer

import cats.syntax.applicative._
import cats.instances.option._
import cats.instances.future._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Example3 extends App {

  case class FutOpt[A](value: Future[Option[A]])

  new Monad[FutOpt] {

    override def pure[A](a: => A): FutOpt[A] =
      FutOpt(a.pure[Option].pure[Future])

    override def map[A, B](f: A => B)(fa: FutOpt[A]): FutOpt[B] =
      FutOpt(fa.value.map(optA => optA.map(f)))

    override def flatMap[A, B](f: A => FutOpt[B])(fa: FutOpt[A]): FutOpt[B] =
      FutOpt(fa.value.flatMap(opt => opt match {
        case Some(a) => f(a).value
        case None => (None: Option[B]).pure[Future]
      }))

  }
}
