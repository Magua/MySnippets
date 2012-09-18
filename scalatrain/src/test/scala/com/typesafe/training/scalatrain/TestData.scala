package com.typesafe.training.scalatrain

object TestData {
  val LULEA = Station("Lulea")
  val STOCKHOLM = Station("Stockholm")
  val GOTHENBURG = Station("Gothenburg")
  val MALMO = Station("Malmo")
  val YSTAD = Station("Ystad")
  val LULEA_STOCKHOLM = Train("Lulea-Stockholm", 1, Seq(
    Time(7, 0) -> LULEA, Time(17, 0) -> STOCKHOLM))
  val LULEA_GOTHENBURG = Train("Lulea-Gothenburg", 2, Seq(
    Time(7, 5) -> LULEA,
    Time(17, 0) -> STOCKHOLM,
    Time(20, 0) -> GOTHENBURG))

}