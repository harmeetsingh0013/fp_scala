package usercases.mtransfomer

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Example8 extends App {


  // side effects operations
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(13, "James")))

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

  val user = updateUser(User(13, "Jimmy"))
  Thread.sleep(1000)
  println(s"User After Update: $user")
}
