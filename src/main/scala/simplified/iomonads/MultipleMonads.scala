package simplified.iomonads

import cats.effect.IO
import simplified.lib.StateV2


object MultipleMonads extends App {

  /**
    * StateV2 code
    */
  type Stack = List[String]
  def push(x: String): StateV2[Stack, Unit] = StateV2[Stack, Unit] {
    xs => (x :: xs, ())
  }

  /**
    * IO functions
    */
  def getLine: IO[String] = IO(scala.io.StdIn.readLine())
  def putStrLn(s: String): IO[Unit] = IO(println(s))

  /**
    * main loop: Prompt a user for some input, then push that input
    * onto a stack
    */
 /* val res = for {
    _     <- putStrLn("Type anything:")   //IO
    input <- getLine                      //IO
    _     <- push(input)                  //StateV2
    _     <- putStrLn(s"Input: $input")   //IO
  } yield ()*/

  /*putStrLn("Type anything:").flatMap { _ => // Unit => IO
   getLine.flatMap { input =>  // String => IO
     push(input).flatMap { _ => // Unit => StateV2

     }
   }
  }*/
}
