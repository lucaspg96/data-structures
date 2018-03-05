package structures.list

case class NonEmptyList[T](elem: T, next: LinkedList[T]) extends LinkedList[T] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def addEnd(e: T): LinkedList[T] = new NonEmptyList[T](elem,next addEnd e)
  def addBeginning(e: T): LinkedList[T] = new NonEmptyList[T](e,this)
  def remove(i: Int): LinkedList[T] = i match {
    case 0 => next
    case _ => new NonEmptyList[T](elem, next remove i-1)
  }

  def reverse: LinkedList[T] = (next reverse) addEnd elem

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: LinkedList[T]): Boolean = b match{
    case NonEmptyList(e,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
