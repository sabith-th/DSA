package days100placements100

class RomanToInt {
    fun romanToInt(s: String): Int {
        val symbolToVal = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        ).withDefault { 0 }
        var ans = 0
        var i = 0
        while (i < s.length-1) {
            if (symbolToVal.getValue(s[i]) < symbolToVal.getValue(s[i+1])) {
                ans -= symbolToVal.getValue(s[i])
            } else {
                ans += symbolToVal.getValue(s[i])
            }
            i++
        }
        ans += symbolToVal.getValue(s[i])
        return ans
    }
}