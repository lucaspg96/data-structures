package structures.CircularDoubleLinkedList

case class EmptyCircularDoubleLinkedList[T]() extends CircularDoubleLinkedList[T] {
  def isEmpty: Boolean = true
  def apply(i: Int) = Head match{
    case null => throw new Error("Index out of bounds")
    case _ => Head.head apply i
  }
  def add(elem: T): CircularDoubleLinkedList[T] = {
    if(!Last.hasLast) {
      val newList = new NonEmptyCircularDoubleLinkedList[T](elem, this, this)
      Head.head = newList
      Last.last = newList
      newList
    }
    else{
      val newList = new NonEmptyCircularDoubleLinkedList[T](elem, Last.last, this)
      Last.last = newList
      newList
    }

  }
  def remove(i: Int): CircularDoubleLinkedList[T] = throw new Error("Index out of bounds")
  def reverse: CircularDoubleLinkedList[T] = this

  override def toString: String = ""

  def ==(b: CircularDoubleLinkedList[T]): Boolean = b.isEmpty
}
