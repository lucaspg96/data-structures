package structures.Trees.BinaryTree.BinarySearchTree

import structures.Trees.BinaryTree.BinaryTree

case class NonEmptyTree(elem: Double, left: BinaryTree[Double], right: BinaryTree[Double]) extends BinaryTree[Double] {

  def isEmpty: Boolean = false

  def contains(x: Double): Boolean =
    if (x < elem) left.contains(x)
    else if (elem < x) right.contains(x)
    else true

  def incl(x: Double): BinaryTree[Double] = {
    if (x < elem) NonEmptyTree(elem, left.incl(x), right)
    else if (elem < x) NonEmptyTree(elem, left, right.incl(x))
    else this
  }

  def remove(x: Double): BinaryTree[Double] =
    if (x < elem) NonEmptyTree(elem, left.remove(x), right)
    else if (elem < x) NonEmptyTree(elem, left, right.remove(x))
    else if(left.isEmpty) right
    else if(right.isEmpty) left
    else {
      val s = successor(x)
      NonEmptyTree(s, left.remove(s), right.remove(s))
    }

  def getNode(x: Double): BinaryTree[Double] =
    if( x == elem) this
    else if(x>elem) right getNode x
    else left getNode x

  def successor(x: Double): Double =
    if(!contains(x)) throw new Error(s"$x is not on the tree")
    else {
      val node = getNode(x)
      val min = node.getMin
      if(min == elem) node match {
        case EmptyTree() => elem
        case NonEmptyTree(_,_,r) => r.getMin
      }
      else min
    }

  def getMin: Double =
    left match {
      case EmptyTree() => elem
      case NonEmptyTree(_, _, _) => left.getMin
    }

  def getMax: Double = right match {
    case EmptyTree() => elem
    case NonEmptyTree(_,_,_) => right.getMax
  }

  def printPreOrder: Unit = {
    print(s"$elem ")
    left.printPreOrder
    right.printPreOrder
  }

  def printPostOrder: Unit = {
    left.printPostOrder
    right.printPostOrder
    print(s"$elem ")
  }

  def printInOrder: Unit = {
    left.printInOrder
    print(s"$elem ")
    right.printInOrder
  }
}
