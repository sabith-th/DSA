package hackerrank

class ClimbingTheLeaderBoard {
    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        // Write your code here
        val rankedSet = mutableListOf<Int>()
        var prev = -1
        for (score in ranked) {
            if (score == prev) continue
            rankedSet.addFirst(score)
            prev = score
        }

        val ans = Array<Int>(player.size) { 0 }

        fun firstGreaterEqual(target: Int): Int {
            val i = rankedSet.binarySearch(target)
            return if (i < 0) (-i-1) else i
        }

        for (i in player.indices) {
            val gtIndex = firstGreaterEqual(player[i])
            if (gtIndex < rankedSet.size) {
                ans[i] = rankedSet.size - gtIndex + if (rankedSet[gtIndex] == player[i]) 0 else 1
            } else {
                ans[i] = 1
            }
        }
        return ans
    }
}

fun main() {
    val test = ClimbingTheLeaderBoard()
    println(test.climbingLeaderboard(arrayOf(100, 90, 90, 80), arrayOf(70, 80, 105)))
}