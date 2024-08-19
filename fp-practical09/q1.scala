import scala.io.StdIn.readLine

object InterestCalculator{
    val findInterest: Double => Unit = (deposit : Double) => deposit match{
        case x if x <= 20000 => print(x*0.02);
        case x if x <= 200000 => print(x*0.04);
        case x if x <= 2000000 => print(x*0.035);
        case x if x > 2000000 => print(x*0.065);
    }

    def main(args : Array[String]): Unit = {
        print("Enter deposit Amount : ");
        val depositAmount = readLine().toDouble;
        print("Interest for deposit "+depositAmount+" is = ");
        findInterest(depositAmount)
    }
}