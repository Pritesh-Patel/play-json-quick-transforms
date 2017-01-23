name := "play-json-quick-transforms"

version := "1.0.2"

scalaVersion := "2.11.1"

organization := "priteshpatel"

crossScalaVersions := Seq("2.11.8","2.10.6")

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" % "play-json_2.11" % "2.5.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
    