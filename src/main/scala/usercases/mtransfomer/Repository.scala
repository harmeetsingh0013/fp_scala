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

  // lists of options
  def getUsersOption: List[Option[User]] = List(Some(User(1, "James")), Some(User(2, "Micky")))
  def getAddressesOption(user: User): List[Option[Address]] =
    List(Some(Address(1, 1, "Moga")), Some(Address(2, 2, "Noida")))

  // some new methods
  def getUserAgeByName(name: String): Future[Int] = Future.successful(13)
  def getUserFirstName(id: Int): Option[String] = Some("James")

}