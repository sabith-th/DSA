package DSA

class LongestIncreasingPathInAMatrix {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array<IntArray>(m) { IntArray(n) {0} }

        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        fun isValid(i: Int, j: Int) = (i >= 0 && i < m && j >= 0 && j < n)

        fun dfs(i: Int, j: Int): Int {
            if (!isValid(i, j)) return 0
            if (dp[i][j] != 0) return dp[i][j]
            dp[i][j] = 1
            for ((dX, dY) in dirs) {
                val newI = i + dX
                val newJ = j + dY
                if (isValid(newI, newJ) && matrix[i][j] < matrix[newI][newJ]) {
                    dp[i][j] = maxOf(dp[i][j], 1 + dfs(newI, newJ))
                }
            }
            return dp[i][j]
        }

        var maxLen = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (dp[i][j] == 0) {
                    maxLen = maxOf(maxLen, dfs(i, j))
                }
            }
        }

        return maxLen
    }
}
fun main() {
    val test = LongestIncreasingPathInAMatrix()
    println("""
        Computed = ${test.longestIncreasingPath(arrayOf(intArrayOf(3,4,5),intArrayOf(3,2,6),intArrayOf(2,2,1)))}
        Expected = 4
    """.trimIndent())
    println("""
        Computed = ${test.longestIncreasingPath(arrayOf(intArrayOf(9,9,4),intArrayOf(6,6,8),intArrayOf(2,1,1)))}
        Expected = 4
    """.trimIndent())
}