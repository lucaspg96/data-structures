package structures.CircularLinkedList

case class NonEmptyCircularLinkedList[T](elem: T, next: CircularLinkedList[T]) extends CircularLinkedList[T] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def add(e: T): CircularLinkedList[T] = new NonEmptyCircularLinkedList[T](elem,next add e)
  def remove(i: Int): CircularLinkedList[T] = i match {
    case 0 => next
    case _ => new NonEmptyCircularLinkedList[T](elem, next remove i-1)
  }

  def reverse: CircularLinkedList[T] = (next reverse) add elem

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: CircularLinkedList[T]): Boolean = b match{
    case NonEmptyCircularLinkedList(e,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
