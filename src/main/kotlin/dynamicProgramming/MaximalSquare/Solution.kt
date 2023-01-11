package dynamicProgramming.MaximalSquare

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val height = matrix.size // Le nombre de ligne
        val width = matrix[0].size // Le nombre de colonne
        // On crée un tableau de taille height * width
        // Pour chaque case du tableau, on va stocker la distance maximale entre la case et le coin supérieur gauche
        val map = Array(height) { IntArray(width) }
        var max = 0 // Pour rechercher le maximal de map
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        map[i][j] = 1
                    } else {
                        map[i][j] = min(min(map[i - 1][j], map[i - 1][j - 1]), map[i][j - 1]) + 1
                    }
                    max = max(max, map[i][j])
                }
            }
        }
        return max * max
    }
}
