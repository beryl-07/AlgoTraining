package graph.bfs.shortestPathLength

class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val toSee = ArrayDeque<Pair<Int, Int>>()
        val n = graph.size
        // C'est le tableau dist ce tableau d'entiers contient n colonnes et pour chaque colonne, 1 << n lignes soit [(2 ^ n) lignes]
        // Ce tableau permettra de voir si pour un nœud n, on a déjà atteint ce nœud grace au masque de chemin
        // si c'est le cas, dist[n][mask] sera différent de -1 et dist[n][mask] contiendra donc la taille du chemin,
        // car nous avons n nœuds, nous devons donc définir le nombre de lignes à 1 << n, parce que le plus grand masque que nous aurons
        // est (1 << n) - 1
        val dist = Array(n) { IntArray(1 shl n) { -1 } } // Rempli le tableau de -1.
        // Et si nous voyons un masque qui est égal à [(1 << n) - 1], cela signifie que nous avons visité tous les chemins. Alors, nous devons
        // arrêter le programme.
        val goal = (1 shl n) - 1
        // Prenons un exemple s'il y a 4 nœuds, goal est (1 << 4) - 1 == 1111.
        // Ainsi, si un nœud a ce chemin, cela signifie que nous avons déjà vu les nœuds 0, 1, 2, 3, 4
        // Ainsi, nous pouvons arrêter le processus.
        // Nous commencerons le BFS en utilisant, pour la première génération, tous les nœuds
        // pour chaque nœud, nous ajoutons sa valeur à la file d'attente et le masque des nœuds vus.
        // Le premier nœud à voir tous les nœuds, (ayant un masque égal à goal) sera le plus rapide,
        // nous mettrons la distance de ces nœuds à 0 telle que dist[i][1 << i] = 0
        // À l'état initial, nous associons à chaque nœud sa valeur en tant que masque.
        // Donc le 4ᵉ nœud sera associé à 10000 (1 << i)
        println("Before")
        for (i in dist) {
            println(i)
        }
        for (i in 0 until n) {
            toSee.addLast(Pair(i, 1 shl i))
            dist[i][1 shl i] = 0
        }
        println("After")
        for (i in dist) {
            println(i)
        }
        println(toSee)

        while (toSee.isNotEmpty()) {
            var size = toSee.size
            while (size != 0) {
                size -= 1
                // current est le nœud actuel, mask est le masque contenant tous les nœuds vus
                val (current, mask) = toSee.removeFirst()
                // Si nous avons atteint le goal, nous retournons la distance de notre nœud actuel, dirigé par le masque
                if (mask == goal) {
                    return dist[current][mask]
                }
                for (neighbor in graph[current]) {
                    // Si le voisin n'a pas été visité avec le masque + le bit du voisin défini à 1*
                    if (dist[neighbor][mask or (1 shl neighbor)] == -1) {
                        toSee.addLast(Pair(neighbor, mask or (1 shl neighbor)))
                        dist[neighbor][mask or (1 shl neighbor)] = dist[current][mask] + 1
                    }
                }
            }
        }
        return -1
    }
}
