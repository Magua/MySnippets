package or

import org.specs2.mutable._
import scala.annotation.tailrec
import scala.Iterator._
import java.io.IOException
import scala.collection.mutable.ListBuffer

class EulerTest011 extends Specification {
  val grid = List(
    8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8,
    /*19*/ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00,
    81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65,
    52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91,
    22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80,
    24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50,
    32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70,
    67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21,
    24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,
    /*Y*/ 21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95,
    78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92,
    16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57,
    86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58,
    19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40,
    04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,
    88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69,
    04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36,
    20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16,
    20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54,
    01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48).grouped(20).toList.reverse
  /*0*/ /*X*/ /*19*/
  object Direction extends Enumeration {
    type Direction = Value
    val Up, Right, DiagonalyRight, DiagonalyLeft = Value
  }
  import Direction._
  def exist(grid: List[List[Int]], xy: Point, length: Int, direction: Direction) = {
    try {
      get(grid, xy)
      direction match {
        case d => get(grid, getDestination(grid, xy, length, d))
      }
      true
    } catch {
      case e: IndexOutOfBoundsException => {
        println("x, y " + xy + direction + " does not exist")
        false
      }
    }
  }
  def product(grid: List[List[Int]], xy: Point, length: Int, direction: Direction) = {
    try {
      getList(grid, xy, length, direction).foldLeft(1)((n, xy) => n * get(grid, xy))
    } catch {
      case e: Exception => 0
    }
  }
  def get(grid: List[List[Int]], xy: Point) = grid(xy.y)(xy.x)
  def getDestination(grid: List[List[Int]], xy: Point, length: Int, direction: Direction) = {
    direction match {
      case Right => Point(xy.x + length, xy.y)
      case Up => Point(xy.x, xy.y + length)
      case DiagonalyRight => Point(xy.x + length, xy.y + length)
      case DiagonalyLeft => Point(xy.x - length, xy.y + length)
    }
  }
  def getList(grid: List[List[Int]], xy: Point, length: Int, direction: Direction) = {
    val list = new ListBuffer[Point]() += xy
    for (i <- 1 to length) list += getDestination(grid, xy, i, direction)
    list.toList
  }
  def greatestProductFromPoint(grid: List[List[Int]], xy: Point, length: Int) =
    Direction.values.foldLeft(0)((p, d) => p max product(grid, xy, length - 1, d))
  def greatestProduct(grid: List[List[Int]], length: Int) = {
    val xLen = grid.size
    val yLen = grid(0).size
    @tailrec def gpReq(xy: Point, gP: Int): Int = {
      xy match {
        case Point(x, y) if Point(x, y).equals(Point(xLen, yLen)) => gP
        case Point(x, y) if y < yLen => gpReq(Point(x, y + 1), gP max greatestProductFromPoint(grid, Point(x, y + 1), length))
        case Point(x, y) if x < xLen => gpReq(Point(x + 1, 0), gP max greatestProductFromPoint(grid, Point(x + 1, 0), length))
      }
    }
    gpReq(Point(0, 0), greatestProductFromPoint(grid, Point(0, 0), length))
  }
  "What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 20×20 grid?" should {
    "verify a few grid locations" in {
      get(grid, Point(0, 0)) must equalTo(1)
      get(grid, Point(2, 7)) must equalTo(0)
      get(grid, Point(19, 19)) must equalTo(8)
    }
    "verify exist method" in {
      exist(grid, Point(0, 0), 19, Up) must equalTo(true)
      exist(grid, Point(2, 19), 4, Right) must equalTo(true)
      exist(grid, Point(16, 16), 3, DiagonalyRight) must equalTo(true)
      exist(grid, Point(2, 19), 1, Up) must equalTo(false)
      exist(grid, Point(17, 16), 3, Right) must equalTo(false)
    }
    "verify getDestination method" in {
      getDestination(grid, Point(0, 0), 4, Up) must equalTo(Point(0, 4))
      getDestination(grid, Point(0, 0), 4, DiagonalyRight) must equalTo(Point(4, 4))
      getDestination(grid, Point(0, 0), 4, Right) must equalTo(Point(4, 0))
      getDestination(grid, Point(0, 0), 4, DiagonalyLeft) must equalTo(Point(-4, 4))
    }
    "verify getList method" in {
      getList(grid, Point(0, 0), 1, Up) must equalTo(List(Point(0, 0), Point(0, 1)))
      getList(grid, Point(0, 0), 1, DiagonalyRight) must equalTo(List(Point(0, 0), Point(1, 1)))
      getList(grid, Point(0, 0), 1, Right) must equalTo(List(Point(0, 0), Point(1, 0)))
    }
    "verify product method" in {
      product(grid, Point(0, 0), 3, Up) must equalTo(1600)
      product(grid, Point(0, 0), 1, DiagonalyRight) must equalTo(73)
      product(grid, Point(0, 0), 1, Right) must equalTo(70)
      product(grid, Point(3, 0), 3, DiagonalyLeft) must equalTo(685860)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(1, 10),
        List(6, 8))
      greatestProduct(g, 2) must equalTo(80)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(1, 10, 3),
        List(6, 8, 4),
        List(7, 5, 9))
      greatestProduct(g, 2) must equalTo(80)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(2, 1, 1, 1),
        List(1, 2, 1, 1),
        List(1, 1, 2, 1),
        List(1, 1, 1, 2))
      greatestProduct(g, 4) must equalTo(16)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(2, 1, 1, 1),
        List(2, 1, 1, 1),
        List(2, 1, 1, 1),
        List(2, 1, 1, 1))
      greatestProduct(g, 4) must equalTo(16)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(1, 1, 1, 1),
        List(1, 1, 1, 1),
        List(1, 1, 1, 1),
        List(2, 2, 2, 2))
      greatestProduct(g, 4) must equalTo(16)
    }
    "verify greatest product in the grid" in {
      val g = List(
        List(1, 1, 1, 2),
        List(1, 1, 1, 2),
        List(1, 1, 1, 2),
        List(1, 1, 1, 2))
      greatestProduct(g, 4) must equalTo(16)
    }
    "verify greatest product in the grid" in {
      greatestProduct(grid, 4) must equalTo(70600674)
    }
  }
}
case class Point(x: Int, y: Int)