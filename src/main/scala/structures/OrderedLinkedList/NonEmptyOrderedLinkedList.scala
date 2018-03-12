package structures.OrderedLinkedList

case class NonEmptyOrderedLinkedList(elem: Int, next: OrderedLinkedList[Int]) extends OrderedLinkedList[Int] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def add(e: Int): OrderedLinkedList[Int] =
    if(e > elem)
      new NonEmptyOrderedLinkedList(elem,next.add(e))
    else
      new NonEmptyOrderedLinkedList(e,this)

  def remove(i: Int): OrderedLinkedList[Int] = i match {
    case 0 => next
    case _ => new NonEmptyOrderedLinkedList(elem, next remove i-1)
  }

  def reversePrint = {
    next.reversePrint
    print(" "+elem)
  }

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: OrderedLinkedList[Int]): Boolean = b match{
    case NonEmptyOrderedLinkedList(e,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
