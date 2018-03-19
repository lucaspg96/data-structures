package structures.HashTables.StaticHashTable

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import structures.Bank.Accounts.Account


@RunWith(classOf[JUnitRunner])
class StaticHashTableSuit extends FunSuite {

  test("creating empty table") {
    val emptyTable: StaticHashTable[Int] = new StaticHashTable[Int](1000,3)
    assert(emptyTable.isEmpty)
  }

  test("inserting integers on table") {
    val table: StaticHashTable[Int] = new StaticHashTable[Int](1000,4)

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

//    println(table)
  }

  test("inserting TAD on table") {
    val table: StaticHashTable[Account] = new StaticHashTable[Account](1000,4, {b => b getId})

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
    val table: StaticHashTable[Int] = new StaticHashTable[Int](1000,4)

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

}
