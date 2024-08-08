package days100placements100

class CountSmallerAfterSelf {
    fun countSmaller(nums: IntArray): List<Int> {
        val n = nums.size
        val bit = IntArray(n+1)

        fun update(idx: Int, value: Int) {
            var i = idx
            while (i <= n) {
                bit[i] += value
                i = i + (i and -i)
            }
        }

        fun query(idx: Int): Int {
            var i = idx
            var ans = 0
            while (i > 0) {
                ans += bit[i]
                i = i - (i and -i)
            }
            return ans
        }

        val numsPair = mutableListOf<Pair<Int, Int>>()
        for (i in nums.indices) {
            numsPair.add(nums[i] to i)
        }
        numsPair.sortWith(compareBy { it.first })
        val ans = IntArray(n)
        for (numPair in numsPair) {
            update(numPair.second + 1, 1)
            ans[numPair.second] = query(n+1) - query(numPair.second + 1)
        }
        return ans.toList()
    }

    fun countSmaller2(nums: IntArray): List<Int> {
        val n = nums.size
        val ans = IntArray(n)

        val numsPair = Array<Pair<Int, Int>>(n){ 0 to 0 }
        for (i in nums.indices) {
            numsPair[i] = nums[i] to i
        }

        fun merge(left: Int, mid: Int, right: Int) {
            val temp = Array<Pair<Int, Int>>(right - left + 1) { 0 to 0 }
            var i = left
            var j = mid + 1
            var k = 0
            var rightCount = 0

            while (i <= mid && j <= right) {
                if (numsPair[i].first > numsPair[j].first) {
                    ++rightCount
                    temp[k++] = numsPair[j].first to numsPair[j].second
                    j++
                } else {
                    ans[numsPair[i].second] += rightCount
                    temp[k++] = numsPair[i].first to numsPair[i].second
                    i++
                }
            }

            while(i <= mid) {
                ans[numsPair[i].second] += rightCount
                temp[k++] = numsPair[i].first to numsPair[i].second
                i++
            }
            while (j <= mid) {
                temp[k++] = numsPair[j].first to numsPair[j].second
                j++
            }

            for (ind in left..right) {
                numsPair[ind] = temp[ind - left].first to temp[ind - left].second
            }
        }

        fun mergeSort(left: Int, right: Int) {
            if (left < right) {
                val mid = left + (right - left) / 2
                mergeSort(left, mid)
                mergeSort(mid+1, right)
                merge(left, mid, right)
            }
        }

        mergeSort(0, n-1)
        return ans.toList()
    }
}

fun main() {
    val test = CountSmallerAfterSelf()
    println(test.countSmaller2(intArrayOf(0,2,1)))
}
