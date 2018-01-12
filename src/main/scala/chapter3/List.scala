package chapter3

sealed trait List[+A] // + operator means, it will allow to cast in sub class
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = {
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def tail[A](list: List[A]): List[A] = list match {
    case Nil => list
    case Cons(_, xs) => xs
  }

  def setHead[A](elem: A, list: List[A]): List[A] = list match {
    case Nil => Cons(elem, Nil)
    case Cons(_, xs) => Cons(elem, xs)
  }

  @annotation.tailrec
  def drop[A](l: List[A], n: Int): List[A] = {
    if(n == 0) l
    else l match {
      case Nil => sys.error("List is empty")
      case Cons(_, xs) => drop(xs, n - 1)
    }
  }

  //TODO
  // def dropWhile[A](a1: List[A], f: A => Boolean): List[A] = {
  //   @annotation.tailrec
  //   def loop(temp: List[A], newList: List[A]): List[A] = a1 match {
  //     case Cons(x, xs) if(f(x)) =>  loop(xs, newList)
  //     case Cons(x, xs) => println("*");loop(xs, Cons(x, newList));
  //   }
  //   loop(a1, Nil)
  // }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => l
    case Cons(_, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }
}
