package or

class StringAddition(thisString: String) {
  private val OVERFLOW_INDICATOR = "<"
  private def overflow(s: String) = s.startsWith(OVERFLOW_INDICATOR)
  private def toInt(c: Char) = (c + "").toInt
  private def tion(thatString: String, f: (String, Tuple2[Char, Char]) => String) = {
    thisString.reverse.zipAll(thatString.reverse, '0', '0').foldLeft("") { f(_, _) }
  }
  def plus(thatString: String) = {
    val addi = (s: String, n: Tuple2[Char, Char]) => {
      val o = if (overflow(s)) s.substring(1, 2).toInt else 0
      val newS = if (overflow(s)) s.substring(2) else s
      val sum = toInt(n._1) + toInt(n._2) + o
      if (sum < 10)
        sum + newS
      else
        OVERFLOW_INDICATOR + sum + newS
    }
    val result = tion(thatString, addi)
    if (overflow(result)) result.substring(1) else result
  }
}