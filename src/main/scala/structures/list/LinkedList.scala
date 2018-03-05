package structures.list

trait LinkedList[T] {

  def isEmpty: Boolean
  def apply(i: Int): T
  def addEnd(elem: T): LinkedList[T]
  def addBeginning(elem: T): LinkedList[T]
  def remove(i: Int): LinkedList[T]
  def reverse: LinkedList[T]
  def show: Unit = println(toString)
  override def toString: String

  def ==(b: LinkedList[T]): Boolean

}
