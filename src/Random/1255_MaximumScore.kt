package Random

class MaximumScore {

    private fun getWordScore(word: String, letters: MutableMap<Char, Int>, score: Map<Char, Int>): Int {
        var total = 0
        var i = 0
        while (i  < word.length) {
            val c = word[i]
            if ((letters[c] ?: 0) > 0) {
                total += score[c] ?: 0
                letters[c]?.let {
                    if (it > 0) {
                        letters[c] = it - 1
                    }
                }
//                letters[c] = letters[c]!! - 1
                i++
            } else {
                total = -1
                i--
                break
            }
        }
        if (i != word.length) {
            while (i >= 0) {
                letters[word[i]] = (letters[word[i]]?:0) + 1
                i--
            }
        }

        return total
    }

    private fun resetLetters(word: String, letters: MutableMap<Char, Int>) {
        for (c in word) {
            letters[c] = (letters[c]?:0) + 1
        }
    }

    private fun helper(i: Int, words: Array<String>, letters: MutableMap<Char, Int>, score: Map<Char, Int>, maxScore: Int): Int {
        if (i == words.size) {
            return maxScore
        }
        var withWordScore = 0
        val wordScore = getWordScore(words[i], letters, score)
        if (wordScore >= 0) {
            withWordScore = helper(i+1, words, letters, score, maxScore + wordScore)
            resetLetters(words[i], letters)
        }
        val withoutWordScore = helper(i+1, words, letters, score, maxScore)
        return maxOf(withWordScore, withoutWordScore)
    }

    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val lettersMap = mutableMapOf<Char, Int>()
        for (l in letters) {
            if (lettersMap.containsKey(l)) {
                lettersMap[l] = (lettersMap[l]?:0) + 1
            } else {
                lettersMap[l] = 1
            }
        }

        val scoreMap = mutableMapOf<Char, Int>()
        for (i in score.indices) {
            scoreMap[(97+i).toChar()] = score[i]
        }

        return helper(0, words, lettersMap, scoreMap, 0)
    }
}

fun main() {
    val test = MaximumScore()
    val words = arrayOf("dog","cat","dad","good")
    val letters = charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o')
    val score = intArrayOf(1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0)
    println(test.maxScoreWords(words, letters, score))
}