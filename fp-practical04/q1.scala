import scala.compiletime.ops.string
object retailStore{
    var item:Array[String] = Array("book","soap","shampoo","coconuts");
    var quantity:Array[Int] = Array(4,5,2,1);

    def displayInventory():Unit = {
        println("------------inventory-------");
        for(i <- 0 until item.length){
            println("item name : "+item(i)+" , quantity : "+quantity(i));
        }
    }

    def restockItem(itemName:String, quantityVal:Int):Unit = {
        var found:Boolean = false;
        
        for(i <- 0 until item.length){
            if(itemName == item(i)){
                quantity(i) += quantityVal;
                println("Item sucessfully restocked");
                found = true;
            }
        }
        if(found == false){
            println("Item not found");
        }
    }

    def sellItem(itemName:String, quantityVal:Int):Unit = {
        var found:Boolean = false;
        for(i <- 0 until item.length){
            if(itemName == item(i)){
                found = true;
                if(quantityVal <= quantity(i)){
                    quantity(i) -= quantityVal;
                    println("Stock updated");
                }else{
                    println("Not enough quantity");
                }
            }
        }
        if(found == false){
            println("Item not found");
        }
    }

    def main(args : Array[String]):Unit = {
        restockItem("book",5);
        displayInventory();
        sellItem("soap",6);
        displayInventory();
    }
}