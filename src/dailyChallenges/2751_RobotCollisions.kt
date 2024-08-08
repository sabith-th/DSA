package dailyChallenges

class RobotCollisions {
    data class Robot(var p: Int, var h: Int, var dir: Char, var order: Int)

    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val robots = mutableListOf<Robot>()
        for (i in positions.indices) {
            robots.add(Robot(positions[i], healths[i], directions[i], i))
        }
        robots.sortedBy { it.p }
        val leftStack = ArrayDeque<Robot>()
        val rightStack = ArrayDeque<Robot>()
        for (robot in robots) {
            if (robot.dir == 'L') {
                leftStack.add(robot)
            } else {
                rightStack.add(robot)
            }
        }
        val survivors = mutableListOf<Robot>()
        while (leftStack.isNotEmpty() && rightStack.isNotEmpty()) {
            val rightTop = rightStack.removeLast()
            val leftTop = leftStack.removeLast()
            if (rightTop.p > leftTop.p) {
                survivors.add(rightTop)
                leftStack.add(leftTop)
            } else {
                if (rightTop.h > leftTop.h) {
                    rightTop.h -= 1
                    rightStack.add(rightTop)
                } else if (rightTop.h < leftTop.h) {
                    leftTop.h -= 1
                    leftStack.add(leftTop)
                }
            }
        }
        while (leftStack.isNotEmpty()) {
            survivors.add(leftStack.removeFirst())
        }
        while (rightStack.isNotEmpty()) {
            survivors.add(rightStack.removeFirst())
        }
        return survivors.sortedBy { it.order }.map { it.h }
    }

    fun survivedRobotsHealths2(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val robots = mutableListOf<Robot>()
        for (i in positions.indices) {
            robots.add(Robot(positions[i], healths[i], directions[i], i))
        }
        robots.sortBy { it.p }
        val stack = mutableListOf<Robot>()
        for (robot in robots) {
            if (robot.dir == 'R') {
                stack.add(robot)
            } else {
                if (stack.isEmpty()) {
                    stack.add(robot)
                } else {
                    while (stack.isNotEmpty() && robot.h > 0) {
                        val leftRobot = stack.removeLast()
                        if (leftRobot.dir == 'L') {
                            stack.add(leftRobot)
                            break
                        } else {
                            if (leftRobot.h > robot.h) {
                                leftRobot.h--
                                stack.add(leftRobot)
                                robot.h = 0
                            } else if (leftRobot.h < robot.h) {
                                robot.h--
                            } else {
                                robot.h = 0
                            }
                        }
                    }
                    if (robot.h > 0) {
                        stack.add(robot)
                    }
                }
            }
        }

        return stack.sortedBy { it.order }.map { it.h }
    }
}

fun main() {
    val test = RobotCollisions()
//    println(test.survivedRobotsHealths2(intArrayOf(5,4,3,2,1), intArrayOf(2,17,9,15,10), "RRRRR"))
    println(test.survivedRobotsHealths2(intArrayOf(3,5,2,6), intArrayOf(10,10,15,12), "RLRL"))
//    println(test.survivedRobotsHealths2(intArrayOf(1,2,5,6), intArrayOf(10,10,11,11), "RLRL"))

//    println(test.survivedRobotsHealths2(intArrayOf(13, 3), intArrayOf(17, 2), "LR"))
}