def map[A, B](f: A => B, seq: Seq[A]) = {
  for {
    x <- seq
  } yield f(x)
}

map((x: Int) => x + 2, List(1, 2, 3, 4, 5))

def filter[A](f: A => Boolean, seq: Seq[A]) = {
  for {
    x <- seq
    if(f(x))
  } yield x
}

filter((x: Int) => (x % 2 == 0), List(1, 2, 3, 4, 5))