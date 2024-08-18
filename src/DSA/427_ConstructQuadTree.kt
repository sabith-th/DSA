package DSA

class QuadTree {
    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun construct(grid: Array<IntArray>): Node? {
        fun dfs(topLeftRow: Int, topLeftColumn: Int, bottomRightRow: Int, bottomRightColumn: Int): Node? {
            var ones = false
            var zeroes = false
            for (i in topLeftRow..bottomRightRow) {
                for (j in topLeftColumn..bottomRightColumn) {
                    if (grid[i][j] == 1) {
                        ones = true
                    } else {
                        zeroes = true
                    }
                    if (ones && zeroes) {
                        break
                    }
                }
                if (ones && zeroes) {
                    break
                }
            }
            val isLeaf = ones xor zeroes
            val node = Node(ones, isLeaf)
            if (!isLeaf) {
                val midRow = (topLeftRow + bottomRightRow) / 2
                val midColumn = (topLeftColumn + bottomRightColumn) / 2
                node.topLeft = dfs(topLeftRow, topLeftColumn, midRow, midColumn)
                node.topRight = dfs(topLeftRow, midColumn + 1, midRow, bottomRightColumn)
                node.bottomLeft = dfs(midRow + 1, topLeftColumn, bottomRightRow, midColumn)
                node.bottomRight = dfs(midRow + 1, midColumn + 1, bottomRightRow, bottomRightColumn)
            }

            return node
        }
        return dfs(0, 0, grid[0].size-1, grid[0].size-1)
    }
}

fun main() {
    val test = QuadTree()
    println(test.construct(arrayOf(intArrayOf(0,1),intArrayOf(1,0))))
}