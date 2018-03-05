package structures.list

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class ListSuit extends FunSuite {

  test("creating empty list") {
    val emptyList: LinkedList[Int] = new Nil[Int]
    assert(emptyList.isEmpty)
  }

  test("adding on beggining"){
    val l = new Nil[Int]
    val l1 = l addBeginning 1
    val l2 = l1 addBeginning 2

    assert(l2.toString == "2 1 ")

  }

  test("adding on end"){
    val l = new Nil[Int]
    val l1 = l addEnd  1
    val l2 = l1 addEnd  2

    assert(l2.toString == "1 2 ")

  }

  test("get element by index"){
    val l = new Nil[Int]
    val l1 = l addEnd  1
    val l2 = l1 addEnd  2
    val l3 = l2 addEnd 3

    assert(l3(0) == 1)
    assert(l3(1) == 2)
    assert(l3(2) == 3)
  }

  test("removing from list"){
    val l = new Nil[Int]
    val l1 = l addEnd  1
    val l2 = l1 addEnd  2
    val l3 = l2 addEnd 3

    val rl = l3 remove 1
    assert(rl.toString == "1 3 ")

  }

  test("reversing list") {
    val l = new Nil[Int]
    val l1 = l addEnd  1
    val l2 = l1 addEnd  2
    val l3 = l2 addEnd 3

    assert(l3.reverse.toString == "3 2 1 ")
  }

}
