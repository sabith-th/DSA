package dailyChallenges

class ChalkReplacer {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var remaining = 0L
        for (c in chalk) {
            remaining += c.toLong()
        }
        remaining = k % remaining
        var i = 0
        while (i < chalk.size) {
            if (remaining < chalk[i]) break
            remaining -= chalk[i++]
        }
        return i
    }
}

fun main() {
    val test = ChalkReplacer()
    println("Computed: ${test.chalkReplacer(intArrayOf(5,1,5), 22)} Expected: 0")
}