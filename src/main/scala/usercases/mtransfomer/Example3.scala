package usercases.mtransfomer

/*import cats.syntax.applicative._
import cats.instances.option._
import cats.instances.future._*/

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example3 extends App {

  val repository = new Repository

  case class FutOpt[A](value: Future[Option[A]]) {
    def map[B](f: A => B): FutOpt[B] =
      FutOpt(value.map(optA => optA.map(f)))

    def flatMap[B](f: A => FutOpt[B]): FutOpt[B] =
      FutOpt(value.flatMap(opt => opt match {
        case Some(a) => f(a).value
        case None => Future.successful(None)
      }))
  }

  /*object FutOpt {
    implicit val monadInstance: Monad[FutOpt] = new Monad[FutOpt] {
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
  }*/

  val result = for {
    user <- FutOpt(repository.getUserOption(1))
    addres <- FutOpt(repository.getAddressOption(user))
  } yield addres.city

  Thread.sleep(1000)
  println(s"City: $result")

}
