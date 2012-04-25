package magua

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

/**
 * It's mutable yes... well I'm a java programmer. =)
 */
case class MutableTree(var parentOpt: Option[MutableTree], key: Option[String], var valueOpt: Option[String] = None,
  childrenOpt: Option[Map[String, MutableTree]]) {
  def this() = this(None, None, None, None)
  def this(key: String) = this(None, Some(key), None, None)
  def this(key: String, value: Option[String]) = this(None, Some(key), value, None)
  def this(parent: Option[MutableTree], key: String) = this(parent, Some(key), None, None)
  def this(parent: Option[MutableTree], key: String, value: Option[String]) = this(parent, Some(key), value, None)
  var children = childrenOpt.getOrElse(Map[String, MutableTree]())
  def ++(dtm: MutableTree): MutableTree = {
    dtm.parentOpt = Some(this)
    children = children + (dtm.key.get -> dtm)
    dtm
  }
  def ++(entry: String): MutableTree = {
    ++(new MutableTree(entry, None))
  }
  def ++(entry: (String, Option[String])): MutableTree = {
    println(entry._1 + "->" + entry._2)
    ++(new MutableTree(entry._1, entry._2))
  }
  def +++(keyValue: (String, String)) {
    \\\(keyValue._1).valueOpt = Some(keyValue._2)
  }
  def -(dtm: MutableTree) {
    children = children - dtm.key.get
  }
  def \(key: String): MutableTree = {
    println("-" + key)
    children.get(key).getOrElse({
      this ++ ((key -> None))
    })
  }
  def \\\(key: String): MutableTree = {
    val keyList = key.split("\\.")
    var p = this
    keyList.foreach(key => {
      p = p \ key
    })
    p
  }
  def keyName: String = {
    keyNameOpt.getOrElse("")
  }
  def keyNameOpt: Option[String] = {
    if (parentOpt.isDefined) {
      if (parentOpt.get.keyNameOpt.isDefined) {
        Some(parentOpt.get.keyNameOpt.get + "." + key.get)
      } else {
        Some(key.get)
      }
    } else {
      None // root
    }
  }
  def keyValue: String = {
    keyName + "=" + valueOpt.getOrElse("none")
  }
  def subtree: String = {
    val s = new StringBuilder
    subtreeLevel(0, s)
    s.toString()
  }
  def subtreeLevel(l: Int, s: StringBuilder) {
    for (i <- 0 until l) {
      s.append("  ")
    }
    s.append(key.getOrElse(""))
    if (valueOpt.isDefined) {
      s.append("->")
      s.append(valueOpt.get)
    }
    s.append("\n")
    children.foreach(c => { c._2.subtreeLevel(l + 1, s) })
  }
}