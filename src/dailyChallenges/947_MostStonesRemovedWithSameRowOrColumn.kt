package dailyChallenges

class MostStonesRemovedWithSameRowOrColumn {
    fun removeStones(stones: Array<IntArray>): Int {
        var connectedComponents = 0

        val adjListX = mutableMapOf<Int, MutableList<Int>>()
        val adjListY = mutableMapOf<Int, MutableList<Int>>()
        for (i in stones.indices) {
            val u = stones[i][0]
            val v = stones[i][1]
            adjListX.getOrPut(u) {mutableListOf()}.add(i)
            adjListY.getOrPut(v) {mutableListOf()}.add(i)
        }

        val visited = mutableSetOf<Int>()

        fun dfs(i: Int) {
            if (i in visited) return
            visited.add(i)
            val u = stones[i][0]
            val v = stones[i][1]
            for (j in adjListX.getOrDefault(u, emptyList())) {
                if (j in visited) continue
                dfs(j)
            }
            for (j in adjListY.getOrDefault(v, emptyList())) {
                if (j in visited) continue
                dfs(j)
            }
        }

        for (i in stones.indices) {
            if (i !in visited) {
                dfs(i)
                connectedComponents++
            }
        }

        return stones.size - connectedComponents
    }
}

fun main() {
    val test = MostStonesRemovedWithSameRowOrColumn()
    println("Computed: ${test.removeStones(arrayOf(intArrayOf(0,0),intArrayOf(0,1),intArrayOf(1,0),intArrayOf(1,2),intArrayOf(2,1),intArrayOf(2,2)))} Expected: 5")
}