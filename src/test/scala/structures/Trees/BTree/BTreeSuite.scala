package structures.Trees.BTree

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BTreeSuite extends FunSuite {
  test("full test"){
    val bt = BTreeHelper.createTree[Double](3)
    bt.add(3,3.0)
    bt.add(2,2.0)
    bt.add(5,5.0)

    assert(bt(3) == 3.0)
    assert(bt(2) == 2.0)
    assert(bt(5) == 5.0)

    bt.remove(2)

    assert(bt(3) == 3.0)
    assertThrows[Error]{
      assert(bt(2) == 2.0)
    }
    assert(bt(5) == 5.0)
  }
}
