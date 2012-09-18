import sbt._
import sbt.Keys._
import com.typesafe.sbtscalariform.ScalariformPlugin._

object Build extends Build {

  lazy val scalatrain = Project(
    "scalatrain",
    file("."),
    settings = 
      Defaults.defaultSettings ++
      scalariformSettings ++
      Seq(
        organization := "com.typesafe.training",
        version := "2.0.0",
        scalaVersion := "2.10.0-M7",
        scalacOptions ++= Seq("-unchecked", "-deprecation", "-language:postfixOps"),
        libraryDependencies ++= Seq(
          // Fill in dependencies later
        ),
        retrieveManaged := true,
        initialCommands in console := "import com.typesafe.training.scalatrain._"
      )
  )
}
