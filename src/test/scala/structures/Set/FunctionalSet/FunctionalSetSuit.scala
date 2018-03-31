package structures.Set.FunctionalSet

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionalSetSuit extends FunSuite{
  test("creating a set"){
    val s = new FunctionalSet[Int]({x => x%2 == 0})

    assert(s(2))
    assert(s(10))
    assert(!s(5))
  }

  test("inserting in a set"){
    val s = new FunctionalSet[Int](2)
    val s1 = s insert 10

    assert(s1(2))
    assert(s1(10))
    assert(!s1(5))
  }

  test("removing from a set"){
    val s = new FunctionalSet[Int](2)
    val s1 = s insert 10
    val s2 = s1 remove 2

    assert(!s2(2))
    assert(s2(10))
    assert(!s2(5))
  }

  test("union from sets"){
    val s = new FunctionalSet[Int](2)
    val s1 = s insert 10

    val t = new FunctionalSet[Int](1)
    val t1 = t insert 11

    val u = s1 union t1

    assert(u(2))
    assert(u(10))
    assert(u(1))
    assert(u(11))
  }

  test("intersection from sets"){
    val s = new FunctionalSet[Int](2)
    val s1 = s insert 10

    val t = new FunctionalSet[Int](2)
    val t1 = t insert 11

    val i = s1 intersection t1

    assert(i(2))
    assert(!i(10))
    assert(!i(1))
    assert(!i(11))
  }

  test("difference from sets"){
    val s = new FunctionalSet[Int](2)
    val s1 = s insert 10

    val t = new FunctionalSet[Int](2)
    val t1 = t insert 11

    val d = s1 diference t1

    assert(!d(2))
    assert(d(10))
    assert(!d(1))
    assert(!d(11))
  }
}
