import zio.{Runtime, UIO, ZIO}
import zio.console._

import java.io.IOException

object ZioTry {

  def main(args: Array[String]): Unit = {
    val program: ZIO[Console, IOException, Int] = for {
      _ <- putStrLn("Index of Fibbonaci number")
      num <- getStrLn.map(_.toInt)
      fib <- fib(num)
      _ <- putStrLn(s"$num Fibbonaci number is $fib")
    } yield fib
    Runtime.default.unsafeRun(program)
  }

  def fib(n: Int): UIO[Int] = {
    if (n == 1 || n == 2) ZIO.succeed(1)
    else fib(n - 1).zipWith(fib(n - 2))(_ + _)
  }

}
