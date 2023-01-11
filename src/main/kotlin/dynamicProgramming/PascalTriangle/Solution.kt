package dynamicProgramming.PascalTriangle

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 1) return listOf(listOf(1))
        if (numRows == 2) return listOf(listOf(1), listOf(1, 1))
        val pascalTriangle = mutableListOf<List<Int>>()
        for (i in 0 until numRows) {
            val row = mutableListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    row.add(1)
                } else {
                    row.add(pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j])
                }
            }
            pascalTriangle.add(row)
        }
        return pascalTriangle
    }
}
