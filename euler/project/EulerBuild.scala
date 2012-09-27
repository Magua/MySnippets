import sbt._
import sbt.Keys._

object EulerBuild extends Build {

  lazy val euler = Project(
    id = "euler",
    base = file("."),
    settings = Project.defaultSettings ++
      scalariformSettings ++
      Seq(
      name := "euler",
      organization := "or",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"))
}
