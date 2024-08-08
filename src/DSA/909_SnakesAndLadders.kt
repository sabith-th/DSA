package DSA

class SnakesAndLadders {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        var i = 1
        val cells = Array<Pair<Int, Int>>(n*n + 1) { 0 to 0 }
        val columns = IntArray(n)
        for (j in 0..<n) columns[j] = j
        for (row in n-1 downTo 0) {
            for (col in columns) {
                cells[i++] = row to col
            }
            columns.reverse()
        }
        val distance = IntArray(n*n + 1) { -1 }
        distance[1] = 0
        val q = ArrayDeque<Int>()
        q.add(1)
        while (q.isNotEmpty()) {
            val cell = q.removeFirst()
            for (next in cell+1..minOf(n*n, cell+6)) {
                val (row, col) = cells[next]
                val destination = if (board[row][col] != -1) board[row][col] else next
                if (distance[destination] == -1) {
                    distance[destination] = 1 + distance[cell]
                    q.add(destination)
                }

            }
        }
        return distance[n * n]
    }
}