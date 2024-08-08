package DSA

class PartitionLabels {
    fun partitionLabels(s: String): List<Int> {
        val positionMap = mutableMapOf<Char, Pair<Int, Int>>()
        for (i in s.indices) {
            positionMap.merge(s[i], Pair(i, i)) {  old, curr -> Pair(old.first, curr.second) }
        }
        val partitions = mutableListOf<Int>()
        partitions.add(-1)
        val ans = mutableListOf<Int>()
        var lastPartition = 0
        var i = 0
        while (i < s.length) {
            val (start, end) = positionMap[s[i]]!!
            if (start <= lastPartition && end > lastPartition) {
                lastPartition = end
            } else if (start > lastPartition) {
                ans.add(lastPartition - partitions.last())
                partitions.add(lastPartition)
                lastPartition = end
            }
            i++
        }
        ans.add(lastPartition - partitions.last())
        partitions.add(lastPartition)
        return ans
    }
}

fun main() {
    val test = PartitionLabels()
    println(test.partitionLabels("ababcbacadefegdehijhklij"))
    println(test.partitionLabels("eccbbbbdec"))
}