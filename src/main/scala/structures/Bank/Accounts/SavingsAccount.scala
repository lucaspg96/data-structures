package structures.Bank.Accounts

class SavingsAccount(id: Int) extends Account(id) {
  def earnInterest: Unit = value*=1.0049
}
