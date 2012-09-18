package com.typesafe.training.scalatrain

import org.specs2.mutable.Specification
import TestData._

class JourneyPlannerSpec extends Specification {
  "Journeyplanner" should {
    "contain a list of all the trains stations" in {
      new JourneyPlanner(ALL_TRAINS).stations must equalTo(ALL_STATIONS)
    }
    "find all trains that contain a given station" in {
      val jp = new JourneyPlanner(ALL_TRAINS)
      jp.trainsAt(LULEA) must equalTo(ALL_TRAINS)
      jp.trainsAt(MALMO) must equalTo(Set(LULEA_YSTAD, LULEA_MALMO))
      jp.trainsAt(YSTAD) must equalTo(Set(LULEA_YSTAD))
    }
  }
}