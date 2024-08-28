package dailyChallenges

class CountSubIslands {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val m = grid1.size
        val n = grid1[0].size
        var ans = 0

        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        var isSubIsland = false

        fun dfs(i: Int, j: Int) {
            if (i < 0 || i >= m || j < 0 || j >= n) return
            if (grid2[i][j] != 1) return
            if (grid1[i][j] != 1) isSubIsland = false
            grid2[i][j] = 2
            for ((dX, dY) in dirs) {
                dfs(i+dX, j+dY)
            }
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true
                    dfs(i, j)
                    if (isSubIsland) {
                        ans++
                    }
                }
            }
        }

        return ans
    }
}

fun main() {
    val test = CountSubIslands()
    val grid1 = arrayOf(intArrayOf(1,1,1,0,0),intArrayOf(0,1,1,1,1),intArrayOf(0,0,0,0,0),intArrayOf(1,0,0,0,0),intArrayOf(1,1,0,1,1))
    val grid2 = arrayOf(intArrayOf(1,1,1,0,0),intArrayOf(0,0,1,1,1),intArrayOf(0,1,0,0,0),intArrayOf(1,0,1,1,0),intArrayOf(0,1,0,1,0))
    println("Computed: ${test.countSubIslands(grid1, grid2)} Expected: 3")
}