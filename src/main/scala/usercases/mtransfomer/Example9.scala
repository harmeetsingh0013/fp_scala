package usercases.mtransfomer

import scala.concurrent.Future

object Example9 extends App {

  case class MyError(msg: String)

  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(1, "James")))

  def checkCanBeUpdated(u: User): Future[Boolean] =
    Future.successful(true)

  def updateUser(user: User): Future[Either[MyError, User]] = {
    getUserOption(user.id).flatMap { userOpt =>
      userOpt match {
        case Some(user) => checkCanBeUpdated(user).flatMap { canBeUpdated =>
          if (canBeUpdated)
            Future.successful(user).map(Right(_))
          else
            Future.successful(Left(MyError("user cannot be updated")))
        }
        case None => Future.successful(Left(MyError("user cannot be updated")))
      }
    }
  }
}
