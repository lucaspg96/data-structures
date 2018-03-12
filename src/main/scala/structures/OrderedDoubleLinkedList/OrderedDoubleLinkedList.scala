package structures.OrderedDoubleLinkedList

trait OrderedDoubleLinkedList[T] {

  def isEmpty: Boolean
  def apply(i: Int): T
  def add(elem: T): OrderedDoubleLinkedList[T]
  def remove(i: Int): OrderedDoubleLinkedList[T]
  def reversePrint: Unit
  def show: Unit = println(toString)
  override def toString: String

  def ==(b: OrderedDoubleLinkedList[T]): Boolean

}
