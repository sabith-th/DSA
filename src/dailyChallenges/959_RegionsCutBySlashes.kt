package dailyChallenges

class RegionCutBySlashes {
    fun regionsBySlashes(grid: Array<String>): Int {
        val n = grid.size
        // Up-scaled grid
        val g = Array<IntArray>(n*3) { IntArray(n*3) }

        for (i in grid.indices) {
            for (j in 0..<n) {
                if (grid[i][j] == '/') {
                    g[i * 3][j * 3 + 2] = 1
                    g[i * 3 + 1][j * 3 + 1] = 1
                    g[i * 3 + 2][j * 3] = 1
                } else if (grid[i][j] == '\\') {
                    g[i * 3][j * 3] = 1
                    g[i * 3 + 1][j * 3 + 1] = 1
                    g[i * 3 + 2][j * 3 + 2] = 1
                }
            }
        }

        var ans = 0
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        fun dfs(i: Int, j: Int) {
            if (i < 0 || i >= g.size || j < 0 || j >= g.size) return
            if (g[i][j] != 0) return
            g[i][j] = 2
            for ((dX, dY) in dirs) {
                dfs(i + dX, j + dY)
            }
        }

        for (i in g.indices) {
            for (j in g.indices) {
                if (g[i][j] == 0) {
                    dfs(i, j)
                    ans++
                }
            }
        }

        return ans
    }
}