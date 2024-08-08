package Random

class MaximizeHappiness {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val sorted = happiness.sortedDescending()
        var happinessSum = 0
        for (i in 0..<k) {
            happinessSum += if (sorted[i] - i >= 0) sorted[i] - i else 0
        }
        return happinessSum.toLong()
    }
}