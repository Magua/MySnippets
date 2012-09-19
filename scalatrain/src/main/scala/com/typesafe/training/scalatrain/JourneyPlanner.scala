package com.typesafe.training.scalatrain

class JourneyPlanner(trains: Set[Train]) {
  val stations: Set[Station] = trains.flatMap(_.stations)
  def trainsAt(station: Station) = trains.filter(_.stations.contains(station))
  def isShortTrip(from: Station, to: Station): Boolean = {
    trains.exists(t => t.stations.dropWhile(s => s != from) match {
      case `from` +: _ +: `to` +: _ => true
      case `from` +: `to` +: _ => true
      case _ => false
    })
  }
  def stopsAt(station: Station): Set[(Time, Train)] = {
    //    trains.filter(t => t.stations match {
    //      case `station` => true
    //      case _ => false
    //    })

    for {
      t <- trains
      (time, st) <- t.schedule if (st == station)
    } yield (time, t)
  }

}