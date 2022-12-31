package graph.bfs.nearestExitFromEntranceInMaze

class Solution {
    // Time complexity: O(n*m), Space complexity: O(n*m)
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size // maze rows
        val n = maze[0].size // maze columns

        // Un tableau de 2D pour marquer les cellules visitées
        val visited = Array(m) { BooleanArray(n) }

        // Une queue pour stocker les noeuds à visiter
        val toSee = ArrayDeque<Triple<Int, Int, Int>>()

        // Ajouter la case d'entrée à la queue
        toSee.addLast(Triple(entrance[0], entrance[1], 0))

        // Marquer la case d'entrée comme visitée
        visited[entrance[0]][entrance[1]] = true

        // Parcourir la queue
        while (toSee.isNotEmpty()) {
            // Pop la tête de la queue
            val (x, y, distance) = toSee.removeFirst()

            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                if (x != entrance[0] || y != entrance[1]) {
                    return distance
                }
            }
            // Parcourir les 4 cases adjacentes à la case (x, y)
            for ((i1, j1) in listOf<Pair<Int, Int>>(Pair(x - 1, y), Pair(x + 1, y), Pair(x, y - 1), Pair(x, y + 1))) {
                // Vérifier si la case (i1, j1) est une case valide
                if (i1 in 0 until m && j1 in 0 until n && maze[i1][j1] == '.' && !visited[i1][j1]) {
                    // Ajouter la case (i1, j1) à la queue
                    toSee.addLast(Triple(i1, j1, distance + 1))
                    // Marquer la case (i1, j1) comme visitée
                    visited[i1][j1] = true
                }
            }
        }
        return -1
    }
    // Solution Alternative (Ma première solution)
    /* fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size // maze rows
        val n = maze[0].size // maze columns

        // Un tableau de 2D pour marquer les cellules visitées
        val visited = Array(m) { BooleanArray(n) }

        // Une queue pour stocker les noeuds à visiter
        val toSee = ArrayDeque<Pair<Int, Int>>()

        // Ajouter la case d'entrée à la queue
        toSee.addLast(Pair(entrance[0], entrance[1]))

        // Marquer la case d'entrée comme visitée
        visited[entrance[0]][entrance[1]] = true

        // Une variable pour compter chaque niveau du graphe ( du coup la distance ici)
        var distance = 0

        // Parcourir la queue
        while (toSee.isNotEmpty()) {
            // Récupérer la taille de la queue
            var size = toSee.size

            // Parcourir les noeuds de la queue
            while (size > 0) {
                // Pop la tête de la queue
                val (x, y) = toSee.removeFirst()
                if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                    if (x != entrance[0] || y != entrance[1]) {
                        return distance
                    }
                }
                // Parcourir les 4 cases adjacentes à la case (x, y)
                for ((i1, j1) in listOf<Pair<Int, Int>>(Pair(x - 1, y), Pair(x + 1, y), Pair(x, y - 1), Pair(x, y + 1))) {
                    // Vérifier si la case (i1, j1) est une case valide
                    if (i1 in 0 until m && j1 in 0 until n && maze[i1][j1] == '.' && !visited[i1][j1]) {
                        // Ajouter la case (i1, j1) à la queue
                        toSee.addLast(Pair(i1, j1))
                        // Marquer la case (i1, j1) comme visitée
                        visited[i1][j1] = true
                    }
                }
                // Décrémenter la taille de la queue
                size--
            }
            // Incrémenter le niveau
            distance++
        }
        // Si on arrive ici, c'est que la case de sortie n'est pas accessible
        return -1
    } */
}
