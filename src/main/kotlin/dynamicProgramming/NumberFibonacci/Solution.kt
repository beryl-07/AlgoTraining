package dynamicProgramming.NumberFibonacci

class Solution {
        /*fun fib(n: Int): Int {
            if (n == 0) return 0
            if (n == 1) return 1
            return fib(n - 1) + fib(n - 2)
        }
         */
    fun fib(n: Int): Int {
            /*if (n == 0) return 0
            if (n == 1) return 1
            var prev = 0
            var curr = 1
            for (i in 2..n) {
                val sum = prev + curr
                prev = curr
                curr = sum
            }
            return curr

             */
        val f = IntArray(n + 1)
        f[0] = 0
        f[1] = 1
        for (i in 2..n) {
            f[i] = f[i - 1] + f[i - 2]
        }
        return f[n]
    }
}
