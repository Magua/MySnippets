package com.typesafe.training.scalatrain

import org.specs2.mutable.Specification
import TestData._

class JourneyPlannerSpec extends Specification {
  "Journeyplanner" should {
    "contain a list of all the trains stations" in {
      val t1 = Train("Big", 1, Seq(Time() -> STOCKHOLM, Time() -> GOTHENBURG))
      val t2 = Train("Big", 1, Seq(Time() -> MALMO, Time() -> LULEA))
      val jp = new JourneyPlanner(Set(t1, t2))
      jp.stations must equalTo(Set(STOCKHOLM, GOTHENBURG, MALMO, LULEA))
    }
    "find all trains that contain a given stations" in {
      val t1 = Train("Big", 1, Seq(Time() -> STOCKHOLM, Time() -> GOTHENBURG))
      val t2 = Train("Big", 1, Seq(Time() -> MALMO, Time() -> LULEA))
      val jp = new JourneyPlanner(Set(t1, t2))
      jp.trainsAt(STOCKHOLM) must equalTo(Set(t1))
      jp.trainsAt(MALMO) must equalTo(Set(t2))
    }
  }
}