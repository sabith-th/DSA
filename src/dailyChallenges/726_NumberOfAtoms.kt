package dailyChallenges

class NumberOfAtoms {
    fun countOfAtoms(formula: String): String {
        val stack = ArrayDeque<Pair<String, Int>>()
        var i = 0
        val n = formula.length
        while (i < n) {
            var ch = formula[i]
            if (ch.isUpperCase()) {
                var el = "$ch"
                var j = i+1
                while (j < n) {
                    if (formula[j].isLowerCase()) {
                        el = "$el${formula[j]}"
                    } else {
                        break
                    }
                    j++
                }
                var count = ""
                while (j < n) {
                    if (formula[j].isDigit()) {
                        count = "$count${formula[j]}"
                    } else {
                        break
                    }
                    j++
                }
                stack.add(Pair(el, if (count != "") count.toInt() else 1))
                i = j
            } else if (ch == '(') {
                stack.add(Pair("(", 0))
                i++
            } else if (ch == ')') {
                var j = i+1
                var count = ""
                while (j<n) {
                    if (formula[j].isDigit()) {
                        count = "$count${formula[j]}"
                    } else {
                        break
                    }
                    j++
                }
                val factor = if (count != "") count.toInt() else 1
                val elems = mutableListOf<Pair<String, Int>>()
                while (stack.isNotEmpty()) {
                    val top = stack.removeLast()
                    if (top.first == "(") {
                        break
                    }
                    elems.add(Pair(top.first, top.second * factor))
                }
                while (elems.isNotEmpty()) {
                    stack.add(elems.removeLast())
                }
                i = j
            }
        }
        val map = mutableMapOf<String, Int>()
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            map[top.first] = map.getOrDefault(top.first, 0) + top.second
        }
        val ans = StringBuilder()
        for (el in map.keys.sorted()) {
            if (map[el]!! > 1) {
                ans.append("$el${map[el]}")
            } else {
                ans.append(el)
            }
        }
        return ans.toString()
    }
}