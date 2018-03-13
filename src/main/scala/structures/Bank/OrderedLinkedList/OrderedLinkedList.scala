package structures.Bank.OrderedLinkedList

trait OrderedLinkedList[Account] {

  def isEmpty: Boolean
  def apply(i: Int): Account
  def add(elem: Account): OrderedLinkedList[Account]
  def remove(i: Int): OrderedLinkedList[Account]
  def reversePrint: Unit
  def show: Unit = println(toString)
  override def toString: String

  def map[U](f: Account => U): Unit

  def ==(b: OrderedLinkedList[Account]): Boolean

}
