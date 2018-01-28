package simplified.iomonads

import java.io.File

import cats.effect.IO
import org.apache.commons.io.FileUtils

object IOMonad4 extends App {

  def fileReader(file: String) = IO { FileUtils.readFileToString(new File(file), "utf-8") }

  def program: IO[Unit] = for {
    file <- fileReader("/home/harmeet/cassandra-backup-dcos-commands")
  } yield println(file)

  program.unsafeRunSync()
}
