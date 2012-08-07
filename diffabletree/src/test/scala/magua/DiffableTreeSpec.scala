package magua

import org.specs2.mutable._

class DiffableTreeSpec extends Specification {

//  "The DiffableMap" should {
//    "be constructed in a mutable way" in {
//      val root1 = new MutableTree()
//      root1 ++ "se" ++ "magua" ++ ("data1" -> Some("perkele"))
//      (root1 \ "se" \ "magua" \ "data1").keyValue must equalTo("se.magua.data1=perkele")
//      (root1 \ "se" \ "magua" \ "data1").valueOpt = Some("dallas")
//      (root1 \ "se" \ "magua" \ "data1").keyValue must equalTo("se.magua.data1=dallas")
//    }
//    "be suitable to construct from dot-separated strings" in {
//      val keyValues = Map(
//        "se" -> "value",
//        "se.magua.data1" -> "perkele",
//        "se.magua.data2" -> "dallas")
//      val root = new MutableTree()
//      keyValues.foreach(p => { root +++ p })
//      println(root.subtree)
//      (root \ "se").keyValue must equalTo("se=value")
//      (root \ "se" \ "magua" \ "data2").keyValue must equalTo("se.magua.data2=dallas")
//    }
//  }
}
