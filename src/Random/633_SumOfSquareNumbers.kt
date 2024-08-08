package Random

class SumOfSquareNumbers {
    fun judgeSquareSum(c: Int): Boolean {
        val newC = c.toLong()
        var start: Long = 0
        var end: Long = Math.sqrt(newC.toDouble()).toLong()
        while (start <= end) {
            val sqSum = (start * start) + (end * end)
            if (sqSum == newC) {
                return true
            } else if (sqSum > newC) {
                end--
            } else {
                start++
            }
        }
        return false
    }
}