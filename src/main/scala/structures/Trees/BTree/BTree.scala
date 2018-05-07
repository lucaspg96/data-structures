package structures.Trees.BTree

object BTreeHelper {
  def createTree[T](n: Int): Node[T] = new Fork[T](n)
}

abstract class Node[T]{
  def add(k: Int,elem: T): Boolean
  def apply(k: Int): T
  def remove(k: Int): Unit

  def getFirst: Int
}

class Leaf[T](order: Int) extends Node[T]{
  val values: Array[Option[(Int,T)]] = (for(_ <- 1 to order) yield None).toArray

  def add(k: Int,elem: T): Boolean = {
    if((values count (o => o.isDefined && o.get._1 == k)) > 0) true
    else {
      val filled = values count (_.isDefined)

      if (filled < order) {
        values(filled) = Some(k, elem)
        true
      }
      else {
        false
      }
    }
  }

  def remove(k: Int): Unit = {
    val elements = values filterNot (o => o.isDefined && o.get._1 == k)

    for(i <- 0 until order) values(i) = None
    for(i <- elements.indices) values(i) = elements(i)
  }

  def apply(k: Int): T = {
//    println(s"checando presença da chave $k na folha")
    val ks = values filter(o => o.isDefined && o.get._1 == k)
    if(ks nonEmpty) ks.head.get._2
    else throw new Error("Key not found")
  }

  def getFirst: Int = values(0).get._1

}

class Fork[T](order: Int) extends Node[T]{
  val values: Array[Option[Int]] = (for(_ <- 1 to order) yield None).toArray

  val childs: Array[Node[T]] = (for(_ <- 1 to order+1) yield new Leaf[T](order)).toArray

  def add(k: Int,elem: T): Boolean = {
    val i = values.foldLeft(0)((i: Int, o: Option[Int]) =>
      if(o.isDefined && o.get <= k) i+1 else i)

    val filled = values count (_.isDefined)

    if(filled == 0) values(0) = Some(k)

    if(childs(i).add(k, elem)) true //deu certo inserir
    else if (i == order) false //ja era o último ponteiro e não pode inserir
    else{
      if(filled == order) false
      else {
        values(filled) = Some(k)
        childs(filled).add(k,elem)
      }
    }

  }

  def apply(k: Int): T = {
//    println(s"checando chave $k no fork")
    val i = values.foldLeft(0)((i: Int, o: Option[Int]) =>
        if(o.isDefined && o.get < k) i+1 else i)

//    println(s"redirecionando para filho $i")
    childs(i)(k)
  }

  def getFirst: Int = values(0).get

  def remove(k: Int): Unit = {
    val i = values.foldLeft(0)((i: Int, o: Option[Int]) =>
      if(o.isDefined && o.get < k) i+1 else i)

    childs(i).remove(k)
  }

}