package magua.immutable

object Tree {
}
case class Tree(k: String, v: Option[String] = None, p: Option[Tree] = None, c: Option[List[Tree]] = None) {
  implicit def augmentString(x: String): Tree = Tree(x)
  
  def /(k: String): Tree = {
    val a: List[String] = k.split("\\.").toList
    this / a
  }
  def /(a: List[String]): Tree = {
    println(a)
    val b = c.find(a.head == _).getOrElse(throw new RuntimeException(k + " '" + a.head + "' not found in tree")).head
    if (a.length > 1) {
      b / a.tail
    }
    else {
      b
    }
  }
  def ++(k: String): Tree = {
    this ++ (k, None)
  }
  def ++(k: String, v: Option[String]): Tree = {
    this ++ (k.split("\\.").toList, v)
  }
  def ++(a: List[String], v: Option[String]): Tree = {
    if (a.length > 1) {
      val n = this ++ (a.tail, v)
      println("called with a.tail=" + a.tail + " return n=" + n)
      new Tree(k=a.head, c=Some(List(n)), v=v, p=Some(this))
    }
    else {
      Tree(k=a.head, v=v, p=Some(this))
    }
  }
  def toTreeString() {
    def toTreeString(level: Int, tree: Tree) {
      
    }
  }
  def ===(v: String) = Tree(k, Some(v))
  def ===(v: (String, String)) = Tree(v._1, Some(v._2))
}