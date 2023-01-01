package graph.bfs.waterAndJugProblem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class SolutionTest {
    @Test
    fun canMeasureWater() {
        val solution = Solution()
        val jug1Capacity = 3
        val jug2Capacity = 5
        val targetCapacity = 4
        val result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)
        assertEquals(result, true)
    }

    @Test
    fun canMeasureWater2() {
        val solution = Solution()
        val jug1Capacity = 2
        val jug2Capacity = 6
        val targetCapacity = 5
        val result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)
        assertEquals(result, false)
    }

    @Test
    fun canMeasureWater3() {
        val solution = Solution()
        val jug1Capacity = 1
        val jug2Capacity = 2
        val targetCapacity = 3
        val result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)
        assertEquals(result, true)
    }

    @Test
    fun canMeasureWater4() {
        val solution = Solution()
        val jug1Capacity = 1
        val jug2Capacity = 1
        val targetCapacity = 12
        val result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)
        assertEquals(result, false)
    }
}
