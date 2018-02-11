package usercases.mtransfomer

object Example5 extends App {

  val repository = new Repository

  case class WhateverOpt[W[_], A] (value: W[Option[A]]) {

    def map[B] (f: A => B) (implicit M: Monad[W]): WhateverOpt[W, B] =
      WhateverOpt(M.map(value)(_.map(f)))

    def flatMap[B] (f: A => WhateverOpt[W, B]) (implicit M: Monad[W]): WhateverOpt[W, B] =
      WhateverOpt(M.flatMap(value)(optA => optA match {
        case Some(v) => f(v).value
      }))
  }

  implicit val optionTMonad = new Monad[Option] {

    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
    override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
  }

  val optionResult = for {
    user <- WhateverOpt(repository.getUserOption(1))
    addres <- WhateverOpt(repository.getAddressOption(user))
  } yield addres.city

  Thread.sleep(1000)
  println(s"City: $optionResult")
}
