package chapter2

object FibonnacciSeries {
  def main(args: Array[String]) {
      println(s">>>>>>>>>>>>>>>>> Without Tal Rec: ${withoutTailRecursion(10)}")
      println(s">>>>>>>>>>>>>>>>> With Tal Rec: ${fib(10)}")
  }

  def withoutTailRecursion(n: Int): Int = {
    var (prev, current, counter) = (0, 1, 0)
    if(n == prev || n == current) n
    while(counter < n) {
      val c = prev + current
      prev = current
      current = c
      counter = counter + 1
    }
    prev
  }

  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(prev: Int, current: Int, counter: Int): Int = {
      if(counter == 0) current
      else loop(current, current + prev, counter - 1)
    }
    if(n == 0 || n == 1) n else loop(0, 1, n - 1)
  }
}
