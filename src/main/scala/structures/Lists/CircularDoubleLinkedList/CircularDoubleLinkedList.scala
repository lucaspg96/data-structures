package structures.Lists.CircularDoubleLinkedList

trait CircularDoubleLinkedList[T] {

  def isEmpty: Boolean
  def apply(i: Int): T
  def add(elem: T): CircularDoubleLinkedList[T]
  def remove(i: Int): CircularDoubleLinkedList[T]
  def reverse: CircularDoubleLinkedList[T]
  def show: Unit = println(toString)
  override def toString: String

  def ==(b: CircularDoubleLinkedList[T]): Boolean

  object Head{
    var head: CircularDoubleLinkedList[T] = new EmptyCircularDoubleLinkedList[T]

    def apply: CircularDoubleLinkedList[T] = head
    def hasHead: Boolean = !head.isEmpty
  }

  object Last{
    var last: CircularDoubleLinkedList[T] = new EmptyCircularDoubleLinkedList[T]
    def hasLast: Boolean = !last.isEmpty
    def apply: CircularDoubleLinkedList[T] = last
  }
}
