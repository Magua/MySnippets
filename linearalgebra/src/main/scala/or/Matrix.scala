package or

object Matrix {
  def fromString(s: String): Matrix = new Matrix(
    s.split("\n").toList.map(_.trim.split(",").toList.map(_.trim.toInt)))
}
class MatrixVector(val l: List[Int]) {
  def *(that:  List[Int]) = {
    print(l)
    print(" * ")
    print(that)
    print(" = ")
    val product = l.zip(that).map(xy => xy._1 * xy._2).foldLeft(0)(_ + _)
    println(product)
    product
  }
}
case class Matrix(m: List[List[Int]]) {
  implicit def matrixVector(l: List[Int]) = new MatrixVector(l)
  def colVector(i: Int): List[Int] = m.map(l => l(i))
  def rowVector(i: Int): List[Int] = m(i)
  def +(that: Matrix): Matrix = {
    this.zip(that, _ + _)
  }
  def -(that: Matrix): Matrix = {
    this.zip(that, _ - _)
  }
  def zip(that: Matrix, f: (Int, Int) => Int): Matrix = {
    new Matrix(m zip that.m map (z => z._1 zip z._2 map (i => f(i._1, i._2))))
  }
  def *(that: Matrix): Matrix = {
    val l = for {
      x <- 0 until this.m.size
      y <- 0 until that.m(0).size
    } yield this.rowVector(x) * that.colVector(y)
    println(l)
    new Matrix(l.toList.grouped(that.m(0).size).toList)
  }
}