package com.typesafe.training.scalatrain

import scala.util.parsing.json.JSONObject
import scala.util.parsing.json.JSONObject
import scala.util.parsing.json.JSONObject

object Time {
  def fromMinutes(minutes: Int): Time =
    new Time(minutes / 60, minutes % 60)
  def fromJson(json: JSONObject): Option[Time] = {
    import scala.util.control.Exception.catching
    val hours = json.obj.get("hours").flatMap(
      catching(classOf[NumberFormatException]) opt _.toString.toInt)
    val minutes = json.obj.get("minutes").flatMap(
      catching(classOf[NumberFormatException]) opt _.toString.toInt)
    for {
      h <- hours
      m <- minutes
    } yield Time(h, m)
  }
}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {

  require(hours >= 0 && 23 >= hours, "invlid hours '" + hours + "'")
  require(minutes >= 0 && 59 >= minutes, "invlid minutes '" + minutes + "'")

  override def compare(other: Time) = minus(other)
  def toJson(): JSONObject = {
    JSONObject(Map("hours" -> hours, "minutes" -> minutes))
  }
  val asMinutes: Int = hours * 60 + minutes
  def minus(t: Time) = asMinutes - t.asMinutes
  def -(t: Time) = minus(t)
  override lazy val toString = f"$hours%02d:$hours%02d"
}