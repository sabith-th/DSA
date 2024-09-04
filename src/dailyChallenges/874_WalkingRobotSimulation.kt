package dailyChallenges

class WalkingRobotSimulation {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val dirs = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var d = 0 // Directions 0: North, 1: East, 2: South, 3: West
        var x = 0
        var y = 0
        val obstacleSet = mutableSetOf<Pair<Int, Int>>()
        for (obs in obstacles) {
            obstacleSet.add(Pair(obs[0], obs[1]))
        }

        var ans = 0
        for (c in commands) {
            when (c) {
                -1 -> d = (d + 1) % 4
                -2 -> d = (d + 3) % 4
                else -> {
                    for (step in 0..<c) {
                        if ((Pair(x+dirs[d].first, y+dirs[d].second)) in obstacleSet) {
                            break
                        }
                        x += dirs[d].first
                        y += dirs[d].second
                    }
                }
            }
            ans = maxOf(ans, x * x + y * y)
        }

        return ans
    }
}