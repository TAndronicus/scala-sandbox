import scala.util.{Failure, Success, Try}

object ScalaTry {

  def main(args: Array[String]): Unit = {
    Array(Try(1), Try(1 / 0))
    .foreach {
      case Success(value) => println(s"Success: $value")
      case Failure(exception) => println(s"Exception: ${exception.getMessage}")
    }
  }

}
