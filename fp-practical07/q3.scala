import scala.io.StdIn.readLine

object filterPrimeNum{
    def filterPrime(numList : List[Int]): List[Int] = {
        return numList.filter(x => isPrime(x));
    }

    def isPrime(num : Int) : Boolean = {
        var isPrimeNum:Boolean = true;
        if (num <= 1){
            isPrimeNum = false;
        }
        for(i <- 2 until num/2){
            if(num % i == 0){
                isPrimeNum = false;
            }
        }
        return isPrimeNum;
    }

    def main(args: Array[String]): Unit = {
        println("Enter a list of numbers seperated by commas : ");
        val inputNumList = readLine().split(",").map(_.trim.toInt).toList;

        println("Output : "+ filterPrime(inputNumList));
    }
}