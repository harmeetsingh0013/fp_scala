package usercases.mtransfomer

import cats.data.EitherT
import cats.instances.future._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example10 extends App {

  case class MyError(msg: String)

  type ResultT[F[_], A] = EitherT[F, MyError, A]
  type FutureResult[A] = ResultT[Future, A]

  def getUserOption(id: Int): FutureResult[User]  = EitherT.fromEither {
    if(id == 13) Right(User(13, "James"))
    else Left(MyError("user does not exist"))
  }

  def checkCanBeUpdated(u: User): FutureResult[User] = EitherT.fromEither {
    if (u.id == 13) Right(u)
    else Left(MyError("only james can be updated"))
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

  val user = updateUser(User(13, "Jimmy"))
  Thread.sleep(1000)
  println(s"User After Update: $user")
}
