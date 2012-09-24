package or

import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec

class EulerTest018 extends Specification {



  "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total" should {
val smallTriangle = """3
7 4
2 4 6
8 5 9 3"""
val bigTriangle = """75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"""
lazy val hugeTriangle = {
  val source = io.Source.fromURL(getClass.getResource("/euler67triangle.txt"))
  val ll = source.getLines.toList
  source.close
  ll
}

  def maxValuePath(triangleS: String): Int = {
    maxValuePathList(triangleS.split("\\n").toList)
  }
  def maxValuePathList(triangle: List[String]): Int = {
    val l = triangle.reverse.map(_.split(" ").toList.map(_.toInt))
    val size = l.size
    def rec(current: List[Int], i: Int): Int = {
      if (current.size == 1)
        current(0)
      else {
        val newList = l(i).view.zipWithIndex.map(t => t._1 + (current(t._2) max current(t._2 + 1))).force.toList
        rec(newList, i + 1)
      }

    }
    rec(l.head, 1)
  }

    "If all the numbers from 1 to 1000 (one thousand) inclusive were written out" in {
      maxValuePath(smallTriangle) must equalTo(23)
      maxValuePath(bigTriangle) must equalTo(1074)
      maxValuePathList(hugeTriangle) must equalTo(7273)
    }
  }
}
