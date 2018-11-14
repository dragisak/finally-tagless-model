name := "finally-tagless-model"

version := "0.1"

scalaVersion := "2.12.7"

val http4sVersion = "0.20.0-M3"
val circeVersion = "0.10.1"


libraryDependencies ++= List(
  "org.typelevel" %% "cats-core" % "1.4.0",
  "org.typelevel" %% "cats-mtl-core" % "0.4.0",
  "org.typelevel" %% "cats-effect" % "1.0.0",
  "io.monix" %% "monix" % "3.0.0-RC2",
  "io.circe" %% "circe-generic" % circeVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7")

scalacOptions ++= List(
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Ypartial-unification"              // Enable partial unification in type constructor inference
)
