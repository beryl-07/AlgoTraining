package dynamicProgramming.MaximalSquare

class Solution_ {
    fun arrayArea_DFS(matrix: Array<CharArray>, i: Int, j: Int, height: Int, width: Int): Int {
        if (i < 0 || i >= height || j < 0 || j >= width || matrix[i][j] == '0') {
            return 0
        }
        var area = 1
        for ((a, b) in listOf(Pair(i + 1, j), Pair(i, j + 1), Pair(i + 1, j + 1))) {
            matrix[i][j] = '#'
            area += arrayArea_DFS(matrix, a, b, height, width)
        }
        return area
    }
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val height = matrix.size
        val width = matrix[0].size
        val area = ArrayList<Int>()
        area.add(1)
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (matrix[i][j] == '1') {
                    area.add(arrayArea_DFS(matrix, i, j, height, width))
                }
            }
        }
        val largestSquare = ArrayList<Int>()
        for (i in area.indices) {
            val square = Math.sqrt(area[i].toDouble()).toInt()
            if (square * square == area[i]) {
                largestSquare.add(square)
            }
        }
        return largestSquare.max() ?: 0
    }
}
