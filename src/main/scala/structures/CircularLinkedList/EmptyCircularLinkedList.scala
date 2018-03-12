package structures.CircularLinkedList

case class EmptyCircularLinkedList[T]() extends CircularLinkedList[T] {
  def isEmpty: Boolean = true
  def apply(i: Int) = Head match{
    case null => throw new Error("Index out of bounds")
    case _ => Head apply i
  }
  def add(elem: T): CircularLinkedList[T] = {
    val newList = new NonEmptyCircularLinkedList[T](elem, this)
    Head.head = newList

    newList
  }
  def remove(i: Int): CircularLinkedList[T] = throw new Error("Index out of bounds")
  def reverse: CircularLinkedList[T] = this

  override def toString: String = ""

  def ==(b: CircularLinkedList[T]): Boolean = b.isEmpty
}
