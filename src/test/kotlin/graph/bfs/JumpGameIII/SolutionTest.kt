package graph.bfs.JumpGameIII

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun canReach() {
        val solution = Solution()
        val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
        val start = 5
        val result = solution.canReach(arr, start)
        assertEquals(result, true)
    }

    @Test
    fun canReach2() {
        val solution = Solution()
        val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
        val start = 0
        val result = solution.canReach(arr, start)
        assertEquals(result, true)
    }

    @Test
    fun canReach3() {
        val solution = Solution()
        val arr = intArrayOf(3, 0, 2, 1, 2)
        val start = 2
        val result = solution.canReach(arr, start)
        assertEquals(result, false)
    }
}
