package DSA

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adjList = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        for (prereq in prerequisites) {
            adjList[prereq[1]].add(prereq[0])
        }

        val inDegree = IntArray(numCourses)

        for (neighbors in adjList) {
            for (v in neighbors) {
                inDegree[v]++
            }
        }

        val pq = ArrayDeque<Int>()
        for (i in inDegree.indices) {
            if (inDegree[i] == 0) pq.add(i)
        }

        val courseOrder = IntArray(numCourses)
        val visited = BooleanArray(numCourses)
        var i = 0

        while (pq.isNotEmpty()) {
            val u = pq.removeFirst()
            if (!visited[u]) {
                for (v in adjList[u]) {
                    inDegree[v]--
                    if (inDegree[v] == 0) {
                        pq.add(v)
                    }
                }
            }
            courseOrder[i++] = u
            visited[u] = true
        }

        return if (i == numCourses) courseOrder else intArrayOf()
    }
}