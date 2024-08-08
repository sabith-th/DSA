package Random

class GrumpyBookstoreOwner {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var zeroSum = 0
        var windowSum = 0
        var maxWindowSum = 0
        for (i in customers.indices) {
            zeroSum += if (grumpy[i] == 0) customers[i] else 0
            if (i < minutes) {
                windowSum += if (grumpy[i] == 1) customers[i] else 0
            } else {
                windowSum += if (grumpy[i] == 1) customers[i] else 0
                windowSum -= if (grumpy[i- minutes] == 1) customers[i-minutes] else 0
            }
            maxWindowSum = maxOf(maxWindowSum, windowSum)
        }
        return maxWindowSum + zeroSum
    }
}

fun main() {
    val test = GrumpyBookstoreOwner()
    println(test.maxSatisfied(intArrayOf(1,0,1,2,1,1,7,5), intArrayOf(0,1,0,1,0,1,0,1), 3))
}