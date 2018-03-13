package structures.Bank.OrderedLinkedList

import structures.Bank.Accounts.Account

case class EmptyOrderedLinkedList() extends OrderedLinkedList[Account] {
  def isEmpty: Boolean = true
  def apply(i: Int) = throw new Error("Index out of bounds")
  def add(elem: Account): OrderedLinkedList[Account] = new NonEmptyOrderedLinkedList(elem, this)
  def remove(i: Int): OrderedLinkedList[Account] = throw new Error("Index out of bounds")
  def reversePrint = print(toString)

  override def toString: String = ""

  def ==(b: OrderedLinkedList[Account]): Boolean = b.isEmpty

  def map[U](f: Account => U): Unit = {}
}
