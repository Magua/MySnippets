package or

import scala.collection.immutable.Stream.consWrapper
import scala.actors._
import Actor._
import org.specs2.mutable.Specification
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import scala.annotation.tailrec
import java.util.concurrent.TimeUnit

class EulerTest015 extends Specification {
  
  val receiver = self
  
  def actorCountRoutes(gridSize: Int) = {
    
  }
  
  def countRoutes(gridSize: Int): Long = {
    def cRReq(p: Point): Long = {
      val ySpawns = if (p.y < gridSize) cRReq(p.copy(y = p.y + 1)) else 0L
      val xSpawns = if (p.x < gridSize) cRReq(p.copy(x = p.x + 1)) else 0L
      if (ySpawns + xSpawns > 0) ySpawns + xSpawns else 1
    }
    cRReq(Point(0, 0))
  }

  
  
  "Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner." should {
    "2x2 grid" in {
      countRoutes(2) must equalTo(6)
    }
    "How many routes are there through a 20×20 grid?" in {
//		countRoutes(1) must equalTo(2)
		actorCountRoutes(2) must equalTo(6)
//		countRoutes(3) must equalTo(20)
//		countRoutes(4) must equalTo(70)
//		countRoutes(5) must equalTo(252)
//		countRoutes(6) must equalTo(924)
//		countRoutes(7) must equalTo(3432)
//		countRoutes(8) must equalTo(12870)
//		countRoutes(9) must equalTo(48620)
//		countRoutes(10) must equalTo(184756)
//		countRoutes(11) must equalTo(705432)
//		countRoutes(12) must equalTo(2704156)
//		countRoutes(13) must equalTo(10400600)
//		countRoutes(14) must equalTo(40116600)
//		countRoutes(15) must equalTo(155117520)
//		countRoutes(16) must equalTo(601080390)
		val s = System.currentTimeMillis()
		//countRoutes(17) must equalTo(2333606220L)
//		countRoutes(18) must equalTo(9075135300L)
//		countRoutes(19) must equalTo(35345263800L)
//		countRoutes(20) must equalTo(137846528820L)
		val elaps = (System.currentTimeMillis() - s)
		println(2333606220.0 / elaps)
        0 must equalTo(0)
    }
  }
}
