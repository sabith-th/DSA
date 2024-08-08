package Random

import kotlin.text.indices

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")


fun solution(S: String): Int {
    // Implement your Random.solution here
    var openCount = 0
    var optionCount = 0
    var ans = 0
    var currLength = 0
    val optionIndices = mutableListOf<Int>()
    for (i in S.indices) {
        if (S[i] == '<') {
            if (openCount == 0) {
                ans = maxOf(ans, currLength)
                currLength = 0
            }
            openCount += 1
            optionCount = 0
        } else if (S[i] == '?') {
            optionCount += 1
            optionIndices.add(i)
        } else {
            if (openCount > 0) {
                currLength += 2
                openCount -= 1
            } else if (optionCount > 0) {
                currLength += 2
                optionCount -= 1
            } else {
                ans = maxOf(ans, currLength)
                currLength = 0
            }
        }
    }
    ans = maxOf(ans, currLength)
    if (openCount > 0) {
        ans = maxOf(ans, 2 * minOf(openCount, optionCount))
    } else if (optionCount > 0) {
        ans = maxOf(ans, 2 * (optionCount / 2))
    }
    return ans
}

fun main() {

}