package Random

class AverageWaitingTime {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var possibleStartTime = 0
        var totalWaitTime: Double = 0.0
        for (cust in customers) {
            val start = cust[0]
            val duration = cust[1]
            if (start >= possibleStartTime) {
                totalWaitTime += duration
                possibleStartTime = start + duration
            } else {
                totalWaitTime += duration + (possibleStartTime - start)
                possibleStartTime += duration
            }
        }
        return totalWaitTime.toDouble() / customers.size
    }
}

fun main() {
    val test = AverageWaitingTime()
    println(test.averageWaitingTime(arrayOf(intArrayOf(1,2),intArrayOf(2,5),intArrayOf(4,3))))
}