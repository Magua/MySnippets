

package com.typesafe.training.scalatrain

import org.specs2.mutable.Specification

class TimeTest extends Specification {
  "Time" should {
    "report time in minutes " in {
      Time(1, 1).asMinutes must equalTo(61)
      Time(23, 59).asMinutes must equalTo(1439)
    }
    "have a working minus method" in {
      Time(1, 1) minus Time(1, 1) must equalTo(0)
      Time(23, 59) minus Time(23, 58) must equalTo(1)
    }
    "have a working - method" in {
      Time(1, 1) - Time(1, 1) must equalTo(0)
      Time(23, 59) - Time(23, 0) must equalTo(59)
    }
    "have working default arguments" in {
      Time(1) must equalTo(Time(1, 0))
      Time(minutes = 59) must equalTo(Time(0, 59))
    }
    "have working from minutes method" in {
      Time.fromMinutes(60) must equalTo(Time(1, 0))
      Time.fromMinutes(61) must equalTo(Time(1, 1))
      Time.fromMinutes(0) must equalTo(Time(0, 0))
      Time.fromMinutes(600) must equalTo(Time(10, 0))
    }
    "have constructor hours validation" in {
      Time(hours = 0) // ok
      Time(hours = 23) // ok
      Time(hours = -1) must throwAn[IllegalArgumentException]
      Time(hours = 24) must throwAn[IllegalArgumentException]
    }
    "have constructor minutes validation" in {
      Time(minutes = 0) // ok
      Time(minutes = 59) // ok
      Time(minutes = -1) must throwAn[IllegalArgumentException]
      Time(minutes = 60) must throwAn[IllegalArgumentException]
    }
    "have constructor minutes validation" in {
      Time(1, 1).toString must equalTo("01:01")
    }
    "have correct order" in {
      Time(1, 1) < Time(2, 2) must equalTo(true)
      Time(3, 3) > Time(2, 2) must equalTo(true)
      Time(3, 3) compareTo Time(3, 3) must equalTo(0)
    }
  }
}