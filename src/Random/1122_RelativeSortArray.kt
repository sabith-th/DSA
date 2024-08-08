package Random

class RelativeSortArray {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val countMap = mutableMapOf<Int, Int>()
        val ans = IntArray(arr1.size)
        for (num in arr1) {
            if (num in countMap) {
                countMap[num] = countMap[num]!! + 1
            } else {
                countMap[num] = 1
            }
        }
        var i = 0
        for (j in arr2.indices) {
            val count = countMap[arr2[j]] ?: 0
            repeat(count) {
                ans[i] = arr2[j]
                i++
            }
            countMap.remove(arr2[j])
        }
        for (j in countMap.keys.sorted()) {
            val count = countMap[j] ?: 0
            repeat(count) {
                ans[i] = j
                i++
            }
        }
        return ans
    }
}