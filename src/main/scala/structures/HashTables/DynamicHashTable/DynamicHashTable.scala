package structures.HashTables.DynamicHashTable

import scala.math.ceil

class DynamicHashTable[T](b: Int, bucketSize: Int, getKey: T => Int = { x: T => x.asInstanceOf[Int]}) {
  private var s = 0 //size
  private var nBuckets = b //number of buckets
  private var values = (for(_ <- 1 to nBuckets) yield List[T]()).toArray //buckets

  def size = s
  private def hashFunction(i: Int): Int = i%nBuckets
  def isEmpty = s==0

  private def expandHash: Unit = {
    nBuckets *= 2
    val oldValues = for{
      b <- values
      i <- b
    } yield i

    s = 0
    values = (for(_ <- 1 to nBuckets) yield List[T]()).toArray

    for{
      i <- oldValues
    } this add i

  }

  def add(elem: T): Unit = {
    val h = hashFunction(getKey(elem))
//    println("Adding "+elem)
    if(!values(h).contains(elem)){
//      println("Its a new element!")
      if(values(h).length==bucketSize){
//        println("Overflow! Expanding hash table")

        expandHash

        this add elem
      }
      else {
        values(h) :+= elem
        s += 1
      }
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

  override def toString: String = s"Table with $nBuckets buckets of size $bucketSize\n"+
    (0 until nBuckets).
    filter(i => values(i).length>0).
    map(i => i + " -> " + values(i)).
    mkString("\n")


}
