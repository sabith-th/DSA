package dailyChallenges

class MaxScoreFromRemovingSubstrings {
    private fun helper(s: String, sub: String, p: Int): Pair<String, Int> {
        var w = 0
        var r = 0
        var newS = mutableListOf<Char>()
        var total = 0
        for (r in 0..<s.length) {
            newS.add(s[r])
            w++
            if (w>1 && newS[w-1]==sub[1] && newS[w-2]==sub[0]) {
                w -= 2
                newS.removeLast()
                newS.removeLast()
                total += p
            }
        }
        return Pair(newS.joinToString(""), total)
    }

    fun maximumGain(s: String, x: Int, y: Int): Int {
        var s1 = "ab"
        var s2 = "ba"
        var p1 = x
        var p2 = y
        if (x < y) {
            s2 = "ab"
            s1 = "ba"
            p1 = y
            p2 = x
        }
        var (newS, total1) = helper(s, s1, p1)
        var (_, total2) = helper(newS, s2, p2)
        return total1 + total2
    }
}