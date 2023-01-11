package dynamicProgramming.MaximalSquare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class SolutionTest {

    @Test
    fun maximalSquare() {
        val solution = Solution()
        val matrix = arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )
        assertEquals(4, solution.maximalSquare(matrix))
    }

    @Test
    fun maximalSquare2() {
        val solution = Solution()
        val matrix = arrayOf(
            charArrayOf('0', '1'),
            charArrayOf('1', '0')
        )
        assertEquals(1, solution.maximalSquare(matrix))
    }

    @Test
    fun maximalSquare3() {
        val solution = Solution()
        val matrix = arrayOf(
            charArrayOf('0')
        )
        assertEquals(0, solution.maximalSquare(matrix))
    }

    @Test
    fun maximalSquare4() {
        val solution = Solution()
        val matrix = arrayOf(
            charArrayOf('1')
        )
        assertEquals(1, solution.maximalSquare(matrix))
    }
}
