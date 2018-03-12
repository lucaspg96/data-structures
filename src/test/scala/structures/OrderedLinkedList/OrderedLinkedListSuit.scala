package structures.OrderedLinkedList

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner




@RunWith(classOf[JUnitRunner])
class OrderedLinkedListSuit extends FunSuite {

  test("creating empty list") {
    val emptyList: OrderedLinkedList[Int] = new EmptyOrderedLinkedList
    assert(emptyList.isEmpty)
  }

  test("inserting on list"){
    val l = new EmptyOrderedLinkedList
    val l1 = l add 3
    val l2 = l1 add  1
    val l3 = l2 add  2
    assert(l3.toString == "1 2 3 ")

  }

  test("get element by index"){
    val l = new EmptyOrderedLinkedList
    val l1 = l add  3
    val l2 = l1 add  1
    val l3 = l2 add 2

    assert(l3(0) == 1)
    assert(l3(1) == 2)
    assert(l3(2) == 3)
  }

  test("removing from list"){
    val l = new EmptyOrderedLinkedList
    val l1 = l add  3
    val l2 = l1 add  1
    val l3 = l2 add 2

    val rl = l3 remove 1
    assert(rl.toString == "1 3 ")

  }

  test("reversing list") {
    val l = new EmptyOrderedLinkedList
    val l1 = l add  1
    val l2 = l1 add  2
    val l3 = l2 add 3

    l3.reversePrint
  }

  test("equallity"){
    val l = new EmptyOrderedLinkedList
    val l1 = l add  1
    val l2 = l1 add  2
    val l3 = l2 add 3

    val m = new EmptyOrderedLinkedList
    val m1 = m add  1
    val m2 = m1 add 3
    val m3 = m2 add 2

    assert(l==m)
  }

}