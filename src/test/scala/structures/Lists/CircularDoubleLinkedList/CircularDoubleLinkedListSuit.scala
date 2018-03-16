package structures.Lists.CircularDoubleLinkedList
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class CircularDoubleLinkedListSuit extends FunSuite {
  test("creating empty list") {
    val emptyList: CircularDoubleLinkedList[Int] = new EmptyCircularDoubleLinkedList[Int]
    assert(emptyList.isEmpty)
  }

  test("inserting"){
    val l = new EmptyCircularDoubleLinkedList[Int]
    val l1 = l add 1
    val l2 = l1 add 2

    assert(l2.toString == "1 2 ")

  }

  test("get element by index"){
    val l = new EmptyCircularDoubleLinkedList[Int]
    val l1 = l add  1
    val l2 = l1 add  2
    val l3 = l2 add 3

    assert(l3(0) == 1)
    assert(l3(1) == 2)
    assert(l3(2) == 3)
    assert(l3(4) == 1)
  }

  test("removing from list"){
    val l = new EmptyCircularDoubleLinkedList[Int]
    val l1 = l add   1
    val l2 = l1 add  2
    val l3 = l2 add 3
    val rl = l3 remove 1
    assert(rl.toString == "1 3 ")

  }

  test("reversing list") {
    val l = new EmptyCircularDoubleLinkedList[Int]
    val l1 = l add  1
    val l2 = l1 add  2
    val l3 = l2 add 3

    assert(l3.reverse.toString == "3 2 1 ")
  }
}
