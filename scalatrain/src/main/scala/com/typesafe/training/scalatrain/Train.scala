package com.typesafe.training.scalatrain

case class Train(kind: String, number: Int, schedule: Seq[(Time, Station)]) {
  val stations: Seq[Station] = schedule.map(_._2)
  require(!schedule.drop(1).isEmpty, "shedule must contain at least two stations")

  // TODO  Verify that schedule is strictly increasing in time
}
