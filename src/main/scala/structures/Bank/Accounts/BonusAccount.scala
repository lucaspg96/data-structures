package structures.Bank.Accounts

class BonusAccount(id: Int) extends Account(id) {
  private var bonus = 0.0

  def getBonus: Double = bonus
  override def credit(v: Double): Unit = {
    bonus += 0.01*v
    value += v
  }

  def earnBonus: Unit = {
    value += bonus
    bonus = 0.0
  }
}
