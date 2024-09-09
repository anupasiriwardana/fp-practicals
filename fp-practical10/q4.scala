class Account(var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  def checkBalance(): Double = balance

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 
    } else if (balance < 0) {
      balance += balance * 0.1 
    }
  }

  override def toString: String = s"Account(Balance: Rs.${balance})"
}

class Bank(var accounts: List[Account]) {
  def accountsWithNegativeBalance(): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def sumOfAllBalances(): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }
  def displayAccounts(): Unit = {
    accounts.foreach(acc => println(acc))
  }
}

object Main extends App {
  val account1 = new Account(1000)
  val account2 = new Account(-200)
  val account3 = new Account(500)
  val account4 = new Account(-50)

  val bank = new Bank(List(account1, account2, account3, account4))

  println("Accounts with negative balance:")
  val negativeAccounts = bank.accountsWithNegativeBalance()
  negativeAccounts.foreach(println)

  val totalBalance = bank.sumOfAllBalances()
  println(s"Sum of all account balances: Rs."+totalBalance)

  bank.applyInterestToAll()
  println("Balances after applying interest:")
  bank.displayAccounts()
}
