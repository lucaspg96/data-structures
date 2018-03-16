package structures.Lists.OrderedDoubleLinkedList

case class EmptyOrderedDoubleLinkedList() extends OrderedDoubleLinkedList[Int] {
  def isEmpty: Boolean = true
  def apply(i: Int) = throw new Error("Index out of bounds")
  def add(elem: Int): OrderedDoubleLinkedList[Int] = new NonEmptyOrderedDoubleLinkedList(elem,this, this)
  def remove(i: Int): OrderedDoubleLinkedList[Int] = throw new Error("Index out of bounds")
  def reversePrint = print(toString)

  override def toString: String = ""

  def ==(b: OrderedDoubleLinkedList[Int]): Boolean = b.isEmpty
}
