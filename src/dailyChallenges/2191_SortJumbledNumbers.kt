package dailyChallenges

class SortJumbledNumbers {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val mappedNums = mutableMapOf<Int, Pair<Int, Int>>()

        fun getMapping(num: Int): Int {
            var newN = StringBuilder()
            for (digit in num.toString()) {
                newN.append(mapping[digit - '0'])
            }
            return newN.toString().toInt()
        }

         for (i in nums.indices) {
             val num = nums[i]
             mappedNums[num] = getMapping(num) to i
         }

        return nums.sortedWith( compareBy<Int> { mappedNums[it]?.first }.thenBy { mappedNums[it]?.second } ).toIntArray()
    }
}

fun main() {
    val test = SortJumbledNumbers()
    println(test.sortJumbled(intArrayOf(7,9,4,1,0,3,8,6,2,5), intArrayOf(454,404,95,47799,19021,162535,51890378)))
}