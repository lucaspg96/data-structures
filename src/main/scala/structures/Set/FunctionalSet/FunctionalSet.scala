package structures.Set.FunctionalSet

class FunctionalSet[T](f: T => Boolean) {

  def this(elem: T) = this({x => x==elem})

  def apply(elem: T): Boolean = f(elem)

  def insert(elem: T) = new FunctionalSet[T]({x => f(x) || x == elem})

  def remove(elem: T) = new FunctionalSet[T]({x => f(x) && x != elem})

  def union(set: FunctionalSet[T]) = new FunctionalSet[T]({x => f(x) || set(x)})

  def intersection(set: FunctionalSet[T]) = new FunctionalSet[T]({x => f(x) && set(x)})

  def diference(set: FunctionalSet[T]) = new FunctionalSet[T]({x => f(x) && !set(x)})

}
