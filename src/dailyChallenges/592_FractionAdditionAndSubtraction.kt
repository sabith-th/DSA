package dailyChallenges

import kotlin.math.abs

class FractionAdditionAndSubtraction {

    private fun gcd(a: Int, b: Int): Int {
        return if (b==0) a else gcd(b, a%b)
    }

    fun fractionAddition(expression: String): String {
        val numerators = mutableListOf<Int>()
        val denominators = mutableListOf<Int>()
        var i = 0
        var sign = 1

        fun extractNumber(i: Int): Int {
            return if (expression[i] == '1') {
                if (i + 1 < expression.length && expression[i+1] == '0') {
                    10
                } else {
                    1
                }
            } else {
                expression[i].digitToInt()
            }
        }

        fun extractFraction() {
            val numerator = extractNumber(i)
            numerators.add(sign * numerator)
            i+=2
            if (numerator == 10) {
                i++
            }
            val denominator = extractNumber(i)
            denominators.add(denominator)
            i++
            if (denominator == 10) {
                i++
            }
        }

        if (expression[0] == '-') {
            i++
            sign = -1
        }

        while (i < expression.length) {
            extractFraction()
            if (i < expression.length) {
                sign = if (expression[i] == '+') 1 else -1
                i++
            }
        }

        var lcm = 1
        for (denominator in denominators) {
            lcm *= denominator
        }
        var numeratorSum = 0
        for (i in numerators.indices) {
            val multiplicationFactor = lcm / denominators[i]
            numeratorSum += numerators[i] * multiplicationFactor
        }

        sign = if (numeratorSum < 0) -1 else 1
        numeratorSum = abs(numeratorSum)
        val gcd = gcd(lcm, numeratorSum)
        numeratorSum = numeratorSum / gcd
        lcm = lcm / gcd
        val sb = StringBuilder()
        if (sign < 0) {
            sb.append("-")
        }
        sb.append(numeratorSum)
        sb.append("/")
        sb.append(lcm)
        return sb.toString()
    }
}

fun main() {
    val test = FractionAdditionAndSubtraction()
    println("Computed: ${test.fractionAddition("-1/2+1/2")} Expected: 0/1")
    println("Computed: ${test.fractionAddition("-1/2+1/2+1/3")} Expected: 1/3")
    println("Computed: ${test.fractionAddition("1/3-1/2")} Expected: -1/6")
}