package structures.Heap

trait Heap[A] {
  type H // type of heap storage

  def empty: H // the empty heap
  def isEmpty(h: H): Boolean // whether the given heap h is empty

  def insert(x: A, h: H): H // the heap resulting from inserting x into h
  def meld(h1: H, h2: H): H // the heap resulting from merging h1 and h2

  def updateElement(oldElement: A, newElement: A, h: H): H //updating the element priority

  def findFirst(h: H): A // a minimum of the heap h
  def deleteFirst(h: H): H // a heap resulting from deleting a minimum of h
}

trait BinomialHeap extends Heap[Int] with IntPriority{

  case class Node(x: Int, priority: P, c: List[Node])

  type H = List[Node]

  protected def root(t: Node): Int = t.x
  protected def rank(t: Node): Int = t.priority
  protected def link(t1: Node, t2: Node): Node = // t1.r==t2.r
    if (priorityFunction(t1.x,t2.x)) Node(t1.x, t1.priority+1, t2::t1.c) else Node(t2.x, t2.priority+1, t1::t2.c)
  protected def ins(t: Node, ts: H): H = ts match {
    case Nil => List(t)
    case tp::ts => // t.r<=tp.r
      if (t.priority<tp.priority) t::tp::ts else ins(link(t, tp), ts)
  }

  def empty: H = Nil
  def isEmpty(ts: H): Boolean = ts.isEmpty

  def insert(x: Int, ts: H): H = ins(Node(x,0,Nil), ts)
  def meld(ts1: H, ts2: H) = (ts1, ts2) match {
    case (Nil, ts) => ts
    case (ts, Nil) => ts
    case (t1::ts1, t2::ts2) =>
      if (t1.priority<t2.priority) t1::meld(ts1,t2::ts2)
      else if (t2.priority<t1.priority) t2::meld(t1::ts1,ts2)
      else ins(link(t1,t2),meld(ts1,ts2))
  }

  def updateElement(oldElement: Int, newElement: Int, h: H): H =
    if(findFirst(h) == oldElement) insert(newElement,deleteFirst(h))
    else insert(findFirst(h),updateElement(oldElement,newElement,deleteFirst((h))))

  def findFirst(ts: H): Int = ts match {
    case Nil => throw new NoSuchElementException("min of empty heap")
    case t::Nil => root(t)
    case t::ts =>
      val x = findFirst(ts)
      if (priorityFunction(root(t),x)) root(t) else x
  }

  def deleteFirst(ts: H): H = ts match {
    case Nil => throw new NoSuchElementException("delete min of empty heap")
    case t::ts =>
      def getFirst(t: Node, ts: H): (Node, H) = ts match {
        case Nil => (t, Nil)
        case tp::tsp =>
          val (tq,tsq) = getFirst(tp, tsp)
          if (priorityFunction(root(t),root(tq))) (t,ts) else (tq,t::tsq)
      }
      val (Node(_,_,c),tsq) = getFirst(t, ts)
      meld(c.reverse, tsq)
  }
}