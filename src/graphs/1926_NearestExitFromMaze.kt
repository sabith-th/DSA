package graphs

class NearestExitFromEntranceInMaze {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size
        val n = maze[0].size
        var steps = 0
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(entrance[0] to entrance[1])
        maze[entrance[0]][entrance[1]] = '+'

        fun isValid(i: Int, j: Int): Boolean {
            return (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == '.')
        }

        fun isExit(i: Int, j: Int): Boolean {
            if (i == entrance[0] && j == entrance[1]) return false
            return (i == 0 || i == m-1 || j == 0 || j == n-1)
        }

        while (q.isNotEmpty()) {
            val size = q.size
            repeat(size) {
                val (x, y) = q.removeFirst()
                if (isExit(x, y)) return steps
                for ((dX, dY) in dirs) {
                    val nextX = x + dX
                    val nextY = y + dY
                    if (isValid(nextX, nextY)) {
                        maze[nextX][nextY] = '+' //mark as visited
                        q.add(nextX to nextY)
                    }
                }
            }
            steps++
        }

        return -1
    }
}

fun main() {
    val test = NearestExitFromEntranceInMaze()
    var maze = arrayOf(charArrayOf('+','+','.','+'),charArrayOf('.','.','.','+'),charArrayOf('+','+','+','.'))
    var entrance = intArrayOf(1,2)
    println("Computed: ${test.nearestExit(maze, entrance)} Expected: 1")
    maze = arrayOf(charArrayOf('+','+','+'),charArrayOf('.','.','.'),charArrayOf('+','+','+'))
    entrance = intArrayOf(1,0)
    println("Computed: ${test.nearestExit(maze, entrance)} Expected: 2")
}