package Random

import kotlin.collections.sort

class HandOfStraights {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) {
            return false
        }

        hand.sort()
        var i = 0
        while (i < hand.size) {
            var size = 0
            var prev = -1
            var j = i
            while (j < hand.size) {
                if (hand[j] < 0) {
                    j++
                    continue
                }
                if (size == 0 || hand[j] == prev+1) {
                    prev = hand[j]
                    hand[j] = -1
                    size++
                }
                if (size == groupSize) {
                    break
                }
                j++
            }
            if (j == hand.size && size < groupSize) {
                return false
            }
            while (i < hand.size && hand[i] < 0) {
                i++
            }
        }

        return true
    }
}

fun main() {
    val handOfStraights = HandOfStraights()
    println(handOfStraights.isNStraightHand(intArrayOf(1,2,3,6,2,3,4,7,8), 3))
}