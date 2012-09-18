package com.typesafe.training.scalatrain

class JourneyPlanner(trains: Set[Train]) {
  val stations: Set[Station] = trains.flatMap(_.stations)
  def trainsAt(station: Station) = trains.filter(_.stations.contains(station))
}