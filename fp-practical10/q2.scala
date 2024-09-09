import scala.io.StdIn.readInt
class Rational(n: Int, d: Int) {
    private val gcdVal: Int = gcd(n.abs, d.abs)
    val numerator: Int = n / gcdVal
    val denominator: Int = d / gcdVal

    def neg: Rational = new Rational(-numerator, denominator)

    def sub(that: Rational): Rational = {
        val commonDenominator = denominator * that.denominator
        val newNumerator = (numerator * that.denominator) - (that.numerator * denominator)
        new Rational(newNumerator, commonDenominator)
    }

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
}

object Main extends App {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    println("x - y - z = " + x.sub(y).sub(z))
}
