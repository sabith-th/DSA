package DSA

class NQueens {
    private fun backTrack(n: Int, row: Int, state: MutableList<MutableList<Char>>, ans: MutableList<MutableList<String>>) {
        if (row==n) {
            val newValidState = mutableListOf<String>()
            for (row in state) {
                newValidState.add(row.joinToString(""))
            }
            ans.add(newValidState)
        } else {
            for (j in 0..<n) {
                if (isValid(state, row, j)) {
                    state[row][j] = 'Q'
                    backTrack(n, row + 1, state, ans)
                    state[row][j] = '.'
                }
            }
        }
    }

    private fun isValid(state: List<List<Char>>, row: Int, col: Int): Boolean {
        //Check the column
        for (i in 0..<row) {
            if (state[i][col] == 'Q') {
                return false
            }
        }
        // Check 135 deg horizontally
        var i = row-1
        var j = col-1
        while (i >= 0 && j >= 0) {
            if (state[i][j] == 'Q') {
                return false
            }
            i--
            j--
        }
        i = row-1
        j = col+1
        // Check 45 deg horizontally
        while (i >= 0 && j < state.size) {
            if (state[i][j] == 'Q') {
                return false
            }
            i--
            j++
        }
        return true
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val ans = mutableListOf<MutableList<String>>()
        val state = mutableListOf<MutableList<Char>>()
        repeat (n) {
            var row = mutableListOf<Char>()
            repeat (n) {
                row.add('.')
            }
            state.add(row)
        }
        backTrack(n, 0, state, ans)
        return ans
    }
}

fun main() {
    val test = NQueens()
    println(test.solveNQueens(4))
}