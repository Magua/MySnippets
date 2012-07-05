package or

import org.specs2.mutable._
import scala.annotation.tailrec
object EulerTest3 {
  def isPrime(n: BigInt): Boolean = {
    val sq = Math.floor(Math.sqrt(n.toDouble)).toInt
    @tailrec def isPrimeReq(rN: BigInt, from: Int): Boolean = {
      if (from > sq)
        true
      else if (rN % from == 0)
        false
      else if (from == rN)
        true
      else
        isPrimeReq(rN, from + 1)
    }
    val l = System.currentTimeMillis
    if (n <= 1) false
    else if (n == 2) true
    else if (n % 2 == 0) false
    else {
    	val result = isPrimeReq(n, 3)
    	//println("Prime elaps: " + ((System.currentTimeMillis - l) / 1000.0d))
    	result
    }
  }  
}
class EulerTest3 extends Specification {
  def sqrt(number : BigInt) = {
	  Math.floor(Math.sqrt(number.toDouble)).toLong
  }


  def e3BiggestPrimeFactor(n: BigInt) = {
   @tailrec def reqBiggestPrimeFactor(nn: BigInt): BigInt = {
     if (EulerTest3.isPrime(nn) && n % nn == 0) nn
     else reqBiggestPrimeFactor(nn - 1)
   }
   reqBiggestPrimeFactor(sqrt(n))
  }

  "Calculating largest prime factors we" should {
    "test sqrt method" in {
      (1 to 1000000).foreach(i => Math.floor(Math.sqrt(i)) must equalTo(sqrt(i)))
    }
	"verify all primes and non primes under 1000" in {
		val facitPrimes = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997)
		val facitNonPrimes = (1 to 1000).toList.filter(i => !facitPrimes.contains(i))
		facitPrimes.foreach(i => 
		  if (!EulerTest3.isPrime(i)) {		    
		    failure(i + " is NOT calculated as prime?")
		  })
		facitNonPrimes.foreach(i => 
		  if (EulerTest3.isPrime(i)) {		    
			  failure(i + " IS calculated as prime?")
		  })
		success
    }
   "find 13195 largest prime factor" in {
   	e3BiggestPrimeFactor(13195) must equalTo(29)
   }
   "find 600851475143 lagest prime factor" in {
    e3BiggestPrimeFactor(600851475143L) must equalTo(6857)
   }
  }
}