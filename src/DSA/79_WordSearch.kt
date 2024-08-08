package DSA

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        val used = Array<BooleanArray>(m) { BooleanArray(n) }
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        fun backTrack(i: Int, j: Int, sIndex: Int): Boolean {
            if (sIndex == word.length) return true
            if (i < 0 || i >= m || j < 0 || j >= n) return false
            if (used[i][j]) return false
            if (board[i][j] != word[sIndex]) return false
            used[i][j] = true
            for ((dirX, dirY) in dirs) {
                if(backTrack(i + dirX, j + dirY, sIndex + 1)) return true
            }
            used[i][j] = false
            return false
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (board[i][j] == word[0]) {
                    if (backTrack(i, j, 0)) return true
                }
            }
        }

        return false
    }
}

fun main() {
    val test = WordSearch()
    val board = arrayOf(charArrayOf('A', 'B','C','E'),charArrayOf('S','F','C','S'),charArrayOf('A','D','E','E'))
    val word = "ABCCED"
    println(test.exist(board, word))
}