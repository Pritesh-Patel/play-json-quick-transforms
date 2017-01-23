name := "play-json-quick-transforms"

version := "1.0"

scalaVersion := "2.11.1"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" % "play-json_2.11" % "2.5.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
    