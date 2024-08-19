object NumberPatternMatching {
    val evaluateInput: Int => Unit = (n: Int) => n match {
        case x if x <= 0 => println("Negative/Zero is input");
        case x if x % 2 == 0 => println("Even number is given");
        case _ => println("Odd number is given");
    }
    
    def main(args: Array[String]): Unit = {
        if (args.length > 0) {
            val input = args(0).toInt
            evaluateInput(input)
        } else {
            println("Please try again with an integer input.")
        }
    }
}
