import scala.io.StdIn.readInt
class Rational(n: Int, d: Int) {
    private val gcdVal: Int = gcd(n.abs, d.abs)
    val numerator: Int = n / gcdVal
    val denominator: Int = d / gcdVal

    def neg: Rational = new Rational(-numerator, denominator)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
}

object Main extends App {
    print("Enter the numerator of the fraction : ");
    val numerator = readInt();
    print("Enter the denominator of the fraction : ");
    val denominator = readInt();
    if(denominator == 0){
        println("Denominator cannot be zero");
        System.exit(0);
    }
    val x = new Rational(numerator,denominator)
    println("x = "+ x)
    println("x.neg = " + x.neg)
}
