package magua

import magua.immutable.Tree
import magua.immutable.Tree._

object ExampleApp extends App {
      var root = Tree("se")
      root = root.addReplaceChild(Tree("child"))
      root = root === "magua"
      println(root.toTreeString())
      root = root / "child" === "childvalue"
      println(root.toTreeString)
}
