name := "scala-sandbox"

version := "0.1"

scalaVersion := "2.12.13"

semanticdbEnabled := true
semanticdbVersion := scalafixSemanticdb.revision

libraryDependencies += "com.twitter" %% "util-core" % "21.1.0"
//libraryDependencies += "com.twitter" %% "summingbird-core" % "0.9.1" // requires scala 2.11 or lower
libraryDependencies += "dev.zio" %% "zio" % "1.0.4-2"
libraryDependencies += "dev.zio" %% "zio-streams" % "1.0.4-2"
libraryDependencies += "org.atnos" %% "eff" % "5.14.0"
libraryDependencies += "com.beachape" %% "enumeratum" % "1.6.1"
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"
libraryDependencies += "com.softwaremill.common" %% "tagging" % "2.2.1"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-core" % "0.17.13"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.1"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.10"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.10"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server" % "0.17.13" exclude("com.typesafe.akka", "akka-stream_2.12")
libraryDependencies += "eu.timepit" %% "refined" % "0.9.22"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.full)

scalacOptions ++= List(
  "-Ypartial-unification",
  "-Yrangepos",
  "-Ywarn-unused-import"
)

