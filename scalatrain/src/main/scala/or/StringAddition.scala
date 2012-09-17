package or

class StringAddition(thisString: String) {
  private val OVERFLOW_INDICATOR = "<"
  private def overflow(s: String) = s.startsWith(OVERFLOW_INDICATOR)
  private def toInt(c: Char) = (c + "").toInt
  private def tion(thatString: String, f: (String, Tuple2[Char, Char]) => String) = {
    thisString.reverse.zipAll(thatString.reverse, '0', '0').foldLeft("") { f(_, _) }
  }
  def minus(thatString: String) = {
    val subtrac = (s: String, n: Tuple2[Char, Char]) => {
      val o = if (overflow(s)) s.substring(2, 3).toInt else 0
      println("o" + o)
      val newS = if (overflow(s)) s.substring(3) else s
      println("newS" + newS)
      val sum = toInt(n._1) - toInt(n._2) - o
      println("sum" + sum)
      if (sum >= 0)
        sum + newS
      else
        OVERFLOW_INDICATOR + sum + newS
    }
    val result = tion(thatString, subtrac)
    if (overflow(result)) result.substring(1) else result
  }
  def plus(thatString: String) = {
    val result = thisString.view.reverse.zipAll(thatString.view.reverse, '0', '0').foldLeft("") { (s, n) =>
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