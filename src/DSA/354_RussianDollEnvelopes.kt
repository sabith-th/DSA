package DSA

class RussianDollEnvelopes {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy({it[0]}, {-it[1]}))
        val tails = mutableListOf<Int>()

        fun firstGreaterEqual(target: Int): Int {
            val i = tails.binarySearch(target)
            return if (i < 0) (-i-1) else i
        }

        for (envelope in envelopes) {
            if (tails.isEmpty() || tails.last() < envelope[1]) {
                tails.add(envelope[1])
            } else {
                val replaceIndex = firstGreaterEqual(envelope[1])
                tails[replaceIndex] = envelope[1]
            }
        }

        return tails.size
    }
}

fun main() {
    val test = RussianDollEnvelopes()
    println(test.maxEnvelopes(arrayOf(intArrayOf(5, 4), intArrayOf(6, 4), intArrayOf(6, 7), intArrayOf(2, 3))))
}