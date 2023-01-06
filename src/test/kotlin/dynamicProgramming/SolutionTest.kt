package dynamicProgramming

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class SolutionTest {
    @Test
    fun fibTest() {
        val solution = Solution()
        assertEquals(0, solution.fib(0))
        assertEquals(1, solution.fib(1))
        assertEquals(1, solution.fib(2))
        assertEquals(2, solution.fib(3))
        assertEquals(3, solution.fib(4))
        assertEquals(5, solution.fib(5))
        assertEquals(8, solution.fib(6))
    }
}
