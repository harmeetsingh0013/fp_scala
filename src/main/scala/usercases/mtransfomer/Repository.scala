package usercases.mtransfomer

import scala.concurrent.Future

case class User(id: Int, name: String)
case class Address(id: Int, userId: Int, city: String)

class Repository {

  // bad practice
  def getUser(id: Int): Future[User] = Future.successful(User(1, "James"))
  def getAddress(user: User): Future[Address] = Future.successful(Address(1, 1, "Moga"))

  //good practice
  def getUserOption(id: Int): Future[Option[User]] =
    Future.successful(Some(User(1, "James")))
  def getAddressOption(user: User): Future[Option[Address]] =
    Future.successful(Some(Address(1, 1, "Moga")))
}