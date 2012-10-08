import sbt._
import sbt.Keys._

object LinearalgebraBuild extends Build {

  lazy val linearalgebra = Project(
    id = "linearalgebra",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "LinearAlgebra",
      organization := "or",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
}
