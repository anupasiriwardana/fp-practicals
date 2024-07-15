object fibonacci{
    def fib(n : Int) : Int = n match{
        case 0 => 0;
        case 1 => 1;
        case _ => fib(n-1) + fib(n-2);
    }

    def main(args: Array[String]) : Unit = {
        print("Enter the number of terms : ");
        val n = scala.io.StdIn.readInt();
        for(i <- 0 to n-1){
            print(fib(i) + " ");
        }
    }
}