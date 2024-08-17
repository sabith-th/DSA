package DSA

class BasicCalculator {
    fun calculate(s: String): Int {
        var ans = 0
        var i = 0
        val stack = ArrayDeque<Int>()
        var sign = 1
        while (i < s.length) {
            when {
                s[i].isDigit() -> {
                    var num = 0
                    while (i < s.length && s[i].isDigit()) {
                        num = num * 10 + (s[i++]-'0')
                    }
                    ans += sign * num
                    i--
                }
                s[i] == '(' -> {
                    stack.add(ans)
                    stack.add(sign)
                    ans = 0
                    sign = 1
                }
                s[i] == ')' -> {
                    ans = stack.removeLast() * ans + stack.removeLast()
                }
                s[i] == '+' -> {
                    sign = 1
                }
                s[i] == '-' -> {
                    sign = -1
                }
            }
            i++
        }
        return ans
    }
}

fun main() {
    val test = BasicCalculator()
    println(test.calculate("1 + 1"))
    println(test.calculate(" 2-1 + 2 "))
    println(test.calculate("(1+(4+5+2)-3)+(6+8)"))
}