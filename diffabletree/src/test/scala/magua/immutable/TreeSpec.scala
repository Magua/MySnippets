package magua

import org.specs2.mutable._
import immutable._
import magua.immutable._

class TreeSpec extends Specification {
implicit def augmentString(x: String): Tree = new Tree(x)
implicit def augmentString(s: String, v: Option[String]): Tree = new Tree(s, v)

  "The Diffable Tree" should {
    "be constructed in an immutable way" in {
      val root = "se" ++ "magua" ++ ("key1", Some("value1"))
      println(root)
      val rootII = root ++ "se.magua" ++ ("key2", Some("value2"))
      "" must equalTo("")
        
      //(root / "se.magua.key1").v must equalTo("value1")
    }
    "be updatable" in {
      "" must equalTo("")
    }
  }
}
