object InventorySystem{
  case class Product(
    name: String, 
    quantity: Int, 
    price: Double
    )

  val inventory1: Map[Int, Product] = Map(
    101 -> Product("Soap", 10, 15.5),
    102 -> Product("Milk", 5, 125.0),
    103 -> Product("Book", 20, 10.0)
  )

  val inventory2: Map[Int, Product] = Map(
    102 -> Product("Milk", 10, 130.0),
    104 -> Product("Biscuit", 5, 50.0)
  )

  def getAllProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) {
      case (acc, (id, product2)) =>
        acc.get(id) match {
          case Some(product1) =>
            acc.updated(id, Product(
              product1.name,
              product1.quantity + product2.quantity,
              math.max(product1.price, product2.price)
            ))
          case None => acc + (id -> product2)
        }
    }
  }

  def checkProductExists(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) => println("Product ID: "+ productId +", Details: name-" + product.name + ", quantity-"+ product.quantity+", price-"+product.price);
      case None => println("Product ID: "+ productId +" does not exist.")
    }
  }

  def main(args : Array[String]) : Unit = {
    println("All product names in inventory1 :")
    println(getAllProductNames(inventory1))

    println("\nTotal value of all products in inventory1 :")
    println(calculateTotalValue(inventory1))

    println("\nIs inventory1 empty? ")
    println(isInventoryEmpty(inventory1))

    println("\nMerged inventory:")
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println(mergedInventory)

    println("\nDoes product ID 102 exist in inventory1? ")
    checkProductExists(inventory1, 102)
  }
}