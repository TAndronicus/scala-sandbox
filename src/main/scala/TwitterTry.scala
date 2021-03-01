import com.twitter.util.{Return, Throw, Try}

object TwitterTry {

  def main(args: Array[String]): Unit = {
    Array(Try(1), Try(1 / 0))
      .foreach {
        case Return(r) => println(s"Success: $r")
        case Throw(e) => println(s"Exception: ${e.getMessage}")
      }
  }

}
