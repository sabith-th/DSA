package DSA

class NumberOfSubsequencesThatSatisfySumCondition {

    fun power(base: Int, exponent: Int, mod: Int): Int {
        var res = 1
        var num = exponent
        var a = base
        while (num > 0) {
            if (num % 2 == 1) {
                res = (res * a) % mod
                num--
            } else {
                a = (a * a) % mod
                num /= 2
            }
        }
        return res
    }
    fun numSubseq(nums: IntArray, target: Int): Int {
        var ans = 0
        var mod = 1_000_000_007
        val n = nums.size
        nums.sort()
        val pow = IntArray(n)
        pow[0] = 1
        for (i in 1..<n) {
            pow[i] = (pow[i-1] shl 1) % mod
        }
        var i = 0
        var j =  n - 1
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                ans += pow[j-i]
                ans %= mod
                i++
            } else {
                j--
            }
        }
        return ans
    }
}