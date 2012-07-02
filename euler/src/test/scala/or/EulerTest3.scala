package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest3 extends Specification {

  def isPrime(n: BigInt): Boolean = {
    @tailrec def isPrimeReq(rN: BigInt): Boolean = {
      if (rN <= 1) true 
      else if (n % rN == 0) false
      else isPrimeReq(rN - 2)
    }
    val l = System.currentTimeMillis
    val even = n % 2 == 0
    val result = !even && isPrimeReq(n - 2)
    println((System.currentTimeMillis - l) / 1000)
    result
  }
  def e3(n: Int) = {
//    @tailrec def reqE2(acc: Int, lastTwo: (Int, Int)): Int = {
//      val fib = lastTwo._1 + lastTwo._2
//      if (fib > max) acc
//      else if (fib % 2 == 0) reqE2(acc + fib, (lastTwo._2 -> fib))
//      else reqE2(acc, (lastTwo._2 -> fib))
//    }
//    if (max < 2) 0
//    else if (max == 2) 2
//    else reqE2(2, (1 -> 2))
  }
  "Calculating largest prime factors we" should {
	  "not make 4 a prime" in {
		  isPrime(4) must equalTo(false)
	  }
    "make 5 a prime" in {
      isPrime(5) must equalTo(true)
    }
    
    "not make 6 a prime" in {
    	isPrime(6) must equalTo(false)
    }
    "not make 12 a prime" in {
    	isPrime(12) must equalTo(false)
    }
    "make 13 a prime" in {
    	isPrime(13) must equalTo(true)
    }
    
    "not make 14 a prime" in {
    	isPrime(14) must equalTo(false)
    }
    "not make 996 a prime" in {
    	isPrime(996) must equalTo(false)
    }
    "make 997 a prime" in {
    	isPrime(997) must equalTo(true)
    }
    
    "not make 998 a prime" in {
    	isPrime(998) must equalTo(false)
    }
    
    "NOT make 99999987 a prime" in {
    	isPrime(99999987) must equalTo(false)
    }
    "make 99999989 a prime" in {
    	isPrime(99999989) must equalTo(true)
    }
    "NOT make 99999991 a prime" in {
    	isPrime(99999991) must equalTo(false)
    }
//    "not make 600851475143 a prime" in {
//    	isPrime(600851475143L) must equalTo(false)
//    }
//    "make 5754853343 a prime" in {
//    	isPrime(5754853343L) must equalTo(true)
//    }
    
//    "not make 5754853344 a prime" in {
//    	isPrime(5754853344L) must equalTo(false)
//    }
    
  }
}