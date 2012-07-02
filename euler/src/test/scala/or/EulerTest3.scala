package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest3 extends Specification {
  def sqrt(number : BigInt) = {
    def next(n : BigInt, i : BigInt) : BigInt = (n + i/n) >> 1

    val one = BigInt(1)

    var n = one
    var n1 = next(n, number)
    
    while ((n1 - n).abs > one) {
      n = n1
      n1 = next(n, number)
    }
     
    while (n1 * n1 > number) {
      n1 -= one
    }
     
    n1
  }
  def isPrime(n: BigInt): Boolean = {
    @tailrec def isPrimeReq(rN: BigInt): Boolean = {
      if (rN <= 1) true
      else if (n % rN == 0) false
      else isPrimeReq(rN - 2)
    }
    val l = System.currentTimeMillis
    val even = n % 2 == 0
    val result = !even && isPrimeReq(sqrt(n))
    //println((System.currentTimeMillis - l) / 1000.0)
    result
  }
  def e3BiggestPrimeFactor(n: BigInt) = {
   @tailrec def reqBiggestPrimeFactor(nn: BigInt): BigInt = {
     if (isPrime(nn) && n % nn == 0) nn
     else reqBiggestPrimeFactor(nn - 1)
   }
   reqBiggestPrimeFactor(n - 1)
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
   "find 600851475143 lagest prime factor" in {
   	e3BiggestPrimeFactor(13195 ) must equalTo(29)
   }
   //"find 600851475143 lagest prime factor" in {
   // e3BiggestPrimeFactor(600851475143L) must equalTo(59569)
   //}
  }
}