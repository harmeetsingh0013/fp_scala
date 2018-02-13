package usercases.mtransfomer

import cats.data.EitherT
import usercases.mtransfomer.Example9.MyError

import scala.concurrent.Future

object Example10 extends App {

  type ResultT[F[_], A] = EitherT[F, MyError, A]
  type FutureResult[A] = ResultT[Future, A]

  def getUserOption(id: Int): FutureResult[User]  = EitherT {
    if(id == 13) Future.successful(Right(User(1, "James")))
    else Future.successful(Left(MyError("user does not exist")))
  }

  def checkCanBeUpdated(u: User): FutureResult[User] = EitherT {
    if (u.id == 13) Future.successful(Right(u))
    else Future.successful(Left(MyError("only james can be updated")))
  }

  def updateUserOnDb(u: User): FutureResult[User] = EitherT {
    if (u.id == 13) Future.successful(Right(u))
    else Future.successful(Left(MyError("only james can be updated")))
  }

  def updateUser(user: User): Future[Either[MyError, User]] = (for {
      user <- getUserOption(13)
      _ <- checkCanBeUpdated(user)
      updateUser <- updateUserOnDb(user)
  } yield updateUser).value

}
