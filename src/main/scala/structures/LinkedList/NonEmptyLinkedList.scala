package structures.LinkedList

case class NonEmptyLinkedList[T](elem: T, next: LinkedList[T]) extends LinkedList[T] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def addEnd(e: T): LinkedList[T] = new NonEmptyLinkedList[T](elem,next addEnd e)
  def addBeginning(e: T): LinkedList[T] = new NonEmptyLinkedList[T](e,this)
  def remove(i: Int): LinkedList[T] = i match {
    case 0 => next
    case _ => new NonEmptyLinkedList[T](elem, next remove i-1)
  }

  def reverse: LinkedList[T] = (next reverse) addEnd elem

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: LinkedList[T]): Boolean = b match{
    case NonEmptyLinkedList(e,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
