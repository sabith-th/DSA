package DSA

class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        var ans = 0
        val m = grid.size
        val n = grid[0].size
        val visited = Array<BooleanArray>(m) { BooleanArray(n) }


        fun dfs(x: Int, y: Int): Int {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return 0
            }
            if (visited[x][y] || grid[x][y] == 0) return 0
            visited[x][y] = true
            var area = 1
            for ((dirX, dirY) in dirs) {
                area += dfs(x + dirX, y + dirY)
            }
            return area
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = maxOf(ans, dfs(i, j))
                }
            }
        }

        return ans
    }
}