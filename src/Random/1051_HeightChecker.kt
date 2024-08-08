package Random

class HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        val expected = heights.sorted()
        var ans = 0
        for (i in heights.indices) {
            if (heights[i] != expected[i]) ans++
        }
        return ans
    }
}