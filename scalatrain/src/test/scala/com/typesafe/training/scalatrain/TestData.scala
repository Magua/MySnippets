package com.typesafe.training.scalatrain

object TestData {
  val LULEA = Station("Lulea")
  val STOCKHOLM = Station("Stockholm")
  val GOTHENBURG = Station("Gothenburg")
  val MALMO = Station("Malmo")
  val YSTAD = Station("Ystad")

  val ALL_STATIONS = Set(LULEA, STOCKHOLM, GOTHENBURG, MALMO, YSTAD)

  val LULEA_STOCKHOLM = Train(StockholmExpress(1), Seq(
    Time(7, 0) -> LULEA,
    Time(17, 0) -> STOCKHOLM))
  val LULEA_GOTHENBURG = Train(GothenburgExpress(2), Seq(
    Time(7, 5) -> LULEA,
    Time(17, 5) -> STOCKHOLM,
    Time(20, 5) -> GOTHENBURG))
  val LULEA_MALMO = Train(MalmoExpress(3), Seq(
    Time(7, 10) -> LULEA,
    Time(17, 10) -> STOCKHOLM,
    Time(20, 10) -> GOTHENBURG,
    Time(22, 10) -> MALMO))
  val LULEA_YSTAD = Train(YstadExpress(4), Seq(
    Time(7, 15) -> LULEA,
    Time(17, 15) -> STOCKHOLM,
    Time(20, 15) -> GOTHENBURG,
    Time(22, 15) -> MALMO,
    Time(23, 15) -> YSTAD))
  val LULEA_YSTAD_INVALID_SEQUENCE = Train(YstadExpress(5), Seq(
    Time(17, 15) -> STOCKHOLM,
    Time(7, 15) -> LULEA,
    Time(20, 15) -> GOTHENBURG,
    Time(22, 15) -> MALMO,
    Time(23, 15) -> YSTAD))

  val ALL_TRAINS = Set(LULEA_STOCKHOLM, LULEA_GOTHENBURG, LULEA_MALMO, LULEA_YSTAD)
}