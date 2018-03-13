package structures.Bank.Accounts

class Account(id: Int) {
  protected var value: Double = 0
  def getValue: Double = value
  def getId: Int = id
  def credit(v: Double): Unit = value += v
  def debit(v: Double): Unit = value -= v

  def ==(b: Account) = id == b.getId

  override def toString: String = "Account: "+id+" Value: "+value
}
