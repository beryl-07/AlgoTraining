package graph.bfs.rottingOranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class SolutionTest {
    @Test
    fun orangesRotting() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )
        val result = solution.orangesRotting(grid)
        assertEquals(result, 4)
    }

    @Test
    fun orangesRotting2() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1)
        )
        val result = solution.orangesRotting(grid)
        assertEquals(result, -1)
    }

    @Test
    fun orangesRotting3() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 2)
        )
        val result = solution.orangesRotting(grid)
        assertEquals(result, 0)
    }

    @Test
    fun orangesRotting4() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0)
        )
        val result = solution.orangesRotting(grid)
        assertEquals(result, 0)
    }
}
