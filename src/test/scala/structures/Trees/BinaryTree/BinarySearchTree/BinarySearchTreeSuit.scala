package structures.Trees.BinaryTree.BinarySearchTree

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import structures.Trees.BinaryTree.BinaryTree

@RunWith(classOf[JUnitRunner])
class BinarySearchTreeSuit extends FunSuite {

  test("creating and searching"){
    val t: BinaryTree[Double] = new EmptyTree
    val t1 = t incl 1
    val t2 = t1 incl 2

    require(t2 contains 1)
    require(t2 contains 2)
    require(!(t2 contains 3))
  }

  test("get successor"){
    val t: BinaryTree[Double] = new EmptyTree
    val t1 = t incl 1
    val t2 = t1 incl 5
    val t3 = t2 incl 2

    require(t3.successor(1) == 2)
  }

  test("removing leaf"){
    val t: BinaryTree[Double] = new EmptyTree
    val t1 = t incl 1
    val t2 = t1 incl 5
    val t3 = t2 incl 2

    val t4 = t3 remove 2

    require(t4 contains 1)
    require(t4 contains 5)
    require(!(t4 contains 2))
  }

  test("removing simple node"){
    val t: BinaryTree[Double] = new EmptyTree
    val t1 = t incl 1
    val t2 = t1 incl 5
    val t3 = t2 incl 2

    val t4 = t3 remove 5

    require(t4 contains 1)
    require(t4 contains 2)
    require(!(t4 contains 5))
  }

  test("removing complex node"){
    val t: BinaryTree[Double] = new EmptyTree
    val t1 = t incl 1
    val t2 = t1 incl 5
    val t3 = t2 incl 2
    val t4 = t3 incl 6

    val t5 = t4 remove 5

    require(t5 contains 1)
    require(t5 contains 2)
    require(t5 contains 6)
    require(!(t5 contains 5))
  }

  test("print pre order"){
    val t = new EmptyTree incl 1 incl 5 incl 0 incl 2 incl 6

    print("Pre order: ")
    t.printPreOrder
    println()
  }

  test("print in order"){
    val t = new EmptyTree incl 1 incl 5 incl 0 incl 2 incl 6

    print("In order: ")
    t.printInOrder
    println()
  }

  test("print post order"){
    val t = new EmptyTree incl 1 incl 5 incl 0 incl 2 incl 6

    print("Post order: ")
    t.printPostOrder
    println()
  }



}
