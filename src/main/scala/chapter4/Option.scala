package chapter4

sealed trait Option[+A]
case class Some[+A] (get: A) extends Option[A]
case object None extends Option[Nothing]

/*object Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case Some(a) => f(a)
    case _ => None
  }

  def flatMap_1[B](f: A => Option[B]): Option[B] = {
    map(f) getOrElse None
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case Some(a) => a
    case _ => default
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case Some(a) => this
    case _ => ob
  }

  def orElse_1[B >: A](ob: => Option[B]): Option[B] = {
    this getOrElse ob
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if (f(a)) => this
    case _ => None
  }

  def filter_1(f: A => Boolean): Option[A] = ???

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a.flatMap(av => b.flatMap(bv => f(av, bv)))
  }
}*/
