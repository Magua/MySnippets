package com.typesafe.training.scalatrain

object Time {
  def fromMinutes(minutes: Int): Time =
    new Time(minutes / 60, minutes % 60)
}

case class Time(hours: Int = 0, minutes: Int = 0) {
  require(hours >= 0 && 23 >= hours, "invlid hours '" + hours + "'")
  require(minutes >= 0 && 59 >= minutes, "invlid minutes '" + minutes + "'")
  val asMinutes: Int = hours * 60 + minutes
  def minus(t: Time) = asMinutes - t.asMinutes
  def -(t: Time) = minus(t)
}