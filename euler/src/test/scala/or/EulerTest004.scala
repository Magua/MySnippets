package or

import org.specs2.mutable._
import scala.annotation.tailrec

class EulerTest4 extends Specification {
  def isPalindromic(i: Int): Boolean = {
    val l = i.toString.toList
    l.equals(l.reverse)
  }
  def lpp(max: Int): Int = {
    var maxPalindrom = 0
    @tailrec def lppReq(n1: Int, n2: Int): Int = {
      val p = n1 * n2
      if (isPalindromic(p)) {
    	if (p > maxPalindrom) {
    	  maxPalindrom = p
		  println(n1 + " * " + n2 + " = " + p)
    	}
      }
      var nn1 = n1
      var nn2 = n2
      //This is a bit of guess... may not work always
      if (n1 < max / 2 || n2 < max / 2) return maxPalindrom
      if (n1 < n2) {
        nn1 = n1
        nn2 = n2 - 1
      }
      else if (n1 == n2) {
    	nn1 = n1 - 1
    	nn2 = max
      }
      lppReq(nn1, nn2)
    }
    lppReq(max, max)
  }
  def largestPalindromicProduct(digits: Int): Int = {
    lpp(("9" * digits).toInt)
  }

  "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99." should {
    "have a working isPalindrome method" in {
      isPalindromic(123321) must equalTo(true)
      isPalindromic(1234321) must equalTo(true)
      isPalindromic(12344321) must equalTo(true)
      isPalindromic(123434321) must equalTo(true)
      isPalindromic(1234444321) must equalTo(true)
      isPalindromic(1188888888) must equalTo(false)
    }
    "be verified for two digits in" in {
      largestPalindromicProduct(2) must equalTo(9009)
    }
    "Find the largest palindrome made from the product of two 3-digit numbers" in {      
    	largestPalindromicProduct(3) must equalTo(906609)
    }
  }
}