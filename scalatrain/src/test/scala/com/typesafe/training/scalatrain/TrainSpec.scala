package com.typesafe.training.scalatrain

import org.specs2.mutable.Specification
import TestData._

class TrainSpec extends Specification {
  "Train" should {
    "contain at least two stations" in {
      Train(StockholmExpress(1), Seq(Time() -> Station("STOCK"))) must throwAn[IllegalArgumentException]
    }
    "contain all the stations in schedule" in {
      //LULEA_YSTAD.stations.size must equalTo(2)
      todo
    }
    "verify to from JSON" in {
      val t = Time(1, 3)
      val json = t.toJson
      val newT = Time.fromJson(json).get
      t must equalTo(newT)
    }
  }
}