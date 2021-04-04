import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.boolean.True
import eu.timepit.refined.numeric._

object RefinedTry {

  def main(args: Array[String]): Unit = {
    val i: Int Refined Positive = -5
    val t: Boolean Refined True = false
    println(t)
  }

}
