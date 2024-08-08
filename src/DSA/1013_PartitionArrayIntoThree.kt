package DSA

class PartitionArrayIntoThreePartsWithEqualSum {
    fun canThreePartsEqualSum(arr: IntArray): Boolean {
        val sum = arr.sum()
        if (sum % 3 != 0) return false
        val avg = sum / 3
        var partCount = 0
        var partSum = 0
        for (num in arr) {
            partSum += num
            if (partSum == avg) {
                partSum = 0
                partCount++
            }
        }
        return partCount >= 3

    }
}