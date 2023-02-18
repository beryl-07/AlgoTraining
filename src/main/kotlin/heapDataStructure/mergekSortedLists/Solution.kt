package heapDataStructure.mergekSortedLists

class ListNode(var `val`: Int = 0, var next: ListNode? = null)

class Solution {
    fun mergeKLists(lists: ArrayList<ListNode?>): ListNode? {
        val heap = Heap()
        for (list in lists) {
            if (list != null) {
                heap.insert(list)
            }
        }
        val dummy = ListNode(0)
        var tail = dummy
        while (heap.size > 0) {
            val node = heap.pop()
            tail.next = node
            tail = node
            if (node.next != null) {
                heap.insert(node.next!!)
            }
        }
        return dummy.next
    }
}
class Heap {
    private val heap = mutableListOf<ListNode>()
    val size: Int
        get() = heap.size
    fun insert(node: ListNode) {
        heap.add(node)
        var index = heap.size - 1
        while (index > 0) {
            val parent = (index - 1) / 2
            if (heap[parent].`val` <= node.`val`) {
                break
            }
            heap[index] = heap[parent]
            index = parent
        }
        heap[index] = node
    }
    fun pop(): ListNode {
        val node = heap[0]
        val last = heap.removeAt(heap.size - 1)
        if (heap.size > 0) {
            var index = 0
            while (index * 2 + 1 < heap.size) {
                var child = index * 2 + 1
                if (child + 1 < heap.size && heap[child + 1].`val` < heap[child].`val`) {
                    child++
                }
                if (heap[child].`val` >= last.`val`) {
                    break
                }
                heap[index] = heap[child]
                index = child
            }
            heap[index] = last
        }
        return node
    }
}
