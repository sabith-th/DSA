package DSA

class MaxPointsOnALine {
    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun getSlope(a: IntArray, b: IntArray): Pair<Int, Int> {
        val dx = a[0] - b[0]
        val dy = a[1] - b[1]
        return if (dx == 0) {
            Pair(0, a[0])
        } else if (dy == 0) {
            Pair(a[1], 0)
        } else {
            val gcd = gcd(dx, dy)
            Pair(dx / gcd, dy / gcd)
        }
    }

    fun maxPoints(points: Array<IntArray>): Int {
        var ans = 1
        var i = 0
        while (i < points.size - 1) {
            val slopeCount = mutableMapOf<Pair<Int, Int>, Int>()
            var samePoints = 1
            var maxPoints = 0
            val p1 = points[i]
            for (j in i+1..<points.size) {
                if (points[j][0] == p1[0] && points[j][1] == p1[1]) {
                    samePoints++
                } else {
                    val slope = getSlope(p1, points[j])
                    slopeCount.merge(slope, 1, Int::plus)
                    maxPoints = maxOf(maxPoints, slopeCount[slope]!!)
                }
            }
            ans = maxOf(ans, samePoints + maxPoints)
            i++
        }

        return ans
    }
}

fun main() {
    val test = MaxPointsOnALine()
    println(test.maxPoints(arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(3,3))))
    println(test.maxPoints(arrayOf(intArrayOf(1,1),intArrayOf(3,2),intArrayOf(5,3),intArrayOf(4,1),intArrayOf(2,3),intArrayOf(1,4))))
}