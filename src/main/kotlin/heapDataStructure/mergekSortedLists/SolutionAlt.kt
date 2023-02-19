package heapDataStructure.mergekSortedLists

class SolutionAlt {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val listNodes = mutableListOf<ListNode>()
        for (node in lists) {
            if (node != null) {
                var head = node
                while (head != null) {
                    listNodes.add(head)
                    head = head.next
                }
            }
        }
        if (listNodes.isEmpty()) {
            return null
        }
        listNodes.sortBy { it.`val` }
        val head = listNodes.removeAt(0)
        var current = head
        while (listNodes.isNotEmpty()) {
            current.next = listNodes.removeAt(0)
            current = current.next!!
        }
        current.next = null
        return head
    }
}