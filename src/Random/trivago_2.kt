package Random

import kotlin.text.indices

fun solution2(S: String) : Int {
    val leftArray = IntArray(S.length + 1)
    val rightArray = IntArray(S.length + 1)
    var ans = 0

    for (i in S.indices) {
        if (S[i] == '<' || S[i] == '?') {
            if (i == 0) {
                leftArray[i]  = 1
            } else {
                leftArray[i] = leftArray[i - 1] + 1
            }
        }

        if (S[S.length - i - 1] == '>' || S[S.length - i - 1] == '?') {
            if (i == S.length - 1) {
                rightArray[i] = 1
            } else {
                rightArray[S.length - i - 1] = rightArray[S.length - i] + 1
            }
        }
    }

    for (i in S.indices) {
        ans = maxOf(ans, 2 * minOf(leftArray[i], rightArray[i+1]))
    }

    return ans
}




fun main() {
    println("${solution2("<<<>>>")} == 6")
    println("${solution2(">>>>")} == 0")
    println("${solution2("<><<>>>")} == 4")
    println("${solution2("<<<>>>>>>>")} == 6")
    println("${solution2("???>>")} == 4")
    println("${solution2("<<??>>")} == 6")
    println("${solution2("??<<>>")} == 4")
    println("${solution2("??<<>>>>")} == 8")
    println("${solution2("<><<<?>>>>")} == 8")
}