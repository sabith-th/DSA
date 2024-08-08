package Random

class MinimumNumberOfMovesToSeatEveryone {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var ans = 0
        for (i in seats.indices) {
            if (seats[i] != students[i]) {
                ans += Math.abs(seats[i] - students[i])
            }
        }
        return ans
    }
}