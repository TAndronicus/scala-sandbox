import cats.effect.IO
import fs2.Stream

object Fs2Try {

  def main(args: Array[String]): Unit = {
    val res = Stream.eval(IO {
      println("some effect"); 1
    })
      .filter(_ => false)
      .compile.toList.unsafeRunSync()
    println(res)
  }

}
