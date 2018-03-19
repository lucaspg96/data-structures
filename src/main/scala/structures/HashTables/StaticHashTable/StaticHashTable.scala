package structures.HashTables.StaticHashTable

import math.ceil

class StaticHashTable[T](n: Int, d: Int = 2, getKey: T => Int = {x: T => x.asInstanceOf[Int]}) {
  private var s = 0 //size
  private val nBuckets: Int = ceil(n/d).asInstanceOf[Int] //number of buckets
  private val values = (for(_ <- 1 to nBuckets) yield List[T]()).toArray //buckets

  def size = s
  private def hashFunction(i: Int): Int = i%nBuckets
  def isEmpty = s==0

  def add(elem: T): Unit = {
    val h = hashFunction(getKey(elem))

    if(!values(h).contains(elem)){
      values(h) :+= elem
      s += 1
    }
  }

  def apply(i: Int): T = {
    val h = hashFunction(i)

    val v = values(h) filter (getKey(_) == i)

    if(v isEmpty) throw new Error("Key not found")
    else v head
  }

  def remove(i: Int): Unit ={
    val h = hashFunction(i)

    if(values(h) exists  (getKey(_) == i)){
      values(h) = values(h) filter (getKey(_) != i)
      s -= 1
    }

  }

  override def toString: String = s"Table with $nBuckets buckets\n"+
    (0 until nBuckets).
      filter(i => values(i).length>0).
      map(i => i + " -> " + values(i)).
      mkString("\n")


}
