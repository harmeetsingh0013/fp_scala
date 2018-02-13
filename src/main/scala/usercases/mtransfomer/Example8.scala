package usercases.mtransfomer

import scala.concurrent.Future

object Example8 extends App {


  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(1, "James")))

  def checkCanBeUpdated(u: User): Future[Boolean] =
    Future.successful(true)

  def updateUser(user: User): Future[Option[User]] = {
    getUserOption(user.id).flatMap { optUser =>
      optUser match {
        case Some(user) =>
          checkCanBeUpdated(user).flatMap { canBeUpdated =>
            if (canBeUpdated)
              Future.successful(user).map(Some(_))
            else Future.successful(None)
          }
        case None =>  Future.successful(None)
      }
    }
  }


}
