package com.typesafe.training.scalatrain

import org.specs2.mutable.Specification

class TrainSpec extends Specification {
  "Train" should {
    "contain at least two stations" in {
      Train("Big", 1, Seq(Time() -> Station("STOCK"), Time() -> Station("GOTH"))) // Ok
      Train("Big", 1, Seq(Time() -> Station("STOCK"))) must throwAn[IllegalArgumentException]
    }
    "contain all the stations in schedule" in {
      val t = Train("Big", 1, Seq(Time() -> Station("STOCK"), Time() -> Station("GOTH")))
      t.stations.size must equalTo(2)
    }
  }
}