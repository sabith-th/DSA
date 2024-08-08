package DSA

class SearchA2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var l = 0
        var r = m * n - 1
        while (l <= r) {
            val mid = (l + r) / 2
            val i = mid / n
            val j = mid % n
            if (matrix[i][j] == target) return true
            else if (matrix[i][j] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return false
    }
}

fun main() {
    val test = SearchA2DMatrix()
    val matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20),intArrayOf(23,30,34,60))
    println(test.searchMatrix(matrix, 3))
}