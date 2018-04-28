package structures.Trees.BinaryTree.BinarySearchTree

import structures.Trees.BinaryTree.BinaryTree

case class EmptyTree() extends BinaryTree[Double] {

  def isEmpty: Boolean = true

  def contains(x: Double): Boolean = false

  def incl(x: Double): BinaryTree[Double] = new NonEmptyTree(x, new EmptyTree, new EmptyTree)

  def remove(x: Double): BinaryTree[Double] = this

  def successor(x: Double): Double = throw new Error("Empty Tree!")

  def getNode(x: Double): BinaryTree[Double] = throw new Error("Empty Tree!")

  def getMin: Double = throw new Error("Empty Tree!")

  def getMax: Double = throw new Error("Empty Tree!")

  def printPreOrder: Unit = print("")

  def printPostOrder: Unit = print("")

  def printInOrder: Unit = print("")
}
