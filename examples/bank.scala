class BankAccount {
  private var bal:Int = 0

  def deposit(amount: Int) = {
    bal += amount
  } //Impure

  def isItEnoughMoney(price: Int, amount: Int) = {
    price > amount
  } //Pure

  def doIhaveEnoughMoney(price: Int) = {
    isItEnoughMoney(price, bal)
  }

}
