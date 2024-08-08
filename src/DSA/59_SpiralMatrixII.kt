package DSA

class SpiralMatrixII {
    fun generateMatrix(n: Int): Array<IntArray> {
        val ans: Array<IntArray> = Array(n) { IntArray(n) }
        var rowStart = 0
        var rowEnd = n - 1
        var colStart = 0
        var colEnd = n - 1
        var num = 1
        while (rowStart <= colStart && colStart <= colEnd) {
            for (j in colStart..colEnd) {
                ans[rowStart][j] = num
                num++
            }
            rowStart++
            for (i in rowStart..rowEnd) {
                ans[i][colEnd] = num
                num++
            }
            colEnd--
            for (j in colEnd downTo colStart) {
                ans[rowEnd][j] = num
                num++
            }
            rowEnd--
            for (i in rowEnd downTo rowStart) {
                ans[i][colStart] = num
                num++
            }
            colStart++
        }
        return ans
    }
}

fun main() {
    val test = SpiralMatrixII()
    println(test.generateMatrix(3))
}