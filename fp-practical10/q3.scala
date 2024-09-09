class Account(var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount;
      println("Deposited Rs." + amount+ " ->New balance is Rs."+ balance);
    } else {
      println("amount must be greater than zero")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println("Withdrawed Rs."+amount+ " ->New balance is Rs."+balance)
    } else if (amount > balance) {
      println("insufficient balace in account")
    } else {
      println("withdrawal amount must be greater than zero")
    }
  }

  def transfer(toAccount: Account, amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println("Transferred Rs."+amount+ " to the other account")
    } else if (amount > balance) {
      println("Insufficient balance -> Could not complete the transfer")
    } else {
      println("Transfer amount must be greater than zero.")
    }
  }

  def checkBalance(): Unit = {
    println("Current balance: Rs."+balance)
  }
}

object Main2 extends App {
  val acc1 = new Account(1000)
  val acc2 = new Account(500)

  acc1.deposit(200)
  acc1.withdraw(150)
  acc1.transfer(acc2, 300)
  acc1.checkBalance()
  acc2.checkBalance()
}
