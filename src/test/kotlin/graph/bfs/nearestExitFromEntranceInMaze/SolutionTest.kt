package graph.bfs.nearestExitFromEntranceInMaze

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class SolutionTest {
    @Test
    fun nearestExit() {
        val solution = Solution()
        val maze = arrayOf(
            charArrayOf('+', '+', '.', '+', '+'),
            charArrayOf('.', '.', '.', '+', '+'),
            charArrayOf('+', '+', '+', '.', '.')
        )
        val entrance = intArrayOf(1, 2)
        val result = solution.nearestExit(maze, entrance)
        assertEquals(result, 1)
    }

    @Test
    fun nearestExit1() {
        val solution = Solution()
        val maze = arrayOf(
            charArrayOf('+', '.', '+'),
            charArrayOf('.', '.', '.'),
            charArrayOf('+', '.', '+')
        )
        val entrance = intArrayOf(1, 2)
        val result = solution.nearestExit(maze, entrance)
        assertEquals(result, 2)
    }

    @Test
    fun nearestExit2() {
        val solution = Solution()
        val maze = arrayOf(
            charArrayOf('+', '.', '+'),
            charArrayOf('.', '.', '.'),
            charArrayOf('+', '.', '+')
        )
        val entrance = intArrayOf(1, 0)
        val result = solution.nearestExit(maze, entrance)
        assertEquals(result, 2)
    }

    @Test
    fun nearestExit3() {
        val solution = Solution()
        val maze = arrayOf(
            charArrayOf('+', '+', '+'),
            charArrayOf('.', '.', '.'),
            charArrayOf('+', '+', '+')
        )
        val entrance = intArrayOf(1, 0)
        val result = solution.nearestExit(maze, entrance)
        assertEquals(result, 2)
    }
}
