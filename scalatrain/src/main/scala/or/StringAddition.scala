package or

class StringAddition(thisString: String) {
  val OVERFLOW_INDICATOR = "<"
  def stringPlus(i: String): String = "2"
  def overflow(s: String) = s.startsWith(OVERFLOW_INDICATOR)
  def toInt(c: Char) = (c + "").toInt
  def plus(thatString: String) = {
    val result = thisString.reverse.zipAll(thatString.reverse, '0', '0').foldLeft("") { (s, n) =>
      {
        val o = if (overflow(s)) s.substring(1, 2).toInt else 0
        val newS = if (overflow(s)) s.substring(2) else s
        val sum = toInt(n._1) + toInt(n._2) + o
        if (sum < 10)
          sum + newS
        else
          OVERFLOW_INDICATOR + sum + newS
      }
    }
    if (overflow(result)) result.substring(1) else result
  }
}