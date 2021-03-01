import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{Directives, Route}
import sttp.tapir._
import sttp.tapir.server
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter

import scala.concurrent.Future
import scala.util.Success

object TapirTry {

  val unitEndpont: Endpoint[Unit, Unit, String, Any] = endpoint
    .get
    .in("unit")
    .out(stringBody)

  val pathVar: Endpoint[String, Unit, String, Any] = endpoint
    .get
    .in("path" / path[String]("name"))
    .out(stringBody)

  def main(args: Array[String]): Unit = {
    implicit val actorSystem = ActorSystem()
    import actorSystem.dispatcher
    val unitRoute: Route = AkkaHttpServerInterpreter.toRoute(unitEndpont) { _ =>
      Future(Right("Hello stranger"))
    }
    val pathVarRoute = AkkaHttpServerInterpreter.toRoute(pathVar) { name =>
      Future(Right(s"Hello $name"))
    }
    val futureBinding = Http()
      .newServerAt("localhost", 8080)
      .bind(Directives.concat(unitRoute, pathVarRoute))
  }

}
