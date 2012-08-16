package magua.immutable

import scala.collection.mutable.StringBuilder

object Tree {
}
case class Tree(k: String, v: Option[String] = None, c: List[Tree] = Nil, p: Option[Tree] = None) {
  implicit def augmentString(x: String): Tree = Tree(x)
  
  def addReplaceChild(child: Tree): Tree = {
    val newChild = child.copy(p=Some(this))
    val idx = c.indexWhere(_.k == newChild.k)
    val newMe = copy(c = if (idx != -1)
      c.patch(idx, Seq(newChild), 1)
    else
      c :+ newChild)
      
    rec(newMe)
  }
  def rec(newTree: Tree): Tree = {
    if (p.isDefined)
      p.get.addReplaceChild(newTree)
    else
      newTree
  }
  def addReplaceValue(value: String): Tree = {
      val newCopy = copy(v=Some(value))
      rec(newCopy.copy(c=c.map(_.copy(p=Some(newCopy)))))
  }
  private def toTreeStringP(level: Int, sb: String): String = {
    val s = sb + ("  " * level) + (if (p.isDefined) "*" else "") + (k + (if(v.isDefined) "=" + v.get else "")) + "\n"
    c.foldLeft(s)((nS, nT) => nT.toTreeStringP(level + 1, nS))
  }
  def toTreeString(): String = {
    toTreeStringP(0, "\n")
  }

  def /(key: String): Tree = {
    c.find(t => key.equals(t.k)).getOrElse(throw new RuntimeException())
  }
  def ===(v: String) = addReplaceValue(v)
}