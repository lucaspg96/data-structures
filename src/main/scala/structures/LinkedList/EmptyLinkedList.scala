package structures.LinkedList

case class EmptyLinkedList[T]() extends LinkedList[T] {
  def isEmpty: Boolean = true
  def apply(i: Int) = throw new Error("Index out of bounds")
  def addEnd(elem: T): LinkedList[T] = new NonEmptyLinkedList[T](elem, this)
  def addBeginning(elem: T): LinkedList[T] = addEnd(elem)
  def remove(i: Int): LinkedList[T] = throw new Error("Index out of bounds")
  def reverse: LinkedList[T] = this

  override def toString: String = ""

  def ==(b: LinkedList[T]): Boolean = b.isEmpty
}
