package com.typesafe.training.scalatrain

sealed abstract class TrainInfo {
  def number: Int
}
case class StockholmExpress(number: Int,
  hasWifi: Boolean = false) extends TrainInfo
case class GothenburgExpress(number: Int) extends TrainInfo
case class MalmoExpress(number: Int) extends TrainInfo
case class YstadExpress(number: Int) extends TrainInfo
