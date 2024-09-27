package dailyChallenges

import java.util.TreeMap

class MyCalendarTwo {
    private val timeline = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        timeline.merge(start, 1, Int::plus)
        timeline.merge(end, -1, Int::plus)

        var activeEvents = 0
        for (count in timeline.values) {
            activeEvents += count
            if (activeEvents > 2) {
                if (timeline.merge(start, -1, Int::plus) == 0) {
                    timeline.remove(start)
                }
                if (timeline.merge(end, 1, Int::plus) == 0) {
                    timeline.remove(end)
                }
                return false
            }
        }

        return true
    }
}

fun main() {
    val myCalendar = MyCalendarTwo()
    // [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
    // [null, true, true, true, false, true, true]
    println("Expected: true Actual: ${myCalendar.book(10, 20)}")
    println("Expected: true Actual: ${myCalendar.book(50, 60)}")
    println("Expected: true Actual: ${myCalendar.book(10, 40)}")
    println("Expected: false Actual: ${myCalendar.book(5, 15)}")
    println("Expected: true Actual: ${myCalendar.book(5, 10)}")
    println("Expected: true Actual: ${myCalendar.book(25, 55)}")
}