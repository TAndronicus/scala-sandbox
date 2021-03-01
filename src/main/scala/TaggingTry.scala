import com.softwaremill.tagging.{@@, Tagger}

class Gram

class KiloGram

object TaggingTry {

  implicit def gram2kilogram(value: Double @@ Gram): Double @@ KiloGram = (.001 * value).taggedWith[KiloGram]

  implicit def kilogram2gram(value: Double @@ KiloGram): Double @@ Gram = (1000 * value).taggedWith[Gram]

  def main(args: Array[String]): Unit = {
    val weight = 77.4.taggedWith[KiloGram]
    gramPrintLn(weight)
  }

  def gramPrintLn(value: Double @@ Gram): Unit = println(s"$value gram")

}
