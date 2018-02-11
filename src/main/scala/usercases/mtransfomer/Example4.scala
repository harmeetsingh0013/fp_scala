package usercases.mtransfomer

object Example4 extends App {

  val repository = new Repository

  case class ListOpt[A](value: List[Option[A]]) {

    def map[B] (f: A => B): ListOpt[B] = ListOpt(value.map(optA => optA.map(f)))

    def flatMap[B] (f: A => ListOpt[B]): ListOpt[B] =
      ListOpt( value.flatMap { optA => optA match {
        case Some(v) => f(v).value
        case None => List(None)
      }})
  }

  val result: ListOpt[String] = for {
    user <- ListOpt(repository.getUsersOption)
    addres <- ListOpt(repository.getAddressesOption(user))
  } yield addres.city

  Thread.sleep(1000)
  println(s"City: $result")

}
