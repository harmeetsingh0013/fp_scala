package simplified.iomonads

import cats.effect.IO

import scala.util.{Failure, Success, Try}
import simplified.lib.Control._

object IOMonad3 extends App {

  def readTextFileAsTry(filename: String): IO[Try[List[String]]] = {
    IO {
      Try {
        val lines = using(io.Source.fromFile(filename)) { source =>
          (for (line <- source.getLines) yield line).toList
        }
        lines
      }
    }
  }

//  val passwdFile = readTextFileAsTry("/etc/passwd-foo")

  /*for {
    tryy <- readTextFileAsTry("/etc/passwd-foo")
    lines <- tryy.toOption
  } yield lines.foreach(println)
*/
  /*passwdFile match {
    case Success(lines) => lines.foreach(println)
    case Failure(s) => println(s"Failed, message is: $s")
  }*/
}
