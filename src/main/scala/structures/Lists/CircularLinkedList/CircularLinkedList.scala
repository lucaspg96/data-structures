package structures.Lists.CircularLinkedList

trait CircularLinkedList[T] {

  def isEmpty: Boolean
  def apply(i: Int): T
  def add(elem: T): CircularLinkedList[T]
  def remove(i: Int): CircularLinkedList[T]
  def reverse: CircularLinkedList[T]
  def show: Unit = println(toString)
  override def toString: String

  def ==(b: CircularLinkedList[T]): Boolean

  object Head{
    var head: CircularLinkedList[T] = new EmptyCircularLinkedList[T]

    def hasHead: Boolean = !head.isEmpty
    def apply = head
  }
}
