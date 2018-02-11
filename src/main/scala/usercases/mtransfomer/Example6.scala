package usercases.mtransfomer

import cats.data.OptionT
import cats.instances.future._
import cats.instances.list._
import scala.concurrent.ExecutionContext.Implicits.global

object Example6 extends App {

  val repository = new Repository

  val futureResult = for {
    user <- OptionT(repository.getUserOption(13))
    address <- OptionT(repository.getAddressOption(user))
  } yield address.city

  Thread.sleep(1000)
  println(s"Future City: ${futureResult}")

  val listResult = for {
    user <- OptionT(repository.getUsersOption)
    address <- OptionT(repository.getAddressesOption(user))
  } yield address.city

  println(s"List City: ${ listResult }")
}
