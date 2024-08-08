package days100placements100

class MedianOfSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size

        fun kthLargest(nums1Start: Int, nums2Start: Int, k: Int): Int {
            if (nums1Start >= m) {
                return nums2[nums2Start + k - 1]
            }
            if (nums2Start >= n) {
                return nums1[nums1Start + k - 1]
            }
            if (k == 1) {
                return minOf(nums1[nums1Start], nums2[nums2Start])
            }

            val mid = k / 2
            val midValNums1 = if (nums1Start + mid - 1 < m) nums1[nums1Start + mid - 1] else Int.MAX_VALUE
            val midValNums2 = if (nums2Start + mid - 1 < n) nums2[nums2Start + mid - 1] else Int.MAX_VALUE

            if (midValNums1 < midValNums2) {
                return kthLargest(nums1Start + mid, nums2Start, k - mid)
            } else {
                return kthLargest(nums1Start, nums2Start + mid, k - mid)
            }
        }

        val leftMedian = kthLargest(0, 0, (m + n + 1) / 2)
        val rightMedian = kthLargest(0, 0, (m + n + 2) / 2)

        return (leftMedian + rightMedian) / 2.0
    }
}