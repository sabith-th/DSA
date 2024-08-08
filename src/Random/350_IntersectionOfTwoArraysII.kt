package Random

import kotlin.collections.contains
import kotlin.collections.getOrElse
import kotlin.collections.set
import kotlin.collections.sort
import kotlin.collections.toIntArray

class IntersectionOfTwoArraysII {
    class Solution {
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            nums1.sort()
            nums2.sort()
            var i = 0
            var j = 0
            var ans = mutableListOf<Int>()
            while (i < nums1.size && j < nums2.size) {
                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i])
                    i++
                    j++
                } else if (nums1[i] < nums2[j]) {
                    i++
                } else {
                    j++
                }
            }
            return ans.toIntArray()
        }

        fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
            val map1 = mutableMapOf<Int, Int>()
            val map2 = mutableMapOf<Int, Int>()
            for (num in nums1) {
                map1[num] = map1.getOrElse(num) {0} + 1
            }
            for (num in nums2) {
                map2[num] = map2.getOrElse(num) {0} + 1
            }
            val ans = mutableListOf<Int>()
            for (key in map1.keys) {
                if (key in map2) {
                    repeat(minOf(map1.getOrElse(key){0}, map2.getOrElse(key){0})) {
                        ans.add(key)
                    }
                }
            }
            return ans.toIntArray()
        }
    }
}