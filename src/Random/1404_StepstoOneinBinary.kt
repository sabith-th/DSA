package Random

class StepsToOneInBinary {
    private fun addOne(s: MutableList<String>) {
        var i = s.size - 1
        while (i >= 0) {
            if (s[i] == "0") {
                s[i] = "1"
                return
            } else {
                s[i] = "0"
                i--
            }
        }
        s.add(0, "1")
//        s.addFirst("1")
    }

    fun numSteps(s: String): Int {
        val num = s.splitToSequence("").filter { it != "" }.toMutableList()
        var ans = 0
        while (num.size > 1) {
            if (num.last() == "0") {
                num.removeLast()
            } else {
                addOne(num)
            }
            ans++
        }
        return ans
    }
}

fun main() {
    val test = StepsToOneInBinary()
    println(test.numSteps("1101"))
}