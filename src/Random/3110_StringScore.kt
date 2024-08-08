package Random

import kotlin.math.abs

class StringScore {
    fun scoreOfString(s: String): Int {
        var ans = 0
        for (i in 1..<s.length) {
            ans += abs(s[i] - s[i-1])
        }
        return ans
    }
}