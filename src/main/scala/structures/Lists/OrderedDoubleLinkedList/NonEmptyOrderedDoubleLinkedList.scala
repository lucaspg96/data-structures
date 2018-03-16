package structures.Lists.OrderedDoubleLinkedList

case class NonEmptyOrderedDoubleLinkedList(elem: Int, prev: OrderedDoubleLinkedList[Int] ,next: OrderedDoubleLinkedList[Int]) extends OrderedDoubleLinkedList[Int] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def add(e: Int): OrderedDoubleLinkedList[Int] =
    if(e > elem)
      new NonEmptyOrderedDoubleLinkedList(elem,prev,next.add(e))
    else
      new NonEmptyOrderedDoubleLinkedList(e,prev,this)

  def remove(i: Int): OrderedDoubleLinkedList[Int] = i match {
    case 0 => next
    case 1 => new NonEmptyOrderedDoubleLinkedList(elem, prev , next remove i-1)
    case _ => new NonEmptyOrderedDoubleLinkedList(elem, prev ,next remove i-1)
  }

  def reversePrint = {
    next.reversePrint
    print(" "+elem)
  }

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: OrderedDoubleLinkedList[Int]): Boolean = b match{
    case NonEmptyOrderedDoubleLinkedList(e,_,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }
}
