name := "ec4"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies += "com.typesafe" % "config" % "1.3.4"
libraryDependencies += "com.github.seratch" %% "awscala-ec2" % "0.8.+"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.0"
)
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"
