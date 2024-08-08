package DSA

class HandOfStraights {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (card in hand) {
            map.merge(card, 1, Integer::sum)
        }
        val sortedMap = map.toSortedMap()
        for (hand in sortedMap.keys) {
            var value = sortedMap.getOrDefault(hand, 0)
            if (value > 0) {
                for (i in hand..<(hand+groupSize)) {
                    sortedMap.merge(i, -value, Integer::sum)?.let {
                        if (it < 0) {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }
}