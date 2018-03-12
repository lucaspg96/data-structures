package structures.CircularLinkedList

case class EmptyCircularLinkedList[T]() extends CircularLinkedList[T] {
  def isEmpty: Boolean = true
  def apply(i: Int) = throw new Error("Index out of bounds")
  def add(elem: T): CircularLinkedList[T] = new NonEmptyCircularLinkedList[T](elem, this)
  def remove(i: Int): CircularLinkedList[T] = throw new Error("Index out of bounds")
  def reverse: CircularLinkedList[T] = this

  override def toString: String = ""

  def ==(b: CircularLinkedList[T]): Boolean = b.isEmpty
}
