package Random

class LongestContinuousSubArrayWithMaxDiff {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var ans = 1
        var minQ = ArrayDeque<Int>()
        var maxQ = ArrayDeque<Int>()
        var l = 0
        var r = 0
        while (r < nums.size) {
            while (!minQ.isEmpty() && minQ.last() > nums[r]) {
                minQ.removeLast()
            }
            minQ.addLast(nums[r])
            while (!maxQ.isEmpty() && maxQ.last() < nums[r]) {
                maxQ.removeLast()
            }
            maxQ.addLast(nums[r])
            while (maxQ.first() - minQ.first() > limit) {
                if (minQ.first() == nums[l])
                    minQ.removeFirst()
                if (maxQ.first() == nums[l])
                    maxQ.removeFirst()
                l++
            }
            ans = maxOf(ans, r - l + 1)
            r++
        }
        return ans
    }
}