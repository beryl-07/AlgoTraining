package graph.bfs.shortestPathBinaryMatrix
class Solution {
    // Time: O(n^2), Space: O(n^2)
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1
        val n = grid.size
        if (grid[n - 1][n - 1] == 1) return -1
        if (n == 1) return 1
        val toSee = ArrayDeque<Triple<Int, Int, Int>>()
        toSee.add(Triple(0, 0, 1))
        val visited = HashMap<Pair<Int, Int>, Int>()
        visited[Pair(0, 0)] = 1
        while (toSee.isNotEmpty()) {
            val (i, j, distance) = toSee.removeFirst()
            // Parcourir les 8 cases adjacentes à la case (i, j)
            for (i1 in i - 1..i + 1) {
                for (j1 in j - 1..j + 1) {
                    if (i1 in 0 until n && j1 in 0 until n && grid[i1][j1] == 0 && visited[Pair(i1, j1)] == null) {
                        grid[i1][j1] = distance + 1
                        // Vérifier si la case (i1, j1) est la case d'arrivée
                        if (i1 == n - 1 && j1 == n - 1) return distance + 1
                        toSee.addLast(Triple(i1, j1, distance + 1))
                        visited[Pair(i1, j1)] = distance + 1
                    } else {
                        continue
                    }
                }
            }
        }
        // Si on arrive ici, c'est que la case d'arrivée n'est pas accessible
        return -1
    }
}
