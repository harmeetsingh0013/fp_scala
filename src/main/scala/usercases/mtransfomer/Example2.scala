package usercases.mtransfomer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Example2 extends App {

  val repository = new Repository

  /*repository.getUserOption(1).flatMap { user =>
    user.flatMap { user =>
      repository.getAddressOption(user).flatMap { addres =>
        addres.map(_.city)
      }
    }
  }*/

  val result: Future[Option[String]] = for {
    user <- repository.getUserOption(1)
    city <- user match {
      case Some(usr) => repository.getAddressOption(usr).map(_.map(_.city))
      case None => Future.successful(None)
    }
  } yield city

  Thread.sleep(1000)
  println(s"City: $result")
}
