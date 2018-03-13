package structures.Bank.OrderedLinkedList

import structures.Bank.Accounts.Account

case class NonEmptyOrderedLinkedList(elem: Account, next: OrderedLinkedList[Account]) extends OrderedLinkedList[Account] {
  def isEmpty: Boolean = false
  def apply(i: Int) = i match{
    case 0 => elem
    case _ => next(i-1)
  }
  def add(e: Account): OrderedLinkedList[Account] =
    if(e.getId > elem.getId)
      new NonEmptyOrderedLinkedList(elem,next.add(e))
    else
      new NonEmptyOrderedLinkedList(e,this)

  def remove(i: Int): OrderedLinkedList[Account] = i match {
    case 0 => next
    case _ => new NonEmptyOrderedLinkedList(elem, next remove i-1)
  }

  def reversePrint = {
    next.reversePrint
    print(" "+elem)
  }

  override def toString: String = elem.toString+" "+next.toString

  def ==(b: OrderedLinkedList[Account]): Boolean = b match{
    case NonEmptyOrderedLinkedList(e,n) => {
      if(e == elem)
        next == n
      else
        false
    }
    case _ => false
  }

  def map[U](f: Account => U): Unit = {
    f(elem)
    next map f
  }
}
