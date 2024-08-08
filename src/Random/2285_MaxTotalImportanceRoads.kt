package Random

class MaxTotalImportanceOfRoads {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val degree = LongArray(n)
        for (road in roads) {
            degree[road[0]]++
            degree[road[1]]++
        }
        var ans: Long = 0
        degree.sort()
        for (i in degree.indices) {
            ans+= degree[i] * (i+1)
        }
        return ans
    }
}