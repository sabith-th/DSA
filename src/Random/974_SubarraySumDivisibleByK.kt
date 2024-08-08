package Random

class SubarraySumDivisibleByK {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var ans = 0
        var prefix = 0
        val count = IntArray(k)
        count[0] = 1

        for (num in nums) {
            prefix = (prefix + num % k + k) % k
            ans += count[prefix]
            ++count[prefix]
        }

        return ans
    }
}

fun main() {
    val test = SubarraySumDivisibleByK()
    println(test.subarraysDivByK(intArrayOf(4,5,0,-2,-3,1), 5))
    println(test.subarraysDivByK(intArrayOf(-1,2,9), 2))
}