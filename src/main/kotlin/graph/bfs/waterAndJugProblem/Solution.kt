package graph.bfs.waterAndJugProblem

class Solution {
    fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false
        return targetCapacity % pgcd(jug1Capacity, jug2Capacity) == 0
    }
    fun pgcd(a: Int, b: Int): Int {
        if (a == 0 || b == 0) return a + b
        val queue = ArrayDeque<Pair<Int, Int>>()
        if (a > b) {
            queue.addLast(Pair(a, b))
        } else {
            queue.addLast(Pair(b, a))
        }
        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            if (x % y == 0) {
                return y
            } else {
                queue.addLast(Pair(y, x % y))
            }
        }
        // Impossible que l'on arrive ici (Mon IDE me saoule avec une erreur)
        return 0
    }
}
