import scala.io.StdIn.readInt
object PatternMatching{
    def pattern(x:Int):Unit = x match{
        case x if(x<=0) => println("Negative/zero");
        case x if(x%2 == 0) => println("Even number");
        case x if(x%2 != 0) => println("Odd number");
    }

    def main(args:Array[String]):Unit= {
        print("Please enter an integer : ");
        val num = readInt();
        pattern(num);
    }
}