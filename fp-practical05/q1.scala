import scala.io.StdIn.readLine;
object inventoryManagement{
    def getproductList() : List[String] = {
        var productList : List[String] = List();
        var product : String = "";
        println("Enter the names of the products (type 'done' to stop)");
        while(product != "done"){
            print("Enter product name : ");
            product = readLine();
            if(product != "done"){
                productList = productList :+ product;
            }
        }
        return productList;
    }

    def printProductList(productList : List[String]) : Unit = {
        println("---Items in the Inventory----");
        for(i <- 0 until productList.length){
            println((i+1) + " - " + productList(i));
        }
    }

    def getTotalProducts(productList : List[String]) : Int = {
        return productList.length;
    }

    def main(args: Array[String]) : Unit = {
        var productList : List[String] = getproductList();
        printProductList(productList);
        println("Total products in the inventory: " + getTotalProducts(productList));
    }
}