package structures.HashTables.StaticHashTable

import math.ceil

class StaticHashTable[T](n: Int, d: Int = 2, getKey: T => Int = {x: T => x.asInstanceOf[Int]}) {
  private var s = 0
  private val k: Int = ceil(n/d).asInstanceOf[Int]
  private val values = (for(_ <- 1 to k) yield List[T]()).toArray

  def size = s
  private def hashFunction(i: Int): Int = i%k
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


}
