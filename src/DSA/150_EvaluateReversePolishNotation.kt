package DSA

class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        val op = mapOf<String, (a: Int, b: Int) -> Int>(
            "+" to {a, b -> a + b},
            "-" to {a, b -> a - b},
            "*" to {a, b -> a * b},
            "/" to {a, b -> a / b}
        )

        for (token in tokens) {
            if (token in op) {
                val op2 = stack.removeLast()
                val op1 = stack.removeLast()
                stack.add(op[token]!!(op1, op2))
            } else {
                stack.add(token.toInt())
            }
        }

        return stack.last()
    }
}