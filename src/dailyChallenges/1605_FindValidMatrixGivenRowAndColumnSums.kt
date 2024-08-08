package dailyChallenges

import java.util.PriorityQueue

class FindValidMatrixGivenRowAndColumnSums {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val m = rowSum.size
        val n = colSum.size
        val matrix = Array<IntArray> (m) { IntArray(n) }
        var i = 0
        var j = 0
        while (i < m && j < n) {
            val minVal = minOf(rowSum[i], colSum[j])
            matrix[i][j] = minVal
            rowSum[i] -= minVal
            colSum[j] -= minVal
            if (rowSum[i] == 0) {
                i++
            } else {
                j++
            }
        }
        return matrix
    }
}