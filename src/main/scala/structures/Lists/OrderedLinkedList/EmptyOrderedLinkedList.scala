package structures.Lists.OrderedLinkedList

case class EmptyOrderedLinkedList() extends OrderedLinkedList[Int] {
  def isEmpty: Boolean = true
  def apply(i: Int) = throw new Error("Index out of bounds")
  def add(elem: Int): OrderedLinkedList[Int] = new NonEmptyOrderedLinkedList(elem, this)
  def remove(i: Int): OrderedLinkedList[Int] = throw new Error("Index out of bounds")
  def reversePrint = print(toString)

  override def toString: String = ""

  def ==(b: OrderedLinkedList[Int]): Boolean = b.isEmpty
}
