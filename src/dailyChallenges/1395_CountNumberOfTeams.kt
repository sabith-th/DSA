package dailyChallenges

class CountNumberOfTeams {
    class BIT(val n: Int) {
        val bit = IntArray(n+1)

        fun update(ind: Int, value: Int) {
            var i = ind
            while (i <= n) {
                bit[i] += value
                i = i + (i and -i)
            }
        }

        fun query(ind: Int): Int {
            var ans = 0
            var i = ind
            while (i > 0) {
                ans += bit[i]
                i = i - (i and -i)
            }
            return ans
        }
    }

    private fun binarySearch(A: List<Int>, target: Int): Int {
        var left = 0
        var right = A.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (A[mid] >= target) right = mid
            else left = mid + 1
        }
        return left + 1
    }

    fun numTeams(rating: IntArray): Int {
        val n = rating.size
        val sortedRating = rating.sorted()
        val ascTree = BIT(n)
        val descTree = BIT(n)

        for (value in rating) {
            val ind = binarySearch(sortedRating, value)
            descTree.update(ind, 1)
        }

        var totalTeams = 0
        for (i in rating.indices) {
            val index = binarySearch(sortedRating, rating[i])
            ascTree.update(index, 1)
            descTree.update(index, -1)

            val leftLessCount = ascTree.query(index-1)
            val rightMoreCount = n - i - 1 - descTree.query(index)

            totalTeams += leftLessCount * rightMoreCount
            totalTeams += (i - leftLessCount) * (n - i - 1 - rightMoreCount)
        }

        return totalTeams
    }
}