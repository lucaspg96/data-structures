package structures.HashTables.DynamicHashTable

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import structures.Bank.Accounts.Account


@RunWith(classOf[JUnitRunner])
class DynamicHashTableSuit extends FunSuite {

  test("creating empty table") {
    val emptyTable: DynamicHashTable[Int] = new DynamicHashTable[Int](2,2)
    assert(emptyTable.isEmpty)
  }

  test("inserting integers on table") {
    val table: DynamicHashTable[Int] = new DynamicHashTable[Int](500,2)

    table add 5
    table add 33
    table add 255
    table add 233

    assert(!table.isEmpty)
    assert(table.size == 4)

    assert(table(5) == 5)
    assert(table(33) == 33)
    assert(table(255) == 255)
    assert(table(233) == 233)
  }

  test("inserting TAD on table") {
    val table: DynamicHashTable[Account] = new DynamicHashTable[Account](500,2,{b: Account => b getId})

    val acc1 = new Account(5)
    val acc2 = new Account(33)
    val acc3 = new Account(255)
    val acc4 = new Account(233)

    table add acc1
    table add acc2
    table add acc3
    table add acc4

    assert(!table.isEmpty)
    assert(table.size == 4)

    assert(table(5) == acc1)
    assert(table(33) == acc2)
    assert(table(255) == acc3)
    assert(table(233) == acc4)
  }

  test("removing from table") {
    val table: DynamicHashTable[Int] = new DynamicHashTable[Int](500,2)

    table add 5
    table add 33
    table add 255
    table add 233

    table remove 5

    assert(!table.isEmpty)
    assert(table.size == 3)

    assertThrows[Error] {table(5)}

    assert(table(33) == 33)
    assert(table(255) == 255)
    assert(table(233) == 233)
  }

  test("expanding table"){
    val table: DynamicHashTable[Int] = new DynamicHashTable[Int](1000,2)

    table add 10
    table add 1010

//    println(table)
//    println()

    table add 2010
//    println(table)

    assert(table(10) == 10)
    assert(table(1010) == 1010)
    assert(table(2010) == 2010)
  }

}
