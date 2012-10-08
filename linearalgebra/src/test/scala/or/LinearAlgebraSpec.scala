package or;

import org.scalatest.FunSpec

class LinearAlgebraSpec extends FunSpec {

	  describe("Adding Matrices") {

	    it("Simple addition should work") {
	      val m1 = Matrix.fromString(
	          """1, 2, 3
	    		 3, 2, 1
	             1, 2, 2""")
	      val m2 = Matrix.fromString(
	          """3, 2, 1
	             1, 2, 3
	             3, 2, 2""")
	      assert((m1 + m2) === Matrix.fromString(
	          """4, 4, 4
	             4, 4, 4
	             4, 4, 4"""))
	    }

	    it("multiplication should also work") {
	      val m1 = Matrix.fromString(
	          """1, 2
	    		 3, 4""")
	      val m2 = Matrix.fromString(
	          """5, 6
	             7, 8""")
	      assert((m1 * m2) === Matrix.fromString(
	          """19, 22
	             43, 50"""))	      
	    }
	    it("multiplication reversed gives different result") {
	      val m1 = Matrix.fromString(
	          """1, 2
	    		 3, 4""")
	      val m2 = Matrix.fromString(
	          """5, 6
	             7, 8""")
	      assert((m2 * m1) === Matrix.fromString(
	          """23, 34
	             31, 46"""))	      
	    }
	    it("multiplication different proportions") {
	      val m1 = Matrix.fromString(
	          """1, 4, 6""")
	      val m2 = Matrix.fromString(
	          """2, 3
	             5, 8
	             7, 9""")
	      assert((m1 * m2) === Matrix.fromString(
	          """64, 89"""))	      
	    }
	  }
	}