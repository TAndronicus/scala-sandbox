import enumeratum.{Enum, EnumEntry}

import scala.collection.immutable

object EnumsTry {

  def main(args: Array[String]): Unit = {
    println(Planet.Earth > Planet.Mercury)
    println(Planet.withName("Venus"))
    println(Planet.values)
    println(exhaustive(Planet.Venus))
    println(nonExhaustive(NativeBetterPlanet.Mars))
    println(shouldBeExhaustive(BetterPlanet.Mars))
  }

  def exhaustive(v: Planet.Value): String =
    v match {
      case Planet.Venus => "Woman"
      case Planet.Mars => "Man"
    }

  def nonExhaustive(v: NativeBetterPlanet.Planet): String =
    v match {
      case NativeBetterPlanet.Venus => "Woman"
      case NativeBetterPlanet.Mars => "Man"
    }

  def shouldBeExhaustive(v: BetterPlanet): String =
    v match {
      case BetterPlanet.Venus => "Woman"
      case BetterPlanet.Mars => "Man"
    }

}

sealed abstract class BetterPlanet(mass: Double, radius: Double) extends EnumEntry {
  def fieldOnSurface: Double = 6.67e-11 * mass / Math.pow(radius, 2)
}
object BetterPlanet extends Enum[BetterPlanet] {
  val values: immutable.IndexedSeq[BetterPlanet] = findValues
  case object Mercury extends BetterPlanet(3.303e+23, 2.4397e6)
  case object Venus extends BetterPlanet(4.869e+24, 6.0518e6)
  case object Earth extends BetterPlanet(5.976e+24, 6.37814e6)
  case object Mars extends BetterPlanet(6.421e+23, 3.3972e6)
  case object Jupiter extends BetterPlanet(1.9e+27, 7.1492e7)
  case object Saturn extends BetterPlanet(5.688e+26, 6.0268e7)
  case object Uranus extends BetterPlanet(8.686e+25, 2.5559e7)
  case object Neptune extends BetterPlanet(1.024e+26, 2.4746e7)
}

object NativeBetterPlanet {
  sealed abstract class Planet (mass: Double, radius: Double) {
    def fieldOnSurface: Double = 6.67e-11 * mass / Math.pow(radius, 2)
  }

  case object Mercury extends Planet(3.303e+23, 2.4397e6)
  case object Venus extends Planet(4.869e+24, 6.0518e6)
  case object Earth extends Planet(5.976e+24, 6.37814e6)
  case object Mars extends Planet(6.421e+23, 3.3972e6)
  case object Jupiter extends Planet(1.9e+27, 7.1492e7)
  case object Saturn extends Planet(5.688e+26, 6.0268e7)
  case object Uranus extends Planet(8.686e+25, 2.5559e7)
  case object Neptune extends Planet(1.024e+26, 2.4746e7)
}

object Planet extends Enumeration {

  protected case class Val(mass: Double, radius: Double) extends super.Val {
    def surfaceGravity: Double = Planet.G * mass / (radius * radius)

    def surfaceWeight(otherMass: Double): Double = otherMass * surfaceGravity
  }

  val G: Double = 6.67300E-11
  val Mercury: Val = Val(3.303e+23, 2.4397e6)
  val Venus: Val = Val(4.869e+24, 6.0518e6)
  val Earth: Val = Val(5.976e+24, 6.37814e6)
  val Mars: Val = Val(6.421e+23, 3.3972e6)
  val Jupiter: Val = Val(1.9e+27, 7.1492e7)
  val Saturn: Val = Val(5.688e+26, 6.0268e7)
  val Uranus: Val = Val(8.686e+25, 2.5559e7)
  val Neptune: Val = Val(1.024e+26, 2.4746e7)
}
