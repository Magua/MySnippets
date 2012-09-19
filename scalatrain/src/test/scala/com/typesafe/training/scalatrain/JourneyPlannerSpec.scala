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
    "find all trains that stops at a given station" in {
      val jp = new JourneyPlanner(ALL_TRAINS)
      jp.stopsAt(YSTAD)
      jp.stopsAt(YSTAD) must equalTo(Set(
        LULEA_YSTAD.schedule.filter(_._2 == YSTAD).head._1 ->
          LULEA_YSTAD))
    }
    "find isShortTrip" in {
      val jp = new JourneyPlanner(ALL_TRAINS)
      jp.isShortTrip(LULEA, STOCKHOLM) must equalTo(true)
      jp.isShortTrip(LULEA, GOTHENBURG) must equalTo(true)
      jp.isShortTrip(LULEA, MALMO) must equalTo(false)
      jp.isShortTrip(LULEA, YSTAD) must equalTo(false)
    }
  }
}