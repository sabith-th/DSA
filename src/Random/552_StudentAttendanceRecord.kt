package Random

class StudentAttendanceRecord {
    private val mod: Int = 1000000007

    fun checkRecord(n: Int): Int {
        val dp = Array(n + 1) { Array(3) { IntArray(4) } }

        for (ac in 0..1) {
            for (clc in 0..2) {
                dp[0][ac][clc] = 1
            }
        }

        for (day in 1..n) {
            for (ac in 0..1) {
                for (clc in 0..2) {
                    dp[day][ac][clc] = (dp[day-1][ac][0]) % mod
                    dp[day][ac][clc] = (dp[day][ac][clc] + dp[day-1][ac+1][0]) % mod
                    dp[day][ac][clc] = (dp[day][ac][clc] + dp[day-1][ac][clc+1]) % mod
                }
            }
        }
        return dp[n][0][0]
    }
}

fun main() {
    val test = StudentAttendanceRecord()
    println(test.checkRecord(2))
}