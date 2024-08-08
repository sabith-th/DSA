package dailyChallenges

class MinNumPushesToTypeWord {
    fun minimumPushes(word: String): Int {
        val count = mutableMapOf<Char, Int>()
        for (c in word) {
            count.merge(c, 1, Integer::sum)
        }

        var ans = 0
        count.values
            .sortedDescending()
            .windowed(8, 8, true)
            .forEachIndexed {
                i, counts -> ans += (i+1) * counts.sum()
            }
        return ans
    }
}

fun main() {
    val test = MinNumPushesToTypeWord()
    println(test.minimumPushes("xyzxyzxyzxyz"))
}