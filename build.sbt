name := "scala-sandbox"

version := "0.1"

scalaVersion := "2.12.12"

semanticdbEnabled := true
semanticdbVersion := scalafixSemanticdb.revision

libraryDependencies += "com.twitter" %% "util-core" % "21.1.0"
//libraryDependencies += "com.twitter" %% "summingbird-core" % "0.9.1"
libraryDependencies += "dev.zio" %% "zio" % "1.0.4-2"
libraryDependencies += "dev.zio" %% "zio-streams" % "1.0.4-2"
libraryDependencies += "org.atnos" %% "eff" % "5.14.0"
libraryDependencies += "com.beachape" %% "enumeratum" % "1.6.1"
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"
libraryDependencies += "com.softwaremill.common" % "tagging_2.11" % "2.2.1"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.full)

scalacOptions ++= List(
  "-Ypartial-unification",
  "-Yrangepos",
  "-Ywarn-unused-import"
)

