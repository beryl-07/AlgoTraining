package graph.bfs.jumpGameIII

class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        if (arr.isEmpty()) return false
        if (arr[start] == 0) return true
        if (!(0 in arr)) return false

        val toSee = ArrayDeque<Int>()
        val visited = HashSet<Int>()
        visited.add(start)
        toSee.add(start)

        while (toSee.isNotEmpty()) {
            val index = toSee.removeFirst()
            for (i in listOf(index + arr[index], index - arr[index])) {
                if (i in arr.indices && !visited.contains(i)) {
                    if (arr[i] == 0) return true
                    toSee.addLast(i)
                    visited.add(index)
                }
            }
        }
        return false
    }
}
