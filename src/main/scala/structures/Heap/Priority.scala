package structures.Heap

trait Priority[T] {
  type P = T
  def priorityFunction(a: T, b: T): Boolean
}

trait IntPriority extends Priority[Int]

trait MaxPriority  extends IntPriority{
  def priorityFunction(a: Int, b: Int): Boolean = a >= b
}

trait MinPriority  extends IntPriority{
  def priorityFunction(a: Int, b: Int): Boolean = a <= b
}