package usercases.mtransfomer

import scala.concurrent.ExecutionContext.Implicits.global

object Example1 extends App {

  val repository = new Repository

  val address1 = repository.getUser(1).flatMap { user =>
    repository.getAddress(user).map { addres =>
      addres.city
    }
  }

  val address2 = for {
    user <- repository.getUser(1)
    addres <- repository.getAddress(user)
  } yield addres.city

  Thread.sleep(1000)
  println(s"Address 1 $address1")
  println(s"Address 2 $address2")
}
