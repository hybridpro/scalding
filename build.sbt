import AssemblyKeys._

name := "scalding"

version := "0.3.5"

organization := "com.twitter"

scalaVersion := "2.8.1"

resolvers += "Concurrent Maven Repo" at "http://conjars.org/repo"

libraryDependencies += "cascading" % "cascading-core" % "2.0.0-wip-238"

libraryDependencies += "cascading" % "cascading-local" % "2.0.0-wip-238"

libraryDependencies += "cascading" % "cascading-hadoop" % "2.0.0-wip-238"

libraryDependencies += "cascading.kryo" % "cascading.kryo" % "0.2.1"

libraryDependencies += "com.twitter" % "meat-locker" % "0.1.6"

libraryDependencies += "commons-lang" % "commons-lang" % "2.4"

libraryDependencies += "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5" % "test"

parallelExecution in Test := false

seq(assemblySettings: _*)

// Janino includes a broken signature, and is not needed:
excludedJars in assembly <<= (fullClasspath in assembly) map { cp =>
  cp filter {_.data.getName == "janino-2.5.16.jar"}
}
