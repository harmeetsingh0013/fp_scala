package simplified.forexpression

case class CustomWrapper[A](elem: A) {
  def map[B](f: A => B): CustomWrapper[B] = {
    val temp = f(elem)
    CustomWrapper(temp)
  }

  def flatMap[B] (f: A => CustomWrapper[B]): CustomWrapper[B] = {
    f(elem)
  }
}