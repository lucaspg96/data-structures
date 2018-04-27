package structures.Set.DynamicPartitionSet

class Node(e: Int, p: Node){

  def this(e: Int) = this(e,null)

  var parent: Node = p
  val elem: Int = e

  def == (n: Int): Boolean =
    elem == n ||
      (null != parent && parent == n)

  def == (n: Node): Boolean =
    n.elem == elem && (
      (null != parent &&  null != n.parent && parent == n.parent) ||
        (null == n.parent && null == parent)
      )

  def setParent(n: Node): Unit =
    parent = n

  def isParent: Boolean = null == parent

}

class DynamicPartitionSet(n: Int) {

  var sets: List[Node] = Nil

  for(i <- 1 to n) makeSet(i)

  private def makeSet(x: Int): Unit =
    sets :+= new Node(x)

  private def getRepresentant(n: Node): Node =
    if(n.isParent) n
    else getRepresentant(n.parent)

  def find(x: Int): Node = {
    val l = sets filter (_ == x)

    if(l.nonEmpty) getRepresentant(l.head)
    else throw new Error("element not found")
  }

  def union(x: Int, y: Int): Unit = {
    val sx = find(x)
    val sy = find(y)

    if(!sx.eq(sy))
      if(x > y) sy setParent sx
      else sx setParent sy

  }

}
