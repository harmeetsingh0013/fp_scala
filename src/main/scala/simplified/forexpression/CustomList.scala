package simplified.forexpression

import scala.collection.mutable.ArrayBuffer

case class CustomList[A](elements: A*) {

  val elems = new ArrayBuffer[A]
  elems ++= elements

  def foreach(c: A => Unit): Unit = {
    elems.foreach(c)
  }

  def map[B](f: A => B): CustomList[B] = {
    val temp = elems.map(f)
    CustomList(temp: _*)
  }

  def withFilter(p: A => Boolean): CustomList[A] = {
    val temp = elems.filter(p)
    CustomList(temp: _*)
  }

  def flatMap[B](f: A => CustomList[B]): CustomList[B] = {
    val temp = elems.map(f)
    flatternLike(temp)
  }

  def flatternLike[B](seq: Seq[CustomList[B]]): CustomList[B] = {
    val temp = new ArrayBuffer[B]
    for(i <- seq) {
      for(j <- i) {
        temp += j
      }
    }
    CustomList(temp: _*)
  }
}
