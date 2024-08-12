import scala.io.StdIn.readInt
object NumberCategorizer {
    def categorizeNum(num : Int) : Unit = num match {
        case num if (num%3 == 0 && num%5 == 0) => println("Multiple of Both Three and Five");
        case num if (num%3 == 0) => println("Multiple of Three");
        case num if (num%5 == 0) => println("Multiple of Five");
        case _ => println("Not a Multiple of Three or Five");
    }

    def main(args : Array[String]) : Unit = {
        print("Enter a number : ");
        val x = readInt();

        print("Number "+ x + " is -> ");
        categorizeNum(x);
    } 
}
