package structures.CircularDoubleLinkedList

case class NonEmptyCircularDoubleLinkedList[T](elem: T, prev: CircularDoubleLinkedList[T] ,next: CircularDoubleLinkedList[T]) extends CircularDoubleLinkedList[T] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def add(e: T): CircularDoubleLinkedList[T] =
    new NonEmptyCircularDoubleLinkedList[T](elem, prev, next add e)

  def remove(i: Int): CircularDoubleLinkedList[T] = i match {
    case 0 => {
      if(this==Head.head){
        Head.head = next
      }
      if(this==Last.last){
        Last.last = prev
      }
      next
    }
    case _ => new NonEmptyCircularDoubleLinkedList[T](elem,prev, next remove i-1)
  }

  def reverse: CircularDoubleLinkedList[T] = (next reverse) add elem

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: CircularDoubleLinkedList[T]): Boolean = b match{
    case NonEmptyCircularDoubleLinkedList(e,_,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
