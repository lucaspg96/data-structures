package structures.Trees.BinaryTree

abstract class BinaryTree[T] {

  def isEmpty: Boolean

  def incl(x: T): BinaryTree[T]

  def remove(x: T): BinaryTree[T]

  def contains(x: T): Boolean

  def successor(x: T): T

  def getNode(x: T): BinaryTree[T]

  def getMin: Double

  def getMax: Double

  def printPreOrder: Unit

  def printPostOrder: Unit

  def printInOrder: Unit
}
