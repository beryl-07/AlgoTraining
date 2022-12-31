package graph.bfs.rottingOranges

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0

        val m = grid.size // Number of rows
        val n = grid[0].size // Number of columns
        val toSee = ArrayDeque<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()
        var fresh = 0

        // Ici il s'agit des levels de notre BFS (Ici, ça correspond au temps)
        var time = 0

        // On ajoute les oranges pourries dans la queue
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) {
                    toSee.add(Pair(i, j))
                    visited.add(Pair(i, j))
                }
                if (grid[i][j] == 1) {
                    fresh++
                }
            }
        }

        while (toSee.isNotEmpty() && fresh > 0) {
            var size = toSee.size
            while (size > 0) {
                val (x, y) = toSee.removeFirst()
                // On marque la case comme visitée
                visited.add(Pair(x, y))
                // On parcourt les 4 cases adjacentes à la case (x, y)
                for ((i1, j1) in listOf(Pair(x - 1, y), Pair(x + 1, y), Pair(x, y - 1), Pair(x, y + 1))) {
                    if (i1 in 0 until m && j1 in 0 until n) {
                        // On vérifie que la case n'est pas visitée et qu'elle contient une orange fraiche
                        if (!visited.contains(Pair(i1, j1)) && grid[i1][j1] == 1) {
                            // On ajoute la case dans la queue
                            toSee.addLast(Pair(i1, j1))
                            // On rend l'orange pourrie
                            grid[i1][j1] = 2
                            // On décrémente le nombre d'oranges fraiches
                            fresh--
                        }
                    }
                }
                size--
            }
            // On incrémente le temps
            time++
        }

        // On vérifie que toutes les oranges sont pourries
        return if (fresh == 0) time else -1
    }
}
