package structures.OrderedLinkedList

trait OrderedLinkedList[T] {

  def isEmpty: Boolean
  def apply(i: Int): T
  def add(elem: T): OrderedLinkedList[T]
  def remove(i: Int): OrderedLinkedList[T]
  def reversePrint: Unit
  def show: Unit = println(toString)
  override def toString: String

  def ==(b: OrderedLinkedList[T]): Boolean

}
