package Random

class SpecialArrayGTX {
    fun specialArray(nums: IntArray): Int {
        val count = IntArray(101) { 0 }
        for (num in nums) {
            if (num >= 100) {
                count[100] += 1
            } else {
                count[num] += 1
            }
        }

        for (i in count.lastIndex-1 downTo 0) {
            count[i] += count[i+1]
        }

        for (x in count.indices) {
            if (x == count[x]) {
                return x
            }
        }

        return -1
    }
}

fun main() {
    val test = SpecialArrayGTX()
    println(test.specialArray(intArrayOf(3, 5)))
}