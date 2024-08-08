package Random

import kotlin.collections.sortWith

class MinimumNumberOfArrowsToBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var ans = 1
        points.sortWith(compareBy { it[1] })
        var arrowShot = points[0][1]
        for (i in 1..<points.size) {
            if (points[i][1] > arrowShot) {
                arrowShot = points[i][1]
                ans++
            }
        }
        return ans
    }
}