package dailyChallenges

class ReverseSubstringBetweenParentheses {
    fun reverseParentheses(s: String): String {
        val stack = ArrayDeque<Char>()
        val queue = ArrayDeque<Char>()
        for (c in s) {
            if (c == ')') {
                var ch = stack.removeLast()
                while (ch != '(') {
                    queue.addFirst(ch)
                    ch = stack.removeLast()
                }
                while (queue.isNotEmpty()) {
                    stack.add(queue.removeLast())
                }
            } else {
                stack.add(c)
            }
        }
        return stack.joinToString("")
    }

    fun reverseParentheses2(s: String): String {
        val oppIndex = IntArray(s.length) { -1 }
        val stack = ArrayDeque<Int>()
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.add(i)
            } else if (s[i] == ')') {
                val j = stack.removeLast()
                oppIndex[i] = j
                oppIndex[j] = i
            }
        }

        var ans = ""
        var dir = 1
        var i = 0
        while (i < s.length) {
            if (s[i] == '(' || s[i] == ')') {
                i = oppIndex[i]
                dir *= -1
            } else {
                ans += s[i]
            }
            i += dir
        }
        return ans
    }
}