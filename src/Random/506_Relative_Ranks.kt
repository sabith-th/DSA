package Random

import kotlin.collections.indices
import kotlin.collections.reversed
import kotlin.collections.set
import kotlin.collections.sorted

class RelativeRanks {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val orderMap = mutableMapOf<Int, Int>()

        for (i in score.indices) {
            orderMap[score[i]] = i
        }

        val ans = Array(score.size) { "" }
        val orderedScore = score.sorted().reversed()
        for (i in orderedScore.indices) {
            val index = orderMap[orderedScore[i]]!!
            when (i) {
                0 -> ans[index] = "Gold Medal"
                1 -> ans[index] = "Silver Medal"
                2 -> ans[index] = "Bronze Medal"
                else -> ans[index] = "${i+1}"
            }
        }

        return ans
    }
}