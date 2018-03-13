package structures.Bank

import structures.Bank.Accounts.{Account, BonusAccount, SavingsAccount}
import structures.Bank.OrderedLinkedList.{EmptyOrderedLinkedList, OrderedLinkedList}

object BankSuit extends App {

  def transaction(from: Account, to: Account, value: Double): Unit = {
    from.debit(value)
    to.credit(value)
  }

  var list: OrderedLinkedList[Account] = new EmptyOrderedLinkedList
  list = list add new Account(0)
  list = list add new SavingsAccount(1)
  list = list add new BonusAccount(2)

  println("All accounts initialized with 0")

  println("Adding 10 over account 0")
  list(1).credit(10)
  println("Account: "+list(1).getId+" Value: "+list(1).getValue)

  println("Adding 50 over account 0")
  list(0).credit(50)
  println("Removing 20 over account 0")
  list(0).debit(20)
  println("Account: "+list(0).getId+" Value: "+list(0).getValue)

  println("Adding 1000 over account 2")
  list(0).credit(50)
  println("Account: "+list(2).getId+" Value: "+list(2).getValue)

  println("Casing account 2 to bonus account")
  var bonusAcc = list(2).asInstanceOf[BonusAccount]
  println("Account: "+bonusAcc.getId+" Bonus: "+bonusAcc.getBonus)

  println("Earning account 2 bonus")
  bonusAcc.earnBonus
  println("Account: "+bonusAcc.getId+" Value: "+bonusAcc.getValue+"Bonus: "+bonusAcc.getBonus)

  println("Earning savings interest from account 1")
  var savingsAccount = list(1).asInstanceOf[SavingsAccount]
  savingsAccount.earnInterest
  println("Account: "+savingsAccount.getId+" Value: "+savingsAccount.getValue)

  println("All accounts:")
  println(list)

  println("Removing account 1:")
  list = list remove 1
  println(list)


  println("Showing all lists using a map function:")
  list map (println(_))

  println("Transfering 40 from account 0 to 2")
  transaction(list(0),list(1),40)
  list map (println(_))
}
