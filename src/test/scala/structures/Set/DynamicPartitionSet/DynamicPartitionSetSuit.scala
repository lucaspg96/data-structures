package structures.Set.DynamicPartitionSet

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DynamicPartitionSetSuit extends FunSuite {
  test("creating and finding set"){
    val sets = new DynamicPartitionSet(10)

    for(i <- 1 to 10) require(sets.find(i) == new Node(i))
  }

  test("union set"){
    val sets = new DynamicPartitionSet(10)

    sets union (3,10)
    sets union (3,5)

    require(sets.find(3) == sets.find(10))
    require(sets.find(5) == sets.find(10))
    require(sets.find(3) == sets.find(5))
  }
}
