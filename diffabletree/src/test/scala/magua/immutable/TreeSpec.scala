package magua.immutable

import org.specs2.mutable._

class TreeSpec extends Specification {

  "The Diffable Tree" should {
    "have a working addChild method" in {
      var root = Tree("se")
      root = root.addReplaceChild(Tree("magua"))
      root = root.addReplaceChild(Tree("key1", Some("value1")))
      root.toTreeString must equalTo(
          
"""
se
  *magua
  *key1=value1
""")
    }
    "be updatable" in {
      var root = Tree("se")
          root = root.addReplaceChild(Tree("magua"))
          root = root.addReplaceChild(Tree("key1", Some("wrong")))
          root = root.addReplaceChild(Tree("key1", Some("value1")))
          root.toTreeString must equalTo(
"""
se
  *magua
  *key1=value1
""")
    }
    "be updatable" in {
      var root = Tree("se")
      root = root.addReplaceChild(Tree("child"))
      root = root === "magua"
      println(root.toTreeString())
      root = root / "child" === "childvalue"
      root.toTreeString must equalTo(     
"""
se=magua
  *child=childvalue
""")
    }
  }
}
