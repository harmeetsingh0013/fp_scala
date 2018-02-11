package usercases.mtransfomer

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example5 extends App {

  val repository = new Repository

  case class WhateverOpt[W[_], A] (value: W[Option[A]]) {

    def map[B] (f: A => B) (implicit M: Monad[W]): WhateverOpt[W, B] =
      WhateverOpt(M.map(value)(_.map(f)))

    def flatMap[B] (f: A => WhateverOpt[W, B]) (implicit M: Monad[W]): WhateverOpt[W, B] =
      WhateverOpt(M.flatMap(value)(optA => optA match {
        case Some(v) => f(v).value
        case None => M.pure(None)
      }))
  }

  // Future monad
  implicit val futureMonad = new Monad[Future] {
    override def pure[A](a: A): Future[A] = Future.successful(a)

    override def map[A, B](fa: Future[A])(f: A => B): Future[B] = fa.map(f)

    override def flatMap[A, B](fa: Future[A])(f: A => Future[B]): Future[B] = fa.flatMap(f)
  }

  val futureResult: WhateverOpt[Future, String] = for {
    user <- WhateverOpt(repository.getUserOption(1))
    address <- WhateverOpt(repository.getAddressOption(user))
  } yield address.city

  Thread.sleep(1000)
  println(s"Future City: ${futureResult}")

  // List monads
  implicit val listTMonad = new Monad[List] {
    override def pure[A](a: A): List[A] = List(a)

    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)

    override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f)
  }

  val listResult: WhateverOpt[List, String] = for {
    user <- WhateverOpt(repository.getUsersOption)
    address <- WhateverOpt(repository.getAddressesOption(user))
  } yield address.city

  println(s"List City: ${ listResult }")
}
