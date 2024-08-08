package DSA

class ValidParenthesis {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '{', '(', '[' -> stack.addLast(c)
                '}' -> stack.removeLastOrNull().let { if (it != '{') return false }
                ')' -> stack.removeLastOrNull().let { if (it != '(') return false }
                ']' -> stack.removeLastOrNull().let { if (it != '[') return false }
            }
        }
        return stack.isEmpty()
    }
}