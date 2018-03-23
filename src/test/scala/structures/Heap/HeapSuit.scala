package structures.Heap

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HeapSuit extends FunSuite {

  val MinHeap = new BinomialHeap with MinPriority
  val MaxHeap = new BinomialHeap with MaxPriority

  test("creating empty heap"){
    val emptyMinHeap = MinHeap.empty
    assert(MinHeap.isEmpty(emptyMinHeap))

    val emptyMaxHeap = MaxHeap.empty
    assert(MaxHeap.isEmpty(emptyMaxHeap))
  }

  test("inserting and removing in minimum heap"){
    var minHeap = MinHeap.insert(10,MinHeap.empty)
    minHeap = MinHeap.insert(5,minHeap)

    val min = MinHeap.findFirst(minHeap)
    minHeap = MinHeap.deleteFirst(minHeap)

    assert(min == 5)
    assert(MinHeap.findFirst(minHeap) == 10)
  }

  test("inserting and removing in maximum heap"){
    var maxHeap = MaxHeap.insert(5,MaxHeap.empty)
    maxHeap = MaxHeap.insert(10,maxHeap)

    val max = MaxHeap.findFirst(maxHeap)
    maxHeap = MaxHeap.deleteFirst(maxHeap)

    assert(max == 10)
    assert(MaxHeap.findFirst(maxHeap) == 5)
  }

  test("updating priority in minimum heap"){
    var minHeap = MinHeap.insert(10,MinHeap.empty)
    minHeap = MinHeap.insert(5,minHeap)

    minHeap = MinHeap.updateElement(10,2,minHeap)

    val min = MinHeap.findFirst(minHeap)
    minHeap = MinHeap.deleteFirst(minHeap)

    assert(min == 2)
    assert(MinHeap.findFirst(minHeap) == 5)
  }

  test("updating priority in maximum heap"){
    var maxHeap = MaxHeap.insert(10,MaxHeap.empty)
    maxHeap = MaxHeap.insert(5,maxHeap)

    maxHeap = MaxHeap.updateElement(10,2,maxHeap)

    val max = MaxHeap.findFirst(maxHeap)
    maxHeap = MaxHeap.deleteFirst(maxHeap)

    assert(max == 5)
    assert(MaxHeap.findFirst(maxHeap) == 2)
  }
}
