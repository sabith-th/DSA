package dailyChallenges

import java.util.TreeMap

class MyCalendar() {

    private val calendar = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val floorEntry = calendar.floorEntry(start)

        if (floorEntry != null && floorEntry.value > start) {
            return false
        }

        val ceilingEntry = calendar.ceilingEntry(start)

        if (ceilingEntry != null && ceilingEntry.key < end) {
            return false
        }

        calendar[start] = end

        return true
    }

}

fun main() {
    val myCalendar = MyCalendar()
    println("Expected: true Actual: ${myCalendar.book(10, 20)}")
    println("Expected: false Actual: ${myCalendar.book(15, 25)}")
    println("Expected: true Actual: ${myCalendar.book(20, 30)}")
}