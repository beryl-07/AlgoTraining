package graph.bfs.shortestPathBinaryMatrix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun shortestPathBinaryMatrix() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, 4)
    }

    @Test
    fun shortestPathBinaryMatrix2() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, 2)
    }

    @Test
    fun shortestPathBinaryMatrix3() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, -1)
    }

    @Test
    fun shortestPathBinaryMatrix4() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(1, 1, 0, 1)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, -1)
    }

    @Test
    fun shortestPathBinaryMatrix5() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, 1)
    }

    @Test
    fun shortestPathBinaryMatrix6() {
        val solution = Solution()
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 1)
        )
        val result = solution.shortestPathBinaryMatrix(grid)
        assertEquals(result, -1)
    }
}
