package usercases.mtransfomer

import cats.data.OptionT
import cats.instances.future._
import scala.concurrent.ExecutionContext.Implicits.global

object Example7 extends App {

  val repository = new Repository

  /*val result1 = for {
    user <- OptionT(repository.getUserOption(13))
    age <- OptionT(repository.getUserAgeByName(user.name))
    firstname <- OptionT(repository.getUserFirstName(user.id))
  } yield firstname*/


  val result2 = for {
    user <- OptionT(repository.getUserOption(13))
    age <- OptionT.liftF(repository.getUserAgeByName(user.name))
    firstName <- OptionT.fromOption(repository.getUserFirstName(user.id))
  } yield (age, firstName)

  Thread.sleep(1000)
  println(s"Tuple: $result2")
}
