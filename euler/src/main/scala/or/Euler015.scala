package or

import akka.actor._
import scala.actors.Actor
import scala.actors.Actor._
import akka.routing.RoundRobinRouter
import akka.util.Duration
import akka.util.duration._

object Euler015 extends App {

}
class ProducerII {
  
  def produceValues: GridPoint = GridPoint(1, 1, 1)
  
  def produce(p: GridPoint) {
    coordinator ! Some(p)
    receive { case Next => }
  }

  val producer: Actor = actor {
    receive {
      case Next =>
        produceValues
        coordinator ! None
    }
  }

  val coordinator: Actor = actor {
    loop {
      react {
        case Next =>
          producer ! Next
          reply {
            receive { case x: Option[_] => x }
          }
        case Stop => exit('stop)
      }
    }
  }
}
case class GridPoint(x: Int, y: Int, gridSize: Int)
case object Next
case object Stop